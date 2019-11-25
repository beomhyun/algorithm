import java.util.HashSet;

public class test05_2 {
    public static int solution(int[] stones, int k) {
        int answer = 0;
        int max = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < stones.length; i++) {
        	set.add(stones[i]);
			max = max<stones[i]?stones[i]:max;
		}
    	for(int tmp = max; tmp>=0; tmp-- ) {
    		if(!set.contains(tmp))continue;
    		int count =0;
    		for(int j=0; j< stones.length; j++) {
    			if(stones[j] - tmp <=0) {
    				count++;
    				if(count == k) {
    					break;
    				}
    			}else {
    				count = 0;
    			}
    		}
    		if(count < k) break;
    		if(count == k) {
    			answer = tmp;
    		}
    	}
        return answer;  


    }
    public static void main(String[] args) {
		int k = 3;
		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		System.out.println(solution(stones, k));
	}
}
