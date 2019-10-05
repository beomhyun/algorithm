import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class test03 {
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
		while(st.hasMoreTokens()) {
			char card = st.nextToken().charAt(0);
			System.out.println(index + " : " +card );
			getcandi.clear();
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
			while(true) {
				int presize = getcandi.size();
				for (int i = 0; i < follow.length; i++) {
					if(getcandi.contains(i))continue;
					for (int j = 0; j < follow[i].size(); j++) {
						if(getcandi.contains(follow[i].get(j))) {
							getcandi.add(i);
							break;
						}
					}
				}
				if(presize == getcandi.size()) break;
			}
			for (Iterator<Integer> it = getcandi.iterator(); it.hasNext();) {
				int tmp = it.next();
				score[tmp]++;
			}
			index++;
			if(index == N) index = 0;
			for (int i = 0; i < score.length; i++) {
				System.out.print(score[i] + " ");
			}System.out.println(follow[0]);
		}
		for (int i = 0; i < score.length; i++) {
			System.out.print(score[i] + " ");
		}
		
	}
}
