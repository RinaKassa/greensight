const { RuleTester } = require('eslint');
const rule = require('../../../lib/rules/check-gitignore-items');

//------------------------------------------------------------------------------
// Tests
//------------------------------------------------------------------------------

const ruleTester = new RuleTester();
ruleTester.run('check-gitignore-items', rule, {
  /*valid: [
    {
      code: `node/
             node_modules
             target/
             .idea/

             sonar-example-plugin.iml
             yarn.lock

             *.log
             *.iml

             !.editorconfig
             !.eslintrc.js
             !.gitattributes`,
      filename: '.gitignore',
    },
  ],

  invalid: [
    {
      code: '/tmp\n/out-tsc\n/bazel-out\n/node_modules\nnpm-debug.log\nyarn-error.log\n.idea/\n.project\n.classpath\n.c9/\n*.launch\n.settings/*\n*.sublime-workspace\n.vscode/*\n.history/*\n/.angular/cache\n.sass-cache\n/connect.lock\n/coverage\n/libpeerconnection.log\ntestem.log\n/typings\n.DS_Store\nThumbs.db',
      filename: '.gitignore',
      errors: [
        {
          message: 'Item "/dist" is missing in .gitignore file.',
        },
      ],
    },
  ],*/
});
