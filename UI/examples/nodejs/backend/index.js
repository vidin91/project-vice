var userService = require('./UserService');
var http = require('http');
var URL = require('url');

function getQuery(url) {
  var parsed = URL.parse(url);
  let query = {};
  if (parsed.query) {
    query = parsed.query.split('&');
    query = query.reduce((prev, curr) => {
      let p = curr.split('=');
      prev[p[0]] = p[1];
      return prev;
    }, {});
  }
  return query;
}

http.createServer((request, response) => {
  let query = getQuery(request.url);
  if (query.command) {
    switch (query.command) {
      case 'add':
        let {name, age, address} = query;
        userService.addUser(name, age, address);
        response.end();
        break;
      case 'list':
        userService.getAllUsers().then((data) => {
          response.write(JSON.stringify(data));
          response.end();
        });
        break;
    }
  }
}).listen(3000);