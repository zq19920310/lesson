package tedu.fish;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class FishFrame implements ActionListener {
	JFrame frame;
	JLabel mainLable;
	FishPanel panel;
	JButton min, close;
	public void init() {
		frame = new JFrame();
		frame.setSize(880, 580);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		// --------------��������----------
		panel = new FishPanel();
		panel.setBounds(40, 65, 800, 480);
		// --------------������ť----------------
		min = new JButton(new ImageIcon("case09/min.png"));
		min.setBounds(760, 28, 33, 33);
		min.setContentAreaFilled(false);
		min.setBorderPainted(false);
		close = new JButton(new ImageIcon("case09/close.png"));
		close.setBounds(794, 28, 33, 33);
		close.setContentAreaFilled(false);
		close.setBorderPainted(false);
		// ------------����mainLable---------
		mainLable = new JLabel(new ImageIcon("case09/bg.png"));
		// ----------��˳����Ӹ������-----------------
		mainLable.add(min);
		mainLable.add(close);
		mainLable.add(panel);
		frame.add(mainLable);
		// -----------�ô�����ʾ----------------------
		frame.setVisible(true);
		// --------------��Ӽ���-----------------
		min.addActionListener(this);
		close.addActionListener(this);

		new Thread(panel).start();
	}

	public void addFish() {
		new Thread() {
			public void run() {
				while (!FishPanel.isOver) {
					Fish fish = new Fish(panel);
					panel.fishes.add(fish);
					new FishThread(fish).start();

					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
		}.start();
	}

	public static void main(String[] args) {
		FishFrame f = new FishFrame();
		f.init();
		f.addFish();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == min) {
			frame.setState(JFrame.ICONIFIED);
		} else if (e.getSource() == close) {
			System.exit(0);
		}
	}
}
