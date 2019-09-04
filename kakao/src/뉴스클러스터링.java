

import java.util.ArrayList;

public class 뉴스클러스터링 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		
		System.out.println(sol.solution("aab1c", "a1aababc"));
//		System.out.println(sol.solution("FR NCE", "fren h"));
	}
}

class Solution {
  public int solution(String str1, String str2) {
      int answer = 0;
	      str1 = str1.toLowerCase();
	      str2 = str2.toLowerCase();
	      ArrayList<node> list1 = new ArrayList<>();
	      ArrayList<node> list2 = new ArrayList<>();

	      for (int i = 0; i < str1.length()-1; i++) {
	    	  String tmp = str1.substring(i,i+2);
	    	  if(tmp.charAt(0) <'a' || tmp.charAt(0) > 'z' || tmp.charAt(1)<'a' || tmp.charAt(1) >'z' ) {
	    		  continue;
	    	  }
	    	  boolean check = true;
	    	  for (int j = 0; j < list1.size(); j++) {

				if(list1.get(j).str.equals(tmp)) {
					list1.get(j).count++;
					check = false;
					break;
				}
			}
	    	  if(check) {
	    		  list1.add(new node(tmp, 1));
	    	  }
	      }
	      
	      for (int i = 0; i < str2.length()-1; i++) {
	    	  String tmp = str2.substring(i,i+2);
	    	  if(tmp.charAt(0) <'a' || tmp.charAt(0) > 'z' || tmp.charAt(1)<'a' || tmp.charAt(1) >'z' ) {
	    		  continue;
	    	  }

	    	  boolean check = true;
	    	  for (int j = 0; j < list2.size(); j++) {
		    	  if(list2.get(j).str.equals(tmp)) {
						list2.get(j).count++;
						check = false;
						break;
					}
	    	  }
				if(check) {
					list2.add(new node(tmp, 1));
				}
	      }
	      ArrayList<node> annd = new ArrayList<>();
	      ArrayList<node> oor = new ArrayList<>();	      
	      //리스트로 해야하나 ????
	      for(node n1 : list1) {
	    	  oor.add(new node(n1.str,n1.count));
	      }

	      for(node n1 : list2) {
	    	  boolean check = true;
	    	  for(node n2 : oor) {
	    		  if(n1.str.equals(n2.str)) {
	    			  if(n1.count >= n2.count) {
	    				  n2.count = n1.count;
	    				  check = false;
	    			  }
	    		  }
	    	  }
	    	  if(check) oor.add(new node(n1.str,n1.count));
	      }

	      for(node n1 : list1) {
	    	  for(node n2 : list2) {
	    		  if(n1.str.equals(n2.str)) {
	    			  if(n1.count >= n2.count) {
	    				  annd.add(new node(n1.str, n2.count));
	    			  }else {
	    				  annd.add(new node(n1.str, n1.count));
	    			  }
	    		  }
	    	  }
	      }

	      double a = 0.0;
	      double b = 0.0;
	      for(node n1 : annd) {
	    	  a += n1.count;
	      }
	      
	      for(node n1 : oor) {
	    	  b+=n1.count;
	      }
	      //if(a==0) a=1;
	      if(b==0) {
              a=1;
              b=1;
          }
	      System.out.println(list1);
	      System.out.println(list2);
	      System.out.println(a);
	      System.out.println(b);
	      System.out.println(annd);
	      System.out.println(oor);
	      double tmp = a/b;
	      answer = (int) (65536*tmp);
	      return answer;
	  }
	  static class node {
		  String str;
		  int count;
		public node(String str, int count) {
			super();
			this.str = str;
			this.count = count;
		}
		@Override
		public String toString() {
			return "node [str=" + str + ", count=" + count + "]";
		}
	  }
	}