public class ¿¹»ê {
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
    }
}
