import java.util.Scanner;

public class ·Îº¿Ã»¼Ò±â {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int r = sc.nextInt();
		int c=  sc.nextInt();
		int d = sc.nextInt();
		
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		boolean[][] visit = new boolean[N][M];
		visit[r][c] = true;
		int cnt = 1;
		while(true) {
			System.out.println("r : "+ r + "   c : "+ c );
			int dd = d-1;
			if(dd == -1) dd=3;
			if(r+dx[dd]>=0 && c+dy[dd]>=0 && r+dx[dd] <N && c+dy[dd]<M && !visit[r+dx[dd]][c+dy[dd]] && map[r+dx[dd]][c+dy[dd]] != 1) {
				d = dd;
				r += dx[d];
				c += dy[d];
				visit[r][c] = true;
				cnt++;
				continue;
			}else {
				boolean check = true;
				int tmpx = r;
				int tmpy = c;
				for (int i = 0; i < 4; i++) {
					d--;
					if(d == -1) d=3;
					if(r+dx[d]>=0 && c+dy[d]>=0 && r+dx[d] <N && c+dy[d]<M && !visit[r+dx[d]][c+dy[d]] && map[r+dx[d]][c+dy[d]] == 0 ) {
						check = false;
						tmpx = r+dx[d];
						tmpy = c+dy[d];
						visit[tmpx][tmpy] = true;
						cnt++;
						break;
					}
				}
				if(check) {
					dd = (d+2)%4;
					if(r+dx[dd]>=0 && c+dy[dd]>=0 && r+dx[dd] <N && c+dy[dd]<M && map[r+dx[dd]][c+dy[dd]] != 1) {
						r += dx[dd];
						c += dx[dd];
						continue;
					}else {
						break;
					}
				}
				r = tmpx;
				c = tmpy;
			}
		}
		System.out.println(cnt);
		
	}
}
