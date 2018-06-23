import {ArrayStack} from './stack/ArrayStack';
import {Stack} from './stack/Stack';
import {List} from './list/List';

var stack: Stack = new ArrayStack(4);
stack.push(22);
stack.push(33);
//console.log(stack.array); //can't do this!
console.log(stack.toString());

