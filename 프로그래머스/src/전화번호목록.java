import java.util.ArrayList;
import java.util.Comparator;

public class 전화번호목록 {
	public static void main(String[] args) {
		String[] phone_book = {"119", "97674223", "1195524421"};
		System.out.println(solution(phone_book));
	}
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < phone_book.length; i++) {
			list.add(phone_book[i]);
		}
        list.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) {
					return 0;
				}else if(o1.length() > o2.length()) {
					return 1;
				}else {
					return -1;
				}
			}
		});
        for (int i = 0; i < list.size()-1; i++) {
			for (int j = i+1; j < list.size(); j++) {
				if(list.get(j).substring(0,list.get(i).length()).equals(list.get(i))){
					answer = false;
					break;
				}
			}
			if(!answer) break;
		}
        
        return answer;
    }
}
