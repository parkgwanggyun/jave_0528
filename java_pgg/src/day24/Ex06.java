package day24;

public class Ex06 {

	public static void main(String[] args) {
		
		/* 1부터 10까지 출력하는 코드를 작성하려고 했다
		 * 원인 : i증감식이 없어서 i가 증가를하지않음 i가 증가하지 않으므로 i가 10까지 도달하지 못하므로
		 * 		무한루프가 돌게됌 i증감식만 넣어주면 됌
		 * 해결방법 : i++ // ++i를 넣으면 11까지 증가되므로 i++이되어야함
		 * */
		/*for(int i =0; i <= 10; ) {
			System.out.println(i);
		}*/
		for(int i =1; i <= 10; i++) {
			System.out.print(i);
		}
		for(int i =1; i <= 10; ) {
			System.out.print(i++);
		}
		
		
	}

}
