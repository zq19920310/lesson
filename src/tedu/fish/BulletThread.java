package tedu.fish;

public class BulletThread extends Thread {
	public Bullet bullet;

	public BulletThread(Bullet bullet) {
		this.bullet = bullet;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while (bullet.isLive) {
			bullet.move();
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
