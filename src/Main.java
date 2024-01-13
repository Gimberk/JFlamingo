import board.Board;

public class Main {
    public static void main(String[] args) {
        final Board board = Board.createBoard("K", true);
        board.displayBoardWithMoves(board.pieces.getFirst().legalMoves(board));
    }
}