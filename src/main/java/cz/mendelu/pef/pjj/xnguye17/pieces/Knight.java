package cz.mendelu.pef.pjj.xnguye17.pieces;
import cz.mendelu.pef.pjj.xnguye17.*;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {

    public Knight(Color pieceColor) {
        super(pieceColor, PieceType.KNIGHT);
    }
    /**
     * @author xnguye17
     * @version etapa 3
     */
    @Override
    public List<Square> availableMovement() {
        Coor coor = new Coor(this.getSquare().getRow(), Board.calculateCoor(this.getSquare().getCol()));
        List<Coor> availableCoor = new ArrayList<>();

        //smer nahoru
        if (coor.row+2 <= 8) {
            //smer nahoru-doleva
            if (coor.col-1 >= 1)
                availableCoor.add(new Coor(coor.row+2, coor.col-1));
            //smer nahoru-doprava
            if (coor.col+1 <= 8)
                availableCoor.add(new Coor(coor.row+2, coor.col+1));
        }

        //smer doprava
        if (coor.col+2 <= 8) {
            //smer doprava-nahoru
            if (coor.row+1 <= 8)
                availableCoor.add(new Coor(coor.row+1, coor.col+2));
            //smer doprava-dolu
            if (coor.row-1 >= 1)
                availableCoor.add(new Coor(coor.row-1, coor.col+2));
        }

        //smer dolu
        if (coor.row-2 >= 1) {
            //smer dolu-doprava
            if (coor.col+1 <= 8)
                availableCoor.add(new Coor(coor.row-2, coor.col+1));
            //smer dolu-doleva
            if (coor.col-1 >= 1)
                availableCoor.add(new Coor(coor.row-2, coor.col-1));
        }

        //smer doleva
        if (coor.col-2 >= 1) {
            //smer doleva-dolu
            if (coor.row-1 >= 1)
                availableCoor.add(new Coor(coor.row-1, coor.col-2));
            //smer doleva-nahoru
            if (coor.row+1 <= 8)
                availableCoor.add(new Coor(coor.row+1, coor.col-2));
        }

        List<Square> availableSquares = new ArrayList<>();
        for (Coor var : availableCoor)
            availableSquares.add(Board.getSquare(var.row, var.col));

        return availableSquares;
    }
}
