package me.hao0.algo.combine;

/**
 * 输出数组a的全排列(不可重复取)，利用二进制位
 */
public class BinaryCombine {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        String str[] = {"A", "B", "C", "D", "E", "1", "2", "3", "4"};

        // 5
        int nCnt = str.length;

        // 11111111 11111111 11111111 11111111
        // >>> 27
        // 00000000 00000000 00000000 00011111

        int nBit = (0xFFFFFFFF >>> (32 - nCnt));

        for (int i = 1; i <= nBit; i++) {
            for (int j = 0; j < nCnt; j++) {
                if ((i << (31 - j)) >> 31 == -1) {
                    System.out.print(str[j]);
                }
            }
            System.out.println("");
        }

        System.out.println("cost: " + (System.currentTimeMillis() - start));
    }
}
