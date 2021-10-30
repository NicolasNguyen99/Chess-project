import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

    public Pawn(Color pieceColor) {
        super(pieceColor, PieceType.PAWN);
    }

    @Override
    protected List<Square> availableMovement() {
        int[] coor = {this.getSquare().getRow(), Board.calculateCoor(this.getSquare().getCol())};
        int tBorder = (coor[0] < 8) ? coor[0]+1 : coor[0];

        int rBorder = (coor[1] < 8) ? coor[1]+1 : coor[1];
        int lBorder = (coor[1] > 1) ? coor[1]-1 : coor[1];

        List<Square> availableSquares = new ArrayList<>();
        if (Board.getSquare(tBorder, lBorder).getPiece() != null)
            availableSquares.add(Board.getSquare(tBorder, lBorder));
        availableSquares.add(Board.getSquare(tBorder, coor[1]));
        if (Board.getSquare(tBorder, rBorder).getPiece() != null)
            availableSquares.add(Board.getSquare(tBorder, rBorder));

        return availableSquares;
    }
}
