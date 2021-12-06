import cz.mendelu.pef.pjj.xnguye17.Board;
import cz.mendelu.pef.pjj.xnguye17.Color;
import cz.mendelu.pef.pjj.xnguye17.Game;
import cz.mendelu.pef.pjj.xnguye17.Square;
import cz.mendelu.pef.pjj.xnguye17.pieces.King;
import cz.mendelu.pef.pjj.xnguye17.pieces.Knight;
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
        Game game = new Game("TestGame");
        game.prepareGame("");
        Square square1 = Board.getSquare(8, 'd');
        Square square2 = Board.getSquare(6, 'c');
        King king = new King(Color.WHITE, 10);
        Knight knight = new Knight(Color.BLACK, 10);
        square1.setPiece(king);
        square2.setPiece(knight);
        //when
        boolean isOver = game.isGameOver();
        //then
        assertTrue(isOver);
    }
}