package tedu_day03_afternoon;

import java.util.Scanner;

public class Atm {


	public static void main(String[] args) {
		int cunkuan=50000;
		while(cunkuan>0) {
			System.out.println("����������ȡ����:");
			Scanner sc = new Scanner( System.in );
			int qukuan = sc.nextInt() ;

			if(qukuan%100  !=   0 ) {
				System.out.println("�����������ȡ�����100������,���������롷����");
				continue;
			}
			if(qukuan>20000) {
				System.out.println("�������������Ľ������Ϊ20000,���������롷����");
				continue;
			}
			if(qukuan>cunkuan) {
				System.out.println("����������������,����������ȡ�����������");//��ʾ�õ�
				continue;
			}
			int yu     = cunkuan-qukuan;
			System.out.println("��ǰ�������:" + yu);
			cunkuan    = yu ;
		}
	}
}





