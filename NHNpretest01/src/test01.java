import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class test01 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		StringTokenizer st= new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			String tmp = st.nextToken();
			if(map.containsKey(tmp)) {
				map.put(tmp, map.get(tmp)+1);
			}else {
				map.put(tmp, 1);
			}
		}
		int max = 0;
		int sum = 0;
		HashSet<Integer> set = new HashSet<Integer>();
		for (Iterator<String> it = map.keySet().iterator(); it.hasNext();) {
//			System.out.println(it.next());
			int tmp = map.get(it.next());
			set.add(tmp);
			max = max>tmp?max:tmp;
			sum += tmp;
		}
		boolean c = true;
		if(set.size() == 2) {
			int cnt = 0;
			for(Iterator<Integer> it = set.iterator(); it.hasNext();) {
				int tmp = it.next();
				if(tmp == max )continue;
				else if(tmp != max-1){
					c = false;
				}
			}
			if(c && cnt<2) {
				System.out.println("Y");
				System.out.println(sum+1);
				System.out.println(map.size());
			}else {
				System.out.println("N");
				System.out.println(sum);
				System.out.println(map.size());
			}
		}else {
			for(Iterator<Integer> it = set.iterator(); it.hasNext();) {
				int tmp = it.next();
				if(tmp == max )continue;
				else if(tmp != max){
					c = false;
				}
			}
			if(c) {
				System.out.println("Y");
				System.out.println(sum);
				System.out.println(map.size());
			}else {
				System.out.println("N");
				System.out.println(sum);
				System.out.println(map.size());
			}
		}
		
		
	}
	
}
