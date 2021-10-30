public class Square {
    private Color squareColor;
    private Piece piece;
    private char row;
    private int col;

    public Square(char row, int col) {
        this.row = row;
        this.col = col;

        if (row % 2 == 0) {
            if (col % 2 == 0) {
                this.squareColor = Color.BLACK;
            } else {
                this.squareColor = Color.WHITE;
            }
        } else {
            if (col % 2 == 0) {
                this.squareColor = Color.WHITE;
            } else {
                this.squareColor = Color.BLACK;
            }
        }
    }

    public void setPiece(Piece piece) {

    }

    public Piece getPiece() {
        return this.piece;
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
