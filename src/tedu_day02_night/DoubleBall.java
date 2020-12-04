package tedu_day02_night;

import java.util.Arrays;

public class DoubleBall {
	public static void main(String[] args) {
		int[] redball = new int[6]; 
		int count = 0;
		while (count < 6) {
			int red = (int) (Math.random() * 33 + 1);
			if(redball[0]==red || redball[1]==red || redball[2]==red ||
			   redball[3]==red || redball[4]==red || redball[5]==red) 
			{
				continue;
			}
			redball[count] = red;
			count++;
		}
		Arrays.sort( redball );
		System.out.print("ºìÇò:");
		int i = 0;
		while (i < 6) {
			System.out.print(redball[i] + "    ");// 0 1 2 3 4 5
			i++;
		}
		int blue = (int) (Math.random() * 16 + 1); //
		System.out.println("\r\nÀ¶Çò:" + blue);

	}

}
