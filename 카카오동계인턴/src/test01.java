import java.util.Stack;

public class test01 {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < moves.length; i++) {
			int pick = moves[i]-1;
			for (int j = 0; j < board.length; j++) {
				int tmp = board[j][pick];
				if(tmp ==0) continue;
				else {
					board[j][pick]=0;
					if(stack.isEmpty()) {
						stack.push(tmp);
					}else if(stack.peek() == tmp) {
						answer+=2;
						stack.pop();
					}else {
						stack.push(tmp);
					}
					break;
				}
			}

		}
        return answer;
    }
    public static void main(String[] args) {
    	int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
    	int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
    	System.out.println(solution(board, moves));

	}
}
