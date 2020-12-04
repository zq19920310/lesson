package tedu.fish;

public class FishThread extends Thread{
	public Fish fish;
	FishThread(Fish fish){
		this.fish=fish;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(fish.isMove&&!FishPanel.isOver){
			fish.swim();
			try {
				Thread.sleep(60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
