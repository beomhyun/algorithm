import java.util.Arrays;

public class ���� {
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
        
        // ���� ū �����û�� �ִ밪���� ����
        int max = budgets[budgets.length-1];
        // ��ü ������ �����û�� ������ ������ �������� ����
        int min = (int) Math.floor(M / budgets.length);
        int mid = 0;
        int compareMid = 0;
        
        while(true){
        	mid = (int) Math.ceil((max+min) / 2);
        	sum = 0;
        	
        	for(int budget: budgets) sum += ( budget > mid ) ? mid : budget;
        	
                // �� �̻� ���Ѱ��� ��ȭ�� ���ٸ� ����
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
