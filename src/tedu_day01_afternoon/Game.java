package tedu_day01_afternoon;
public class Game {
	public static void main(String[] args) {
		String[] arr={"����","��ľ��","¶��","��ʿ","������","ī��","¶�Ƚ�ɫ","��ľ����ɫ"};
		int suiji = (int)(Math.random()*1000000);
		System.out.println( suiji );//�����ڿ���̨�������С�����������
			  if(0<=suiji && suiji<250000) {
				 System.out.println("����");
		}else if(250000<=suiji && suiji<390000) {
				  int b = (int) (Math.random() * 2+7);
				  System.out.println(arr[b]);
		}else if(390000<=suiji && suiji<490000) {
				System.out.println("��è");
		}else if(490000<=suiji && suiji<490004) {
				System.out.println("�����");
		}else {
				  int a = (int) (Math.random() * 6);
				  System.out.println(arr[a]);
			  }
	}
}








