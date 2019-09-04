

import java.util.Arrays;

public class 비밀지도 {
	public static void main(String[] args) {
		int[] arr1 = {9, 20,28,18,11};
		int[] arr2 = {30,1,21,17,28};
		solution(5,arr1 ,arr2);
	}
	public static String[] solution(int n, int[] arr1, int[] arr2) {
	      String[] answer = new String[n];
	      
	      boolean[] map1 = new boolean[n];
	      boolean[] map2 = new boolean[n];
	      
	      for (int i = 0; i < n; i++) {
		      for (int j = 0; j < n; j++) {
					map1[j] = false;
					map2[j] = false;
				}

	    	int tmp1 = arr1[i];
	    	int tmp2 = arr2[i];
	    	for (int j = 0; j < n; j++) {
	    		  int jari = (int) Math.pow(2, n-j-1);
	    		  if(tmp1-jari >= 0) {
	    			  map1[j] = true;
	    			  tmp1-=jari;
	    		  }
	    		  if(tmp2 -jari >=0) {
	    			  map2[j] = true;
	    			  tmp2-=jari;
	    		  }
			}
	    	String stmp = "";
	    	for (int j = 0; j < n; j++) {
				if(map1[j]|map2[j]) {
					stmp+="#";
				}else {
					stmp+=" ";
				}
			}
	    	answer[i] =stmp;
		}
	      return answer;
	  }

}
