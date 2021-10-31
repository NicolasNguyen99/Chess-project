import cz.mendelu.pef.pjj.xnguye17.Board;
import cz.mendelu.pef.pjj.xnguye17.Color;
import cz.mendelu.pef.pjj.xnguye17.Square;
import cz.mendelu.pef.pjj.xnguye17.pieces.King;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KingTest {

    /**
     * @author xnguye17
     * @version etapa 2
     */
    @Test
    void availableMovement() {
        //setup
        Board.createBoard();
        var piece = new King(Color.WHITE);
        var square = Board.getSquare(1, 'd');
        square.setPiece(piece);
        var square1C = new Square(1, 'c');
        var square2C = new Square(2, 'c');
        var square2D = new Square(2, 'd');
        var square1E = new Square(1, 'e');
        var square2E = new Square(2, 'e');
        Square[] squaresExpected = new Square[]{square1C, square2C, square2D, square1E, square2E};
        //when
        var squares = piece.availableMovement();
        //then
        assertArrayEquals(squaresExpected, squares.toArray());
    }
}