package piece;

import java.util.List;

public class Move {
    public final int start, end;
    public final Piece piece, taken;

    public Move(final int start, final int end, final Piece piece, final Piece taken){
        this.start = start; this.end = end; this.piece = piece; this.taken = taken;
    }

    public static boolean contains(List<Move> moves, int end){
        for (Move move : moves) if (move.end == end) return true;
        return false;
    }
}
