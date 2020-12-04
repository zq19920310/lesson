package tedu.fish;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;

public class Fish {
	public int speed = 2;// �ٶ�
	public ImageIcon[] imgs;// ͼƬ����
	public int index;// ��ǰʹ�õ�ͼƬ����ͼƬ������±�ֵ

	public ImageIcon[] caImgs;
	public int caIndex;

	public int x, y;// ������
	public Random rr = new Random();// ���������Ķ���
	public FishPanel panel;// ����
	public boolean isMove = true;// ���ζ����߳̽������
	public int kind;
	public int direction;
	public boolean isCatch = false;
	public int hp;
	public int money;
	public static final int RIGHT_TO_LEFT = 0;// �ζ�����
	public static final int LEFT_TO_RIGHT = 1;// �ζ�����
	public static final int TOP_TO_BOTTOM = 2;// �ζ�����

	public Fish(FishPanel panel) {
		kind = 1 + rr.nextInt(9);
		
		if(kind==1){
			hp=1;
			money=2;
		}else if(kind==2){
			hp=1;
			money=2;
		}
		else if(kind==3){
			hp=1;
			money=2;
		}
		else if(kind==4){
			hp=1;
			money=2;
		}
		else if(kind==5){
			hp=2;
			money=4;
		}
		else if(kind==6){
			hp=2;
			money=4;
		}
		else if(kind==7){
			hp=3;
			money=6;
		}
		else if(kind==8){
			hp=3;
			money=6;
		}
		else if(kind==9){
			hp=4;
			money=8;
		}
		
		direction = rr.nextInt(3);

		imgs = new ImageIcon[10];
		caImgs = new ImageIcon[2];

		String path = "";
		switch (direction) {
		case RIGHT_TO_LEFT:
			for (int i = 0; i < 10; i++) {
				path = "case09/right_to_left/fish0" + kind + "_" + (i == 9 ? "10" : "0" + (i + 1)) + ".png";
				imgs[i] = new ImageIcon(path);
			}

			for (int i = 0; i < 2; i++) {
				path = "case09/right_to_left/fish0" + 
								kind + "_catch_0" + (i + 1) + ".png";
				caImgs[i] = new ImageIcon(path);
			}

			x = panel.getWidth() + 100;
			y = rr.nextInt(panel.getHeight() - 100);
			break;
		case LEFT_TO_RIGHT:
			for (int i = 0; i < 10; i++) {
				path = "case09/left_to_right/fish0" + kind + "_" + (i == 9 ? "10" : "0" + (i + 1)) + ".png";
				imgs[i] = new ImageIcon(path);
			}

			for (int i = 0; i < 2; i++) {
				path = "case09/left_to_right/fish0" + kind + "_catch_0" + (i + 1) + ".png";
				caImgs[i] = new ImageIcon(path);
			}
			x = -100;
			y = rr.nextInt(panel.getHeight() - 100);
			break;
		case TOP_TO_BOTTOM:
			for (int i = 0; i < 10; i++) {
				path = "case09/up_to_buttom/fish0" + kind + "_" + (i == 9 ? "10" : "0" + (i + 1)) + ".png";
				imgs[i] = new ImageIcon(path);
			}

			for (int i = 0; i < 2; i++) {
				path = "case09/up_to_buttom/fish0" + kind + "_catch_0" + (i + 1) + ".png";
				caImgs[i] = new ImageIcon(path);
			}

			x = rr.nextInt(panel.getWidth() - imgs[0].getIconWidth());
			y = -100;
			break;
		}

		this.panel = panel;

	}

	public void drawFish(Graphics g) {
		if (!isCatch) {
			g.drawImage(imgs[index].getImage(), x, y, panel);
		} else {
			g.drawImage(caImgs[caIndex].getImage(), x, y, panel);
		}
	}

	public void swim() {
		if (!isCatch) {
			if (direction == RIGHT_TO_LEFT) {
				x -= speed;
				if (x < -imgs[0].getIconWidth()) {
					isMove = false;
					panel.fishes.remove(this);
				}
			} else if (direction == LEFT_TO_RIGHT) {
				x += speed;
				if (x > panel.getWidth()) {
					isMove = false;
					panel.fishes.remove(this);
				}
			} else if (direction == TOP_TO_BOTTOM) {
				y += speed;
				if (y > panel.getHeight()) {
					isMove = false;
					panel.fishes.remove(this);
				}
			}
			index++;
			index = index % imgs.length;
		} else {
			caIndex++;
			caIndex = caIndex % caImgs.length;
		}
		panel.repaint();
	}
}
