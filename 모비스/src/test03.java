
public class test03 {
	public static void main(String[] args) {
		String[] board = {"ABCBA", "DABAG", "EBABH", "FAJAI", "AKLMA"};
		System.out.println(solution(board));
	}
	static int[] dx = {-1,-1,1,1};
	static int[] dy = {-1,1,1,-1};
    public static int solution(String[] board) {
        int answer = 0;
        int N = board.length;
        char[][] map = new char[N][N];
        for (int i = 0; i < map.length; i++) {
        	for (int j = 0; j < map.length; j++) {
				map[i][j] = board[i].charAt(j);
			}
        }
        
        
        for (int i = 1; i < map.length-1; i++) {
			for (int j = 1; j < map.length-1; j++) {
				char tmp = map[i][j];
				int cnt = 1;
				while(true) {
					boolean check = true;
					for (int k = 0; k < 4; k++) {
						int x = i + dx[k]*cnt;
						int y = j + dy[k]*cnt;
						if(x<0 || y<0 || x>=N || y>=N || map[x][y] != tmp) {
							check = false;
							break;
						}
					}
					if(!check)break;
					cnt++;
				}
				answer = answer>cnt?answer:cnt;
			}
		}
        
        if(answer == 1) return 0;
        return 2*answer-1;
    }
}
