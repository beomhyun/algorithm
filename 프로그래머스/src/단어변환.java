
public class 단어변환 {
	public static void main(String[] args) {
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		String begin = "hit";
		String target = "cog";
		System.out.println(solution(begin, target, words));
	}
	static int answer;
    static boolean[] use;
	public static int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        use = new boolean[words.length];
        boolean check = false;
        for (int i = 0; i < words.length; i++) {
			if(words[i].equals(target)) {
				check = true;
				break;
			}
		}
        if(!check) return 0;
        dfs(begin,target,words,0);
    	return answer;
    }
    static void dfs(String begin, String target, String[] words, int d) {
    	if(d >= answer) return;
    	if(begin.equals(target)) {
    		if(answer > d) answer = d;
    		return;
    	}
    	for (int i = 0; i < words.length; i++) {
			if(use[i]) continue;
			int cnt = 0;
			for (int j = 0; j < words[i].length(); j++) {
				if(begin.charAt(j) != words[i].charAt(j)) cnt++;
			}
			if(cnt==1) {
				use[i] = true;
				dfs(words[i],target,words,d+1);
				use[i] = false;
			}
		}
    }
}
