import java.util.List;
import java.util.Objects;

abstract class Piece {
    private Color pieceColor;
    private PieceType pieceType;
    private Square square;

    public Piece(Color pieceColor, PieceType pieceType){
        this.pieceColor = pieceColor;
        this.pieceType = pieceType;
        this.square = null;
    }

    public record Coor(
            Integer row,
            Integer col
    ) {}

    /**
     * @author xnguye17
     * @version etapa 3
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return this.pieceColor == piece.pieceColor && this.pieceType == piece.pieceType && Objects.equals(this.square, piece.square);
    }

    /**
     * @author xnguye17
     * @version etapa 3
     */
    @Override
    public int hashCode() {
        return Objects.hash(pieceColor, pieceType, square);
    }

    /**
     * @author xnguye17
     * @version etapa 3
     */
    @Override
    public String toString() {
        return "Piece{ pieceColor=" + pieceColor +
                ", pieceType=" + pieceType +
                ", squareColor=" + square.getColor() +
                ", squareCoordinates(row/col)=" + square.getRow() + ", " + square.getCol() +
                '}';
    }

    /**
     * Metoda podle typu figurky vraci mozne tahy (policka).
     * @return pole dostupnych policek.
     *
     * @author xnguye17
     * @version etapa 2
     */
    protected List<Square> availableMovement() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Metoda presune figurku na zvolene policko.
     * @param row je pismeno v rozsahu 1 - 8.
     * @param col je cislo v rozsahu a - h.
     *
     * @author xnguye17
     */
    public void moveTo(int row, char col) {

    }

    public void setSquare(Square square) {
        this.square = square;
    }

    public Square getSquare() {
        return this.square;
    }
}
