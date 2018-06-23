const Express = require('express');
const MongoClient = require('mongodb').MongoClient;

const router = Express.Router();

// Connection URL
const url = 'mongodb://localhost:27017';

// Database Name
const dbName = 'ticket_service';

router.get('/', function (req, res) {
  MongoClient.connect(url, (err, client) => {
    const db = client.db(dbName);
    var r = db.collection('events').find({}).toArray((err, result) => {
      res.send(result);
      client.close();
    });
  });
});

exports.router = router;