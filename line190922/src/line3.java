import java.util.Scanner;

public class line3 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] input = new int[n][2];
        for (int i = 0; i < n; i++) {
			input[i][0] = sc.nextInt();
			input[i][1] = sc.nextInt();
		}
        int min = 0;
        
        for (int i = 0; i < n; i++) {
			int tmp = 0;
        	for (int j = 0; j < n; j++) {
				if((input[i][0] <= input[j][0] && input[i][1] > input[j][0]) || (input[i][0] < input[j][1] && input[i][1] >= input[j][1])) {
					tmp++;
				}
			}
        	if(min < tmp) min = tmp;
		}
        System.out.println(min);
	}
}
