package tedu_day04_afternoon;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
				Scanner scan =new Scanner(System.in);
				System.out.println("�������һ������");
				double a = scan.nextDouble();
				System.out.println("������ڶ�������");
				double b = scan.nextDouble();
				System.out.println("���������");
				String fuhao = scan.next();
				switch(fuhao) {//�жϷ���
					case "+" : System.out.println(a+b); break;//������ǰ�ĳ���
					case "-" : System.out.println(a-b); break;
					case "*" : System.out.println(a*b); break;
					case "/" : System.out.println(a/b); break;
					default  : System.out.println("������ķ��Ų���ȷ,����������"); 
				}
				
				
				
				
		/*
		 * if(fuhao.equals("+")) { System.out.println(a+b); }else if(fuhao.equals("-"))
		 * { System.out.println(a-b); }else if(fuhao.equals("*")) {
		 * System.out.println(a*b); }else if(fuhao.equals("/")) {
		 * System.out.println(a/b); }else { //�����Ĳ�������������Ľ��
		 * System.out.println("������ķ��Ų���ȷ,����������"); }
		 */
	}	
}








