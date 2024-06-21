package day18;

public class ThreadEx02 {

	public static void main(String[] args) {
		// Runable 인터페이스를 이용한 쓰레드 생성 예제
		MyThread2 mt = new MyThread2();
		
		Runnable r = ()-> {
			for(int i = 0; i <10000; i++) {
				System.out.print("-");
			}
		};
		
		Thread tread = new Thread(mt);
		tread.start();
		
		for(int i =0; i <10000; i++) {
			System.out.print("|");
		}
	}
}
class MyThread2 implements Runnable{

	@Override
	public void run() {
		for(int i = 0; i <10000; i++) {
			System.out.print("-");
		}
	}
}