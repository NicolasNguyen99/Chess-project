package cz.mendelu.pef.pjj.xnguye17.pieces;
import cz.mendelu.pef.pjj.xnguye17.Board;
import cz.mendelu.pef.pjj.xnguye17.Color;
import cz.mendelu.pef.pjj.xnguye17.Square;

import java.util.List;
import java.util.Objects;

public abstract class Piece {
    private Color pieceColor;
    private PieceType pieceType;
    private Square square;
    private boolean isChosed;
    private boolean isAlive;
    private Square changedPosition;
    private int key;

    public Piece(Color pieceColor, PieceType pieceType, int key){
        this.pieceColor = pieceColor;
        this.pieceType = pieceType;
        this.square = null;
        this.isChosed = false;
        this.isAlive = true;
        this.changedPosition = null;
        this.key = key;
    }

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
    public List<Square> availableMovement() {
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
        if (Board.getSquare(row, col).getPiece() != null)
            capturePiece(Board.getSquare(row, col));

        square.removePiece();
        this.setSquare(row, col);
        square.setPiece(this);
    }

    public void setChangedPosition(Square square) {
        changedPosition = square;
    }

    public Square getChangedPosition() {
        return changedPosition;
    }

    public void setSquare(Square square) {
        this.square = square;
    }

    public void setSquare(int row, char col) {
        setSquare(Board.getSquare(row, Board.calculateCoor(col)));
    }

    public Square getSquare() {
        return this.square;
    }

    public Color getPieceColor() {
        return this.pieceColor;
    }

    public PieceType getPieceType() {
        return this.pieceType;
    }

    public void switchIsChosed() {
        this.isChosed = !this.isChosed;
    }

    public boolean getIsChosed() {
        return this.isChosed;
    }

    public void capturePiece(Square capturedSquare) {
        Board.removePiece(capturedSquare.getPiece());
        capturedSquare.removePiece();
    }

    public int getKey() {
        return this.key;
    }
}
