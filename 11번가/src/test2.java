public class test2 {
	public static void main(String[] args) {
		int[] v= {20,8,10,1,4,15};
		int[] res = new int[v.length];
		boolean[] use = new boolean[v.length];
		dfs(v, use, res, 0);
		System.out.println(max);
	}
	static int max = 0;
	public static void dfs(int[] v, boolean[] use, int[] res, int k) {
		if(k == v.length) {
			int tmp = 0;
			for (int i = 1; i < res.length; i++) {
				tmp += Math.abs(res[i] - res[i-1]);
			}
			max = max>tmp?max:tmp;
			return;
		}
		for (int i = 0; i < v.length; i++) {
			if(use[i]) continue;
			use[i] = true;
			res[k] = v[i];
			dfs(v, use, res, k+1);
			use[i] = false;
		}
	}
}
