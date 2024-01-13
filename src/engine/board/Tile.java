package engine.board;

import engine.piece.Piece;

public class Tile {
    public final int index;
    public Piece piece;
    public boolean occupied;

    public Tile(final int index, final Piece piece){
        this.index = index; this.piece = piece; occupied = piece != null;
    }

    public void update(final Piece piece) {
        occupied = true;
        this.piece = piece;
    }

    @Override
    public String toString() {
        return occupied ? piece.toString() : "-";
    }
}