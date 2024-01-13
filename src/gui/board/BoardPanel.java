package gui.board;

import engine.board.Tile;
import gui.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BoardPanel extends JPanel {
    private final GameFrame frame;
    private final List<TilePanel> tiles = new ArrayList<>();

    public BoardPanel(final GameFrame frame){
        super(new GridLayout(8, 8));

        this.frame = frame;
        setSize(frame.boardPanelDimensions);
        setBackground(frame.lightTileColor);

        generateTiles();
    }

    private void generateTiles() {
        for (int i = 0; i < 64; i++){
            final TilePanel panel = new TilePanel(frame.board.tiles.get(i), false, frame);
            add(panel);
        }
    }
}
