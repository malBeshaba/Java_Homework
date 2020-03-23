import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class NumOfString {
	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<>();
		List<String> list = new ArrayList<>();
		for (String str: args) {
			if (map.get(str) == null) {
				map.put(str, 1);
				list.add(str);
			} else {
				map.put(str, map.get(str) + 1);
			}
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i)+"="+map.get(list.get(i)));
		}
		
	}
}