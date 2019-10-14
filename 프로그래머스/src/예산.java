<<<<<<< HEAD
public class 예산 {
	public static void main(String[] args) {
		int[] budgets = {9,8,5,6,7};
		System.out.println(solution(budgets, 10));
	}
    public static int solution(int[] budgets, int M) {
        int answer = 0;
        long sum = 0;
        int max = 0;
        for (int i = 0; i < budgets.length; i++) {
			sum += budgets[i];
			max = max>budgets[i]?max:budgets[i];
		}
        if(sum <= (long)M) return max;
        
        int low = 0;
        int high = max;
        int targetlimit = 0;
        long maxtotal = Integer.MIN_VALUE;
        
        while(low <= high) {
        	int mid = (low+high) /2;
        	long total = 0;
        	for (int i = 0; i < budgets.length; i++) {
				total += mid>budgets[i]?mid:budgets[i];
			}
        	if(total == (long)M) return mid;
        	else if(total < (long)M) {
        		low = mid+1;
        		if(maxtotal < total) {
        			maxtotal = total;
        			targetlimit = mid;
        		}
        	}else {
        		high = mid -1;
        	}
        }
        
        return targetlimit;
=======
import java.util.Arrays;

public class 예산 {
	public static void main(String[] args) {
		int[] budgets = {120, 110, 140, 150};
		int M = 485;
		System.out.println(solution(budgets, M));
	}
    public static int solution(int[] budgets, int M) {
        int answer = 0;
        
        Arrays.sort(budgets);
        
        long sum = 0;
        for(int budget: budgets) sum += budget;
        
        if(sum <= M) return budgets[budgets.length-1];
        
        // 가장 큰 예산요청을 최대값으로 설정
        int max = budgets[budgets.length-1];
        // 전체 예산을 예산요청의 개수로 나누어 최저값을 설정
        int min = (int) Math.floor(M / budgets.length);
        int mid = 0;
        int compareMid = 0;
        
        while(true){
        	mid = (int) Math.ceil((max+min) / 2);
        	sum = 0;
        	
        	for(int budget: budgets) sum += ( budget > mid ) ? mid : budget;
        	
                // 더 이상 상한값의 변화가 없다면 종료
    		if(mid == compareMid){
    			answer = mid;
    			break;
    		}
        	
        	if(sum > M){
        		max = mid;
        	} else {
        		min = mid;
        	}
        	compareMid = mid;
        }
        
        return answer;

>>>>>>> 6dbea009d9aadb2fb5412caf3b2d4508283744c6
    }
}
