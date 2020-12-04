package tedu_day05_night;
public class RedPackage {
	public static void main(String[] args) {
		double  total  = 188.88; //红包金额
		int		num    = 10;    //红包个数
		double	max	   = total / num * 2 ;	
		double[] red   = new double [num];
		int count =0;
		double sum=0;
		while(count < num ) {
			double  price  = Math.random() * max;		
			double  money  = Math.round(  price *100 ) / 100.0 ;  
			if(count<num-1) {
				red[count] = money;
				sum +=money;
			}else {
				double  last   = Math.round(  (total-sum) *100 ) / 100.0 ;
				if(last>0) {
					red[count] = last;
				}else {
					count=0;
					sum  =0;
					continue;
				}
			}
			count++;
		}
		int i=0;	
		while(i<num) {		
			System.out.println( red[i] );
			i++;
		}
	}
}













