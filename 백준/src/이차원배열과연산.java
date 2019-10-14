import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class 이차원배열과연산 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int k = sc.nextInt();
		int[][] A = new int[100][100];
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				A[i][j] = sc.nextInt();
			}
		}
		int time = 0;
		int x = 1;
		int y = 1;
		while(true) {
			for (int i = 0; i < A.length; i++) {
				if(A[i][0] == 0) continue;
				for (int j = 0; j < A.length; j++) {
					if(A[i][j] == 0) break;
					System.out.print(A[i][j] + " ");
				}System.out.println();
			}
			System.out.println();
			
			if(A[r-1][c-1] == k) {
				break;
			}
			if(x>=y) {
				for (int i = 0; i < A.length; i++) {
					ArrayList<num> list = new ArrayList<>();
					for (int j = 0; j < A.length; j++) {
						if(A[i][j] == 0) break;
						boolean cc = true;
						for (int kk = 0; kk < list.size(); kk++) {
							if(list.get(kk).num == A[i][j]) {
								list.get(kk).cnt++;
								cc = false;
								break;
							}
						}
						if(cc) list.add(new num(A[i][j], 1));
					}
					list.sort(new Comparator<num>() {
						@Override
						public int compare(num o1, num o2) {
							if(o1.cnt < o2.cnt) {
								return -1;
							}else if(o1.cnt > o2.cnt) {
								return 1;
							}else {
								return o1.num - o2.num;
							}
						}
					});
					y = 0;
//					if(list.size()>0) System.out.println(list);
					int index = 0;
					for (int j = 0; j < list.size(); j++) {
						A[i][index++] = list.get(j).num;
						A[i][index++] = list.get(j).cnt;
					}
					y = y>(index-1)?y:(index-1);
					for (int j = index; j < A.length; j++) {
						A[i][j] = 0;
					}
				}
			}else {
				x=0;
				for (int i = 0; i < A.length; i++) {
					ArrayList<num> list = new ArrayList<>();
					for (int j = 0; j < A.length; j++) {
						if(A[j][i] == 0) break;
						boolean cc = true;
						for (int kk = 0; kk < list.size(); kk++) {
							if(list.get(kk).num == A[j][i]) {
								list.get(kk).cnt++;
								cc = false;
								break;
							}
						}
						if(cc) list.add(new num(A[j][i], 1));
					}
					list.sort(new Comparator<num>() {
						@Override
						public int compare(num o1, num o2) {
							if(o1.cnt < o2.cnt) {
								return -1;
							}else if(o1.cnt > o2.cnt) {
								return 1;
							}else {
								return o1.num - o2.num;
							}
						}
					});
//					if(list.size()>0) System.out.println(list);
					int index = 0;
					for (int j = 0; j < list.size(); j++) {
						A[index++][i] = list.get(j).num;
						A[index++][i] = list.get(j).cnt;
					}
					x = x>(index-1)?x:(index-1);
					for (int j = index; j < A.length; j++) {
						A[j][i] = 0;
					}
				}
			}
			
			time++;
		}
		System.out.println(time);
		
	}
	static class num{
		int num;
		int cnt;
		
		@Override
		public String toString() {
			return "num [num=" + num + ", cnt=" + cnt + "]";
		}
		public num(int num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}
	}
}
