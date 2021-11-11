package cz.mendelu.pef.pjj.xnguye17.greenfoot;

import cz.mendelu.pef.pjj.xnguye17.Board;
import cz.mendelu.pef.pjj.xnguye17.Square;
import cz.mendelu.pef.pjj.xnguye17.pieces.Piece;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

import java.awt.*;

public class HighlightActor extends Actor {
    private final Square square;
    private Piece piece;

    public HighlightActor(Piece oldPiece, Square futureSquare) {
        this.square = futureSquare;
        this.piece = oldPiece;
        var image = new GreenfootImage("images/squares/highlight.png");
        setImage(image);
    }

    @Override
    public void act() {
        if (!piece.getIsChosed()) {
            getWorld().removeObject(this);
        }

        if(Greenfoot.mouseClicked(this)) {
            if (Board.movePiece(piece, square.getRow(), square.getCol()))
                piece.switchIsChosed();
        }
    }
}
