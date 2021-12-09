package cz.mendelu.pef.pjj.xnguye17;

public class End {
    private final String endQuote;
    private final Player whoWon;

    public End(String endQuote, Player whoWon) {
        this.endQuote = endQuote;
        this.whoWon = whoWon;
    }

    public String getEndQuote() {
        return endQuote;
    }

    public Player getWhoWon() {
        return whoWon;
    }

    @Override
    public String toString() {
        return whoWon.getName() + " has won, because other player " + endQuote;
    }
}
