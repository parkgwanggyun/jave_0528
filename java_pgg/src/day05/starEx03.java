package day05;

public class starEx03 {

	public static void main(String[] args) {
		for(int i = 0; i < 5; i++) {
			for(int k = 4; k > i; k--) {
				System.out.print("-");
			}for(int j = 0; j < i+1; j++) {
				System.out.print("★");
			}System.out.println();
		}

	}

}
