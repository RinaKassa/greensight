// eslint-disable-next-line func-names
module.exports = function (api) {
  // see https://babeljs.io/docs/en/config-files#apicache
  api.cache(true);

  // list are processed in reverse order
  const presets = ['@babel/preset-env', 'vue'];

  const plugins = ['babel-plugin-styled-components'];

  return {
    presets,
    plugins,
  };
};
