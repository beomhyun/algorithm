

import java.util.Scanner;

public class 비밀지도2 {
	public static void main(String[] args) {
		Scanner sc=  new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][]map = new int[n][n];

		for (int i = 0; i < n; i++) {
			int tmp = sc.nextInt();
			for (int j = n-1; j >=0; j--) {
				int jari = (int) Math.pow(2, j);
				if(tmp >= jari) {
					map[i][n-1-j] = 1;
					tmp -= jari;
				}
				if(tmp == 0) break;
			}
		}
		for (int i = 0; i < n; i++) {
			int tmp = sc.nextInt();
			for (int j = n-1; j >=0; j--) {
				int jari = (int) Math.pow(2, j);
				if(tmp >= jari) {
					map[i][n-1-j] = 1;
					tmp -= jari;
				}
				if(tmp == 0) break;
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j]==1) {
					System.out.print("#");
				}else {
					System.out.print(" ");
				}
			}System.out.println();
		}
		
	}
}
