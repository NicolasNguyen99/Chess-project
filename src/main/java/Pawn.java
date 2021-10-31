import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

    public Pawn(Color pieceColor) {
        super(pieceColor, PieceType.PAWN);
    }

    public record Coor(
            Integer row,
            Integer col
    ) {}

    @Override
    protected List<Square> availableMovement() {
        Coor coor = new Coor(this.getSquare().getRow(), Board.calculateCoor(this.getSquare().getCol()));
        int tBorder = (coor.row < 8) ? coor.row+1 : coor.row;

        int rBorder = (coor.col < 8) ? coor.col +1 : coor.col ;
        int lBorder = (coor.col  > 1) ? coor.col -1 : coor.col ;

        List<Square> availableSquares = new ArrayList<>();
        if (Board.getSquare(tBorder, lBorder).getPiece() != null)
            availableSquares.add(Board.getSquare(tBorder, lBorder));
        availableSquares.add(Board.getSquare(tBorder, coor.col ));
        if (Board.getSquare(tBorder, rBorder).getPiece() != null)
            availableSquares.add(Board.getSquare(tBorder, rBorder));

        return availableSquares;
    }
}
