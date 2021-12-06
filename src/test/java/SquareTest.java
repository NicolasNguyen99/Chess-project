import cz.mendelu.pef.pjj.xnguye17.Board;
import cz.mendelu.pef.pjj.xnguye17.Color;
import cz.mendelu.pef.pjj.xnguye17.pieces.King;
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
        var piece = new King(Color.WHITE, 10);
        //when
        square.setPiece(piece);
        //then
        assertNotNull(square.getPiece());
    }
}