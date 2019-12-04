import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 다리만들기 {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int sum =2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 1) {
					map[i][j] = sum;
					Queue<xy> que = new LinkedList<>();
					que.add(new xy(i, j));
					while(!que.isEmpty()) {
						xy tmp = que.poll();
						for (int k = 0; k < 4; k++) {
							if(tmp.x+dx[k] >=0 && tmp.x+dx[k]<N && tmp.y+dy[k]>=0 && tmp.y+dy[k]<M && map[tmp.x+dx[k]][tmp.y+dy[k]]==1) {
								map[tmp.x+dx[k]][tmp.y+dy[k]] = sum;
								que.add(new xy(tmp.x+dx[k], tmp.y+dy[k]));
							}
						}
					}
					sum++;
				}
			}
		}

		int sumcnt = sum-1;
		
		int[][] dis = new int[sum+1][sum+1];
		for (int i = 0; i < dis.length; i++) {
			for (int j = 0; j < dis[i].length; j++) {
				dis[i][j] = Integer.MAX_VALUE;
			}
		}
		
		
	}
	static class xy {
		int x;
		int y;
		public xy(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
