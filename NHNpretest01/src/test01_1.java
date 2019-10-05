import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class test01_1 {
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
		ArrayList<Integer> set=  new ArrayList<Integer>();
		for (Iterator<String> it = map.keySet().iterator(); it.hasNext();) {
			int tmp = map.get(it.next());
			set.add(tmp);
			max = max>tmp?max:tmp;
			sum += tmp;
		}
		boolean c = true;
		int cnt = 0;
		for (int i = 0; i < set.size(); i++) {
			if(set.get(i) == max) continue;
			else if(set.get(i) != max-1) {
				c = false;
				break;
			}else if(set.get(i) == max-1) {
				cnt++;
			}
		}
		if(c && cnt == 0) {
			System.out.println("Y");
			System.out.println(sum);
			System.out.println(map.size());
		}else if(c && cnt == 1) {
			System.out.println("Y");
			System.out.println(sum+1);
			System.out.println(map.size());
		}else {
			System.out.println("N");
			System.out.println(sum);
			System.out.println(map.size());
		}
		
	}
	
}
