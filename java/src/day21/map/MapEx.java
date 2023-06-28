package day21.map;
import java.util.*;
import java.util.Map.Entry;

public class MapEx {

	public static void main(String[] args) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < 20; i++) {
			map.put(i, i + 1);
		}
		System.out.println(map);
		
		HashMap<String, String> map2 = new HashMap<>();
		map2.put("abc", "123456");
		map2.put("def", "654321");
		map2.put("abc", "000000");
		map2.put("ghi", "654321");
		System.out.println(map2);
		
		Set<String> keySet = map2.keySet();
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()) {
			String id = it.next();
			String pw = map2.get(id);
			System.out.println("id : " + id + ", pw : " + pw);
		}
		
		Set<Entry<String, String>> entrySet = map2.entrySet();
		Iterator<Entry<String, String>> it2 = entrySet.iterator();
		while(it2.hasNext()) {
			Entry<String, String> tmp = it2.next();
			String id = tmp.getKey();
			String pw = tmp.getValue();
			System.out.println("id : " + id + ", pw : " + pw);
		}
	}

}
