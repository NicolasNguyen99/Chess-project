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
        Game game = new Game();
        Board.createBoard();
        Square square1 = Board.getSquare(8, 'd');
        Square square2 = Board.getSquare(6, 'c');
        King king = new King(Color.WHITE);
        Knight knight = new Knight(Color.BLACK);
        square1.setPiece(king);
        square2.setPiece(knight);
        //when
        boolean isOver = game.isGameOver();
        //then
        assertTrue(isOver);
    }
}