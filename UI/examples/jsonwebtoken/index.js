const jwt = require('jsonwebtoken');

const token = jwt.sign('Milos Milenovic', 'sifrica123');

const decoded = jwt.decode(token);

console.log(decoded);