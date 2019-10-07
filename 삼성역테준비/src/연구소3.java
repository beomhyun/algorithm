import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ¿¬±¸¼Ò3 {
	static int N;
	static int M;
	static int res;
	static int[][] map;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		res = Integer.MAX_VALUE;
		map = new int[N][N];
		n = 0;
		ArrayList<xy> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 0) n++;
				else if(map[i][j] == 2) {
					list.add(new xy(i, j,0));
				}
			}
		}
		boolean[] use = new boolean[list.size()];
		dfs(list, 0, 0, use);
		if(res == Integer.MAX_VALUE) res = -1;
		System.out.println(res);
	}
	static void dfs(ArrayList<xy> list, int d, int k, boolean[] use) {
		if(k==M) {
			Queue<xy> que = new LinkedList<>();
			boolean[][] visit = new boolean[N][N];
			for (int i = 0; i < use.length; i++) {
				if(use[i]) {
					xy tmp = list.get(i);
					visit[tmp.x][tmp.y] = true;
					que.add(tmp);
				}
			}
			int cnt = 0;
			int max = 0;
			while(!que.isEmpty()) {
				xy tmp = que.poll();
				for (int i = 0; i < 4; i++) {
					int x = tmp.x + dx[i];
					int y = tmp.y + dy[i];
					
					if(x >=0 && y>=0 && x<N && y<N && map[x][y]==0 && !visit[x][y]) {
						cnt++;
						visit[x][y] = true;
						if(max < tmp.d+1) max = tmp.d+1;
						que.add(new xy(x, y,tmp.d+1));
					}else if(x >=0 && y>=0 && x<N && y<N && map[x][y]==2 && !visit[x][y]) {
						visit[x][y] = true;
						que.add(new xy(x, y,tmp.d+1));
					}
				}
			}
			if(cnt == n) {
				if(max < res) res = max;
			}
			return;
		}
		if(d == list.size()) return;
		use[d] = true;
		dfs(list, d+1, k+1, use);
		use[d] = false;
		dfs(list, d+1, k, use);
	}
	static class xy {
		int x;
		int y;
		int d;
		public xy(int x, int y,int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
}
