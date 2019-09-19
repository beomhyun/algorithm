import java.util.ArrayList;
import java.util.HashMap;

public class º£½ºÆ®¾Ù¹ü {
	public static void main(String[] args) {
		
	}
	public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < plays.length; i++) {
			if(map.containsKey(genres[i])) {
				map.put(genres[i], map.get(genres[i])+plays[i]);
			}else {
				map.put(genres[i], plays[i]);
			}
		}
        ArrayList<Integer> list = new ArrayList<Integer>();
        boolean[] use = new boolean[plays.length];
		int SS = 0;
		while(SS < map.size()) {
			String tmp = "";
			int max = 0;
			for (String key : map.keySet()) {
				if(max < map.get(key)) {
					tmp = key;
					max = map.get(key);
				}
			}
			for (int i = 0; i < 2; i++) {
				max = 0;
				int id = -1;
				for (int j = 0; j < plays.length; j++) {
					if(genres[j].equals(tmp)) {
						if(max < plays[j]) {
							max = plays[j];
							id = j;
						}
					}
				}
				if(id == -1) break;
				list.add(id);
				plays[id] = 0;
			}
			map.put(tmp, 0);
			SS++;
		}
		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
        return answer;
    }
}
