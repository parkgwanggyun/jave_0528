package day15;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.text.html.parser.Entity;

public class MapEx02 {

	public static void main(String[] args) {
		//Map을 이용한 반복문 예제
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("2024160001", "고길동");
		map.put("2024160002", "홍길동");
		map.put("2024135001", "임꺽정");
		//방법1. ketSet을 이용
		HashSet<String> set = (HashSet)map.keySet();
		
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String key = it.next();
			String value = map.get(key);
			System.out.println(key + " : " + value);
		}
		//방법2 EntrySet을 이용, Entry 클래스를 이용하여 Set으로 만들고 
		//반복문을 활용
		Set<Map.Entry<String, String>> entitySet = map.entrySet();
		Iterator<Map.Entry<String, String>> it2 = entitySet.iterator();
		while(it2.hasNext()) {
			Map.Entry<String, String> tmp = it2.next();
			String key = tmp.getKey();
			String value = tmp.getValue();
			System.out.println(key + " : " + value);
		}	
	}

}
