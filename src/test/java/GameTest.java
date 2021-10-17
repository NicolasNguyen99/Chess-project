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
        var square1 = Board.getSquare('d', 8);
        var square2 = Board.getSquare('c', 6);
        var king = new Piece(Color.WHITE, PieceType.KING);
        var knight = new Piece(Color.BLACK, PieceType.KNIGHT);
        square1.setPiece(king);
        square2.setPiece(knight);
        //when
        var isOver = game.isGameOver();
        //then
        assertTrue(isOver);
    }
}