var fs = require('fs');
var path = require('path');
const RECORD_SIZE = 61;
const MAX_NAME_SIZE = 30;
const MAX_ADDRESS_SIZE = 30;

class UserService {
  constructor() {}
  getPath() {
    return path.resolve(__dirname, './store.dat');
  }
  addUser(name, age, address) {
    let size = 0;
    if (fs.existsSync(this.getPath())) {
      size = fs.statSync(this.getPath()).size;
    }
    var record = Buffer.alloc(RECORD_SIZE);
    record.write(name, 'utf8');
    record.writeInt8(age, MAX_NAME_SIZE);
    record.write(address, 1 + MAX_NAME_SIZE, address.length, 'utf8');
    /**
     * Common mistake: if I open in 'write' mode everything is overwritten, no matter
     * If I pass offset for writting or not
     */
    fs.open(this.getPath(), 'a', (err, fileDescriptor) => {
      fs.write(fileDescriptor, record, 0, 61, size, () => {
        fs.close(fileDescriptor);
      });
    });
  }
  getAllUsers() {
    return new Promise((resolve, reject) => {
      debugger;
      var data = [];
      var stream = fs.createReadStream(this.getPath());
      stream.pause();
      stream.on('readable', () => {
        var record = stream.read(61);
        if (record) {
          let name = record.toString('utf8', 0, 30);
          let age = record.readInt8(30);
          let address = record.toString('utf8', 31, 61);
          data.push({name, age, address});
        }
      });
      stream.on('end', () => resolve(data));
    });
  }

  getUser(order) {}
}

module.exports = new UserService();