import java.util.Set;
import java.util.TreeSet;

public class 소수찾기 {
	public static void main(String[] args) {
		System.out.println(solution("17"));
	}
	static Set<Integer> list;
	static int[] map;
	static int N;
	public static int solution(String numbers) {
        list = new TreeSet<Integer>();
        map = new int[numbers.length()];
        N = map.length;
        for (int i = 0; i < map.length; i++) {
			map[i] = numbers.charAt(i)-'0';
		}
        boolean[] use = new boolean[N];
        dfs(use,new StringBuilder());
        System.out.println(list);
        return list.size();
    }
    public static void dfs(boolean[] use, StringBuilder str) {
    	if(str.length()!=0) {
    		boolean check = true;
    		int num = Integer.parseInt(str.toString());
    		for (int i = 2; i < num; i++) {
    			if(num%i == 0) {
    				check = false;
    				break;
    			}
    		}
    		if(check) list.add(num);
    	}
    	for (int i = 0; i < use.length; i++) {
			if(!use[i]) {
				str.append(map[i]);
				dfs(use,str);
				str.replace(str.length()-1, str.length(), "");
				use[i] = false;
				dfs(use,str);
			}
		}
    }
}
