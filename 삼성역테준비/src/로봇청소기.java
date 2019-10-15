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
//			System.out.println("r  : " + r + " c : "+ c +"  d  :" + d);
//			for (int i = 0; i < visit.length; i++) {
//				for (int j = 0; j < visit[i].length; j++) {
//					if(visit[i][j]) System.out.print(1+" ");
//					else System.out.print(0+" ");
//				}System.out.println();
//			}
			boolean check = true;
			int dd = d;
			for (int i = 0; i < 4; i++) {
				dd--;
				if(dd==-1) dd = 3;
				int x = r + dx[dd];
				int y = c + dy[dd];
				if(x >= 0 && y>=0 && x < N && y <M && !visit[x][y] && map[x][y]!=1 ) {
					visit[x][y] = true;
					cnt++;
					r = x;
					c = y;
					check = false;
					d=dd;
					break;
				}
			}
			if(check) {
				check = true;
				dd = d;
				for (int i = 0; i < 2; i++) {
					dd--;
					if(dd==-1)dd=3;
				}
				int x = r+dx[dd];
				int y = c+dy[dd];
				if(x >= 0 && y>=0 && x < N && y <M && map[x][y]==1 ) {
					break;
				}else {
					r = x;
					c = y;
				}
			}
			
		}
		System.out.println(cnt);
	}
}
