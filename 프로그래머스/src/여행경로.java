import java.util.ArrayList;

public class 여행경로 {
	public static void main(String[] args) {
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
		solution(tickets);
	}
	static boolean[] use;
	static ArrayList<String> res = new ArrayList<String>();
    static int N;
	public static String[] solution(String[][] tickets) {
        use = new boolean[tickets.length];
    	String begin = "ICN";
    	ArrayList<String> list = new ArrayList<String>();
    	list.add(begin);
    	N = tickets.length;
    	dfs(begin, list, tickets, 0);
    	String[] answer = new String[res.size()];
    	for (int i = 0; i < answer.length; i++) {
			answer[i] = res.get(i);
		}
    	return answer;
    }
    static void dfs(String begin, ArrayList<String> list, String[][] tickets, int d) {
    	if(d==N) {
    		if(res.size()==0) res = (ArrayList<String>) list.clone(); 
    		else {
    			boolean check = false;
    			boolean c = false;
    			for (int i = 0; i < list.size(); i++) {
					String tmp1 = list.get(i);
					String tmp2 = res.get(i);
					for (int j = 0; j < 3; j++) {
						if(tmp1.charAt(j) == tmp2.charAt(j)) continue;
						else if(tmp1.charAt(j) < tmp2.charAt(j)) {
							check = true;
							c=true;
							break;
						}else {
							check = false;
							c=true;
							break;
						}
					}
					if(c) break;
				}
    			if(check) res = (ArrayList<String>) list.clone();
    		}
    		return;
    	}
    	for (int i = 0; i < tickets.length; i++) {
			if(use[i]) continue;
			if(tickets[i][0].equals(begin)) {
				use[i] = true;
				list.add(tickets[i][1]);
				dfs(tickets[i][1], list, tickets, d+1);
				list.remove(list.size()-1);
				use[i] = false;
			}
		}

    }
}
