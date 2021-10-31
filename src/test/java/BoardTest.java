import cz.mendelu.pef.pjj.xnguye17.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @BeforeEach
    void setUp() {
        Board.createBoard();
    }

    /**
     * @author xnguye17
     * @version etapa 2
     */
    @Test
    void createBoard() {
        //setup
        //when
        var squareA1 = Board.getSquare(1, 'a');
        var squareH8 = Board.getSquare(8, 'h');
        //then
        assertNotNull(squareA1);
        assertNotNull(squareH8);
    }

    /**
     * @author xnguye17
     * @version etapa 2
     */
    @Test
    void getSquare() {
        //setup
        //when
        var square = Board.getSquare(8, 'a');
        //then
        assertNotNull(square);
        assertEquals(8, square.getRow());
        assertEquals('a', square.getCol());
    }

    /**
     * @author xnguye17
     * @version etapa 2
     */
    @Test
    void getSquare_outOfChessBoard() {
        //setup
        //when + then
        assertThrows(
                IndexOutOfBoundsException.class, () -> Board.getSquare(9, 'a'));
    }
}