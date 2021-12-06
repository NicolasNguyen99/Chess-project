package cz.mendelu.pef.pjj.xnguye17.greenfoot;

import cz.mendelu.pef.pjj.xnguye17.Board;
import cz.mendelu.pef.pjj.xnguye17.pieces.Pawn;
import cz.mendelu.pef.pjj.xnguye17.pieces.Piece;
import cz.mendelu.pef.pjj.xnguye17.pieces.PieceType;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

import java.util.Map;

/**
 * (greenfoot) trida zobrazujici figurku.
 * Vytvari highlight pri stisknuti a umoznuje presun figurky na zvolene policko.
 *
 * @author xnguye17
 * @version etapa 4
 */
public class PieceActor extends Actor {
    private Piece piece;
    private int row;
    private int col;

    public static int inverseInt(int num) {
        return 9 - num;
    }

    public PieceActor(int row, int col) {
        this.row = row;
        this.col = col;
        piece = Board.getSquare(this.row, Board.calculateCoor(this.col)).getPiece();
        var image = new GreenfootImage(String.format("images/pieces/%s/%s.png", piece.getPieceColor(), piece.getPieceType()));
        setImage(image);
    }

    @Override
    public void act() {
        if (Greenfoot.mouseClicked(this) && piece.getPieceColor() == Board.getPlayerRound()) {
            //zmena stavu IsChosed u vsech ostatnich figurek na false
            Map<Integer, Piece> pieces = Board.getPieces();
            for (int i = 1; i <= 36; i++ ) {
                if (pieces.get(i) != null)
                    if (pieces.get(i) != piece && Board.getPieces().get(i).getIsChosed())
                        pieces.get(i).switchIsChosed();
            }

            //vytvoreni highlightu na dostupnych polickach pro zvolenou figurku
            if (!piece.getIsChosed()) {
                var availableMovement = piece.availableMovement();
                for (var square : availableMovement) {
                    getWorld().addObject(new HighlightActor(piece, Board.getSquare(square.getRow(), Board.calculateCoor(square.getCol()))), Board.calculateCoor(square.getCol()) - 1, inverseInt(square.getRow()) - 1);
                }
            }
            piece.switchIsChosed();
        }

        //presun figurky
        if (piece.getChangedPosition() != null) {
            this.setLocation(Board.calculateCoor(piece.getChangedPosition().getCol())-1, inverseInt(piece.getChangedPosition().getRow()+1));
            this.row = piece.getChangedPosition().getRow();
            this.col = Board.calculateCoor(piece.getChangedPosition().getCol());
            if (piece.getPieceType() == PieceType.PAWN && ((Pawn)piece).getIsFirstMove()) {
                ((Pawn)piece).switchIsFirstMove();
            }
            piece.setChangedPosition(null);
        }

        //kontrola vymazani figurky
        if (!Board.getPieces().containsValue(piece)) {
            System.out.println(Board.getSquare(row, col).getPiece());
            getWorld().removeObject(this);
        }
    }
}
