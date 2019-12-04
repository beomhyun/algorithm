import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class test01 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		while(st.hasMoreTokens()) {
			String tmp = st.nextToken();
			if(map.containsKey(tmp)) {
				map.put(tmp,map.get(tmp)+1);
			}else {
				map.put(tmp, 1);
			}
		}
		int max = 0;
		int sum = 0;
		for (Iterator<String> it = map.keySet().iterator(); it.hasNext();) {
			int tmp = map.get(it.next());
			max = Math.max(max,tmp);
			sum += tmp;
		}
		int cnt = 0;
		boolean check = true;
		for (Iterator<String> it = map.keySet().iterator(); it.hasNext();) {
			if(map.get(it.next()) == max) continue;
			else if(map.get(it.next()) < max -1) {
				check = false;
				break;
			}else if(map.get(it.next()) == max -1) {
				cnt++;
			}
		}
		if(cnt >1) check = false;
		
		if(check) {
			if(cnt ==0) {
				System.out.println("Y");
				System.out.println(sum);
				System.out.println(map.size());
			}else {
				System.out.println("Y");
				System.out.println(sum+1);
				System.out.println(map.size());
			}
		}else {
			System.out.println("N");
			System.out.println(sum);
			System.out.println(map.size());
		}
		
		
	}
}
