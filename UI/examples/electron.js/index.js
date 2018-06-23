var {app, BrowserWindow} = require('electron');
var path = require('path');

app.on('ready', () => {
  let main = new BrowserWindow({
    width: 500,
    height: 500
  });
  main.loadURL('file://' + path.resolve(__dirname, './index.html'));
});