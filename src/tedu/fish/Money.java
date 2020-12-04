package tedu.fish;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Money {
	public int x,y;
	public ImageIcon img;
	public FishPanel panel;
	public boolean isLive=true;
	public int count;
	public Fish fish;
	public Money(FishPanel panel,Fish fish){
		this.panel=panel;
		this.x=fish.x;
		this.y=fish.y;
		this.fish=fish;
		img=new ImageIcon("case09/m"+fish.money+".png");
	}
	
	public void drawMoeny(Graphics g){
		g.drawImage(img.getImage(), x, y, panel);
	}
	
	public void move(){
		y+=3;
		x-=3;
		
		if(y>panel.getHeight()-70){
			y=panel.getHeight()-70;
		}
		
		if(x<50){
			x=50;
		}
		
		if(x>=48
				&&x<=50
				&&y<=panel.getHeight()-68
				&&y>=panel.getHeight()-70){
			isLive=false;
			panel.ms.remove(this);
			panel.score+=fish.money;
		}
		
		panel.repaint();
		count++;
		if(count==15){
			img=new ImageIcon("case09/money.png");
		}
	}
}
