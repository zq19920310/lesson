package tedu_day06_afternoon;

public class HumanTest {
	
	public static void main(String[] args) {

		Human   zhaoqiang = new  Human();
		String  adress	  = zhaoqiang.adress;
		int 	shengao   = zhaoqiang.shengao;
		System.out.println(adress);
		System.out.println(shengao);
		zhaoqiang.eat();
		zhaoqiang.drink();
	}

}
