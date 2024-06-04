package day06;

import java.util.Arrays;
import java.util.Scanner;

import day04.WhileEx01;

public class ArrayEx07_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int num;
        int munu;
        int count;
        int[] record = new int[5];
        int recordCount = 0;
        
        do {
            System.out.println("1.플레이");
            System.out.println("2.기록확인");
            System.out.println("3.종료");
            System.out.println("메뉴를 선택하세요: ");
            munu = sc.nextInt();

            switch (munu) {
                case 1:
                    count = 0;
                    int min = 1, max = 100;
                    int random = (int) (Math.random() * (max - min + 1) + min);

                    do {
                        System.out.println("정수 입력 : ");
                        num = sc.nextInt();
                        count++;

                        if (num > random) {
                            System.out.println("Down");
                        } else if (num < random) {
                            System.out.println("Up");
                        } else {
                            System.out.println("정답입니다. 맞힌 횟수는 " + count + "회 입니다.");

                            // 기록 등록
                            if (recordCount < record.length) {
                                record[recordCount] = count;
                                recordCount++;
                            } else {
                                if (record[recordCount - 1] > count) {
                                    record[recordCount - 1] = count;
                                    Arrays.sort(record, 0, recordCount);
                                }
                            }
                        }
                    } while (random != num);
                    break;

                case 2:
                    if (recordCount == 0) {
                        System.out.println("등록된 기록이 없습니다.");
                    } else {
                        for (int i = 0; i < recordCount; i++) {
                            System.out.println((i + 1) + ". " + record[i] + "회");
                        }
                    }
                    break;

                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    break;

                default:
                    System.out.println("잘못된 메뉴입니다.");
            }
        } while (munu != 3);
    }
}