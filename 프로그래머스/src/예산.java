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

    }
}
