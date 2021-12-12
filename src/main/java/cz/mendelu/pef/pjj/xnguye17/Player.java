package cz.mendelu.pef.pjj.xnguye17;

public class Player {
    private String name;
    private final Color color;
    private boolean hasKing;
    private boolean wantSurrender;
    private boolean hasWon;
    private int remainingTime;

    public Player(String name, Color color, int time) {
        this.name = name;
        this.color = color;
        this.hasKing = true;
        this.wantSurrender = false;
        this.hasWon = false;
        this.remainingTime = time;
        startCountdown();
    }

    public void wantSurrender() {
        wantSurrender = true;
    }

    public boolean getWantSurrender() {
        return wantSurrender;
    }

    public Color getPieceColor() {
        return this.color;
    }

    public String getName() {
        return this.name;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void lowerRemainingTime() {
        this.remainingTime--;
    }

    public void startCountdown() {
        if(getPieceColor() == Board.getPlayerRound())
            new Countdown(this);
    }

    public boolean hasKing() {
        return hasKing;
    }

    public void killKing() {
        hasKing = false;
    }

    public void playerWon() {
        hasWon = true;
    }

    public boolean hasWon() {
        return hasWon;
    }

    public void setPlayerName(String playerName) {
        name = playerName;
    }
}
