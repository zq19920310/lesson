package tedu_day01_afternoon;
public class Game {
	public static void main(String[] args) {
		String[] arr={"戴泽","伐木机","露娜","术士","帕格纳","墨客","露娜金色","伐木机金色"};
		int suiji = (int)(Math.random()*1000000);
		System.out.println( suiji );//可以在控制台当中输出小括号里的内容
			  if(0<=suiji && suiji<250000) {
				 System.out.println("莱恩");
		}else if(250000<=suiji && suiji<390000) {
				  int b = (int) (Math.random() * 2+7);
				  System.out.println(arr[b]);
		}else if(390000<=suiji && suiji<490000) {
				System.out.println("火猫");
		}else if(490000<=suiji && suiji<490004) {
				System.out.println("不朽盾");
		}else {
				  int a = (int) (Math.random() * 6);
				  System.out.println(arr[a]);
			  }
	}
}








