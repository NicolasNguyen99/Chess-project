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
    protected List<Square> availableMovement() {
        int[] coor = {this.getSquare().getRow(), Board.calculateCoor(this.getSquare().getCol())};
        int tBorder = (coor[0] < 8) ? coor[0]+1 : coor[0];
        int bBorder = (coor[0] > 1) ? coor[0]-1 : coor[0];

        int rBorder = (coor[1] < 8) ? coor[1]+1 : coor[1];
        int lBorder = (coor[1] > 1) ? coor[1]-1 : coor[1];

        List<Square> availableSquares = new ArrayList<>();
        for (int col = lBorder; col <= rBorder; col++) {
            for (int row = bBorder; row <= tBorder; row++) {
                if (coor[0] != row || coor[1] != col) {
                    availableSquares.add(Board.getSquare(row, col));
                }
            }
        }
        return availableSquares;
    }

}
