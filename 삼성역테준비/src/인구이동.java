import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 인구이동 {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int L = sc.nextInt();
		int R = sc.nextInt();
		
		int[][] A = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				A[i][j] = sc.nextInt();
			}
		}
		boolean check = true;
		int cnt = -1;
		while(check) {
//			for (int i = 0; i < A.length; i++) {
//				for (int j = 0; j < A.length; j++) {
//					System.out.print(A[i][j]+ " ");
//				}System.out.println();
//			}System.out.println();
			check = false;
			boolean[][] visit = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(visit[i][j]) continue;
					Queue<xy> que = new LinkedList<>();
					que.add(new xy(i, j));
					visit[i][j] = true;
					HashSet<xy> set = new HashSet<>();
					set.add(new xy(i,j));
					while(!que.isEmpty()) {
						xy tmp = que.poll();
						for (int k = 0; k < 4; k++) {
							int x = tmp.x + dx[k];
							int y = tmp.y + dy[k];
							
							if(x>=0 && y>=0 && x<N && y<N && !visit[x][y] && Math.abs(A[tmp.x][tmp.y]-A[x][y])>=L && Math.abs(A[tmp.x][tmp.y]-A[x][y])<=R) {
								visit[x][y] = true;
								set.add(new xy(x,y));
								que.add(new xy(x, y));
							}
						}
					}
					int sum = 0;
					for(xy tmp : set) {
						sum += A[tmp.x][tmp.y];
					}
					for(xy tmp : set) {
						A[tmp.x][tmp.y] = sum/set.size(); 
					}
					if(set.size() != 1) {
						check =true;
					}
				}
			}
			cnt++;
		}
		System.out.println(cnt);
		
	}
	static class xy{
		int x;
		int y;
		public xy(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			xy other = (xy) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
	}
}
