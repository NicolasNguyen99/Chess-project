package cz.mendelu.pef.pjj.xnguye17;

import cz.mendelu.pef.pjj.xnguye17.LAN.Lan;
import cz.mendelu.pef.pjj.xnguye17.pieces.King;
import cz.mendelu.pef.pjj.xnguye17.pieces.Piece;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {
    private final String gameName;
    private final Player[] players;

    public Game(String gameName) {
        System.out.println("Gamename: " + gameName);
        Board.setGameName(gameName);
        this.gameName = gameName;
        players = new Player[2];
        if(Lan.getServer() == null){
            Lan.newLan(this);
            Lan.getServer().start();
        }
    }

    /**
     * Metoda vytvori novou sachovnici s figurkama.
     *
     * @author xnguye17
     */
    public void prepareGame(String gameName) {
        loadGame(gameName);
        System.out.println("Po loadGame()");
        Board.prepareGame(gameName, players);
        System.out.println("Po Board.prepareGame()");
        saveGame();
        System.out.println("Po saveGame()");
    }

    private void loadGame(String gameName) {
        var savedGames = new File("texts").list();
        assert savedGames != null;
        String confFileName = Arrays.asList(savedGames).contains(gameName) ? "texts/"+gameName : "texts/piecesStartingLayout";

        try (var r = new BufferedReader(new InputStreamReader(new FileInputStream(confFileName), StandardCharsets.UTF_8))) {
            Matcher matcher;
            String line;
            for (int i = 0; i < players.length; i++) {
                line = r.readLine();
                var pattern = Pattern.compile("^(\\w*\\s\\d)\\t(\\w*)\\t(\\d*)\\t(\\w*)");
                matcher = pattern.matcher(line);
                if (matcher.find()) {
                    players[i] = new Player(matcher.group(1), Color.valueOf(matcher.group(2)), Integer.parseInt(matcher.group(3)));
                    Board.setPlayerRound(Color.valueOf(matcher.group(4)));
                }
            }
            if(players.length == 0) {
                players[0] = new Player("Player 1", Color.WHITE, 1800);
                players[1] = new Player("Player 2", Color.BLACK, 1800);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public void endGame() {
        System.exit(0);
    }

    public void saveGame() {
        Board.saveBoard(gameName);
    }

    public String getGamename() {
        return gameName;
    }
}
