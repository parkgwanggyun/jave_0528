package day15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Ex05 {

    public static void main(String[] args) {
        /* 숫자 야구 게임을 구현하세요 */

        // 컴퓨터가 생성한 중복되지 않은 1~9 사이의 3개의 숫자
        HashSet<Integer> computerNumbers = new HashSet<>();
        Random random = new Random();
        int min = 1, max = 9;
        while (computerNumbers.size() < 3) {
            int randomNumber = random.nextInt(max - min + 1) + min;
            computerNumbers.add(randomNumber);
        }
        System.out.println("컴퓨터가 생성한 숫자: " + computerNumbers);

        // 사용자 입력 받기
        Scanner scanner = new Scanner(System.in);
        HashSet<Integer> userNumbers = new HashSet<>();
        System.out.println("1부터 9 사이의 숫자를 중복되지 않게 3개 입력하세요:");
        while (userNumbers.size() < 3) {
            int inputNumber = scanner.nextInt();
            if (inputNumber < 1 || inputNumber > 9) {
                System.out.println("잘못된 입력입니다. 1부터 9 사이의 숫자를 입력하세요.");
                continue;
            }
            userNumbers.add(inputNumber);
        }

        // 숫자 비교하여 결과 계산
        int strike = 0;
        int ball = 0;

        ArrayList<Integer> computerList = new ArrayList<>(computerNumbers);
        ArrayList<Integer> userList = new ArrayList<>(userNumbers);

        for (int i = 0; i < 3; i++) {
            if (computerList.get(i).equals(userList.get(i))) {
                strike++;
            } else if (computerNumbers.contains(userList.get(i))) {
                ball++;
            }
        }

        // 결과 출력
        if (strike == 3) {
            System.out.println("3 스트라이크! 정답입니다.");
        } else if (strike == 0 && ball == 0) {
            System.out.println("아웃! 모두 틀렸습니다.");
        } else {
            System.out.println("스트라이크: " + strike + ", 볼: " + ball);
        }
    }
}