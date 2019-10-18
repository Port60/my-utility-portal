var path = require('path');
var MiniCssExtractPlugin = require("mini-css-extract-plugin");
var CopyPlugin = require('copy-webpack-plugin');


module.exports = {
    entry: [
        './node_modules/popper.js/dist/umd/popper.min.js',
        './node_modules/bootstrap/dist/js/bootstrap.min.js',
        //'./node_modules/pace-progress/pace.min.js',
        './node_modules/perfect-scrollbar/dist/perfect-scrollbar.min.js',
        './node_modules/@coreui/coreui/dist/js/coreui.min.js',
        './node_modules/chart.js/dist/Chart.min.js',
        './src/js/main.js',
        // './node_modules/@coreui/icons/css/coreui-icons.min.css',
        // './node_modules/flag-icon-css/css/flag-icon.min.css',
        // './node_modules/font-awesome/css/font-awesome.min.css',
        // './node_modules/simple-line-icons/css/simple-line-icons.css',
        './src/scss/style.scss',
        './src/scss/vendors/pace-progress/pace.scss'],
    output: {
        filename: 'js/bundle.js',
        path: path.resolve(__dirname, 'dist'),
    },

    module: {
        rules: [
            {
                test: /\.js$/,
                exclude: /(node_modules)/,
                use: {
                    loader: 'babel-loader',
                    options: {
                        presets: ['@babel/preset-env']
                    }
                }
            },
            {
                // Apply rule for .sass, .scss or .css files
                test: /\.(sa|sc|c)ss$/,

                // Set loaders to transform files.
                // Loaders are applying from right to left(!)
                // The first loader will be applied after others
                use: [
                    {
                        // After all CSS loaders we use plugin to do his work.
                        // It gets all transformed CSS and extracts it into separate
                        // single bundled file
                        loader: MiniCssExtractPlugin.loader
                    },
                    {
                        // This loader resolves url() and @imports inside CSS
                        loader: "css-loader",
                    },
                    {
                        // First we transform SASS to standard CSS
                        loader: "sass-loader",
                        options: {
                            implementation: require("sass")
                        }
                    }
                ]
            },

        ],

    },
    plugins: [

        new MiniCssExtractPlugin({
            filename: "css/bundle.css"
        }),
        new CopyPlugin([
            { from: './src/img', to: 'img' },
            { from: './src/icon', to: 'icon' },
            { from: './src/notifications', to: 'notifications' },
        ]),

    ]
};