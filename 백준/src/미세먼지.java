import java.util.ArrayList;
import java.util.Scanner;

public class 미세먼지 {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		int T = sc.nextInt();
		
		int[][] map = new int[R][C];
		xy[] air = new xy[2];
		int id = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == -1) air[id++]= new xy(i, j);
			}
		}
		for (int time = 0; time < T; time++) {
			ArrayList<xy> list = new ArrayList<>();
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if(map[i][j] !=0 && map[i][j] != -1) {
						int cnt = 0;
						for (int k = 0; k < 4; k++) {
							int x = i + dx[k];
							int y = j + dy[k];
							if(x >=0 && y>= 0 && x < R && y < C && map[x][y] != -1) {
								cnt++;
								list.add(new xy(x, y, map[i][j]/5));
							}
						}
						if(cnt > 0) {
							int tmp = -1* cnt * (int)(map[i][j]/5);
							list.add(new xy(i, j, tmp));
						}
					}
				}
			}
			for (int i = 0; i < list.size(); i++) {
				xy tmp = list.get(i);
				map[tmp.x][tmp.y] += tmp.d; 
			}
			//미세먼지 확산
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					System.out.print(map[i][j]+ " ");
				}System.out.println();
			}
			
			
			System.out.println();
			
			xy tmp = air[0];
			int x = tmp.x;
			int y = tmp.y;
			
			int d = 0;
			
			while(true) {
				int xx = x + dx[d];
				int yy = y + dy[d];
				if(!(x == tmp.x && y == tmp.y)) {
					map[x][y] = map[xx][yy];
				}
				x = xx;
				y = yy;
				
				if(x+dx[d] < 0 || y+dy[d] >=C || x+dx[d] >=R || y+dy[d]<0) {
					d++;
					if(d == 4 ) d= 0;
				}
				if(x == tmp.x && y == tmp.y) break;
			}
			
			tmp = air[1];
			x = tmp.x;
			y = tmp.y;
			d = 2;
			
			while(true) {
				int xx = x + dx[d];
				int yy = y + dy[d];
				if(!(x == tmp.x && y == tmp.y)) {
					map[x][y] = map[xx][yy];
				}
				x = xx;
				y = yy;
				if(x+dx[d] < 0 || y+dy[d] >=C || x+dx[d] >=R || y+dy[d]<0) {
					if(d == 0) d =3;
					else d--;
				}
				if(x == tmp.x && y == tmp.y) break;
			}
			
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					System.out.print(map[i][j]+ " ");
				}System.out.println();
			}
			System.out.println();
		}
		
		int res = 0;
		for (int i = 0; i < map.length; i++) {
			for (int k = 0; k < map[i].length; k++) {
				if(map[i][k]!=-1) {
					res += map[i][k];
				}
			}
		}
		System.out.println(res);
	}
	static class xy{
		int x;
		int y;
		int d;
		public xy(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		public xy(int x, int y,int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
}
