export function bubbleSort(array: Array<number>): Array<number> {
  let high = array.length - 1;
  while (high >= 0) {
    for (let i = 0; i < high; i++) {
      if (array[i] > array[i + 1]) {
        [array[i], array[i + 1]] = [array[i + 1], array[i]];
      }
    }
    high--;
  }
  return array;
}
