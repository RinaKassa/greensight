/**
 * @fileoverview Avoid query with select * to limit the amount of data flow
 * @author Capgemini
 */

//------------------------------------------------------------------------------
// Requirements
//------------------------------------------------------------------------------

const { RuleTester } = require('eslint');
const rule = require('../../../lib/rules/query-not-select-star');

//------------------------------------------------------------------------------
// Tests
//------------------------------------------------------------------------------

const ruleTester = new RuleTester();
ruleTester.run('query-not-select-star', rule, {
  valid: [
    {
      code: '"SELECT value FROM table"',
      only: true,
    },
    {
      code: "'SELECT count(numbers), values FROM anotherTable'",
      only: true,
    },
  ],

  invalid: [
    {
      code: '"SELECT * FROM table"',
      only: true,
      errors: [{ messageId: 'selectStar' }],
    },
    {
      code: "'SELECT * FROM table'",
      only: true,
      errors: [{ messageId: 'selectStar' }],
    },
  ],
});
