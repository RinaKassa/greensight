/**
 * @fileoverview While using angluar CLI, it's often generate empty files that are never going to be used. So avoid empty files in the project.
 * @author Capgemini
 */

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
      description: 'Disallow empty files in the project.',
      recommended: false,
    },
    messages: {
      emptyFile: 'This file {{ fileName }} is empty.',
    },
    schema: [],
  },
  create: function (context) {
    return {
      Program(node) {
        if (node.body.length === 0) {
          context.report({
            node,
            messageId: 'emptyFile',
            data: {
              fileName: context.filename,
            },
          });
        }
      },
    };
  },
};
