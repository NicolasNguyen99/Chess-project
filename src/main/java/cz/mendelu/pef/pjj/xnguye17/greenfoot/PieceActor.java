package cz.mendelu.pef.pjj.xnguye17.greenfoot;

import cz.mendelu.pef.pjj.xnguye17.Board;
import cz.mendelu.pef.pjj.xnguye17.pieces.Piece;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

public class PieceActor extends Actor {
    private final Piece piece;
    private int row;
    private int col;

    public PieceActor(int row, int col) {
        this.piece = Board.getSquare(row+1, Board.calculateCoor(col+1)).getPiece();
        this.row = row;
        this.col = col;
        var image = new GreenfootImage(String.format("images/%s/%s.png", piece.getPieceColor(), piece.getPieceType()));
        setImage(image);
    }

    @Override
    public void act() {
//        var image = new GreenfootImage(String.format("images/%s/%s.png", piece.getPieceColor(), piece.getPieceType()));
//        setImage(image);
    }
}
