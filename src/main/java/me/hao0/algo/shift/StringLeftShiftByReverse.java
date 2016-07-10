package me.hao0.algo.shift;

/**
 * 对于字符串的左旋实现，逆序实现
 * 上午2:23:43
 */
public class StringLeftShiftByReverse {
	public static void main(String[] args) {
		String str = "1234abcd";
		int shiftNum = 3; //左旋位数
		System.out.println("original string: ");
		System.out.println(str);
		str = leftShift(str, shiftNum);
		System.out.println("shifted string: ");
		System.out.println(str);
	}
	
	/**
	 * 左旋字符串
	 * @param str 原字符串
	 * @param shiftNum 旋转位数
	 * @return
	 */
	private static String leftShift(String str, int shiftNum) {
		String leftString = str.substring(0, str.length()-shiftNum);
		String rightString = str.substring(str.length()-shiftNum);
		leftString = reverse(leftString); //逆序左边的子串
		rightString = reverse(rightString); //逆序右边的子串
		return reverse(leftString + rightString); //逆序整个子串
	}
	
	/**
	 * 逆序字符串
	 * @param str "abc" --> "cba"
	 * @return 逆序后的字符串
	 */
	private static String reverse(String str) {
		char[] cs = str.toCharArray();
		int i = 0, j=cs.length-1;
		while (i < j){
			char temp = cs[i];
			cs[i] = cs[j];
			cs[j] = temp;
			i++;
			j--;
		}
		return new String(cs);
	}
}
