package projectvice.algorithms.sorting;

public class QuickSort {
  public static void sort(int[] array) {
    quickSort(array, 0, array.length - 1);
  }
  
  private static void quickSort(int[] array, int low, int high) {
    if (low < high) {
      int j = partition(array, low, high);
      quickSort(array, low, j - 1);
      quickSort(array, j + 1, high);
    }
  }
  
  private static int partition(int[] array, int low, int high) {
    int pivot = array[low];
    int i = low;
    int j = high;
    while (i < j) {
      while (array[i] <= pivot && i < j) i++;
      while (array[j] > pivot) j--;
      if (i < j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
      }
    }
    array[low] = array[j];
    array[j] = pivot;
    return j;
  }
}
