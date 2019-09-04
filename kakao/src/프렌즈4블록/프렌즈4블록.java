package 프렌즈4블록;
import java.util.HashSet;

public class 프렌즈4블록 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
	}
	static class Solution {
		static int dx[] = {1,1,0};
		static int dy[] = {0,1,1};
		//자기 칸 기준으로 우,하,우하 방향을 보고 자기랑 같은 모양이면 지울꺼
		  public int solution(int m, int n, String[] board) {
		      int answer = 0;
		      
		      char[][] map = new char[m][n];
		      for (int i = 0; i < m; i++) {
		    	  for (int j = 0; j < n; j++) {
		    		  map[i][j] = board[i].charAt(j);
		    	  }
		      }
		      boolean check = true;
		      while(check) {
		    	  check = false;
		    	  HashSet<xy> remove = new HashSet<>();
		    	  for (int i = 0; i < m; i++) {
					for (int j = 0; j < n; j++) {
						char block = map[i][j];
						if(block=='x') continue;
						//지운건 x로 표시
						int count = 1;
						for (int k = 0; k < 3; k++) {
							int x = i+dx[k];
							int y = j+dy[k];
							if(x>=0 && x<m && y>=0 && y<n && map[x][y]==block) {
								count++;
							}
						}
						if(count==4) {
							remove.add(new xy(i, j));
							check=true;
							for (int k = 0; k < 3; k++) {
								int x = i+dx[k];
								int y = j+dy[k];
								remove.add(new xy(x,y));
							}
						}
						//지울거 고르기 끝
					}
		    	  }
					for(xy tmp : remove) {
						answer++;
						int x = tmp.x;
						int y = tmp.y;
						map[x][y] = 'x';
					}
					remove.clear();
					//지우기 끝
					
					for (int i = 0; i < n; i++) {
						for (int j = m-1; j >=0; j--) {
							if(map[j][i]=='x') {
								for (int k = j; k >= 0; k--) {
									if(map[k][i]!='x') {
										map[j][i]=map[k][i];
										map[k][i]='x';
										break;
									}
								}
							}
						}
					}
					//블럭 내리기 끝
		      }
		      return answer;
		  }
		}
	static class xy {
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
