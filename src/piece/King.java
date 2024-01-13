package piece;

import board.Board;
import board.Tile;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece{
    public King(final Tile tile, final int index, final Alliance alliance) {
        super(tile, Type.KING, alliance, index);
        directions = List.of(-9, -8, -7, -1, 1, 7, 8, 9);
    }

    @Override
    public List<Move> legalMoves(Board board) {
        List<Move> legals = new ArrayList<>();
        int start = tile.index;

        for (int direction : directions){
            int end = start + direction;
            if (end > 63 || end < 0) continue;

            Tile endTile = board.tiles.get(end);
            if (validateTile(endTile)) continue;

            legals.add(new Move(start, end, this, endTile.piece));
        }

        return legals;
    }

    @Override
    public String toString() {
        return alliance == Alliance.WHITE ? "K" : "k";
    }
}