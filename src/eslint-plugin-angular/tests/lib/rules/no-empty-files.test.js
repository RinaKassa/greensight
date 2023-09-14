const { RuleTester } = require('eslint');
const rule = require('../../../lib/rules/no-empty-files');

//------------------------------------------------------------------------------
// Tests
//------------------------------------------------------------------------------

const FILE_NAME = 'sample.js';
const ruleTester = new RuleTester();

ruleTester.run('no-empty-files', rule, {
  valid: [
    {
      code: 'var x = 18; function getX() { return x;}',
    },
  ],

  invalid: [
    {
      code: '// This is a single line comment present in the file',
      filename: FILE_NAME,
      errors: [
        {
          message: `This file ${FILE_NAME} is empty.`,
        },
      ],
    },
    {
      code: '//',
      filename: FILE_NAME,
      errors: [
        {
          message: `This file ${FILE_NAME} is empty.`,
        },
      ],
    },
    {
      code: '',
      filename: FILE_NAME,
      errors: [
        {
          message: `This file ${FILE_NAME} is empty.`,
        },
      ],
    },
  ],
});
