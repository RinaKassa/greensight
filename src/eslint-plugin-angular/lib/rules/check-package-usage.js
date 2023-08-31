/**
 * @fileoverview Check if all packages listed in package.json are used
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
      description: 'Check if all packages listed in package.json are used',
      recommended: true
    },
    schema: []
  },
  create: function(context) {
    //const packageJson = require('./package.json');
    //const usedDependencies = new Set();

    return {}
  }
};
