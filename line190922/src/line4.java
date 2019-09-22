import java.util.Scanner;

public class line4 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] input = new int[N];
		
		for (int i = 0; i < input.length; i++) {
			input[i] = sc.nextInt();
		}
		int[] dp = new int[N];
		int cnt = 0;
		for (int i = 0; i < input.length; i++) {
			if(input[i] == 1) {
				cnt = 0;
				dp[i] = cnt;
			}else {
				dp[i] = ++cnt;
			}
		}
		for (int i = input.length-1; i >= 0; i--) {
			if(input[i] == 1) {
				cnt = 0;
				dp[i] = cnt;
			}else {
				cnt++;
				dp[i] = cnt<dp[i]?cnt:dp[i];
			}
		}
		int answer =0;
		for (int i = 0; i < dp.length; i++) {
			if(answer < dp[i]) answer = dp[i];
		}
		System.out.println(answer);
	}
}
