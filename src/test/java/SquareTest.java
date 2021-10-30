import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    /**
     * @author xnguye17
     */
    @Test
    void setPiece() {
        //setup
        var square = Board.getSquare(1, 'a');
        var piece = new King(Color.WHITE);
        //when
        square.setPiece(piece);
        //then
        assertNotNull(square.getPiece());
    }
}