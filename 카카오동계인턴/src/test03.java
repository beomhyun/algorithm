import java.util.ArrayList;
import java.util.HashSet;

public class test03 {
    public static int solution(String[] user_id, String[] banned_id) {
    	ArrayList[] noc = new ArrayList[banned_id.length];
    	for (int i = 0; i < noc.length; i++) {
    		noc[i] = new ArrayList<Integer>();
			int cnt = 0;
			String tmp = banned_id[i];
			for(int j=0; j<user_id.length; j++) {
				String str = user_id[j];
				if(tmp.length() != str.length()) continue;
				boolean check = true;
				for (int k = 0; k < str.length(); k++) {
					if(tmp.charAt(k) == '*') continue;
					else if(tmp.charAt(k) != str.charAt(k)) {
						check = false;
						break;
					}
				}
				if(check) {
					noc[i].add(j);
				}
			}
		}
    	set = new HashSet<String>();
    	boolean[] choise = new boolean[user_id.length];
    	dfs(noc, choise, 0);
        int answer = set.size();
        return answer;
    }
    static HashSet<String> set;
    public static void dfs(ArrayList<Integer>[] noc,boolean[] choise, int k) {
    	if(k == noc.length) {
    		String tmp = "";
    		for (int i = 0; i < choise.length; i++) {
				if(choise[i]) {
					tmp += i;
				}
			}
    		set.add(tmp);
    		return;
    	}
    	for (int i : noc[k]) {
			if(choise[i])continue;
    		choise[i] = true;
			dfs(noc, choise, k+1);
			choise[i] = false;
		}
    }
    public static void main(String[] args) {
//		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
//		String[] banned_id = {"fr*d*", "abc1**"};
		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id = {"fr*d*", "*rodo", "******", "******",};
		
		System.out.println(solution(user_id, banned_id));
	}
}
