package projectvice.algorithms.sorting;

import org.junit.Test;
import projectvice.algorithms.sorting.InsertionSort;

import java.util.Arrays;

import org.junit.Assert;

public class InsertionSortTest {
  
  @Test
  public void testInsertionSort() {
    int[] array = new int[] {2, 1, 10, 4, 5, 7, 6};
    InsertionSort.sort_v2(array);
    Assert.assertEquals(Arrays.toString(array), "[1, 2, 4, 5, 6, 7, 10]");
  }
}
