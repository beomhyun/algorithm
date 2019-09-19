public class 다리를지나는트럭 {
	public static void main(String[] args) {
		int[] truck_weights = {7,7,7,7};
		System.out.println(solution(2, 10, truck_weights));
	}
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int index =0;
        while(index < truck_weights.length){
        	int W = 0;
        	int cnt = 0;
        	while(W + truck_weights[index] <= weight) {
        		W += truck_weights[index++];
        		cnt++;
        		if(index == truck_weights.length) break;
        	}
        	if(cnt == 1) {
        		answer += (bridge_length+cnt-1);
        	}else {
        		answer += (bridge_length+cnt);
        	}
		}
        return answer;
    }
}
