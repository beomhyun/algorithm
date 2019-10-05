import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class test02 {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			if(st.nextToken().equals("enqueue")) {
				int tmp = Integer.parseInt(st.nextToken());
				list.add(tmp);
				if(map.containsKey(tmp)) {
					map.put(tmp, map.get(tmp)+1);
				}else {
					map.put(tmp, 1);
				}
			}else {
				int cnt = 0;
				for(Iterator<Integer> it = map.keySet().iterator(); it.hasNext();) {
					int tmp = it.next();
					if(map.get(tmp) > cnt) cnt = map.get(tmp);
				}
				for(Iterator<Integer> it = list.iterator(); it.hasNext();) {
					int tmp = it.next();
					if(map.get(tmp) == cnt) {
						System.out.println(tmp);
						map.put(tmp, map.get(tmp)-1);
						it.remove();
					}
				}
				
			}
		}
	}
	
}
