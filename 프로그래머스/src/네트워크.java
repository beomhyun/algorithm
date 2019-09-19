
public class 네트워크 {
	public static void main(String[] args) {
		int[][] com = {{1,1,0},{1,1,0},{0,0,1}};
	}
	static int[] par;
	public int solution(int n, int[][] computers) {
        int answer = 0;
        par = new int[n];
        for (int i = 0; i < n; i++) {
			par[i] = i;
		}
        for (int i = 0; i < computers.length; i++) {
			for (int j = 0; j < computers[i].length; j++) {
				if(computers[i][j] == 1) {
					union(i, j);
					for (int k = 0; k < n; k++) {
						find(k);
					}
				}
			}
		}
        for (int i = 0; i < n; i++) {
			if(i == par[i]) answer++;
		}
        return answer;
    }
	static void union(int a, int b) {
		if(find(a) == find(b)) {
			return;
		}else if(find(a) > find(b)) {
			par[b] = par[a];
		}else {
			par[a] = par[b];
		}
	}
	static int find(int a) {
		if(a == par[a]) {
			return a;
		}
		return par[a] = find(par[a]);
		
	}
}
