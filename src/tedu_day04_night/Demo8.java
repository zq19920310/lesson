package tedu_day04_night;

import java.util.Arrays;

public class Demo8 {
	public static void main(String[] args) {
		System.out.println(test());
		int [] arr= test2(8);
		Arrays.stream(arr).forEach(s->System.out.println(s));
	}
	
	public static String test() {
		return "今天天气真不错";
	}
	public static int[] test2(int a) {
		return new int[a];
	}
}
