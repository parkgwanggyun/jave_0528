package day03;

import java.util.Random;
import java.util.Scanner;

public class DiceGame {

	public static void main(String[] args) {
		
		System.out.println("주사위 게임을 하겠습니까?");
		
		Scanner sc = new Scanner(System.in);
		String yes = sc.nextLine();
		
		System.out.println("주사위를 몇 개 굴리겠습니까? (1~3개)");
		int diceNum = sc.nextInt();
		
		yes = sc.nextLine();
		System.out.println("화면에 주사위를 굴리까요?");
		
		Random r = new Random();
		
		int yourDice1 = 0;
		int yourDice2 = 0;
		int yourDice3 = 0;
		int yourDiceNum = diceNum;
		
		while(yourDiceNum > 0) {
			if(yourDiceNum >= 3) {
				yourDice3 = r.nextInt(6);
			}else if (yourDiceNum >=2) {
				yourDice2 = r.nextInt(6);								
			}else {
				yourDice1 = r.nextInt(6);
			}
			yourDiceNum = yourDiceNum-1;
			}
		if (diceNum == 3) {
			System.out.println("당신의 주사위는 " + (yourDice1 + 1) + " " + (yourDice2 + 1) + " " + (yourDice3 + 1) + "입니다.\n\n컴퓨터가 주사위를 굴립니다. 실행할까요?");
		} else if (diceNum == 2) {
			System.out.println("당신의 주사위는 " + (yourDice1 + 1) + " " + (yourDice2 + 1) + "입니다.\n\n컴퓨터가 주사위를 굴립니다. 실행할까요?");				
		} else {
			System.out.println("당신의 주사위는 " + (yourDice1 + 1) + "입니다.\n\n컴퓨터가 주사위를 굴립니다. 실행할까요?");
		}
			
		yes = sc.nextLine();
		
		int comDice1 = 0;
		int comDice2 = 0;
		int comDice3 = 0;
		int comDiceNum = diceNum;
				
		while (comDiceNum > 0) {
			if (comDiceNum >= 3) {
				comDice3 = r.nextInt(6);
			} else if (comDiceNum >= 2) {
				comDice2 = r.nextInt(6);
			} else {
				comDice1 = r.nextInt(6);
			}
			comDiceNum = comDiceNum -1;
		}
				
		if (diceNum == 3) {
			System.out.println("컴퓨터의 주사위는 " + (comDice1 + 1) + " " + (comDice2 + 1) + " " + (comDice3 + 1) + "입니다.\n");
		} else if (diceNum == 2) {
			System.out.println("컴퓨터의 주사위는 " + (comDice1 + 1) + " " + (comDice2 + 1) + "입니다.\n");				
		} else {
			System.out.println("컴퓨터의 주사위는 " + (comDice1 + 1) + "입니다.\n");
		}
		
		int yourDiceSum = yourDice1 + yourDice2 + yourDice3;
		int comDiceSum = comDice1 + comDice2 + comDice3;
		
		if (yourDiceSum > comDiceSum) {
			System.out.println("You Win!");
		} else if (yourDiceSum == comDiceSum) {
			System.out.println("Draw");
		} else {
			System.out.println("You Lose!");
		}

	}

		}

