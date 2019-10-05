import java.util.ArrayList;
import java.util.Scanner;

public class 게리맨더링2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] people = new int[N+1];
		
		for (int i = 1; i < people.length; i++) {
			people[i] = sc.nextInt();
		}
		ArrayList<Integer>[] list = new ArrayList[N+1];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i < people.length; i++) {
			int M = sc.nextInt();
			for (int j = 0; j < M; j++) {
				list[i].add(sc.nextInt());
			}
		}
		int mindiff = Integer.MAX_VALUE;
		
		for (int i = 1; i <= N; i++) {
			boolean[] use = new boolean[N+1];
			
		}
		
	}
}
