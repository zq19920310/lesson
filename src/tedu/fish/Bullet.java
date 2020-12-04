package tedu.fish;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;

public class Bullet {
	public int speed = 20;
	public double rotate;
	public ImageIcon img;
	public int x, y;
	public FishPanel panel;
	public boolean isLive = true;
	public int baseX, baseY;
	public int xxx, yyy;// Ͷ��֮�������ֵ��day17
	public int beginY;// ��ʼ��Y��day17

	public Bullet(FishPanel panel, int baseX, int baseY, double rotate) {
		this.baseX = baseX;
		this.baseY = baseY;
		x = baseX - 10;
		y = baseY - 17;
		beginY = y;// day17
		this.rotate = rotate;
		this.panel = panel;
		img = new ImageIcon("case09/A4.png");
	}

	public void drawBullet(Graphics g) {
		Graphics2D gp = (Graphics2D) g.create();
		gp.rotate(rotate, baseX, baseY);
		gp.drawImage(img.getImage(), x, y, panel);
	}

	public void move() {
		y -= speed;
		// ------------day17----------
		// Y����Ĳ�ֵ
		int yy = Math.round((float) Math.cos(rotate) * (beginY - y));
		yyy = baseY - yy - 17;
		// x����Ĳ�ֵ
		int xx = Math.round((float) Math.sin(rotate) * (beginY - y));
		xxx = baseX + xx - 10;
		//�жϳ����ͽ����߳�
		if (yyy < -10 || xxx < -10 ) {
			isLive = false;
			panel.bullets.remove(this);
		}
		hint();
		// -------------------------------
		panel.repaint();
	}

	public void hint() {//day17
		for(int i =0;i<panel.fishes.size();i++){
			Fish f= panel.fishes.get(i);
			if(xxx>f.x-img.getIconWidth()&&
				xxx<f.x+f.imgs[0].getIconWidth()&&
				yyy<f.y+f.imgs[0].getIconHeight()){
				isLive=false;
				panel.bullets.remove(this);
				FishNet net = new FishNet(panel,xxx-58,yyy-59);
				panel.nets.add(net);
				net.caFish();
			}
		}
	}
}
