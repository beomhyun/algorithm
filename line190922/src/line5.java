import java.util.Scanner;

public class line5 {
	static int time;
	static int cnt;
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
        	time = Integer.MAX_VALUE;
        	cnt = 0;
        	dfs(0, 0, 0, x, y);
        	System.out.println(time);
        	System.out.println(cnt);
        }
	}
	static void dfs(int d, int x, int y , int cx, int cy) {
		if(x > cx || y > cy || d > time) return;
		if(x==cx && y==cy) {
			if(time == d) cnt++;
			else if(time > d) {
				time = d;
				cnt = 1;
			}
			return;
		}
		dfs(d+1,x+1,y,cx,cy);
		dfs(d+1,x,y+1,cx,cy);
	}

}
