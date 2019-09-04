package 추석트래픽;

import java.util.ArrayList;

public class 추석트래픽 {
	public static void main(String[] args) {
//		String tmp = "2016-09-15 01:00:04.001 2.0s";
//		for (int i = 0; i < tmp.length(); i++) {
//			System.out.println(i+" : "+ tmp.charAt(i));
//		}
//		System.out.println(tmp.length());
//		System.out.println(tmp.substring(11,13));
		
		Solution sol = new Solution();
		System.out.println(sol.solution(new String[] {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"}));
	}
	
	static class Solution {
		  public int solution(String[] lines) {
			  int answer = 0;
		      ArrayList<time> list = new ArrayList<>();
		      for (int i = 0; i < lines.length; i++) {
		    	  int h = Integer.parseInt(lines[i].substring(11, 13));
		    	  int m = Integer.parseInt(lines[i].substring(14, 16));
		    	  int s = Integer.parseInt(lines[i].substring(17, 19));
		    	  int ss = Integer.parseInt(lines[i].substring(20, 23));
		    	  
		    	  String tmp = lines[i].substring(24, lines[i].length()-1);
		    	  float te = Float.parseFloat(lines[i].substring(24, lines[i].length()-1));
		    	  int term = (int) (te*1000);
//		    	  System.out.println(lines[i]);
//		    	  System.out.println(ss+s*1000+m*60*1000+h*60*60*1000);
//		    	  System.out.println(term);
		    	  long T = ss+s*1000+m*60*1000+h*60*60*1000;
		    	  long start = T-term+1;
		    	  long end = T;
		    	  if(start <0) start = 0;
		    	  if(end > 24*60*60*1000) end = 24*60*60*1000;
		    	  list.add(new time(start, end));
		    	  System.out.println("              "+(T-term+1));
		    	  System.out.println(T);
		      }
		      for (int i = 0; i < list.size(); i++) {
		    	  //시작시간 기준 1초
		    	  long s = list.get(i).start;
		    	  int count =0;
		    	  for (int j = 0; j < list.size(); j++) {
		    		  if((s<= list.get(j).start && s+1000 > list.get(j).start)|| (s <= list.get(j).end && s+1000 >list.get(j).end)) {
//		    			  System.out.println(list.get(j));
		    			  count++;
		    		  }
		    	  }
		    	  if(count > answer) {
		    		  System.out.println("######"+s);
		    		  System.out.println(count);
		    		  answer = count;
		    	  }
		    	  
		    	  //끝나는시간 기준 +1초
		    	  long e = list.get(i).end;
		    	  count=0;
		    	  for (int j = 0; j < list.size(); j++) {
					if((e <= list.get(j).start && e+1000 > list.get(j).start)|| (e<=list.get(j).end && e+1000 > list.get(j).end)) {
//						System.out.println(list.get(j));
						count++;
					}
				}
		    	  if(count > answer) {
		    		  System.out.println("!!!!!!!!!!!!"+e);
		    		  System.out.println(count);
		    		  answer = count;
		    	  }
		      }
		      return answer;
		  }
		}
	static class time {
		long start;
		long end;
		public time(long start, long end) {
			super();
			this.start = start;
			this.end = end;
		}
		@Override
		public String toString() {
			return "time [start=" + start + ", end=" + end + "]";
		}
		
	}
}
