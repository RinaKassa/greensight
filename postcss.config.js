const postcssPresetEnv = require('postcss-preset-env');

module.exports = {
  plugins: [
    'autoprefixer',
    'postcss-nested',
    postcssPresetEnv({
      stage: 2,
    }),
  ],
};
