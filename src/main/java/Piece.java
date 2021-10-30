public class Piece {
    private Color pieceColor;
    private PieceType pieceType;
    private Square square;

    public Piece(Color color, PieceType type){

    }

    /**
     * Metoda podle typu figurky vraci mozne tahy (policka).
     * @return pole dostupnych policek.
     *
     * @author xnguye17
     * @version etapa 2
     */
    protected Square[] availableMovement() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Metoda presune figurku na zvolene policko.
     * @param row je pismeno v rozsahu a - h.
     * @param col je cislo v rozsahu 1 - 8.
     *
     * @author xnguye17
     */
    public void moveTo(char row, int col) {

    }
}
