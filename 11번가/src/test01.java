public class test01 {
	public static void main(String[] args) {
		int[] sol = solution(1000000);
		for (int i = 0; i < sol.length; i++) {
			System.out.println(sol[i]);
		}
	}
	public static int[] solution(int N) {
		int max = 0;
		int res = 0;
		for (int i = 2; i < 10; i++) {
			int n = N;
			int m = findM(N,i);
			int tmp = 1;
			for (int j = m; j >=0; j--) {
				int k = (int)Math.pow(i, j);
				int l = findK(n, k);
				if(l==0) continue;
				tmp *=l;
				n -= k*l;
				if(n==0) break;
			}
			if(tmp >=max) {
				max = tmp;
				res = i;
			}
		}
		int[] answer = new int[2];
		answer[0] = res;
		answer[1] = max;
		return answer;
	}
	public static int findK(int N, int m) {
		int res = 0;
		while(true) {
			if(res > N) break;
			res += m;
		}
		return (res/m)-1;
	}
	public static int findM(int N, int k) {
		int res = 0;
		while(true) {
			if(Math.pow(k, res)>N) break;
			res++;
		}
		return res-1;
	}
	
}
