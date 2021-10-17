import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceTest {

    /**
     * @author xnguye17
     * @version etapa 2
     */
    @Test
    void availableMovement_king() {
        //setup
        var piece = new Piece(Color.WHITE, PieceType.KING);
        var square = Board.getSquare('d', 1);
        square.setPiece(piece);
        var squareC1 = new Square('c', 1);
        var squareC2 = new Square('c', 2);
        var squareD2 = new Square('d', 2);
        var squareE1 = new Square('e', 1);
        var squareE2 = new Square('e', 2);
        Square squaresExpected[] = new Square[]{squareC1, squareC2, squareD2, squareE1, squareE2};
        //when
        var squares = piece.availableMovement();
        //then
        assertArrayEquals(squaresExpected, squares);
    }

    /**
     * @author xnguye17
     * @version etapa 2
     */
    @Test
    void availableMovement_knight() {
        //setup
        var piece = new Piece(Color.WHITE, PieceType.KNIGHT);
        var square = Board.getSquare('a', 6);
        square.setPiece(piece);
        var squareB8 = new Square('b', 8);
        var squareC7 = new Square('c', 7);
        var squareC5 = new Square('c', 5);
        var squareB4 = new Square('b', 4);
        Square squaresExpected[] = new Square[]{squareB8, squareC7, squareC5, squareB4};
        //when
        var squares = piece.availableMovement();
        //then
        assertArrayEquals(squaresExpected, squares);
    }

    /**
     * @author xnguye17
     * @version etapa 2
     */
    @Test
    void availableMovement_pawn() {
        //setup
        var piece = new Piece(Color.BLACK, PieceType.PAWN);
        var piece2 = new Piece(Color.WHITE, PieceType.PAWN);
        var square = Board.getSquare('h', 5);
        var square2 = Board.getSquare('g', 6);
        square.setPiece(piece);
        square2.setPiece(piece2);
        var squareH6 = new Square('h', 6);
        var squareG6 = new Square('g', 6);
        Square squaresExpected[] = new Square[]{squareH6, squareG6};
        //when
        var squares = piece.availableMovement();
        //then
        assertArrayEquals(squaresExpected, squares);
    }

    @Test
    void moveTo() {
    }
}