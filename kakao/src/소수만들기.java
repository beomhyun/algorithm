import java.util.ArrayList;
import java.util.TreeSet;

public class 소수만들기 {
	public static void main(String[] args) {
		System.out.println(solution("17"));
	}
    public static int solution(String numbers) {
        int answer = 0;
        int N = numbers.length();
        int[] number = new int[N];
        for (int i = 0; i < N; i++) {
			number[i] = numbers.charAt(i);
		}
        boolean[] use = new boolean[N];
        
        
        return answer;
    }
    static TreeSet<Integer> list = new TreeSet<Integer>();
    public static void dfs(int[] number, boolean[] use, int num) {
    	if(num != 0) {
    		if(!list.contains(num)) {
    			boolean check = true;
    			for (int i = 1; i < num; i++) {
					if(num%i ==0) {
						check = false;
					}
				}
    			if(check) {
    				list.add(num);
    			}
    		}
    	}
    	
    }
}
