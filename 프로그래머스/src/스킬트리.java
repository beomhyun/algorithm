public class 스킬트리 {
	public static void main(String[] args) {
		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		System.out.println(solution(skill, skill_trees));
	}
	public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (int i = 0; i < skill_trees.length; i++) {
        	boolean[] check = new boolean[skill.length()];
			boolean c = true;
        	for (int j = 0; j < skill_trees[i].length(); j++) {
        		char tmp = skill_trees[i].charAt(j);
        		for (int k = 0; k < skill.length(); k++) {
					if(skill.charAt(k) == tmp) {
						boolean c2 = true;
						for (int l = 0; l < k; l++) {
							if(!check[l]) {
								c2 = false;
								break;
							}
						}
						if(!c2) {
							c= false;
							break;
						}else {
							check[k] = true;
						}
					}
				}
			}
        	if(c) answer++;
		}
        
        return answer;
    }
}
