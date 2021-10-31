import cz.mendelu.pef.pjj.xnguye17.Board;
import cz.mendelu.pef.pjj.xnguye17.Color;
import cz.mendelu.pef.pjj.xnguye17.Square;
import cz.mendelu.pef.pjj.xnguye17.pieces.Pawn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

    /**
     * @author xnguye17
     * @version etapa 2
     */
    @Test
    void availableMovement() {
        //setup
        Board.createBoard();
        Pawn piece = new Pawn(Color.BLACK);
        Square square = Board.getSquare(5, 'h');
        square.setPiece(piece);
        var square6H = new Square(6, 'h');
        Square[] squaresExpected = new Square[]{square6H};
        //when
        var squares = piece.availableMovement();
        //then
        assertArrayEquals(squaresExpected, squares.toArray());
    }
}