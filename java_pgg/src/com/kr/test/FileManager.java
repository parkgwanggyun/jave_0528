package com.kr.test;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class FileManager {
	
	public void fileSave(Food food,String fileName) {
		try {
			File file = new file(fileName);
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(food);
			
			oos.close();
			fos.close();
			System.out.println("파일을 저장했습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Food apple = new Food("사과",20);
		FileManager fileManager = new FileManager();
		fileManager.fileSave(apple, "food.dat");
	}
}
