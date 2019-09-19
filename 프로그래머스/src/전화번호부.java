public class 전화번호부 {
	public static void main(String[] args) {
		
	}
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        for (int i = 0; i < phone_book.length; i++) {
			for (int j = 0; j < phone_book.length; j++) {
				if(i == j) continue;
				if(phone_book[i].length() >= phone_book[j].length()) {
					if(phone_book[i].substring(0,phone_book[j].length()).equals(phone_book[j])) {
						answer = false;
						break;
					}
				}else {
					if(phone_book[j].substring(0,phone_book[i].length()).equals(phone_book[i])) {
						answer = false;
						break;
					}

				}
			}
			if(!answer) break;
        }
        return answer;
    }
}
