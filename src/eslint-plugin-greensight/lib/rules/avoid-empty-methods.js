/**
 * @fileoverview Empty methods will end up consumming CPU and RAM although they do nothing
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
    type: 'suggestion', // `problem`, `suggestion`, or `layout`
    messages: {
      emptyBody: "Function '{{ functionName }}' has empty body",
    },
    schema: [], // Add a schema if the rule has options
  },

  create(context) {
    return {
      FunctionDeclaration(node) {
        if (node.body.body[0] == null) {
          // context.report(node, "Supprimez les fonctions avec un corps vide");
          context.report({
            node,
            messageId: 'emptyBody',
            data: {
              functionName: node.id.name,
            },
          });
        }
      },
    };
  },
};
