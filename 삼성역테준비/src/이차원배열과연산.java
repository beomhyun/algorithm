import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
		int x = 2;
		int y = 2;
		int time = 0;
		while(true) {
//			for (int i = 0; i <= x; i++) {
//				for (int j = 0; j <=y; j++) {
//					System.out.print(A[i][j]+" ");
//				}System.out.println();
//			}
//			System.out.println();
			
			if(A[r-1][c-1] == k) {
				break;
			}
			if(x>=y) {
				for (int i = 0; i <= x; i++) {
					Map<Integer, Integer> map = new HashMap<Integer, Integer>();
					int max = 0;
					for (int j = 0; j <= y; j++) {
						if(A[i][j] == 0) continue;
						if(map.containsKey(A[i][j])) {
							map.put(A[i][j], map.get(A[i][j])+1);
						}else {
							map.put(A[i][j], 1);
						}
					}
					Iterator<Integer> it = sortByValue(map).iterator();
					int index = 0;
					int sum =0;
					while(it.hasNext()) {
						int key = it.next();
						int val = map.get(key);
						System.out.println(key  + " " + val);
						sum += 2;
						A[i][index++] = key;
						A[i][index++] = val;
					}
				}
				
			}else {
				for (int i = 0; i <= y; i++) {
					Map<Integer, Integer> map = new HashMap<Integer, Integer>();
					for (int j = 0; j <= x; j++) {
						if(A[j][i] == 0) continue;
						if(map.containsKey(A[j][i])) {
							map.put(A[j][i], map.get(A[j][i])+1);
						}else {
							map.put(A[j][i], 1);
						}
					}
					Iterator<Integer> it = sortByValue(map).iterator();
					int index = 0;
					while(it.hasNext()) {
						int key = it.next();
						int val = map.get(key);
						
						A[index++][i] = key;
						A[index++][i] = val;
					}
				}
				
			}
			time ++;
		}
		System.out.println(time);
	}
    public static List sortByValue(final Map map){
        List<Integer> list = new ArrayList();
        list.addAll(map.keySet());
         
        Collections.sort(list,new Comparator(){
             
            public int compare(Object o1,Object o2){
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);
                 
                return ((Comparable) v1).compareTo(v2);
            }
             
        });
        Collections.reverse(list); // 주석시 오름차순
        return list;
    }
}
