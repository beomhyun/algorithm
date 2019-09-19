
public class Å¸°Ù³Ñ¹ö {
	public static void main(String[] args) {
		int[] num = {1,1,1,1,1};
		System.out.println(solution(num, 3));
	}
	static int answer;
    public static int solution(int[] numbers, int target) {
        answer = 0;
        boolean[] check = new boolean[numbers.length];
        dfs(check,0,numbers,target);
        return answer;
    }
    static void dfs(boolean[] check, int d,int[] numbers, int  target) {
    	if(d == numbers.length) {
    		int tmp = 0;
    		for (int i = 0; i < numbers.length; i++) {
				if(check[i]) tmp += numbers[i];
				else tmp -= numbers[i];
			}
    		if(tmp == target) {
    			answer++;
    		}
    		return;
    	}
    	dfs(check,d+1,numbers,target);
    	check[d] = true;
    	dfs(check,d+1,numbers,target);
    	check[d] = false;
    	
    }
}
