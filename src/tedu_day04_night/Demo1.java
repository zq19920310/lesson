package tedu_day04_night;
public class Demo1 {

	public static void main(String[] args) {//程序的入口---计算机执行命令的地方
		int a 	=300;
		int b 	=500;
		int c 	=400;
		int max;
		if(a>=b) {
			max=a;
		}else {
			max=b;
		}
		if(c>=max) {
			max=c;
		}
		System.out.println( max );
	}
}






