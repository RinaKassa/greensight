// see https://webpack.js.org/plugins/mini-css-extract-plugin/
// this plugin should NOT be used in development
// it should only be loaded in a production build
const MiniCssExtractPlugin = require('mini-css-extract-plugin');

// see https://webpack.js.org/plugins/css-minimizer-webpack-plugin/
const CssMinimizerPlugin = require('css-minimizer-webpack-plugin');

const { VueLoaderPlugin } = require('vue-loader');

// used to get absolute path
const path = require('path');
const { DefinePlugin } = require('webpack');

// will be true if we are in a development environnement
// make sure NODE_ENV is set properly, this will have a significant impact
// on bundle size
const devMode = process.env.NODE_ENV !== 'production';

module.exports = {
  mode: devMode ? 'development' : 'production',

  // Define the entry points here. They MUST have the same name as the page_id
  // defined in src/main/java/org/sonarsource/plugins/web/MyPluginPageDefinition.java
  entry: {
    // tell webpack that view.js in bundle correspond to index.jsx on disk
    view: './src/main/js/index.js',
  },
  output: {
    // The entry point files MUST be shipped inside the final JAR's static/ directory.
    // aka, set where webpack should export compiled files
    path: path.join(__dirname, 'target/classes/static'),
    filename: '[name].js',

    // tell dev-server where to serve all files
    // output files will be available on localhost:8080/static/greensight/
    publicPath: '/static/greensight/',

    // clear output.path before building
    clean: true,
  },

  // define externals packages, package that will NOT be included in
  // a production build
  externals: [
    {
      // Register the Sonar* globals as packages, to simplify importing.
      // See src/main/js/common/api.js for more information on what is exposed
      // in SonarRequest.
      'sonar-request': 'SonarRequest',

      // TODO: provide an example
      'sonar-measures': 'SonarMeasures',
    },
  ],
  resolve: {
    // alias ready to be used
    alias: {
      Icons: path.resolve(__dirname, 'src/main/assets/icons'),
      Images: path.resolve(__dirname, 'src/main/assets/images'),
    },
    extensions: ['.js', '.jsx', '...'],
  },

  // only load MiniCssExtractPlugin if we are in prod
  plugins: [
    new VueLoaderPlugin(),
    new DefinePlugin({
      // Drop Options API from bundle
      __VUE_OPTIONS_API__: false,
      __VUE_PROD_DEVTOOLS__: false,
    }),
  ].concat(devMode ? [] : new MiniCssExtractPlugin()),
  optimization: {
    // minimizing will only happend on production build
    minimizer: [
      // extend webpack minimizer with our own
      '...',
      new CssMinimizerPlugin({
        // should make Minimizing a bit faster
        parallel: true,
      }),
    ],

    // the two lines below should make js code a bit smaller
    mangleExports: 'size',
    mangleWasmImports: true,
  },
  module: {
    rules: [
      {
        test: /\.vue$/,
        loader: 'vue-loader',
      },
      {
        // see babel.config.js for babel config
        test: /\.(js|jsx)$/,
        exclude: /(node_modules)/,
        loader: 'babel-loader',
      },
      {
        // match css, sass and scss files
        test: /\.(c|(s[ac]))ss$/,
        use: [
          // if in dev, style loader will be used, css will be injected in inline
          // if in prod, css will be in a separated file and inserted MANUALLY on loading
          // see index.js
          devMode
            ? { loader: 'style-loader' }
            : { loader: MiniCssExtractPlugin.loader },
          {
            loader: 'css-loader',
            options: {
              // 1 because we have postcss
              importLoaders: 1,

              // disable sourcemap in prod, this will have a huge impact
              // on outputted css file size
              sourceMap: devMode,
            },
          },
          {
            // see postcss.config.js
            loader: 'postcss-loader',
          },
          {
            loader: 'sass-loader',
            options: {
              sourceMap: devMode,
            },
          },
        ],
      },
      {
        test: /\.(jpe?g|png|gif|woff|woff2|eot|ttf|svg)$/,

        // see https://webpack.js.org/guides/asset-management/#loading-images
        type: 'asset/resource',
      },
    ],
  },
  devServer: {
    client: {
      logging: 'verbose',
    },
    proxy: [
      {
        // by default we forward everything to the proxy (Sonarqube)
        // except Greensight files and webpack path
        context: ['**', '!/webpack-dev-server/**', '!/static/greensight/**'],
        target: 'http://localhost:9000',
        changeOrigin: false,
      },
    ],

    // this will tell devServer to open the webpage with /projects happened at the end
    open: ['/projects'],
  },

  // this will allow debugging of css much easier, at the cost of file size
  // this will be disabled in prod
  devtool: devMode ? 'inline-source-map' : false,
};
