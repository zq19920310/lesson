package tedu.fish;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Rotate {
	public static void main(String[] args) {
		JFrame jf = new JFrame();
		RotatePanel panel = new RotatePanel();
		jf.add(panel);
		jf.setSize(800, 500);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
}

class RotatePanel extends JPanel{
	ImageIcon le;
	int baseX,baseY;
	RotatePanel(){
		le=new ImageIcon("case09/level.png");
		baseX=400+20;
		baseY=300+40;
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 800, 500);
//		g.drawImage(le.getImage(), 400, 300, this);
		
		Graphics2D gp= (Graphics2D) g.create();
		gp.rotate(Math.PI/6, baseX, baseY);
		gp.drawImage(le.getImage(), 400, 300, this);
		
		gp= (Graphics2D) g.create();
		gp.rotate(Math.PI/4, baseX, baseY);
		gp.drawImage(le.getImage(), 400, 300, this);
		
	}
}
