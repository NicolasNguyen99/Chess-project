import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    /**
     * @author xnguye17
     */
    @Test
    void setPiece() {
        //setup
        var square = Board.getSquare('a', 1);
        var piece = new Piece(Color.WHITE, PieceType.KING);
        //when
        square.setPiece(piece);
        //then
        assertNotNull(square.getPiece());
    }
}