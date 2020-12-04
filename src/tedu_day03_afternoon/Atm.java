package tedu_day03_afternoon;

import java.util.Scanner;

public class Atm {


	public static void main(String[] args) {
		int cunkuan=50000;
		while(cunkuan>0) {
			System.out.println("请输入您的取款金额:");
			Scanner sc = new Scanner( System.in );
			int qukuan = sc.nextInt() ;

			if(qukuan%100  !=   0 ) {
				System.out.println("《《《输入的取款金额不是100的整数,请重新输入》》》");
				continue;
			}
			if(qukuan>20000) {
				System.out.println("《《《单次提款的金额上限为20000,请重新输入》》》");
				continue;
			}
			if(qukuan>cunkuan) {
				System.out.println("《《《您卡内余额不足,请重新输入取款金额！！》》》");//提示用的
				continue;
			}
			int yu     = cunkuan-qukuan;
			System.out.println("当前卡内余额:" + yu);
			cunkuan    = yu ;
		}
	}
}





