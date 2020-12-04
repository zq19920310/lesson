package tedu_day05_afternoon;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FishJFrame extends JFrame{
	public FishJFrame(){
		FishJPanel fp=new FishJPanel();
		this.add(fp);
		fp.moveWugui();
		this.setSize(800, 480);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("捕鱼达人之乌龟游泳");
		this.setIconImage(new ImageIcon("image/icon.jpg").getImage());
		this.setVisible(true);
	}

	public static void main(String[] args) {//主线程
		new FishJFrame();
	}
}

class FishJPanel extends JPanel{
	int index=0;
	int x=200;
	int y=200;
	Image []wuGui=new Image[10];
	public FishJPanel(){
		for (int i = 0; i < wuGui.length; i++) {
			wuGui[i]=new ImageIcon("image/left_to_right/fish08_0"+(i+1)+".png").getImage();
		}
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(new ImageIcon("image/bg_03.png").getImage(), 0, 0, this);
		g.drawImage(wuGui[index], x, y, this);
	}
	
	public void moveWugui(){
		new Thread(){//布置乌龟的线程的详细任务		Thread就是线程的意思
			public void run(){
				while(true){
					x+=10;
					if(x>800){
						x=-20;
					}
					index++;
					if(index>=9){
						index=0;
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					repaint();
				}
				
			}
		}.start();
	}
}










