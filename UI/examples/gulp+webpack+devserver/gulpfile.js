var Gulp = require('gulp');
var WebServer = require('gulp-webserver');

Gulp.task('default', function () {
  Gulp.src('./src/**/*.js').pipe(Gulp.dest('./public'));
});

Gulp.task('server', function() {
  Gulp.src('./')
    .pipe(WebServer({
      livereload: true,
      directoryListing: true,
      port: 9002
    }));
});