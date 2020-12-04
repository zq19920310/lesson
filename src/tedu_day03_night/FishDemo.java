//看代码不要看单词,要了解一行代码的含义
package tedu_day03_night;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class FishDemo {
	public static void main(String[] args) {
			JFrame   jf	    = new JFrame();

			ImageIcon minImg= new ImageIcon("C://image/min.png");
			ImageIcon cloImg= new ImageIcon("C://image/close.png");
			
			JButton  min    = new JButton( minImg );
			min.setBounds(700,20, 35, 35);
			min.setContentAreaFilled(false);
			
			JButton  close  = new JButton( cloImg );
			close.setBounds(750, 20, 35, 35);
			close.setContentAreaFilled(false);
			
			ImageIcon bgImg = new ImageIcon("C://image/bg_03.png");
			
			JLabel huabu    = new JLabel(bgImg);
			
			huabu.add(min);
			huabu.add(close);
			
			jf.add(huabu);
			
			jf.setUndecorated(true);
			
			jf.setBounds(200,100,800,480);
			
			jf.show();
			
	}
}






