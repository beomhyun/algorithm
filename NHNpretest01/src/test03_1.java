import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class test03_1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] score = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer>[] follow = new ArrayList[N];
		for (int i = 0; i < follow.length; i++) {
			follow[i] = new ArrayList<Integer>();
		}
		HashSet<Integer> getcandi = new HashSet<Integer>();
		int index = 0;
		boolean[] get = new boolean[N];
		while(st.hasMoreTokens()) {
			char card = st.nextToken().charAt(0);

			getcandi.clear();
			boolean c = true;
			if(card == 'A') {
				getcandi.add(index);
			}else if(card == 'J') {
				if(index == 0 ) {
					getcandi.add(N-1);
					getcandi.add(index+1);
				}else if(index == N-1) {
					getcandi.add(index-1);
					getcandi.add(0);
				}else {
					getcandi.add(index-1);
					getcandi.add(index+1);
				}
			}else if(card == 'Q') {
				for (int i = 0; i < N; i++) {
					getcandi.add(i);
				}
			}else if(card == 'K') {
				int who = Integer.parseInt(st.nextToken());
				follow[who].add(index);
			}
			for (Iterator<Integer> it = getcandi.iterator(); it.hasNext();) {
				int tmp = it.next();
				score[tmp]++;
			}
			while(true) {
				int presize = getcandi.size();
				for (int i = 0; i < follow.length; i++) {
					for (int j = 0; j < follow[i].size(); j++) {
						if(getcandi.contains(follow[i].get(j))) {
							getcandi.add(i);
							if(!get[i]) {
								score[i]++;
								get[i] = true;
							}
							break;
						}
					}
				}
				if(presize == getcandi.size()) break;
			}
			index++;
			if(index == N) index = 0;
		}
		for (int i = 0; i < score.length; i++) {
			System.out.print(score[i] + " ");
		}
		
	}
}
