package projectvice.algorithms.sorting;

import org.junit.Test;
import java.util.Arrays;
import org.junit.Assert;
import projectvice.algorithms.sorting.BubbleSort;

public class BubbleSortTest {
  @Test
  public void test1() {
    int[] array = new int[] {2, 1, 10, 5, 3, 2};
    BubbleSort.sort_v1(array);
    Assert.assertEquals(Arrays.toString(array), "[1, 2, 2, 3, 5, 10]");
  }
  
  @Test
  public void test2() {
    int[] array = new int[] {2, 1, 10, 5, 3, 2};
    BubbleSort.sort_v2(array);
    Assert.assertEquals(Arrays.toString(array), "[1, 2, 2, 3, 5, 10]");
  }
}
