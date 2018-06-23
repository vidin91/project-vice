/**
 * Performs binary Search.
 * NOTE: Binary search only works with sorted arrays!
 * @param {Array<number>} array 
 * @param {number} value 
 */
export function binarySearch(array: Array<number>, value: number) {
  let low: number = 0;
  let high: number = array.length - 1;
  while (low < high) {
    let mid = Math.trunc((low + high) / 2);
    if (array[mid] === value) {
      return mid;
    } else if (array[mid] < value) {
      low = mid + 1;
    } else {
      high = mid - 1;
    }
  }
  if (array[low] === value) {
    return low;
  }
  return -1;
}

export function binarySearchRecursive(array, value) {
  return req(array, value, 0, array.length - 1);
  function req(array: Array<number>, value: number, low: number, high: number) {
    if (low < high) {
      let mid = Math.trunc((low + high) / 2);
      if (array[mid] === value) {
        return mid;
      } else if (array[mid] < value) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
      return req(array, value, low, high);
    } else {
      if (array[low] === value) {
        return low;
      } else {
        return -1;
      }
    }
  }
}