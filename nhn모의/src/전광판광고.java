import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Àü±¤ÆÇ±¤°í {
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer input = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(input.nextToken());
		int W = Integer.parseInt(input.nextToken());
		
		StringBuilder[][] map = new StringBuilder[N][N];
		for (int i = 0; i < N; i++) {
			input = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = new StringBuilder(input.nextToken());
			}
		}
		StringBuilder[][] printingmap = new StringBuilder[N][N];
		if(true) {
			for (int i = 0; i < N/2; i++) {
				int min = i;
				int max = N-1-i;
				int move = (int) (W%((max-min)*4)*Math.pow(-1, i));
				if(move < 0) {
					move = (max-min)*4 + move;
				}
				int x = i;
				int y = i;
				int cnt = 0;
				int d = 0;
				int newx = i;
				int newy = i;
				for (int j = 0; j < move; j++) {
					newx = newx+dx[d];
					newy = newy+dy[d];
					if(d==0 && newy == max) {
						d++;
					}else if(d==1 && newx == max ) {
						d++;
					}else if(d==2 && newy == min) {
						d++;
					}else if(d==3 && newx == min ) {
						d = 0;
					}
				}
				int d2= 0;
				while(cnt < (max-min)*4) {
					cnt++;
//					System.out.println("x : "+x + " " + "y : "+ y);
//					System.out.println("newx : "+newx + " " + "newy : "+ newy);
					
					printingmap[newx][newy] = map[x][y];
//					System.out.println(printingmap[newx][newy]);	
					

					if(d==0 && newy == max) {
						d++;
					}else if(d==1 && newx == max ) {
						d++;
					}else if(d==2 && newy == min) {
						d++;
					}else if(d==3 && newx == min ) {
						d = 0;
					}
					newx = newx+dx[d];
					newy = newy+dy[d];
//					System.out.println("d  " + d+ "   max : " + max );
					

					if(d2==0 && y  == max) {
						d2++;
					}else if(d2==1 && x== max ) {
						d2++;
					}else if(d2==2 && y == min) {
						d2++;
					}else if(d2==3 && x == min ) {
						d2 = 0;
					}
					x = x+dx[d2];
					y = y+dy[d2];
//					System.out.println("d2  " + d2);
				}
				
				
			}
		}
		if(N%2 !=0) {
			printingmap[N/2][N/2] =map[N/2][N/2];
		}
		for (int i = 0; i < printingmap.length; i++) {
			for (int j = 0; j < printingmap[i].length; j++) {
				System.out.print(printingmap[i][j].toString()+" ");
			}System.out.println();
		}
		
	}
}
