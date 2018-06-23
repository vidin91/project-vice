var Rx = require('rxjs');
var observable = Rx.Observable.create((observer) => {
  /**
   * this function body is executed everytime new subscriber is added
   * Similar to Iterator protocol!
   */
  console.log('new subscriber');
  observer.next(11);
  observer.next(22);
  setTimeout(() => {
    observer.next(44);
  }, 1000);
});

var s = observable.subscribe((x) => {
  console.log(x);
});

setTimeout(() => {
var s2 = observable.subscribe((x) => {
  console.log(x);
});
}, 2000);
/**
 * ^^ code will output:
 * new subscriber
 * 11
 * 22
 * 44
 * TWICE!
 */

/**
 * Subject
 */
console.log('*** subject example ***');
var subject = new Rx.Subject();
subject.next(1);
subject.next(2);
setTimeout(() => {
  subject.next(3);
}, 400);

subject.subscribe((x) => {
  console.log(x);
});
// only 3 is printed!

/**
 * Subject Example 2: Since Subject is also Observer:
 */
var subject = new Rx.Subject();

subject.subscribe({
  next: (v) => console.log('observerA: ' + v)
});
subject.subscribe({
  next: (v) => console.log('observerB: ' + v)
});

var observable = Rx.Observable.from([1, 2, 3]);

observable.subscribe(subject); // You can subscribe providing a Subject