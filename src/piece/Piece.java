package piece;

import board.Board;
import board.Tile;

import java.util.List;

public abstract class Piece {
    public final Type type;
    public final Alliance alliance;
    public final int index;

    public List<Integer> directions;
    public Tile tile;

    public Piece(final Tile tile, final Type type, final Alliance alliance, final int index){
        this.tile = tile; this.type = type; this.alliance = alliance; this.index = index;
    }

    public abstract List<Move> legalMoves(Board board);

    boolean validateTile(final Tile end){ // returns true if the tile is invalid
        return end.piece != null && alliance == end.piece.alliance;
    }
}
