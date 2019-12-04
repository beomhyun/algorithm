import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ±∏ΩΩ≈ª√‚2 {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static xy R;
	static xy B;
	static xy O;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'R') {
					R = new xy(i, j);
				}else if(map[i][j] == 'B') {
					B = new xy(i, j);
				}else if(map[i][j] == 'O') {
					O = new xy(i, j);
				}
			}
		}
		res = Integer.MAX_VALUE;
		for (int i = 0; i < 4; i++) {
			dfs(map, 1,0);
		}
		if(res == Integer.MAX_VALUE) res = -1;
		System.out.println(res);
	}
	static int res;
	static public void dfs(char[][] map, int cnt,int d) {
		System.out.println(cnt);
		if(cnt >= res || cnt>10) return;
		int dd = d-2;
		if(dd == -1) dd = 3;
		else if(dd == -2) dd = 2;
		xy RR = new xy(R.x, R.y);
		xy BB = new xy(B.x, B.y);
		for (int i = 0; i < 4; i++) {
			if(i==d) continue;
			char[][] newmap = map.clone();
			if(i==0) {
				if(R.y < B.y) {
					xy tmpR = findxy(newmap, i, R);
					newmap[R.x][R.y]= '.';
					newmap[tmpR.x][tmpR.y] = 'R';
					R = tmpR;
					if(R.x == O.x && R.y == O.y) {
						if(res > cnt) res = cnt;
						return;
					}
					xy tmpB = findxy(newmap, i, B);
					newmap[B.x][B.y]= '.';
					newmap[tmpB.x][tmpB.y] ='B';
					B = tmpB;
					if(B.x == O.x && B.y == O.y) {
						return;
					}
				}else {
					xy tmpB = findxy(newmap, i, B);
					newmap[B.x][B.y]= '.';
					newmap[tmpB.x][tmpB.y] ='B';
					B = tmpB;
					if(B.x == O.x && B.y == O.y) {
						return;
					}
					xy tmpR = findxy(newmap, i, R);
					newmap[R.x][R.y]= '.';
					newmap[tmpR.x][tmpR.y] = 'R';
					R = tmpR;
					if(R.x == O.x && R.y == O.y) {
						if(res > cnt) res = cnt;
						return;
					}
				}
			}else if(i==1) {
				if(R.x > B.x) {
					xy tmpR = findxy(newmap, i, R);
					newmap[R.x][R.y]= '.';
					newmap[tmpR.x][tmpR.y] = 'R';
					R = tmpR;
					if(R.x == O.x && R.y == O.y) {
						if(res > cnt) res = cnt;
						return;
					}
					xy tmpB = findxy(newmap, i, B);
					newmap[B.x][B.y]= '.';
					newmap[tmpB.x][tmpB.y] ='B';
					B = tmpB;
					if(B.x == O.x && B.y == O.y) {
						continue;
					}
				}else {
					xy tmpB = findxy(newmap, i, B);
					newmap[B.x][B.y]= '.';
					newmap[tmpB.x][tmpB.y] ='B';
					B = tmpB;
					if(B.x == O.x && B.y == O.y) {
						continue;
					}
					xy tmpR = findxy(newmap, i, R);
					newmap[R.x][R.y]= '.';
					newmap[tmpR.x][tmpR.y] = 'R';
					R = tmpR;
					if(R.x == O.x && R.y == O.y) {
						if(res > cnt) res = cnt;
						return;
					}
				}
			}else if(i==2) {
				if(R.y > B.y) {
					xy tmpR = findxy(newmap, i, R);
					newmap[R.x][R.y]= '.';
					newmap[tmpR.x][tmpR.y] = 'R';
					R = tmpR;
					if(R.x == O.x && R.y == O.y) {
						if(res > cnt) res = cnt;
						return;
					}
					xy tmpB = findxy(newmap, i, B);
					newmap[B.x][B.y]= '.';
					newmap[tmpB.x][tmpB.y] ='B';
					B = tmpB;
					if(B.x == O.x && B.y == O.y) {
						continue;
					}
				}else {
					xy tmpB = findxy(newmap, i, B);
					newmap[B.x][B.y]= '.';
					newmap[tmpB.x][tmpB.y] ='B';
					B = tmpB;
					if(B.x == O.x && B.y == O.y) {
						continue;
					}
					xy tmpR = findxy(newmap, i, R);
					newmap[R.x][R.y]= '.';
					newmap[tmpR.x][tmpR.y] = 'R';
					R = tmpR;
					if(R.x == O.x && R.y == O.y) {
						if(res > cnt) res = cnt;
						return;
					}
				}
			}else if(i==3) {
				if(R.x < B.x) {
					xy tmpR = findxy(newmap, i, R);
					newmap[R.x][R.y]= '.';
					newmap[tmpR.x][tmpR.y] = 'R';
					R = tmpR;
					if(R.x == O.x && R.y == O.y) {
						if(res > cnt) res = cnt;
						return;
					}
					xy tmpB = findxy(newmap, i, B);
					newmap[B.x][B.y]= '.';
					newmap[tmpB.x][tmpB.y] ='B';
					B = tmpB;
					if(B.x == O.x && B.y == O.y) {
						continue;
					}
				}else {
					xy tmpB = findxy(newmap, i, B);
					newmap[B.x][B.y]= '.';
					newmap[tmpB.x][tmpB.y] ='B';
					B = tmpB;
					if(B.x == O.x && B.y == O.y) {
						continue;
					}
					xy tmpR = findxy(newmap, i, R);
					newmap[R.x][R.y]= '.';
					newmap[tmpR.x][tmpR.y] = 'R';
					R = tmpR;
					if(R.x == O.x && R.y == O.y) {
						if(res > cnt) res = cnt;
						return;
					}
				}
			}
			for (int j = 0; j < newmap.length; j++) {
				for (int k = 0; k < newmap[j].length; k++) {
					System.out.print(newmap[j][k] + " ");
				}System.out.println();
			}
			System.out.println();
			if(R.x == RR.x && R.y == RR.y && B.x == BB.x && B.y == BB.y) return;
			dfs(newmap, cnt+1,i);
		}
	}
	static public xy findxy(char[][] map, int d, xy XY) {
		int x = XY.x;
		int y = XY.y;
		while(true) {
			int xx = x+dx[d];
			int yy = y+dy[d];
			if(xx > 0 && yy > 0 && xx < map.length && yy < map[0].length && map[xx][yy] =='O') {
				return new xy(xx, yy);
			}else if(xx < 0 || yy < 0 || xx >= map.length || yy >= map[0].length || map[xx][yy] !='.') {
				break;
			}
			x = xx;
			y = yy;
		}
		return new xy(x, y);
	}
	static class xy{
		int x;
		int y;
		public xy(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
