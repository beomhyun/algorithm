package 이분탐색;

import java.util.Arrays;
import java.util.Scanner;

public class 나무자르기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] tree = new int[N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			tree[i] = sc.nextInt();
			max = max>tree[i]?max:tree[i];
		}
		Arrays.sort(tree);
		
		int low = -1;
		int high = max;
		int limit = 0;
		while(high -low > 1) {
			int total = 0;
			int mid = (low + high) / 2;
			for (int i = 0; i < N; i++) {
				if(tree[i] > mid) {
					total += (tree[i] - mid);
				}
			}
			if(total == M) {
				limit = mid;
				break;
			}else if(total > M) {
				
			}
		}
	}
}
