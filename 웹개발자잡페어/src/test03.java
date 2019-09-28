
public class test03 {
	public static void main(String[] args) {
		int[] sticker = {12,12,12,12,12};
		System.out.println(solution(sticker));
	}
    public static int solution(int[] sticker) {
    	int[] dp = new int[sticker.length+2];

    	for (int i = 2; i < dp.length; i++) {
    		dp[i] = Math.max(dp[i-2]+sticker[i-2], dp[i-1]);
    	}
			
        int answer = dp[dp.length-1];
        return answer;
    }
}
