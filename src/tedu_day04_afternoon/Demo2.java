package tedu_day04_afternoon;

import java.math.BigDecimal;

public class Demo2 {
	public static void main(String[] args) {
		//1.0跟0.9被计算机处理过了
		BigDecimal big1=new BigDecimal(Double.toString(1.0));
		BigDecimal big2=new BigDecimal(Double.toString(0.9));	
		System.out.println( big1.subtract(big2) );   //1.0-0.9
		
	}
}
