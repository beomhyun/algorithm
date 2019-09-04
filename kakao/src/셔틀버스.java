

import java.util.ArrayList;
import java.util.Arrays;

public class ¼ÅÆ²¹ö½º {
	public static void main(String[] args) {
		
		  System.out.println(getLastTime(5, 20, 3, new String[]{"09:10","09:10","10:20","10:19","10:19", "10:19"}));
//        System.out.println(getLastTime(1, 1, 5, new String[]{"08:00", "08:01", "08:02", "08:03"}));
//        System.out.println(getLastTime(2, 10, 2, new String[]{"09:10", "09:09", "08:00"}));
//        System.out.println(getLastTime(2, 1, 2, new String[]{"09:00", "09:00", "09:00", "09:00"}));
//        System.out.println(getLastTime(1, 1, 5, new String[]{"00:01", "00:01", "00:01", "00:01", "00:01"}));
//        System.out.println(getLastTime(1, 1, 1, new String[]{"18:00"}));
//        System.out.println(getLastTime(10, 60, 5, new String[]{"18:00","18:00", "18:00", "18:00", "18:00", "18:00"
//                , "18:00", "18:00", "18:00", "18:00", "18:00", "18:00", "18:00", "18:00", "18:00", "18:00"}));

	}
	static String getLastTime(int n , int t, int m, String[] timetable) {
		  String answer = "";
			int H = 9;
			int M = 0;
			Arrays.sort(timetable);
			ArrayList<time> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				list.add(new time(H, M));
				M+=t;
				H+=M/60;
				M %= 60;
			}
			int[] people = new int[list.size()];
			ArrayList<time> lastbus = new ArrayList<>();
			
			for (int i = 0; i <timetable.length; i++) {
				String[] strtmp = timetable[i].split(":");
				
				int hh = Integer.parseInt(strtmp[0]);
				int mm = Integer.parseInt(strtmp[1]);
				if((hh==24 && mm==0) ) continue;
//				System.out.println(hh+":"+mm);
				for (int j = 0; j < list.size(); j++) {
					H  = list.get(j).hour;
					M = list.get(j).mimute;
//					System.out.println("##"+H+":"+M);
					if((hh==H && mm <= M)||(hh<H)) {
//						System.out.println("hi");
						if(people[j] < m) {
							people[j]++;
							if(j==list.size()-1) {
								lastbus.add(new time(hh, mm));
							}
							break;
						}
					}
				}
			}
			System.out.println(lastbus);
			int len = people.length-1;
			
			if(people[people.length-1] < m) {
				H = list.get(len).hour;
				M = list.get(len).mimute;
				if(H <10) {
					answer+="0";
				}
				answer += H+":";
				if(M<10) {
					answer += "0";
				}
				answer += M;
			}else {
//				System.out.println("#######################");
				int maxh = 0;
				int maxm = 0;
				for(time t1:lastbus) {
					if((maxh == t1.hour && maxm < t1.mimute)||(maxh < t1.hour)) {
						maxh = t1.hour;
						maxm = t1.mimute;
					}
				}
				maxm -= 1;
				if(maxm == -1) {
					maxh -= 1;
					maxm = 59;
				}
				
				if(maxh <10) {
					answer+="0";
				}
				answer += maxh+":";
				if(maxm<10) {
					answer += "0";
				}
				answer += maxm;
			}
			return answer;
	}
	
	static class time{
		int hour;
		int mimute;
		public time(int hour, int mimute) {
			super();
			this.hour = hour;
			this.mimute = mimute;
		}
		@Override
		public String toString() {
			return "time [hour=" + hour + ", mimute=" + mimute + "]";
		}
		
	}
}
