package projectvice.algorithms.sorting;

public class BubbleSort {
  public static void sort_v1(int [] array) {
    if (array.length < 2) return;
    int limit = array.length - 1;
    while (limit > 0) {
      boolean swapped = false;
      for (int i = 0; i < limit; i++) {
        if (array[i] > array[i + 1]) {
          int temp = array[i];
          array[i] = array[i + 1];
          array[i + 1] = temp;
          swapped = true;
        }
      }
      if (!swapped) break;
      limit--;
    }
  }
  
  public static void sort_v2(int[] array) {
    // If we remember last position where swap was done,
    // it means that elements on higher positions are already in order
    if (array.length < 2) return;
    int lastSwapped = array.length - 1;
    do {
      int limit = lastSwapped;
      lastSwapped = 0;
      for (int i = 0; i < limit; i++) {
        if (array[i] > array[i + 1]) {
          int temp = array[i];
          array[i] = array[i + 1];
          array[i+1] = temp;
          lastSwapped = i;
        }
      }
    } while (lastSwapped > 0);
  }
}
