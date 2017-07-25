package me.hao0.algo.combine;

/**
 * 输出数组a的全排列(可重复取)
 */
public class RepeatableCombine {

  public void runPermutation(int[] a) {

    if (null == a || a.length == 0) {
      return;
    }
    int[] b = new int[a.length];// 辅助空间，保存待输出排列数
    getAllPermutation(a, b, 0);
  }

  public void getAllPermutation(int[] a, int[] b, int index) {
    // 当index和数组的长度一致的时候打印
    if (index == a.length) {
      for (int i = 0; i < index; i++) {
        System.out.print(b[i] + " ");
      }
      System.out.println();
      return;
    }

    for (int i = 0; i < a.length; i++) {
      b[index] = a[i];
      getAllPermutation(a, b, index + 1);
    }
  }

  public static void main(String[] args) {
    RepeatableCombine robot = new RepeatableCombine();
    int[] a = {1, 2, 3};
    robot.runPermutation(a);
  }
}