export function fibonacci (n) {
  let prev_0 = 1;
  let prev_1 = 1;
  if (n === 1 || n === 2) return 1;
  let k = 3;
  while (k++ <= n) {
    let sum = prev_0 + prev_1;
    prev_0 = prev_1;
    prev_1 = sum;
  }
  return prev_1;
}

export function fibonacciRecursion (n) {
  if (n === 1 || n === 2) return 1;
  return fibonacciRecursion(n - 2) + fibonacciRecursion(n - 1);
}

//1 1 2 3 5 8 13