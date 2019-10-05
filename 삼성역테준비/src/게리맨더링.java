import java.util.ArrayList;
import java.util.Scanner;

public class 게리맨더링 {
	static int diff = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] people  = new int[N+1];
		for (int i = 1; i <= N; i++) {
			people[i] = sc.nextInt();
		}
		int[] pre = new int[N+1];
		ArrayList<Integer>[] check = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			pre[i] = i;
			check[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i <= N; i++) {
			int M = sc.nextInt();
			for (int j = 0; j < M; j++) {
				int b = sc.nextInt();
				union(pre,i,b);
				check[i].add(b);
			}
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < pre.length; i++) {
			if(pre[i] == i) {
				list.add(i);
			}
		}

		if(list.size() >2) {
			System.out.println(-1);
			return;
		}else if(list.size() == 2){
			int A = 0;
			int B = 0;
			for (int i = 1; i < pre.length; i++) {
				if(pre[i] == list.get(0)) {
					A += people[i];
				}else {
					B += people[i];
				}
			}
			System.out.println(Math.abs(A-B));
			return;
		}else {
			boolean[] use = new boolean[N+1];
			dfs(N,people, 1, use,check);
			System.out.println(diff);
		}
		
	}
	static void dfs(int N, int[] people, int d, boolean[] use,ArrayList<Integer>[] check) {
		if(d == people.length) {
			int A = 0;
			int B = 0;
			for (int i = 1; i < use.length; i++) {
				if(use[i]) {
					A+=people[i];
				}
				else B+=people[i];
			}
			diff = diff<Math.abs(A-B)?diff:Math.abs(A-B);
			return;
		}
		use[d] = true;
		dfs(N,people, d+1, use,check);
		use[d] = false;
		dfs(N,people, d+1, use,check);
	}
	static int find(int[] pre,int a) {
		if(pre[a] == a) return a;
		else {
			return pre[a] = find(pre,pre[a]);
		}
	}static void union(int[] pre,int a, int b){
		if(find(pre,a) == find(pre,b)) return;
		else {
			if(find(pre,a) > find(pre,b)) {
				pre[find(pre,a)] = find(pre,b);
				for (int i = 1; i < pre.length; i++) {
					find(pre,i);
				}
			}else {
				pre[find(pre,b)] = find(pre,a);
				for (int i = 1; i < pre.length; i++) {
					find(pre,i);
				}
			}
		}
	}
}
