import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    /**
     * @author xnguye17
     * @version etapa 2
     */
    @Test
    void createBoard() {
        //setup
        //when
        Board.createBoard();
        var squareA1 = Board.getSquare('a', 1);
        var squareH8 = Board.getSquare('h', 8);
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
        Board.createBoard();
        //when
        var square = Board.getSquare('a', 1);
        //then
        assertNotNull(square);
        assertEquals('a', square.getRow());
        assertEquals(1, square.getCol());
    }

    /**
     * @author xnguye17
     * @version etapa 2
     */
    @Test
    void getSquare_outOfChessBoard() {
        //setup
        Board.createBoard();
        //when + then
        assertThrows(
                IndexOutOfBoundsException.class, () -> Board.getSquare('a', 9));
        assertThrows(
                IndexOutOfBoundsException.class, () -> Board.getSquare('m', 6));
    }
}