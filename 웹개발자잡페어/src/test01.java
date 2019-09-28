import java.util.Arrays;

public class test01 {
	public static void main(String[] args) {

	}
    public int solution(int[] goods, int[] boxes){
    	Arrays.sort(goods);
    	Arrays.sort(boxes);
    	int answer = 0;
    	int index = 0;
    	for (int i = 0; i < goods.length; i++) {
			int good = goods[i];
    		boolean c = false;
    		while(index < boxes.length) {
				if(boxes[index] >= good) {
					c = true;
					index++;
					break;
				}
				index++;
			}
			if(c) answer++;
		}
        return answer;
    }
}
