

import java.util.ArrayList;
import java.util.Scanner;

public class 다트게임 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Solution sol = new Solution();
		System.out.println(sol.solution(sc.next()));
	}
	static class Solution {
		  public int solution(String dartResult) {
			  int res = 0;
			  int N = dartResult.length();
			  
			  char[] str = dartResult.toCharArray();
			  int[] list = new int[N];
			  int index= 0;
			  for (int i = 0; i < str.length; i++) {
				  if(str[i]-'0'>=0 && str[i]-'0' <=9) {
					  if(str[i]-'0'==1 && str[i+1]-'0' == 0) {
						  list[index++]=10;
						  i++;
					  }else {
						  list[index++] =str[i]-'0';
					  }
				  }else if(str[i] == 'S') {
					continue;  
				  }else if(str[i] == 'D') {
					  list[index-1] = (int) Math.pow(list[index-1], 2);
				  }else if(str[i] == 'T') {
					  list[index-1] = (int) Math.pow(list[index-1], 3);
				  }else if(str[i] == '*') {
					  if(index==1) {
						  list[index-1]*=2;
					  }else {
						  list[index-1]*=2;
						  list[index-2]*=2;
					  }
				  }else if(str[i] == '#') {
					  list[index-1]*=-1;
				  }
			}
			  for (int i = 0; i < N; i++) {
				res+=list[i];
			}
			  return res;
		  }
		}
}
