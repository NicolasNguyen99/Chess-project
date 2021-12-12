package cz.mendelu.pef.pjj.xnguye17.greenfoot.worlds;

import cz.mendelu.pef.pjj.xnguye17.Board;
import cz.mendelu.pef.pjj.xnguye17.Game;
import cz.mendelu.pef.pjj.xnguye17.LAN.Lan;
import cz.mendelu.pef.pjj.xnguye17.greenfoot.*;
import cz.mendelu.pef.pjj.xnguye17.pieces.Piece;
import cz.mendelu.pef.pjj.xnguye17.Color;
import greenfoot.Actor;
import greenfoot.Greenfoot;
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
    private final String player1;
    private final String player2;
    private boolean isEndDisplayed = false;

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
                    addObject(new PieceActor(game, row, col), col-1, 9-row-1);
                }
            }
        }

        if (Lan.getServer().getPort() == 4000) {
            player1 = "You";
            player2 = "Enemy";
        } else {
            player1 = "Enemy";
            player2 = "You";
        }

        /**
         * (greenfoot) anonymni trida, ktera zobazuje jmeno hrace.
         *
         * @author xnguye17
         * @version etapa 4
         */
        addObject(new Actor() {
            {
                var image = new GreenfootImage(player1, 24, java.awt.Color.BLACK, new java.awt.Color(0, 0, 0, 0));
                setImage(image);
            }
        },9, 0);
        addObject(new Actor() {
            {
                var image = new GreenfootImage(player2, 24, java.awt.Color.BLACK, new java.awt.Color(0, 0, 0, 0));
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

        //zobrazeni countdown
        addObject(new TimerActor(game.getPlayers()[0]), 9, 2);
        addObject(new TimerActor(game.getPlayers()[1]), 9, 3);

        //zobrazeni menu
        addObject(new SaveGameActor(game), 9, 4);
        addObject(new SurrenderActor(game), 9, 5);
        addObject(new ExitGameActor(), 9, 6);
    }

    public void act() {
        if(Board.getRefreshGame()) {
            Board.switchResreshGame();
            var chessWorld = new ChessWorld(game.getGamename());
            Greenfoot.setWorld(chessWorld);
        }

        if (!isEndDisplayed && (game.getPlayers()[0].hasWon() || game.getPlayers()[1].hasWon())) {
            addObject(new Actor() {
                {
                    var image = new GreenfootImage(825, 700);
                    image.setColor(java.awt.Color.BLACK);
                    image.fill();
                    image.setTransparency(75);
                    setImage(image);
                }
            }, 5, 3);
            addObject(new Actor() {
                {
                    var image = new GreenfootImage("images/end/endLogo.png");
                    setImage(image);
                }
            },5, 4);

            String img;
            if ((Lan.getServer().getPort() == 4000 && game.getPlayers()[0].hasWon()) || (Lan.getServer().getPort() == 4001 && game.getPlayers()[1].hasWon()))
                img = "winner";
            else
                img = "loser";

            addObject(new Actor() {
                {
                    var image = new GreenfootImage(String.format("images/end/%s.png", img));
                    setImage(image);
                }
            },5, 4);

            addObject(new ExitGameActor(), 5, 5);

            isEndDisplayed = true;
        }

        //zvyrazneni hrace na tahu
        if (game != null) {
            if (Board.getPlayerRound() == Color.WHITE)
                addObject(new PlayerHighlightActor(game.getPlayers()[0]), 8, 0);
            else
                addObject(new PlayerHighlightActor(game.getPlayers()[1]), 8, 7);
        }
    }
}
