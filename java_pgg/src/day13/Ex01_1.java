package day13;

public class Ex01_1 {

	public static void main(String[] args) {
		 String[] books = {"자바의 정석", "혼자하는 자바", "혼자하는 C", "수학의 정석", "누구나 하는 C"};
		 
		 String search = "자바";
		 int count = 0;
		 for(String book : books) {
			 //book에 search가 포함되어 있으면 book을 출력
			 /*if(book.contains(search)) {
				 System.out.println(book);
				 count++;
			 }*/
			 if(book.indexOf(search) >= 0) {
				 System.out.println(book);
				 count++;
			 }
		 }
		 //일치하는 책의 개수가 0이면 출력
		 if(count == 0) {
			 System.out.println("일치하는 책이 없습니다.");
		 }
	}

}
