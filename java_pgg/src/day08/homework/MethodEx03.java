package day08.homework;

import java.util.Scanner;

    	public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("배열의 크기를 입력하세요: ");
            int n = sc.nextInt();
            random(n);
        }

        /**
         * 기능 : 입력받은 배열 크기에 1~9에서 랜덤이 만들어내고 배열에 저장한 후 중복을 걸러내는 기능
         *
         * @param n 배열의 크기
         */
        public static void random(int n) {
            int min = 1, max = 9;
            int[] list = Arrangement(n);
            int count = 0;
            while (count < n) {
                int randomNumber = (int) (Math.random() * (max - min + 1) + min);
                boolean isDuplicate = false;
                for (int i = 0; i < count; i++) {
                    if (list[i] == randomNumber) {
                        isDuplicate = true;
                        break;
                    }
                }
                if (!isDuplicate) {
                    list[count] = randomNumber;
                    count++;
                }
            }
            // 배열 출력
            for (int num : list) {
                System.out.println(num);
            }
        }

        /**
         * 기능 : 입력된 n을 받고 배열의 크기를 정하는 기능
         *
         * @param n 배열의 크기
         * @return 생성된 배열
         */
        public static int[] Arrangement(int n) {
            int[] list = new int[n];
            return list;
        }
    }