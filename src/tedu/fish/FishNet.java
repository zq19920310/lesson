package tedu.fish;

import java.awt.Graphics;
import java.util.Vector;

import javax.swing.ImageIcon;

public class FishNet {
	public int x, y;
	public ImageIcon img;
	public FishPanel panel;

	public Vector<Fish> caFish = new Vector<Fish>();
	public int count;// ¼ÆÊýÆ÷
	public boolean isLive = true;

	public FishNet(FishPanel panel, int x, int y) {
		this.x = x;
		this.y = y;
		this.panel = panel;
		img = new ImageIcon("case09/web.png");
	}

	public void drawNet(Graphics g) {
		g.drawImage(img.getImage(), x, y, panel);
	}

	public void raiseNet() {
		count++;
		if (count > 15) {
			x = -100;
			y = -100;
			isLive = false;
		}
	}

	public void caFish() {
		for (int i = 0; i < panel.fishes.size(); i++) {
			Fish f = panel.fishes.get(i);
			if (f.x + f.imgs[0].getIconWidth() / 2 > this.x
					&& f.x + f.imgs[0].getIconWidth() / 2 < this.x + this.img.getIconWidth()
					&& f.y + f.imgs[0].getIconHeight() / 2 > this.y
					&& f.y + f.imgs[0].getIconHeight() / 2 < this.y + this.img.getIconHeight()) {

				f.hp--;
				if (f.hp == 0) {
					f.isCatch = true;
					caFish.add(f);
					
					Money m = new Money(panel,f);
					panel.ms.add(m);
					new MoneyThread(m).start();
					
//					panel.score+=f.money;
				}
			}
		}
	}
}
