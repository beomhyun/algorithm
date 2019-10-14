import java.util.PriorityQueue;

public class test02 {
	public static void main(String[] args) {
		
	}
    public String solution(int n, String[] plates, int[] odo, int k, int[] drives) {
    	PriorityQueue<car> que = new PriorityQueue<>();
    	for (int i = 0; i < plates.length; i++) {
			que.add(new car(plates[i], odo[i]));
		}
    	for (int i = 0; i < drives.length; i++) {
			car tmp = que.poll();
			tmp.odo += drives[i];
			que.add(tmp);
		}
    	String answer = que.poll().num.toString();
        return answer;
    }
    static class car implements Comparable<car>{
    	StringBuilder num;
    	int odo;
		
		public car(String num, int odo) {
			super();
			this.num = new StringBuilder(num);
			this.odo = odo;
		}

		@Override
		public int compareTo(car o) {
			if(this.odo-o.odo == 0) {
				return this.num.toString().compareTo(o.num.toString());
			}else return this.odo-o.odo;
		}
    }
}
