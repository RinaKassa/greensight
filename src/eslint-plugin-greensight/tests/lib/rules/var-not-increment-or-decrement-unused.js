/**
 * @fileoverview Do not increment or decrement unused variables
 * @author Capgemini
 */

//------------------------------------------------------------------------------
// Requirements
//------------------------------------------------------------------------------

const { RuleTester } = require('eslint');
const rule = require('../../../lib/rules/var-not-increment-or-decrement-unused');

//------------------------------------------------------------------------------
// Tests
//------------------------------------------------------------------------------

const ruleTester = new RuleTester();
ruleTester.run('var-not-increment-or-decrement-unused', rule, {
  valid: [
    {
      code: 'var number = 2; number++; print(number);',
      only: true,
    },
  ],

  invalid: [
    {
      code: 'var number = 2; number++;',
      only: true,
      errors: [{ messageId: 'updatedUnused' }],
    },
  ],
});
