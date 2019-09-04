

import java.util.ArrayList;

public class Ä³½Ã {
	public static void main(String[] args) {
		
        System.out.println(getCountTime(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork"
                , "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"})); // 50
        System.out.println(getCountTime(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju"
                , "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"})); // 21
        System.out.println(getCountTime(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork"
                , "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"})); // 60
        System.out.println(getCountTime(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork"
                , "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"})); // 52
        System.out.println(getCountTime(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"})); // 16
        System.out.println(getCountTime(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"})); // 25

	}
	static int getCountTime(int cacheSize, String[] cities) {
		int runtime = 0;
		java.util.ArrayList<String> cache = new ArrayList<>();

		for (int i = 0; i < cities.length; i++) {
			String tmp = cities[i].toLowerCase();
			if(cacheSize!=0) {
				if(cache.contains(tmp)) {
					runtime +=1;
					cache.remove(tmp);
					cache.add(tmp);
				}else {
					runtime +=5;
					if(cache.size() == cacheSize) {
						cache.remove(0);
					}
					cache.add(tmp);
				}
			}else {
				runtime +=5;
			}
			
		}
		return runtime;
	}
}
