public class test02 {
	public static void main(String[] args) {
		String[] bishops = {"D5", "E8", "G2"};
		System.out.println(solution(bishops));
	}
	static int[] dx = {-1,-1,1,1};
	static int[] dy = {-1,1,1,-1};
	
    public static int solution(String[] bishops) {
    	int[][] map = new int[8][8];
    	for (int i = 0; i < bishops.length; i++) {
			int x = bishops[i].charAt(0)-'A';
			int y = bishops[i].charAt(1)-'1';
    		map[x][y] = 9;
			for (int j = 0; j < 4; j++) {
				int xx = x;
				int yy = y;
				while(true) {
					xx += dx[j];
					yy += dy[j];
					if(xx >= 0 && xx <=7 && yy >=0 && yy<=7 && map[xx][yy] != 9) {
						map[xx][yy] = 1;
					}else {
						break;
					}
					
				}
			} 
    	}
    	int answer = 0;
    	for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]+" ");
				if(map[i][j]==0) {
					answer++;
				}
			}System.out.println();
		}
    	
        return answer;
    }
}
