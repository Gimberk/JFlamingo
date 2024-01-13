package engine.board;

public class BoardUtil {
    public static boolean firstFile(final Tile tile){
        return tile.index % 8 == 0;
    }

    public static boolean eighthFile(final Tile tile){
        return (tile.index + 1) % 8 == 0;
    }

    public static boolean secondFile(final Tile tile){
        return (tile.index - 1) % 8 == 0;
    }

    public static boolean seventhFile(final Tile tile){
        return (tile.index + 2) % 8 == 0;
    }
}
