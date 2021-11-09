package cz.mendelu.pef.pjj.xnguye17;
public class Player {
    private String name;
    private int numPieces;
    private Color color;
    private boolean wantSurrender;

    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public void wantSurrender () {
        wantSurrender = true;
    }

    public Color getPieceColor() {
        return this.color;
    }

    public String getName() {
        return this.name;
    }
}
