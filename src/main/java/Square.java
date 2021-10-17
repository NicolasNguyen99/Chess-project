public class Square {
    private Color squareColor;
    private Piece piece;
    private char row;
    private int col;

    public Square(char row, int col) {
        this.row = row;
        this.col = col;
    }

    public void setPiece(Piece piece) {

    }

    public Piece getPiece() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public Color getColor() {
        return this.squareColor;
    }

    public char getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

}
