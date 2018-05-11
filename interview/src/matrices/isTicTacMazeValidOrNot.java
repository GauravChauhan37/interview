package matrices;

public class isTicTacMazeValidOrNot {
	private static boolean isWinner(char[] board, char ch) {
		// take the board matrix , mark it 0 to 8 to understand the moves
		int win[][] = { { 0, 1, 2 }, // Check first row.
				{ 3, 4, 5 }, // Check second Row
				{ 6, 7, 8 }, // Check third Row
				{ 0, 3, 6 }, // Check first column
				{ 1, 4, 7 }, // Check second Column
				{ 2, 5, 8 }, // Check third Column
				{ 0, 4, 8 }, // Check first Diagonal
				{ 2, 4, 6 } }; // Check second Diagonal
		for (int i = 0; i < 8; i++) { // 8 cz win moves have 8 rows
			if (board[win[i][0]] == ch && board[win[i][1]] == ch && board[win[i][2]] == ch)
				// this if is picking values row wise from win and checking
				// board for character
				return true;
		}
		return false;
	}

	private static boolean IsBoardValid(char[] board) {
		int countX = 0;
		int countO = 0;
		for (int i = 0; i < board.length; i++) {
			if (board[i] == 'X')
				countX++;
			else
				countO++;
		}
		if (Math.abs(countX - countO) > 1) {
			return false;
		} else if (isWinner(board, 'O')) {
			if (isWinner(board, 'X')) {
				return false;
			}
		} else if (isWinner(board, 'X') && countX != countO + 1) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		char board[] = { 'X', 'X', 'O', 'O', 'O', 'X', 'X', 'O', 'X' };
		// char board[] = { 'X', 'X', 'X', 'O', 'O', 'O', 'X', 'O', 'X' };
		System.out.println(IsBoardValid(board));
	}

}
