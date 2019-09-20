import java.util.ArrayList;

public class 모의고사 {
	public static void main(String[] args) {
		int[] answers = {1,2,3,4,5};
		solution(answers);
	}
    public static int[] solution(int[] answers) {
    	int a =0;
    	int b =0;
    	int c =0;
    	
    	int indexb =1;
    	int indexc =0;
    	int cntc = 0;
    	int[] cc = {3,1,2,4,5};
    	for (int i = 0; i <answers.length; i++) {
//			System.out.println(i%5+1);
			if(answers[i] == (i%5+1)) a++;
			
			if(i%2 ==0) {
//				System.out.println(2);
				if(answers[i] == 2) b++;
			}else {
				if(indexb == 2) indexb++;
//				System.out.println(indexb++);
				if(answers[i] == indexb++) b++;
				if(indexb == 6) indexb = 1;
			}
			
//			System.out.println(cc[indexc]);
			if(answers[i] == cc[indexc]) c++;
			cntc++;
			if(cntc == 2) {
				cntc=0;
				indexc++;
				if(indexc == 5) indexc=0;
			}
			
//			System.out.println();
    	}
//    	System.out.println(a);
//    	System.out.println(b);
//    	System.out.println(c);
    	int[] tmp = {a,b,c};
    	int max = 0;
    	for (int i = 0; i < tmp.length; i++) {
			if(max < tmp[i]) max = tmp[i];
		}
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	for (int i = 0; i < tmp.length; i++) {
			if(tmp[i] == max) list.add(i+1);
		}
    	
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
        return answer;
    }
}
