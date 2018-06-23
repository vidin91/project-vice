const MongoClient = require('mongodb').MongoClient;

const types = ['SPORT', 'MUSIC', 'FILM'];

const event1 = {
  name: 'F4 Final Game: Real Madrid - Fenerbahce',
  date: '2018-5-20T20:00:00',
  type: 'SPORT',
  description: 'final game of Euroleague basketball',
  location: {
    name: 'Stark Arena',
    city: 'Belgrade',
    type: 'arena',
    capacity: 30000
  },
  tags: ['basketball', 'belgrade', 'Final4']
}

const event2 = {
  name: 'Metallica concert',
  date: '2018-6-10T20:00:00',
  type: 'MUSIC',
  description: 'Metallica again in Belgrade',
  location: {
    name: 'Usce',
    city: 'Belgrade',
    type: 'open',
    capacity: 100000
  },
  tags: ['metallica', 'belgrade', 'usce2018']
};

MongoClient.connect('mongodb://localhost:27017', (err, client) => {
  const db = client.db('ticket_service');
  db.collection('events').insertMany([event1, event2], (err, result) => {
    console.log(result);
    client.close();
  })
});
