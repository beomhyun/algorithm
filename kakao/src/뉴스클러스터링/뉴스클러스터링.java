package 뉴스클러스터링;

import java.util.ArrayList;

public class 뉴스클러스터링 {
	public static void main(String[] args) {
		solution("FRANCE","french");
	}
	public static int solution(String str1, String str2) {
		int answer = 0;
		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();
		
		ArrayList<word> list1 = new ArrayList<>();
		ArrayList<word> list2 = new ArrayList<>();
		ArrayList<word> list3 = new ArrayList<>();
		ArrayList<word> list4 = new ArrayList<>();
		for (int i = 0; i < str1.length()-1; i++) {
			String tmp = str1.substring(i, i+2);
			if(tmp.charAt(0)>='A' && tmp.charAt(0)<='Z' && tmp.charAt(1)>='A' && tmp.charAt(1)<='Z') {
				boolean check = false;
				for (int j = 0; j < list1.size(); j++) {
					if(list1.get(j).str.equals(tmp)) {
						check = true;
						list1.get(j).count++;
						break;
					}
				}
				if(!check) list1.add(new word(tmp, 1));
			}
		}
		for (int i = 0; i < str2.length()-1; i++) {
			String tmp = str2.substring(i, i+2);
			if(tmp.charAt(0)>='A' && tmp.charAt(0)<='Z' && tmp.charAt(1)>='A' && tmp.charAt(1)<='Z') {
				boolean check = false;
				for (int j = 0; j < list2.size(); j++) {
					if(list2.get(j).str.equals(tmp)) {
						check = true;
						list2.get(j).count++;
						break;
					}
				}
				if(!check) list2.add(new word(tmp, 1));
			}
		}
		for (int i = 0; i < list1.size(); i++) {
			word tmp1 = list1.get(i);
			boolean check = false;
			for (int j = 0; j < list2.size(); j++) {
				word tmp2 = list2.get(j);
				if(tmp1.str.equals(tmp2.str)) {
					if(tmp1.count >= tmp2.count) {
						list3.add(tmp1);
						list4.add(tmp2);
					}else {
						list3.add(tmp2);
						list4.add(tmp1);
					}
					check = true;
					break;
				}
			}
			if(!check) {
				list3.add(tmp1);
			}
		}
		for (int i = 0; i < list2.size(); i++) {
			word tmp = list2.get(i);
			boolean check = false;
			for (int j = 0; j < list3.size(); j++) {
				if(tmp.str.equals(list3.get(j).str)) {
					check = true;
					break;
				}
			}
			if(!check) list3.add(tmp);
		}
		float a = 0;
		float b = 0;
		for (int i = 0; i < list3.size(); i++) {
			a+= list3.get(i).count;
		}
		for (int i = 0; i < list4.size(); i++) {
			b+= list4.get(i).count;
		}
		if(a==0) answer = 1;
		else answer = (int) (b/a *65536);
		return answer;
	}
	static class word{
		String str;
		int count;
		public word(String str, int count) {
			super();
			this.str = str;
			this.count = count;
		}
		@Override
		public String toString() {
			return "word [str=" + str + ", count=" + count + "]";
		}
	}
}
