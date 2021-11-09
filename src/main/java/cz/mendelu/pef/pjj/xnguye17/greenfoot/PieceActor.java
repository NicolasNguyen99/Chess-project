package cz.mendelu.pef.pjj.xnguye17.greenfoot;

import cz.mendelu.pef.pjj.xnguye17.Board;
import cz.mendelu.pef.pjj.xnguye17.Square;
import cz.mendelu.pef.pjj.xnguye17.pieces.Piece;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

import java.util.ArrayList;
import java.util.List;

public class PieceActor extends Actor {
    private final Piece piece;
    private int row;
    private int col;
    private List<Square> availableSquares = new ArrayList<>();

    public static int inverseInt(int num) {
        return 9 - num;
    }

    public PieceActor(int row, int col) {
        this.row = inverseInt(row);
        this.col = col;
        this.piece = Board.getSquare(this.row-1, Board.calculateCoor(this.col+1)).getPiece();
        var image = new GreenfootImage(String.format("images/pieces/%s/%s.png", piece.getPieceColor(), piece.getPieceType()));
        setImage(image);
    }

    @Override
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            System.out.println(piece);
            availableSquares = piece.availableMovement();
            System.out.println(availableSquares);
        }

        if (row != piece.getSquare().getRow() || col != piece.getSquare().getCol()) {
            this.row = piece.getSquare().getRow();
            this.col = piece.getSquare().getCol();
            //presunuti obrazku
        }
    }
}
