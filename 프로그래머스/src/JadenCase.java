public class JadenCase {
	public static void main(String[] args) {
		System.out.println(solution("A       u n Followed me"));
	}
	public static String solution(String s) {
		StringBuilder answer = new StringBuilder();
		boolean check = true;
		for (int i = 0; i < s.length(); i++) {
			if(!check) {
				answer.append(s.charAt(i));
				if(s.charAt(i) == ' ') check = true;
			}else {
				answer.append(Character.toUpperCase(s.charAt(i)));
				check = false;
			}
		}
		return answer.toString();
	}
}
