
public class ž {
	public static void main(String[] args) {
		int[] height = {3,9,9,3,5,7,2};
		System.out.println(solution(height));
	}
    public static int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        for(int i=0; i<heights.length; i++){
            int tmp = -1;
            for(int j=i-1; j>=0; j--){
                if(heights[i] < heights[j]) {
                    tmp = j;
                    break;
                }
            }
            if(tmp != -1) {
            	tmp++;
            	answer[i] = tmp;
            }else {
            	answer[i] =0;
            }
        }
        for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i]);
		}
        return answer;
    }
}
