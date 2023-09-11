module.exports = {
  env: {
    browser: true,
    es2021: true,
    node: true,
  },
  extends: ['plugin:vue/vue3-essential', '@vue/airbnb', 'prettier'],
  parserOptions: {
    ecmaFeatures: {
      jsx: true,
    },
    ecmaVersion: 'latest',
    sourceType: 'module',
  },
  plugins: ['prettier', 'greensight', 'angular'],
  settings: {
    // tell eslint-import-resolver-webpack to read webpack config to learn import alias
    'import/resolver': {
      webpack: {},
    },
  },
  rules: {
    // prettier
    'prettier/prettier': 'error',

    // greensight rules

    'greensight/avoid-empty-methods': 'warn',
    'greensight/query-not-select-star': 'warn',

    // "greensight/var-not-increment-or-decrement": "warn",

    // angular rules
    'angular/check-gitignore-items': 'warn',
    'angular/no-empty-files': 'error',

    // custom rules
    // enforce blank line before comment
    'lines-around-comment': [
      'error',
      {
        beforeBlockComment: true,
        afterBlockComment: false,
        beforeLineComment: true,
        afterLineComment: false,
        allowBlockStart: true,
        allowBlockEnd: true,
        allowObjectStart: true,
        allowObjectEnd: true,
        allowArrayStart: true,
        allowArrayEnd: true,
      },
    ],

    // https://eslint.org/docs/latest/rules/no-mixed-operators
    'no-confusing-arrow': ['error', { allowParens: false, onlyOneSimpleParam: true }],

    // ensure single quote are used
    quotes: ['error', 'single', { avoidEscape: true, allowTemplateLiterals: false }],
  },
  overrides: [
    {
      files: ['*.jsx', '*.js', '*.vue', '*.css', '*.ts'],
    },
  ],
};
