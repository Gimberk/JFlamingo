package gui;

import engine.board.Board;

import javax.swing.*;
import java.awt.*;

public class GameFrame {
    public JFrame frame;

    private final Dimension frameDimensions = new Dimension(600, 600);

    public GameFrame(final String fen, final boolean whiteOnTop){
        final Board board = Board.createBoard(fen, whiteOnTop);
        board.displayBoardWithMoves(board.pieces.getFirst().legalMoves(board));

        frame = createGameFrame();
        frame.setVisible(true);
    }

    private JFrame createGameFrame(){
        JFrame game = new JFrame("Flamingos are pretty cool I think");

        game.setSize(frameDimensions);
        return game;
    }
}