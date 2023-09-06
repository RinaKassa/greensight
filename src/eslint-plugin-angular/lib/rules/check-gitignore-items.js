/**
 * @fileoverview Check that the .gitignore is well defined
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
      description: 'Check if specific items are present in .gitignore',
      recommended: false,
    },
    schema: []
  },
  create: function (context) {
      const gitignorePath = '.gitignore';// à récupérer le bon fichier
      const patternsToCheck = [
        "/dist",
        "/tmp",
        "/out-tsc",
        "/bazel-out",
        "/node_modules",
        "npm-debug.log",
        "yarn-error.log",
        ".idea/",
        ".project",
        ".classpath",
        ".c9/",
        "*.launch",
        ".settings/*",
        "*.sublime-workspace",
        ".vscode/*",
        ".history/*",
        "/.angular/cache",
        ".sass-cache",
        "/connect.lock",
        "/coverage",
        "/libpeerconnection.log",
        "testem.log",
        "/typings",
        ".DS_Store",
        "Thumbs.db"
      ];

      // Read the content of .gitignore file
      const gitignoreContent = fs.readFileSync(gitignorePath, 'utf8');

      // Check if each item is present in .gitignore
      itemsToCheck.forEach((item) => {
        if (gitignoreContent.indexOf(item) === -1) {
          context.report({
            node: null,
            message: `Item "${item}" is missing in .gitignore file.`,
          });
        }
      });

      return {};
    },
};
