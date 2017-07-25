package me.hao0.algo.combine;

import java.util.Arrays;

/**
 * 从数组a中，取出n个数的所有组合(可重复取)
 */
public class RepeatableSelectableCombine {

  public void combine(int[] a, int n) {
    if (null == a || a.length == 0 || n <= 0 || n > a.length) {
      return;
    }
    Arrays.sort(a);
    int[] b = new int[n];// 辅助空间，保存待输出组合数
    getCombination(a, n, 0, b, 0);
  }

  private void getCombination(int[] a, int n, int begin, int[] b, int index) {
    if (n == 0) {// 如果够n个数了，输出b数组
      for (int i = 0; i < index; i++) {
        System.out.print(b[i] + " ");
      }
      System.out.println();
      return;
    }

    for (int i = 0; i < a.length; i++) {
      if (index == 0 || a[i] >= b[index - 1]) {
        b[index] = a[i];
        getCombination(a, n - 1, i + 1, b, index + 1);
      }
    }
  }

  public static void main(String[] args) {

    RepeatableSelectableCombine robot = new RepeatableSelectableCombine();

    int[] a = {1, 2, 3, 4, 5};

    long start = System.currentTimeMillis();

    for (int i=1; i<=a.length; i++){
      robot.combine(a, i);
    }

    System.out.println("cost: " + (System.currentTimeMillis() - start));
  }
}
