export function insertionSort(array: Array<number>): Array<number> {
  for (let i = 1; i < array.length; i++) {
    let j = i - 1;
    let val = array[i];
    while (j >= 0 && array[j] > val) {
      array[j + 1] = array[j];
      j--;
    };
    array[j + 1] = val;
  }
  return array;
}
