import java.util.Scanner;

public class line5_2 {
	static int time;
	static long cnt;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        if(x >n || y>m ) {
        	System.out.println("fail");
        }
        else {
        	long[][] map = new long[n+1][m+1];
        	time = x+y;
        	map[1][1] = 1;
        	boolean c = false;
        	for (int i = 1; i < map.length; i++) {
				for (int j = 1; j < map.length; j++) {
					if(i==1 && j== 1) continue;
					map[i][j] = map[i-1][j] + map[i][j-1];
					if(i==x+1 && j==y+1) {
						cnt = map[i][j];
						c = true;
						break;
					}
				}
				if(c)break;
			}
        	for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					System.out.print(map[i][j] + "\t");
				}System.out.println();
			}
        	
        	
        	System.out.println(time);
        	System.out.println(cnt);
        }
	}
}
