	import java.util.ArrayList;

public class «¡∏∞≈Õ {
	public static void main(String[] args) {
//		int[] priorities = {2,1,3,2};
		int[] priorities = {1,1,9,1,1,1};
		System.out.println(solution(priorities, 0));
	}
    public static int solution(int[] priorities, int location) {
    	ArrayList<print> list = new ArrayList<>();
    	for (int i = 0; i < priorities.length; i++) {
			list.add(new print(i, priorities[i]));
		}
    	int answer = 1;
    	while (true) {
			print tmp = list.remove(0);
			boolean check = true;
			for (int i = 0; i < list.size(); i++) {
				if(tmp.prioritie < list.get(i).prioritie) {
					list.add(tmp);
					check = false;
					break;
				}
			}
			if(check) {
				if(tmp.index == location) break;
				else {
					answer++;
				}
			}
		}
    	return answer;
    }
    static class print{
    	int index;
    	int prioritie;
		public print(int index, int prioritie) {
			super();
			this.index = index;
			this.prioritie = prioritie;
		}
		@Override
		public String toString() {
			return "print [index=" + index + ", prioritie=" + prioritie + "]";
		}
		
    }
}
