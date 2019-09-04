import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class ÈÄº¸Å° {
	static int N;
	static int R;
	static ArrayList<TreeSet<Integer>> res;
	public static void main(String[] args) {
		String[][] relation = {{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}};
		System.out.println(solution(relation));
	}
    public static int solution(String[][] relation) {
        int answer = 0;
        //ÄÃ·³°¹¼ö
        N = relation[0].length;
        //Æ©ÇÃ°¹¼ö
        R = relation.length;
        res = new ArrayList<>();
        boolean[] used = new boolean[N];
        dfs(relation, used, 0);
//        for (int i = 0; i < res.size(); i++) {
//			System.out.println(res.get(i));
//		}
        
        res.sort(new Comparator<TreeSet<Integer>>() {
			@Override
			public int compare(TreeSet<Integer> o1, TreeSet<Integer> o2) {
				if(o1.size() > o2.size()) return 1;
				else if(o1.size()==o2.size()) return 0;
				else return -1;
			}
		});
//        for (int i = 0; i < res.size(); i++) {
//			System.out.println(res.get(i));
//		}
        ArrayList<TreeSet<Integer>> set = new ArrayList<>();
        for (int i = 0; i < res.size(); i++) {
			TreeSet<Integer> tmpset = res.get(i);
			boolean check = true;
			for(TreeSet<Integer> tmp : set) {
				for(int tmp1 : tmp) {
					boolean c = false;
					for(int tmp2: tmpset) {
						if(tmp1 ==  tmp2) {
							c = true;
							break;
						}
					}
					if(c) {
						check = false;
						break;
					}
					
				}

			}
			if(check) {
				set.add(tmpset);
			}
		}
        
//        for (int i = 0; i < set.size(); i++) {
//			System.out.println(set.get(i));
//		}
        answer = set.size();
        return answer;
    }
    static void dfs(String[][] relation,boolean[] used, int k) {
    	if(k==N) return;
    	TreeSet<Integer> listtmp = new TreeSet<>();
    	boolean check = true;
    	for (int i = 0; i < used.length; i++) {
			if(used[i]) {
				listtmp.add(i);
	    		TreeSet<String> set = new TreeSet<>();
				for (int j = 0; j < relation.length; j++) {
					set.add(relation[j][i]);
				}
				if(set.size()!=R) {
					check = false;
					break;
				}
			}
		}
    	System.out.println(listtmp);
    	if(check && k!=0) {
//    		System.out.println(listtmp);
    		res.add(listtmp);
    	}
    	used[k] = true;
    	dfs(relation, used, k+1);
    	used[k] = false;
    	dfs(relation, used, k+1);
    }
}
