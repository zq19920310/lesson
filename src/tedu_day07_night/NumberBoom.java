package tedu_day07_night;
/*
 * import  哥们儿跟我来一下
 * java.util.  家庭地址
 */
import java.util.Scanner;


public class NumberBoom {
	public static void main(String[] args) {
		int start =1;
		int end   =100;
		System.out.println("如果想玩数字炸弹游戏,请输入Y/N？");
		Scanner sc    =new Scanner(System.in);
		String  choice=sc.nextLine();

		boolean flag = true;
		int num =0;
		while( choice.equals("Y") || choice.equals("y") ) {

			if(flag==true) {
				num =(int)(Math.random()*100+1) ;
				System.out.println("系统已生成了一个炸弹数字");
				flag=false;
			}
			System.out.println("请猜数字.....");
			Scanner scan =new Scanner(System.in);
			int guess =scan.nextInt();
				  if(num < guess) {
					  end = guess;
			}else if(num > guess) {
					start = guess;
			}else if(num == guess) {
					flag=true;
					start=1;
					end=100;
					System.out.println("恭喜恭喜,你踩中了数字炸弹");
					System.out.println("是否还想继续,Y/N");
					choice=sc.nextLine();
					continue;
			}
			System.out.println("当前所猜测的数字范围:" + start+"~~~"+end);
		}
		if(choice.equals("N") || choice.equals("n")) {
			System.out.println("退出游戏");
		}
	
		
	}
}





