package projectvice.algorithms.sorting;

public class InsertionSort {
  public static void sort(int[] array) {
    for (int i = 1; i < array.length; i++) {
      int toInsert = array[i];
      int j = i - 1;
      while (j >= 0 && array[j] > toInsert) {
        array[j + 1] = array[j];
        j--;
      }
      array[j + 1] = toInsert;
    }
  }
  
  public static void sort_v2(int[] array) {
    for (int i = 1; i < array.length; i++) {
      int j = 0;
      // find insert position
      while (j < i && array[j] < array[i]) j++;
      if (j < i) {
        int next = array[i];
        while (j <= i) {
          int temp = array[j];
          array[j++] = next;
          next = temp;
        }
      }
    }
  }
}
