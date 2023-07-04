/**
 * @fileoverview Avoid query with select * to limit the amount of data flow
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
    type: 'problem', // `problem`, `suggestion`, or `layout`
    messages: {
      selectStar: 'Do not use select * in SQL queries',
    },
    schema: [], // Add a schema if the rule has options
  },

  create(context) {
    return {
      Literal(node) {
        if (typeof node === 'undefined' || typeof node.value === 'undefined') {
          return;
        }

        if (node.value === null) {
          return;
        }

        if (node.value.length > 1) {
          // eslint-disable-next-line greensight/query-not-select-star
          if (node.value.includes('SELECT *')) {
            context.report({
              node,
              messageId: 'selectStar',
            });
          }
        }
      },
    };
  },
};
