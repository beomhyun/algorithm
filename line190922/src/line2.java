import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class line2 {
	static ArrayList<Integer> list;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tmp = sc.nextLine();
        int k = sc.nextInt();
        StringTokenizer st = new StringTokenizer(tmp);
        int[] input = new int[st.countTokens()];
        for (int i = 0; i < input.length; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
        list = new ArrayList<Integer>();
        boolean[] use = new boolean[input.length];
        int[] num = new int[input.length];
        dfs(input, use, 0, num);
        list.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		});
        System.out.println(list);
        String answer = ""+list.get(k-1);
        while(answer.length() < input.length) {
        	answer = "0"+answer;
        }
        System.out.println(answer);
	}
	static void dfs(int[] input, boolean[] use,int d,int[] num) {
		if(d == input.length) {
			StringBuilder tmp = new StringBuilder();
			for (int i = 0; i < num.length; i++) {
				tmp.append(num[i]);
			}
			list.add(Integer.parseInt(tmp.toString()));
			return;
		}
		for (int i = 0; i < use.length; i++) {
			if(!use[i]) {
				use[i] = true;
				num[d] = input[i];
				dfs(input, use,d+1, num);
				use[i] =false;
			}
		}
	}
}
