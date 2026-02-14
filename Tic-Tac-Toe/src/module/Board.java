package module;

public class Board {
    public static char[][] board;
    private final int ROWS=3;
    private final int COLS=3;

    public Board(char[][] board){
         this.board = board;
    }

    public static char[][] getBoard(){
        return board;
    }
}
