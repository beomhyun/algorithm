import java.util.ArrayList;

public class 뉴스클러스터링2 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		
		System.out.println(sol.solution("FRANCE", "french"));

	}
	static class Solution {
		  public int solution(String str1, String str2) {
		      int answer = 0;
		      str1 = str1.toLowerCase();
		      str2 = str2.toLowerCase();
		      
		      ArrayList<String> list1 =  new ArrayList<>();
		      ArrayList<String> list2 =  new ArrayList<>();
		      for (int i = 0; i < str1.length()-1; i++) {
		    	  String tmp = str1.substring(i, i+2);
		    	  if(tmp.charAt(0) <'a' || tmp.charAt(0) > 'z' || tmp.charAt(1)<'a' || tmp.charAt(1) >'z' ) {
		    		  continue;
		    	  }
		    	  list1.add(tmp);
		      }
		      for (int i = 0; i < str2.length()-1; i++) {
		    	  String tmp = str2.substring(i, i+2);
		    	  if(tmp.charAt(0) <'a' || tmp.charAt(0) > 'z' || tmp.charAt(1)<'a' || tmp.charAt(1) >'z' ) {
		    		  continue;
		    	  }
		    	  list2.add(tmp);
		      }
		      ArrayList<String> intersection = intersection(list1, list2);
		      ArrayList<String> union = union(list1, list2);
//		      System.out.println(list1);
//		      System.out.println(list2);
//		      System.out.println(intersection);
//		      System.out.println(union);
		      
		      
		      if(union.size() == 0) return 1;
		      
		      answer = (int)(((double)(intersection.size()) / (double) (union.size())) * 65536);
		      
		      return answer;
		  }
		  public ArrayList<String> union(ArrayList<String> list1, ArrayList<String> list2){
			  ArrayList<String> l1 =  (ArrayList<String>) list1.clone();
			  ArrayList<String> l2 =  (ArrayList<String>) list2.clone();
			  ArrayList<String> union = new ArrayList<>();
			  
			  for(String tmp : l1) {
				  if(l2.contains(tmp)) {
					  l2.remove(tmp);
				  }
			  }
			  union.addAll(l1);
			  union.addAll(l2);
			  
			  return union;
		  }
		  public ArrayList<String> intersection(ArrayList<String> list1, ArrayList<String> list2){
			  ArrayList<String> l1 =  (ArrayList<String>) list1.clone();
			  ArrayList<String> l2 =  (ArrayList<String>) list2.clone();
			  ArrayList<String> intersection = new ArrayList<>();
			  
			  for(String tmp : l1) {
				  if(l2.contains(tmp)) {
					  intersection.add(tmp);
					  l2.remove(tmp);
				  }
			  }
			  return intersection;
		  }
	}
}