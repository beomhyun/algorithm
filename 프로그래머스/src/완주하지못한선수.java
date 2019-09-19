import java.util.HashMap;

public class 완주하지못한선수 {
	public static void main(String[] args) {
		
	}
    public String solution(String[] participant, String[] completion) {
    	HashMap<String, Integer> map = new HashMap<String, Integer>();
    	for (int i = 0; i < participant.length; i++) {
			if(map.containsKey(participant[i])) {
				map.put(participant[i], map.get(participant[i])+1);
			}else {
				map.put(participant[i], 1);
			}
		}
    	for (int i = 0; i < completion.length; i++) {
			map.put(completion[i], map.get(completion[i])-1);
		}
        String answer = "";
        for( String key : map.keySet() ){
            if(map.get(key) > 0) answer = key;
        }
        return answer;
    }
}
