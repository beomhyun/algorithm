import java.util.Stack;

public class �踷��� {
	public static void main(String[] args) {
		
	}
	public static int solution(String arrangement) {
        int answer = 0;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < arrangement.length(); i++) {
			char tmp = arrangement.charAt(i);
			if(tmp == '(') {
				if(arrangement.charAt(i+1) == ')') {
					i++;
					answer += stack.size();
				}else {
					stack.add('(');
				}
			}else {
				answer++;
				stack.pop();
			}
		}
        return answer;
    }
}
