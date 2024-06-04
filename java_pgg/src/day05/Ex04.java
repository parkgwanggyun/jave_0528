package day05;

public class Ex04 {
	
	public static void main(String[] args) {
		String[] strings = {"apple", "banana", "orange", "strawberry", "kiwi"};
        String longestString = ""; // 가장 긴 문자열을 저장할 변수를 초기화합니다.

        for (String str : strings) {
            if (str.length() > longestString.length()) {
                longestString = str; // 현재 문자열이 더 길면 가장 긴 문자열을 업데이트합니다.
            }
        }

        System.out.println("가장 긴 문자열: " + longestString);
    }
}