import java.util.ArrayList;

public class 기능개발 {
	public static void main(String[] args) {
		int[] pro = {93, 30, 55};
		int[] sp = {1, 30, 5};
		solution(pro, sp);
	}
    public static int[] solution(int[] progresses, int[] speeds) {
    	int[] day = new int[progresses.length];
    	for (int i = 0; i < day.length; i++) {
    		if((100 - progresses[i])%speeds[i] == 0) {
    			day[i] = (100 - progresses[i])/speeds[i];
    		}else {
    			day[i] = (100 - progresses[i])/speeds[i] +1;
    		}
//    		System.out.println(day[i]);
		}
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	int index = 0;
    	while(index < day.length) {
    		int cnt = 0;
    		for (int i = index; i < day.length; i++) {
    			if(day[i] <= day[index]) cnt++;
    		}
    		list.add(cnt);
    		index+=cnt;
    	}
//    	System.out.println(list);
    	int[] answer = new int[list.size()];
    	for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
        return answer;
    }
}
