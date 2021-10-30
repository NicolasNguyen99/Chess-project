import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceTest {

    /**
     * @author xnguye17
     * @version etapa 2
     */
    @Test
    void availableMovement_knight() {
        //setup
        var piece = new Knight(Color.WHITE);
        var square = Board.getSquare(6, 'a');
        square.setPiece(piece);
        var square8B = new Square(8, 'b');
        var square7C = new Square(7, 'c');
        var square5C = new Square(5, 'c');
        var square4B = new Square(4, 'b');
        Square squaresExpected[] = new Square[]{square8B, square7C, square5C, square4B};
        //when
        var squares = piece.availableMovement();
        //then
        assertArrayEquals(squaresExpected, squares.toArray());
    }

    @Test
    void moveTo() {
    }
}