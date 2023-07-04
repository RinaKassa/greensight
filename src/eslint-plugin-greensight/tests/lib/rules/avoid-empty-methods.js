/**
 * @fileoverview Empty methods will end up consumming CPU and RAM although they do nothing
 * @author Capgemini
 */

//------------------------------------------------------------------------------
// Requirements
//------------------------------------------------------------------------------

const { RuleTester } = require('eslint');
const rule = require('../../../lib/rules/avoid-empty-methods');

//------------------------------------------------------------------------------
// Tests
//------------------------------------------------------------------------------

const ruleTester = new RuleTester();
ruleTester.run('avoid-empty-methods', rule, {
  valid: [RuleTester.only('function notEmpty(){var jaaj = 2; return jaaj;}')],

  invalid: [
    {
      code: 'function empty(){}',
      errors: [{ messageId: 'emptyBody' }],
      only: true,
    },
  ],
});
