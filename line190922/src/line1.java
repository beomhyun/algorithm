import java.util.Scanner;

public class line1 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int c = sc.nextInt();
        int[] message = new int[m];
        for (int i = 0; i < m; i++) {
			message[i] = sc.nextInt();
		}
        int[] consumer = new int[c];
        
        for (int i = 0; i < m; i++) {
			int mintime = Integer.MAX_VALUE;
			int minindex = -1;
			for (int j = 0; j < consumer.length; j++) {
				if(mintime > consumer[j]) {
					mintime = consumer[j];
					minindex = j;
				}
			}
			consumer[minindex] += message[i];
		}
        int maxtime = 0;
        for (int i = 0; i < consumer.length; i++) {
			if(maxtime < consumer[i]) maxtime = consumer[i];
		}
        
        System.out.println(maxtime);
	}
	
}
