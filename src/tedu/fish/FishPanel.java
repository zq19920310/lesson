package tedu.fish;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FishPanel extends JPanel implements Runnable {
	ImageIcon bg, bg1, solider, leftEduce, rightAdd, barrel;
	public int mouseX, mouseY, barrelX, barrelY, baseX, baseY;
	public double rotate;
	public Vector<Fish> fishes = new Vector<Fish>();
	public Vector<Bullet> bullets = new Vector<Bullet>();
	public Vector<FishNet> nets = new Vector<FishNet>();
	public Vector<Money> ms = new Vector<Money>();
	public int score = 10;
	public static boolean isOver=false;
	public MouseAdapter a1,a2;
	public FishPanel() {
		bg = new ImageIcon("case09/bg_03.png");
		bg1 = new ImageIcon("case09/bg1.jpg");
		solider = new ImageIcon("case09/solider.png");
		leftEduce = new ImageIcon("case09/ui_button_63_hv.png");
		rightAdd = new ImageIcon("case09/ui_button_65_hv.png");
		barrel = new ImageIcon("case09/level.png");
		barrelX = 423;
		barrelY = bg.getIconHeight() - barrel.getIconHeight();
		baseX = barrelX + 20;
		baseY = barrelY + 40;
		addMouseMotionListener(a1=new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseMoved(e);
				mouseX = e.getX();
				mouseY = e.getY();
				repaint();
			}
		});

		addMouseListener(a2=new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				if (e.getY() < FishPanel.this.getHeight() - 50) {
					Bullet bullet = new Bullet(FishPanel.this, baseX, baseY, rotate);
					bullets.add(bullet);
					new BulletThread(bullet).start();
					score--;
				}
			}
		});
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawImage(bg.getImage(), 0, 0, this);

		for (int i = 0; i < fishes.size(); i++) {
			Fish f = fishes.get(i);
			f.drawFish(g);
		}

		for (int i = 0; i < bullets.size(); i++) {
			Bullet b = bullets.get(i);
			b.drawBullet(g);
		}

		for (int i = 0; i < nets.size(); i++) {
			FishNet net = nets.get(i);
			net.drawNet(g);
		}
		
		for (int i = 0; i < ms.size(); i++) {
			Money m = ms.get(i);
			m.drawMoeny(g);
		}

		g.drawImage(bg1.getImage(), (this.getWidth() - bg1.getIconWidth()) / 2, this.getHeight() - bg1.getIconHeight(),
				this);
		g.drawImage(solider.getImage(), 561, 453, this);
		g.drawImage(leftEduce.getImage(), 350, this.getHeight() - leftEduce.getIconHeight(), this);
		g.drawImage(rightAdd.getImage(), 500, this.getHeight() - rightAdd.getIconHeight(), this);

		// 画成绩
		g.setColor(Color.red);
		g.setFont(new Font("微软雅黑", Font.BOLD, 20));
		g.drawString("" + score % 10, 155, 471);
		g.drawString("" + score / 10 % 10, 131, 471);
		g.drawString("" + score / 100 % 10, 109, 471);
		g.drawString("" + score / 1000 % 10, 86, 471);
		g.drawString("" + score / 10000 % 10, 62, 471);
		g.drawString("" + score / 100000 % 10, 39, 471);
		Graphics2D gp = (Graphics2D) g.create();
		rotate = getRotate();
		gp.rotate(rotate, barrelX + 20, barrelX + 40);
		gp.drawImage(barrel.getImage(), barrelX, barrelY, this);
                  	}

	public double getRotate() {
		if (mouseY < baseY) {
			double x1 = (double) (mouseX - baseX);
			double y1 = (double) (mouseY - baseY);
			return Math.atan(-x1 / y1);
		} else {
			if (mouseX < baseX) {
				return -Math.PI / 2;
			} else {
				return Math.PI / 2;
			}
		}
	}

	@Override
	public void run() {
		while (!isOver) {
			if(score<=0){
				isOver=true;
				this.removeMouseListener(a2);
				this.removeMouseMotionListener(a1);
				JOptionPane.showMessageDialog(null, "游戏结束");
			}
			

			for (int i = nets.size() - 1; i >= 0; i--) {
				FishNet net = nets.get(i);

				if (net.isLive) {
					net.raiseNet();
				} else {
					for (int j = net.caFish.size() - 1; j >= 0; j--) {
						Fish f = net.caFish.get(j);
						f.isMove = false;// 让鱼动的线程结束
						fishes.remove(f);
						net.caFish.remove(f);
					}
					nets.remove(net);
				}
			}

			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
