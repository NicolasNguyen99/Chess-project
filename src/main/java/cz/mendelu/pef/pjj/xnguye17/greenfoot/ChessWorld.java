package cz.mendelu.pef.pjj.xnguye17.greenfoot;

import cz.mendelu.pef.pjj.xnguye17.Board;
import cz.mendelu.pef.pjj.xnguye17.Game;
import cz.mendelu.pef.pjj.xnguye17.pieces.Piece;
import cz.mendelu.pef.pjj.xnguye17.Color;
import greenfoot.Actor;
import greenfoot.GreenfootImage;
import greenfoot.World;

import java.util.Map;

/**
 * TODO Predelat vetsinu trid do anonymnich trid, opravit countDown (asi vyuziti vlaken)
 *
 * @author xnguye17
 */
public class ChessWorld extends World {
    private final Game game;

    public ChessWorld(String gameName) {
        super(11, 8, 75);
        setBackground("images/board.png");
        game = new Game(gameName);
        game.prepareGame(gameName);
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
                var image = new GreenfootImage(game.getPlayers()[0].getName(), 24, java.awt.Color.BLACK, new java.awt.Color(0, 0, 0, 0));
                setImage(image);
            }
        },9, 0);
        addObject(new Actor() {
            {
                var image = new GreenfootImage(game.getPlayers()[1].getName(), 24, java.awt.Color.BLACK, new java.awt.Color(0, 0, 0, 0));
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

        //zobrazeni countdown (Bude upraveno)
        //addObject(new TimerActor(), 9, 3);
        addObject(new TimerActor(), 9, 4);

        //zobrazeni menu
        addObject(new MenuButtonActor(game), 9, 6);
    }

    public void act() {
        //zvyrazneni hrace na tahu
        if (game != null) {
            if (Board.getPlayerRound() == Color.WHITE)
                addObject(new PlayerHighlightActor(game.getPlayers()[0]), 8, 0);
            else
                addObject(new PlayerHighlightActor(game.getPlayers()[1]), 8, 7);
        }
    }
}
