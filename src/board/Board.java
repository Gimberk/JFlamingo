package board;

import piece.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Board {
    public static final String standardFen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";

    public boolean whiteOnBottom;

    public final List<Tile> tiles = new ArrayList<>();
    public final List<Piece> pieces = new ArrayList<>();

    public Board(){
        generateTiles();
    }

    public static Board createBoard(String fen, boolean whiteOnBottom){
        Board board = new Board();
        board.loadFen(fen);
        board.whiteOnBottom = whiteOnBottom;

        return board;
    }

    public void displayBoard(){
        final StringBuilder board = new StringBuilder();
        int file = 0, index = 7;
        board.append("\n8 ");

        for (final Tile tile : tiles)
        {
            if (file > 7)
            {
                file = 0;
                board.append('\n');
                board.append(index).append(' ');
                index--;
            }
            board.append(tile.toString());;
            board.append(' ');
            file++;
        }

        board.append("\n  a b c d e f g h");

        System.out.println(board);
    }

    public void displayBoardWithMoves(List<Move> moves){
        final StringBuilder board = new StringBuilder();
        int file = 0, index = 7;
        board.append("\n8 ");

        for (final Tile tile : tiles)
        {
            if (file > 7)
            {
                file = 0;
                board.append('\n');
                board.append(index).append(' ');
                index--;
            }
            if (Move.contains(moves, tile.index)) board.append('@');
            else board.append(tile.toString());
            board.append(' ');
            file++;
        }

        board.append("\n  a b c d e f g h");

        System.out.println(board);
    }

    private void generateTiles() {
        for (int i = 0; i < 64; i++) tiles.add(new Tile(i, null));
    }

    private void loadFen(String fen){
        Map<Character, Type> pieces = Map.of(
                'k', Type.KING,
                'q', Type.QUEEN,
                'r', Type.ROOK,
                'n', Type.KNIGHT,
                'p', Type.PAWN,
                'b', Type.BISHOP);

        int file = 0, rank = whiteOnBottom ? 0 : 7;
        for (char symbol : fen.toCharArray())
        {
            if (symbol == '/')
            {
                file = 0;
                rank = whiteOnBottom ? rank + 1 : rank - 1;
            }
            else
            {
                if (Character.isDigit(symbol))
                    file += Character.getNumericValue(symbol);
                else
                {
                    final int index = rank * 8 + file;

                    final Alliance alliance = Character.isUpperCase(symbol) ? Alliance.WHITE : Alliance.BLACK;
                    final Type type = pieces.get(Character.toLowerCase(symbol));

                    System.out.println(type);
                    placePiece(type, alliance, tiles.get(index));
                    file++;
                }
            }
        }
    }

    private void placePiece(final Type type, final Alliance alliance, final Tile tile){
        Piece piece = null;
        switch (type){
            case KING -> piece = new King(tile, pieces.size(), alliance);
        }

        pieces.add(piece);
        tile.update(piece);
    }
}
