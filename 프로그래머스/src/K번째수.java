
public class K¹øÂ°¼ö {
	public static void main(String[] args) {
		int[] array = {1,5,2,6,3,7,4};
		int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
		solution(array, commands);
	}
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
			int start = commands[i][0]-1;
			int end = commands[i][1]-1;
			int target = commands[i][2]-1;
        	int[] tmp = new int[end-start+1];
			for (int j = start; j <= end; j++) {
				tmp[j-start] = array[j];
			}
			for (int j = 0; j < tmp.length-1; j++) {
				for (int k = j+1; k < tmp.length; k++) {
					if(tmp[j] > tmp[k]) {
						int t = tmp[j];
						tmp[j] = tmp[k];
						tmp[k] = t;
					}
				}
			}
			answer[i] = tmp[target];
		}
        for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i]+ " ");
		}
        return answer;
    }
}
