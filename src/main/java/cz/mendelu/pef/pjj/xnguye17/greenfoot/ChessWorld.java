package cz.mendelu.pef.pjj.xnguye17.greenfoot;

import cz.mendelu.pef.pjj.xnguye17.Board;
import cz.mendelu.pef.pjj.xnguye17.Game;
import cz.mendelu.pef.pjj.xnguye17.pieces.Piece;
import greenfoot.Actor;
import greenfoot.GreenfootImage;
import greenfoot.World;

import java.awt.*;
import java.util.Map;

/**
 * TODO Predelat vetsinu trid do anonymnich trid, opravit countDown (asi vyuziti vlaken)
 *
 * @author xnguye17
 */
public class ChessWorld extends World {

    public ChessWorld() {
        super(11, 8, 75);
        setBackground("images/board.png");

        Game game = new Game();
        game.prepareGame();
        Map<Integer, Piece> pieces = Board.getPieces();

        //Graficke rozmisteni figurek na sachovnici
        for (int row = 1; row <= 8; row++) {
            for (int col = 1; col <= 8; col++) {
                if (Board.getSquare(row, col).getPiece() != null) {
                    addObject(new PieceActor(row, col), col-1, 9-row-1);
                }
            }
        }

        /**
         * (greenfoot) anonymni trida, ktera zobazuje jmeno hrace.
         *
         * @author xnguye17
         * @version etapa 4
         */
        addObject(new Actor() {
            {
                var image = new GreenfootImage(game.getPlayers()[0].getName(), 24, Color.BLACK, new Color(0, 0, 0, 0));
                setImage(image);
            }
        },9, 0);
        addObject(new Actor() {
            {
                var image = new GreenfootImage(game.getPlayers()[1].getName(), 24, Color.BLACK, new Color(0, 0, 0, 0));
                setImage(image);
            }
        },9, 7);

        /**
         * (greenfoot) anonymni trida, vykresluje barvu hrace.
         *
         * @author xnguye17
         * @version etapa 4
         */
        addObject(new Actor() {
            {
                setImage(String.format("images/playerColors/%s.png", game.getPlayers()[0].getPieceColor()));
            }
        }, 8, 0);
        addObject(new Actor() {
            {
                setImage(String.format("images/playerColors/%s.png", game.getPlayers()[1].getPieceColor()));
            }
        }, 8, 7);

        //zvyrazneni hrace na tahu
        addObject(new PlayerHighlightActor(), 8, 0);
        addObject(new PlayerHighlightActor(), 8, 7);

        //zobrazeni countdown (Bude upraveno)
        //addObject(new TimerActor(), 9, 3);
        addObject(new TimerActor(), 9, 4);

        //zobrazeni menu
        addObject(new MenuButtonActor(game), 9, 6);
    }
}
