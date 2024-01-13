package gui.board;

import engine.board.Tile;
import gui.GameFrame;

import javax.swing.*;

public class TilePanel extends JPanel {
    public final Tile tile;

    public TilePanel(final Tile tile, final boolean color, final GameFrame frame){
        this.tile = tile;

        setSize(frame.tilePanelDimensions);
        setBackground(color ? frame.lightTileColor : frame.darkTileColor);
    }
}
