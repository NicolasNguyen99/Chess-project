package cz.mendelu.pef.pjj.xnguye17.pieces;
import cz.mendelu.pef.pjj.xnguye17.*;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

    public Pawn(Color pieceColor) {
        super(pieceColor, PieceType.PAWN);
    }
    /**
     * @author xnguye17
     * @version etapa 3
     */
    @Override
    public List<Square> availableMovement() {
        Coor coor = new Coor(this.getSquare().getRow(), Board.calculateCoor(this.getSquare().getCol()));
        int tBorder, rBorder, lBorder;

        //urceni smeru figurek
        if (this.getPieceColor() == Color.BLACK)
            tBorder = (coor.row < 8) ? coor.row+1 : coor.row;
        else
            tBorder = (coor.row > 1) ? coor.row-1 : coor.row;

        rBorder = (coor.col < 8) ? coor.col +1 : coor.col ;
        lBorder = (coor.col  > 1) ? coor.col -1 : coor.col ;

        List<Square> availableSquares = new ArrayList<>();
        //kontrola jestli je diagonalne vlevo o jedno enemy figurka
        if ((Board.getSquare(tBorder, lBorder).getPiece() != null) && (Board.getSquare(tBorder, lBorder).getPiece().getPieceColor() != this.getPieceColor()))
            availableSquares.add(Board.getSquare(tBorder, lBorder));
        //kontrola jestli je o policko vpred volne policko
        if (Board.getSquare(tBorder, coor.col).getPiece() == null)
            availableSquares.add(Board.getSquare(tBorder, coor.col ));
        //kontrola jestli je diagonalne vpravo o jedno enemy figurka
        if ((Board.getSquare(tBorder, rBorder).getPiece() != null) && (Board.getSquare(tBorder, rBorder).getPiece().getPieceColor() != this.getPieceColor()))
            availableSquares.add(Board.getSquare(tBorder, rBorder));

        return availableSquares;
    }
}
