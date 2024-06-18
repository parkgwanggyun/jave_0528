package day15;

import java.util.ArrayList;
import java.util.Iterator;

public class ListEx02 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("gg");
		list.add("ww");
		list.add("hh");
		
		for(String tmp : list) {
			System.out.print(tmp + " ");
		}
		System.out.println();
		
		Iterator<String> it = list.iterator();
		
		while (it.hasNext()) {
			String tmp = it.next();
			System.out.print(tmp + " ");
			
		}
		System.out.println();
		
		for(int i =0; i < list.size(); i++) {
			String tmp = list.get(2);
			System.out.print(tmp + " ");
		}
	}

}
