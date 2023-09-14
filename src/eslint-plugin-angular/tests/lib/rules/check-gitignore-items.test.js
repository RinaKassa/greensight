//------------------------------------------------------------------------------
// Requirements
//------------------------------------------------------------------------------

const { RuleTester } = require('eslint');
const rule = require('../../../lib/rules/check-gitignore-items');

//------------------------------------------------------------------------------
// Tests
//------------------------------------------------------------------------------
const ruleTester = new RuleTester();

ruleTester.run('check-gitignore-items', rule, {
  valid: [
    {
      code: '',
      filename: '.gitignore',
      options: [{ itemsToCheck: ['/dist', '/tmp'], gitignoreContent: '/dist\n/tmp' }],
    },
  ],
  invalid: [
    {
      code: '',
      filename: '.gitignore',
      options: [{ itemsToCheck: ['/dist', '/tmp'], gitignoreContent: '/dist' }],
      errors: [
        {
          message: 'Item "/tmp" is missing in .gitignore file.',
        },
      ],
    },
  ],
});
