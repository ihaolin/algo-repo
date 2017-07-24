package me.hao0.algo.utils;

import java.util.Random;

public class Maths {
	private static Random random = new Random();
	
	/**
	 * 产生随机数
	 * @param min 上界
	 * @param max 下界
	 * @return [min, max)
	 */
	public static int random(int min, int max){
		return random.nextInt(max)%(max-min+1) + min;
	}
}
