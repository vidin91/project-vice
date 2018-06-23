/**
 * @overview
 * Permutations, Variations, Combinations
 */

/**
 * Number of permutations for given n numbers: n!
 * Number of variations of k elements from n
 */

/**
 * Algorithm: take AB, returns AB, BA.
 * Take ABC: returns A "+" permutations(AB). What "+" means here, is to insert it at every
 * single position: A "+" BC = ABC, BAC, BCA
 */
function permutations (string) {
  let array = string.split('');
  if (array.length === 2) {
      return [String(array[0]) + String(array[1]), String(array[1]) + String(array[0])];
  }
  let ret = [];
  permutations(array.slice(1)).forEach(substring => {
      for (let i = 0; i < substring.length + 1; i++) {
          let toAdd = substring.split('');
          toAdd.splice(i, 0, array[0]);
          ret.push(toAdd.join(''));
      }
  });
  return ret;
}

/**
 * Algorithm uses a tree (@see https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/)
 * @param string 
 */
function permutationsSecondApproach(string) {
  function swap(array, i, j) {
    let temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
  let ret = [];
  function permutate(array, start, end) {
    if (start === end) ret.push(array.join(''));
    for (let i = start; i <= end; i++) {
      swap(array, start, i);
      permutate(array, start + 1, end);
      swap(array, i, start); //restore original value
    }
  }
  permutate(string.split(''), 0, string.length - 1);
  return ret;
}