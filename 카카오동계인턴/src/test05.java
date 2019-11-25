import java.util.TreeSet;

public class test05 {
    public static int solution(int[] stones, int k) {
    	TreeSet<Integer> set = new TreeSet<Integer>();
    	for (int i = 0; i < stones.length; i++) {
			set.add(stones[i]);
		}
    	int answer = 0;
    	for(int tmp : set ) {
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
    		if(count == k) {
    			answer = tmp;
    			break;
    		}
    	}
//    	for (int i = 0; i < stones.length; i++) {
//    		int count = 0;
//			for (int j = 0; j < prestones.length; j++) {
//				if(prestones[j] - stones[i] <= 0) {
//					count++;
//					if(count == k) {
//						break;
//					}
//				}else {
//					count = 0;
//				}
//			}
//			if(count == k) {
//				answer = stones[i];
//				break;
//			}
//		}
        return answer;
    }
    public static void main(String[] args) {
		int k = 3;
		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		System.out.println(solution(stones, k));
	}
}
