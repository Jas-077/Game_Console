public class GameLogic {

    public int winner;
    private int[][] board;
    int row;
    int col;

    public GameLogic(int[][] board, int row, int col) {
        this.board = board;
        this.row = row;
        this.col = col;
        winner = -1;
    }

    public int findGameWinner() {

        winner = checkRow();

        if (winner == -1) {
            winner = checkColumn();
            if (winner == -1) {
                winner = checkDiagonal();
            }
        }

        return winner;

    }

    private int checkRow() {

        int current_chip = board[row][col];

        int count = 0;
        for (int i = 0; i < 7; i++) {

            if (board[row][i] == current_chip)
                count++;
            else
                count = 0;
            if (count == 4)
                return current_chip;
        }
        return -1;
    }

    private int checkColumn() {
        int current_chip = board[row][col];

        int count = 0;
        for (int i = 0; i < 6; i++) {

            if (board[i][col] == current_chip)
                count++;
            else
                count = 0;
            if (count == 4)
                return current_chip;
        }
        return -1;
    }

    private int checkDiagonal() {
        int sr = -1, sc = -1;
        int dr = 0, dc = 0;

        int current_chip = board[row][col];
        int count = 0;

        if (row + 1 >= 6 || col - 1 < 0 || board[row][col] == board[row + 1][col - 1]
                || (row - 1 > -1 && col + 1 < 7 && board[row][col] == board[row - 1][col + 1])) {
            sr = 5;
            sc = col - (5 - row);
            if (sc < 0) {
                sr += sc;
                sc = 0;
            }

            dr = -1;
            dc = 1;

            // System.out.println("Right diagonal");
            // System.out.println("sr: " + sr + " sc: " + sc);
            // System.out.println("dr: " + dr + " dc: " + dc);

            count = 0;

            while (sr > -1 && sc < 7) {

                if (current_chip == board[sr][sc])
                    count++;
                else
                    count = 0;

                if (count == 4)
                    return current_chip;

                sc += dc;
                sr += dr;
            }

        }

        if (row + 1 >= 6 || col + 1 >= 7 || board[row][col] == board[row + 1][col + 1]
                || (row - 1 > -1 && col - 1 > -1 && board[row][col] == board[row - 1][col - 1])) {
            sr = 5;
            sc = col + (5 - row);
            if (sc >= 7) {
                sr -= (sc - 6);
                sc = 6;

            }
            dr = -1;
            dc = -1;

            // System.out.println("Left Diagonal");
            // System.out.println("sr: " + sr + " sc: " + sc);
            // System.out.println("dr: " + dr + " dc: " + dc);

            count = 0;

            while (sr > -1 && sc > -1) {

                if (current_chip == board[sr][sc])
                    count++;
                else
                    count = 0;

                if (count == 4)
                    return current_chip;

                sc += dc;
                sr += dr;
            }

        }

        return -1;
    }

}
