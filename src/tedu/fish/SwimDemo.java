package tedu.fish;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SwimDemo {
	public static void main(String[] args) {
		JFrame jf = new JFrame();
		FPanel panel = new FPanel();
		jf.add(panel);
		jf.setSize(800, 520);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);

		new Thread(panel).start();
	}
}

class FPanel extends JPanel implements Runnable {
	ImageIcon bg;
	ImageIcon[] fishes = new ImageIcon[10];
	int x, y;
	int index = 0;
//	Random rr = new Random();

	public FPanel() {
		bg = new ImageIcon("case09/bg_03.png");
		for (int i = 0; i < 10; i++) {
			/*if (i == 9) {
				fishes[i] = new ImageIcon(
						"case09/right_to_left/fish01_" + (i + 1) + ".png");
			} else {
				fishes[i] = new ImageIcon(
						"case09/right_to_left/fish01_0" + (i + 1) + ".png");
			}*/
			/*String num="0"+(i+1);
			num=num.substring(num.length()-2);
			
			fishes[i] = new ImageIcon(
					"case09/right_to_left/fish01_" + num + ".png");*/
			fishes[i] = new ImageIcon(
					"case09/right_to_left/fish01_" + 
							(i==9?"10":"0"+(i+1)) + ".png");
		}
		x = 800;
		y = 100;
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawImage(bg.getImage(), 0, 0, null);
		g.drawImage(fishes[index].getImage(), x, y, null);
	}

	@Override
	public void run() {
		while (true) {
			x -= 2;
			if (x < -fishes[index].getIconWidth()) {
				x = 800;
				//y = rr.nextInt(520 - fishes[index].getIconHeight());
				y=(int)(Math.random()*(520-fishes[index].getIconHeight()));
			}

			index++;
			index = index % fishes.length;

			repaint();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
