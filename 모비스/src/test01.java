
public class test01 {
	public static void main(String[] args) {
		
	}
    public int solution(int n, int[] P) {
        int answer = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < P.length; i++) {
        	min = min<P[i]?min:P[i];
        	answer += min;
        }
        return answer;
    }
}
