import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    /**
     * @author xnguye17
     * @version etapa 2
     */
    @Test
    void isGameOver_mat() {
        //setup
        var game = new Game();
        Board.createBoard();
        var square1 = Board.getSquare(8, 'd');
        var square2 = Board.getSquare(6, 'c');
        var king = new King(Color.WHITE);
        var knight = new Knight(Color.BLACK);
        square1.setPiece(king);
        square2.setPiece(knight);
        //when
        var isOver = game.isGameOver();
        //then
        assertTrue(isOver);
    }
}