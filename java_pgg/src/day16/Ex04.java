package day16;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

public class Ex04 {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student(1, 1, 1, "홍길동", 100, 20, 30));
		list.add(new Student(1, 1, 2, "고길동", 100, 100, 100));
		list.add(new Student(1, 2, 1, "마이콜", 60, 60, 70));
		
		/*국어 평균,영어평균,수학평균을 계산해서 출력하는 코드를 작성하세요*/
		int totalkor = 0;
		int totaleng = 0;
		int totalmath = 0;
		for(Student student : list) {
			totalkor += student.getKor();
			totaleng += student.getEng();
			totalmath += student.getMath();
		}
		int Students = list.size();
		double avgKor = (double)totalkor/Students;
		double avgEng = (double)totaleng/Students;
		double avgMath = (double)totalmath/Students;
		System.out.println("국어 평균 : " + avgKor);
		System.out.println("영어 평균 : " + avgEng);
		System.out.println("수학 평균 : " + avgMath);
		
		/*각 학생의 국어,영어,수학 성적을 출력하는 코드를 작성하세요*/
		for(Student student : list) {
			System.out.println("이름 :" + student.getName()+ " ");
			System.out.print("국어 점수 :" + student.getKor()+ " ");
			System.out.print("영어 점수 :" + student.getEng()+ " ");
			System.out.println("수학 점수 :" + student.getMath());
			System.out.println();
		}
	}
}
@Data
@AllArgsConstructor
class Student{
	
	private int grade,classNum,num;
	private String name;
	private int kor,eng,math;
	@Override
	public String toString() {
		return grade + "학년" + classNum + "반" + num + "번" + name + "국어 : " + kor
			+ "점, 영어 : " + eng + "점, 수학 : " + math + "점"; 
	}
	
}