package cz.mendelu.pef.pjj.xnguye17.pieces;
import cz.mendelu.pef.pjj.xnguye17.*;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {

    public King(Color pieceColor) {
        super(pieceColor, PieceType.KING);
    }
    /**
     * @author xnguye17
     * @version etapa 3
     */
    @Override
    public List<Square> availableMovement() {
        Coor coor = new Coor(this.getSquare().getRow(), Board.calculateCoor(this.getSquare().getCol()));
        int tBorder = (coor.row < 8) ? coor.row+1 : coor.row;
        int bBorder = (coor.row > 1) ? coor.row-1 : coor.row;

        int rBorder = (coor.col < 8) ? coor.col+1 : coor.col;
        int lBorder = (coor.col > 1) ? coor.col-1 : coor.col;

        List<Square> availableSquares = new ArrayList<>();
        for (int col = lBorder; col <= rBorder; col++) {
            for (int row = bBorder; row <= tBorder; row++) {
                //kontrola hranice
                if (coor.row != row || coor.col != col)
                    //kontrola policka s enemy figurkou nebo prazdyn polickem
                    if (Board.getSquare(row, col).getPiece() == null || Board.getSquare(row, col).getPiece().getPieceColor() != this.getPieceColor())
                    availableSquares.add(Board.getSquare(row, col));
            }
        }
        return availableSquares;
    }

}
