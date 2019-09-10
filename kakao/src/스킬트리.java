public class 스킬트리 {
	public static void main(String[] args) {
		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		System.out.println(solution(skill, skill_trees));
	}
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        char[] s = new char[skill.length()];
        for (int i = 0; i < skill.length(); i++) {
        	s[i] = skill.charAt(i);
		}
        for (int i = 0; i < skill_trees.length; i++) {
			boolean check = true;
	        boolean[] c = new boolean[skill.length()];
			for (int j = 0; j < skill_trees[i].length(); j++) {
				char tmp = skill_trees[i].charAt(j);
				for (int k = 0; k < s.length; k++) {
					if(tmp == s[k]) {
						c[k] = true;
						for (int l = 0; l < k; l++) {
							if(!c[l]) {
								check = false;
								break;
							}
						}
						if(!check)break;
					}
				}
				if(!check) break;
			}
			if(check) {
				System.out.println(i);
				answer++;
			}
		}
        return answer;
    }
}
