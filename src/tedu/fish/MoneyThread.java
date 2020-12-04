package tedu.fish;

public class MoneyThread extends Thread {
	public Money m;
	public MoneyThread(Money m){
		this.m=m;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(m.isLive){
			m.move();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
