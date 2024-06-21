package day18;

import lombok.AllArgsConstructor;
import lombok.Data;

public class SynchronizedEx02 {

	public static void main(String[] args) {
		// 은행 잔고를 통한 동기화 블록 예제
		BankBook bankBook = new BankBook("홍길동", 0);
		Customer c1 = new Customer("홍길동", bankBook);
		Customer c2 = new Customer("홍아무개", bankBook);

		Thread t1 = new Thread(() -> c1.deposit(10000));
		Thread t2 = new Thread(() -> c2.deposit(10000));
	}
}
@AllArgsConstructor
	class Customer {
		private String name;
		private BankBook2 bankBook;

		public void deposit(int money) {
			synchronized (bankBook) {
				int balance = bankBook.getBalance();
				bankBook.setBalance(balance + money);

				try {
					// 현재 쓰레드를 2초간 멈춤
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(name + " : " + money + "원");
			}
		}
	}

@Data
@AllArgsConstructor
class BankBook2 {
	private String name;
	private int balance;
}