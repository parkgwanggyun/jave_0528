package day05;

public class starEx04 {

	public static void main(String[] args) {
		 int num1 = 1;//최상단에 1이 있어야하므로 1로 값을초기화한다.
		 
		 for(int i = 0; i < 5; i++) {
				for(int k = 4; k > i; k--) {
					//i가 0알 때 k가 5 (1행일 때 별이 5개)
					//i가 1일 때 k가 4 (2행일 때 별이 4개)...
					//이런식으로 진행되기 때문에 조건이 j는 5부터 시작해서 j>i까지 하니씩 줄어든다.
					System.out.print("-");
				}for(int j = 0; j < num1; j++) {//별이 1,3,5,7,9번 출력되어야하므로 변수 하나 만든다.
					System.out.print("★");
					
	}num1 = num1+2;//1,3,5,7,9번 출력될 수 있도로 변수에 2를 더해주어 계속 홀수로 만들어준다.
				System.out.println();
	

}
	}
}