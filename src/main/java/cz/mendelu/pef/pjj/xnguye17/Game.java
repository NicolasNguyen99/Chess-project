package cz.mendelu.pef.pjj.xnguye17;

import cz.mendelu.pef.pjj.xnguye17.LAN.Lan;
import cz.mendelu.pef.pjj.xnguye17.pieces.King;
import cz.mendelu.pef.pjj.xnguye17.pieces.Pawn;
import cz.mendelu.pef.pjj.xnguye17.pieces.Piece;
import cz.mendelu.pef.pjj.xnguye17.pieces.PieceType;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {
    private final String gameName;
    private Color playerColor;
    private final Player[] players;
    private boolean isMenuOpen;

    public Game(String gameName) {
        Board.setGameName(gameName);
        this.gameName = gameName;
        this.isMenuOpen = false;
        players = new Player[2];
        if(Lan.getServer() == null){
            Lan.newLan(this);
            Lan.getServer().start();
        }
        playerColor = Lan.getServer().getPort() == 4000 ? Color.WHITE : Color.BLACK;
    }

    /**
     * Metoda vytvori novou sachovnici s figurkama.
     *
     * @author xnguye17
     */
    public void prepareGame(String gameName) {
        loadGame(gameName);
        Board.prepareGame(gameName, players);
        saveGame();
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
                var pattern = Pattern.compile("^(\\w*\\s\\d)\\t(\\w*)\\t(\\d*)\\t(\\w*)\\t(\\w*)");
                matcher = pattern.matcher(line);
                if (matcher.find()) {
                    players[i] = new Player(matcher.group(1), Color.valueOf(matcher.group(2)), Integer.parseInt(matcher.group(3)));
                    Board.setPlayerRound(Color.valueOf(matcher.group(4)));
                    if (Objects.equals(matcher.group(5), "true")) {
                        players[i].playerWon();
                    }
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

    public Color getPlayerColor() {
        return playerColor;
    }

    public void switchIsMenuOpen(){
        isMenuOpen = !isMenuOpen;
    }

    public boolean getIsMenuOpen() {
        return isMenuOpen;
    }
}
