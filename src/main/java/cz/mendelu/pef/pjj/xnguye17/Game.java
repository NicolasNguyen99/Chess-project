package cz.mendelu.pef.pjj.xnguye17;

import cz.mendelu.pef.pjj.xnguye17.pieces.King;
import cz.mendelu.pef.pjj.xnguye17.pieces.Piece;

public class Game {
    private Player[] players;

    public Game() {
        players = new Player[2];
    }

    /**
     * Metoda vytvori novou sachovnici s figurkama.
     *
     * @author xnguye17
     */
    public void prepareGame() {
        Board.prepareGame();
        players[0] = new Player("Player 1", Color.WHITE);
        players[1] = new Player("Player 2", Color.BLACK);
    }

    /**
     * Metoda, ktera kontroluje konec.
     * Konec hry nastane, kdyz hrac dostane mat, vzda se nebo ve hre zustanou posledni dve figurky a zadna ze stran nemuze zvitezit.
     * @return Boolean (true = konec hry, false = hra pokracuje)
     *
     * @author xnguye17
     * @version etapa 3
     */
    public boolean isGameOver() {
        boolean isGameOver = false;
        boolean isMat = false;

        King king = (King)Board.getPieces().get(1);

        for (var entry : Board.getPieces().entrySet()) {
            Piece piece = entry.getValue();
            if ((piece.getPieceColor() != king.getPieceColor()) && (piece.availableMovement().contains(king.getSquare())))
                isMat = true;
        }
        //TODO surrender, noWinner, lastTwoPieces

        if (isMat)
            isGameOver = true;

        return isGameOver;
    }

    public Player[] getPlayers () {
        return this.players;
    }
}
