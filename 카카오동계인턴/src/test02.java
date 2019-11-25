import java.util.Arrays;
import java.util.Comparator;

public class test02 {
    public static int[] solution(String s) {
    	String[] input = s.replaceAll("\\{", "").split("},");
    	for (int i = 0; i < input.length; i++) {
			input[i]= input[i].replaceAll("\\}","");
		}
        Arrays.sort(input,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length()-o2.length();
			}
		});
        int[] answer = new int[input.length];
        for (int i = 0; i < answer.length; i++) {
			String[] tmp = input[i].split(",");
			for(String st : tmp ) {
				int tmpint = Integer.parseInt(st);
				boolean check = false;
				for (int j = 0; j < i; j++) {
					if(answer[j]==tmpint) {
						check = true;
						break;
					}
				}
				if(check) continue;
				answer[i] = tmpint;
			}
		}
        return answer;
    }
    public static void main(String[] args) {
//		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
    	String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		int[] re = solution(s);
		for (int i = 0; i < re.length; i++) {
			System.out.print(re[i]+" ");
		}
	}
}
