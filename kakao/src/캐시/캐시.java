package 캐시;

import java.util.ArrayList;

public class 캐시 {
	public static void main(String[] args) {
		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		System.out.println(solution(3, cities));
	}
	public static int solution(int cacheSize, String[] cities) {
		int answer = 0;
		ArrayList<String> cache = new ArrayList<>();
		if(cacheSize == 0) {
			answer = cities.length*5;
		}else {
			for (int i = 0; i < cities.length; i++) {
				String tmp = cities[i].toUpperCase();
				if(cache.contains(tmp)) {
					answer+=1;
					cache.remove(tmp);
					cache.add(tmp);
				}else {
					if(cache.size() < cacheSize) {
						cache.add(tmp);
						answer += 5;
					}else {
						cache.remove(0);
						cache.add(tmp);
						answer += 5;
					}
				}
			}
		}

		return answer;	
	}
}
