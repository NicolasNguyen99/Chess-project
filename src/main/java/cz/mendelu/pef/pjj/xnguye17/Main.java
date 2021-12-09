package cz.mendelu.pef.pjj.xnguye17;
import cz.mendelu.pef.pjj.xnguye17.pieces.Knight;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Board.createBoard();
        Knight knight = new Knight(Color.WHITE, 10);
        Square square = Board.getSquare(6, 'a');
        square.setPiece(knight);
        System.out.println(knight);
        System.out.println(square);

        List<Square> squares = knight.availableMovement();
        System.out.println(squares.size());
        System.out.println(squares);
    }
}
