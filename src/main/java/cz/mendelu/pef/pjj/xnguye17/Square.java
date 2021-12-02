package cz.mendelu.pef.pjj.xnguye17;
import cz.mendelu.pef.pjj.xnguye17.pieces.Piece;

import java.util.Objects;

public class Square {
    private Color squareColor;
    private Piece piece;
    private int row;
    private char col;

    public Square(int row, char col) {
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

    /**
     * @author xnguye17
     * @version etapa 3
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return this.row == square.row && this.col == square.col && this.squareColor == square.squareColor;
    }

    /**
     * @author xnguye17
     * @version etapa 3
     */
    @Override
    public int hashCode() {
        return Objects.hash(squareColor, row, col);
    }

    @Override
    public String toString() {
        return "Square{" +
                "squareColor=" + squareColor +
                ", piece=" + piece +
                ", row=" + row +
                ", col=" + col +
                '}';
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
        piece.setSquare(this);
    }

    public Piece getPiece() {
        return this.piece;
    }

    public Color getColor() {
        return this.squareColor;
    }

    public int getRow() {
        return this.row;
    }

    public char getCol() {
        return this.col;
    }

    public void removePiece() {
        piece = null;
    }

}
