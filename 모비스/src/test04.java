public class test04 {
	public static void main(String[] args) {
		solution(10);
		System.out.println(count);
	}
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static char[][] map = {{'Q','W','E','R','T','Y','U','I','O','P'},{'A','S','D','F','G','H','J','K','L'},{'Z','X','C','V','B','N','M'}};
	static int[][] map2 = {{7,6,5,4,3,2,1,2,3,4},{6,5,4,3,2,1,0,1,2},{7,6,5,4,3,2,1}};
	public static int solution(int T) {
        if(T%2 != 0 ) return 0;
        int answer = -1;
        count = 0;
        dfs(T, 0, 1, 6);
        return answer;
    }
	static int count;
    public static void dfs(int T, int n, int x, int y) {
    	if(map2[x][y]+n > T ) return;
    	if(n == T) {
    		if( x== 1 && y == 6) {
    			count++;
    		}
    		count = count%1000000007;
    		return;
    	}
    	for (int i = 0; i < 4; i++) {
    		int xx = x+dx[i];
    		int yy = y+dy[i];
    		if(xx<0 || yy <0 || xx>2 || (xx==0 && yy>9)||(xx==1 && yy >8)|| (xx==2 && yy>6)) continue;
			dfs(T, n+1, xx,yy);
		}
    }
}
