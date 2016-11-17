module.exports = {
  files: {
    javascripts: {
      joinTo: {
        'js/app.js':  [/^(?!app)/,/^app/]
      }
    },
    stylesheets: {joinTo: 'app.css'}
  },

  plugins: {
    babel: {presets: ['es2015', 'react']},

    eslint: {
      pattern: /^app\/.*\.js?x?$/,
      warnOnly: true
    }
  }
};