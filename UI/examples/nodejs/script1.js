var fs = require('fs');

var data = Buffer.alloc(20);
data.write('milos', 'ascii');

fs.open('store.dat', 'w', function (err, fd) {
  console.log(fd);
  fs.write(fd, data, 0, 20, 20);
});
