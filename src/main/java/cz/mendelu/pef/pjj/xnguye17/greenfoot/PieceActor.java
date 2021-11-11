package cz.mendelu.pef.pjj.xnguye17.greenfoot;

import cz.mendelu.pef.pjj.xnguye17.Board;
import cz.mendelu.pef.pjj.xnguye17.Square;
import cz.mendelu.pef.pjj.xnguye17.pieces.Pawn;
import cz.mendelu.pef.pjj.xnguye17.pieces.Piece;
import cz.mendelu.pef.pjj.xnguye17.pieces.PieceType;
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
        this.row = inverseInt(row)-1;
        this.col = col+1;
        this.piece = Board.getSquare(this.row, Board.calculateCoor(this.col)).getPiece();
        var image = new GreenfootImage(String.format("images/pieces/%s/%s.png", piece.getPieceColor(), piece.getPieceType()));
        setImage(image);
    }

    @Override
    public void act() {

        if (Greenfoot.mouseClicked(this)) {
            for (int i = 1; i <= 16; i++) {
                if (Board.getPieces().get(i) != piece && Board.getPieces().get(i).getIsChosed())
                    Board.getPieces().get(i).switchIsChosed();
            }
            for (int i = 21; i <= 36; i++) {
                if (Board.getPieces().get(i) != piece && Board.getPieces().get(i).getIsChosed())
                    Board.getPieces().get(i).switchIsChosed();
            }

            //zobrazeni moznych tahu
//            piece.switchIsChosed();
//            var avaiableMovement = piece.availableMovement();
//            for(var square : avaiableMovement) {
//                getWorld().addObject(new HighlightActor(piece, Board.getSquare(square.getRow(), Board.calculateCoor(square.getCol()))), Board.calculateCoor(square.getCol())-1, inverseInt(square.getRow())-1);
//            }
            System.out.println("Kliknuti");
            System.out.println(piece.getIsChosed());
            if (piece.getIsChosed()) {
                piece.switchIsChosed();
                System.out.println("Je aktivni, a je znovu kliknute");
            } else {
                var avaiableMovement = piece.availableMovement();
                for (var square : avaiableMovement) {
                    getWorld().addObject(new HighlightActor(piece, Board.getSquare(square.getRow(), Board.calculateCoor(square.getCol()))), Board.calculateCoor(square.getCol()) - 1, inverseInt(square.getRow()) - 1);
                }
                piece.switchIsChosed();
            }
        }

        //presun piece
        if (piece.getChangedPosition() != null) {
            this.setLocation(Board.calculateCoor(piece.getChangedPosition().getCol())-1, inverseInt(piece.getChangedPosition().getRow()+1));
            this.row = piece.getChangedPosition().getRow();
            this.col = Board.calculateCoor(piece.getChangedPosition().getCol());
            if (piece.getPieceType() == PieceType.PAWN && ((Pawn)piece).getIsFirstMove()) {
                ((Pawn)piece).switchIsFirstMove();
            }
            piece.setChangedPosition(null);
        }
    }
}
