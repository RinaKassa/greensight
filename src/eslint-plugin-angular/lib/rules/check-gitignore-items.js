/**
 * @fileoverview Check that the .gitignore is well defined
 * @author Capgemini
 */

const fs = require('fs');
const path = require('path');

//------------------------------------------------------------------------------
// Rule Definition
//------------------------------------------------------------------------------
/**
 * @type {import('eslint').Rule.RuleModule}
 */
module.exports = {
  meta: {
    type: 'problem',
    docs: {
      description: 'Check if specific items are present in .gitignore',
      recommended: false,
    },
    schema: [
      {
        type: 'object',
        properties: {
          itemsToCheck: {
            type: 'array',
            items: { type: 'string' },
          },
          gitignoreContent: {
            type: 'string',
          }
        },
        additionalProperties: false,
      },
    ],
  },

  create: function (context) {
    const defaultItemsToCheck = [
      '/dist',
      '/tmp',
      '/out-tsc',
      '/bazel-out',
      '/node_modules',
      'npm-debug.log',
      'yarn-error.log',
      '.idea/',
      '.project',
      '.classpath',
      '.c9/',
      '*.launch',
      '.settings/',
      '*.sublime-workspace',
      '.vscode/*',
      '.history/*',
      '/.angular/cache',
      '.sass-cache/',
      '/connect.lock',
      '/coverage',
      '/libpeerconnection.log',
      'testem.log',
      '/typings',
      '.DS_Store',
      'Thumbs.db',
    ];

    const userOptions = context.options[0] || {};
    const itemsToCheck = userOptions.itemsToCheck || defaultItemsToCheck;
    try {
      const pathArg = process.env.LINT_PATH;
      if (pathArg) {
        const gitignorePath = path.join(pathArg, '.gitignore');
        const gitignoreContent = userOptions.gitignoreContent || fs.readFileSync(gitignorePath, 'utf8').split('\n');
          itemsToCheck.forEach((item) => {
            if (!gitignoreContent.includes(item)) {
              context.report({
                node: context.getScope().block,
                message: `Item "${item}" is missing in .gitignore file.`,
              });
            }
          });
      } else {
        console.error('Please specify the variable env LINT_PATH');
      }
    } catch (error) {
      context.report({
        node: context.getScope().block,
        message: `Could not read .gitignore file: ${error.message}`,
      });
    }

    return {};
  },
};
