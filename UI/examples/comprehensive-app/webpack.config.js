const path = require('path');

module.exports = {
  mode: 'development',
  entry: {
    app: './src/index.js'
  },
  devtool: 'inline-source-map',
  // plugins: [
  //   new CleanWebpackPlugin(['dist']),
  //   new HtmlWebpackPlugin({
  //     title: 'Output Management'
  //   })
  // ],
  module: {
    rules: [
      {test: /\.js$/, use: 'babel-loader', exclude: /node_modules/},
      {test: /\.css$/, use: ['style-loader', 'css-loader']}, //loaders are applied in reverse order!
      {test: /\.less$/, use: ['style-loader', 'css-loader', 'less-loader']},
      {test: /\.handlebars$/, use: ['handlebars-loader']},
      {test: /\.html$/, use: ['raw-loader']}
    ]
  },
  output: {
    filename: '[name].bundle.js',
    path: path.resolve(__dirname, 'dist')
  }
};