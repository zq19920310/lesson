package tedu_day07_night;
/*
 * import  ���Ƕ�������һ��
 * java.util.  ��ͥ��ַ
 */
import java.util.Scanner;


public class NumberBoom {
	public static void main(String[] args) {
		int start =1;
		int end   =100;
		System.out.println("�����������ը����Ϸ,������Y/N��");
		Scanner sc    =new Scanner(System.in);
		String  choice=sc.nextLine();

		boolean flag = true;
		int num =0;
		while( choice.equals("Y") || choice.equals("y") ) {

			if(flag==true) {
				num =(int)(Math.random()*100+1) ;
				System.out.println("ϵͳ��������һ��ը������");
				flag=false;
			}
			System.out.println("�������.....");
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
					System.out.println("��ϲ��ϲ,�����������ը��");
					System.out.println("�Ƿ������,Y/N");
					choice=sc.nextLine();
					continue;
			}
			System.out.println("��ǰ���²�����ַ�Χ:" + start+"~~~"+end);
		}
		if(choice.equals("N") || choice.equals("n")) {
			System.out.println("�˳���Ϸ");
		}
	
		
	}
}





