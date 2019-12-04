package 이분탐색;

import java.util.Arrays;
import java.util.Scanner;

public class 수찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N  = sc.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		int M = sc.nextInt();
		int[] B = new int[M];
		for (int i = 0; i < M; i++) {
			B[i] = sc.nextInt();
		}
		Arrays.sort(A);
		int[] answer = new int[M];
		for (int i = 0; i < M; i++) {
			int low = -1;
			int high = N;
			while(high-low > 1) {
				int mid = (low + high) /2;
				if(A[mid] == B[i]) {
					answer[i] = 1;
					break;
				}
				else if(A[mid] < B[i]) {
					low = mid;
				}else if(A[mid] > B[i]) {
					high = mid;
				}
			}
		}
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
}
