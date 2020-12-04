package tedu_day04_afternoon;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
				Scanner scan =new Scanner(System.in);
				System.out.println("请输入第一个数字");
				double a = scan.nextDouble();
				System.out.println("请输入第二个数字");
				double b = scan.nextDouble();
				System.out.println("请输入符号");
				String fuhao = scan.next();
				switch(fuhao) {//判断符号
					case "+" : System.out.println(a+b); break;//结束当前的程序
					case "-" : System.out.println(a-b); break;
					case "*" : System.out.println(a*b); break;
					case "/" : System.out.println(a/b); break;
					default  : System.out.println("您输入的符号不正确,请重新输入"); 
				}
				
				
				
				
		/*
		 * if(fuhao.equals("+")) { System.out.println(a+b); }else if(fuhao.equals("-"))
		 * { System.out.println(a-b); }else if(fuhao.equals("*")) {
		 * System.out.println(a*b); }else if(fuhao.equals("/")) {
		 * System.out.println(a/b); }else { //其他的不满足上述情况的结果
		 * System.out.println("您输入的符号不正确,请重新输入"); }
		 */
	}	
}








