import java.util.Arrays;
import java.util.Comparator;

public class ����ū�� {
	public static void main(String[] args) {
		int[] numbers = {30,3};
		solution(numbers);
	}
    public static String solution(int[] numbers) {
    	String answer = "";
    	String[] arr = new String[numbers.length];
    	for (int i = 0; i < arr.length; i++) {
			arr[i] = ""+numbers[i];
		}
    	Arrays.sort(arr,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return (o2+o1).compareTo(o1+o2);
			}
		});
    	if(arr[0].equals("0")) return "0";
    	for (int i = 0; i < arr.length; i++) {
			answer += arr[i];
		}
        return answer;
    }
}
