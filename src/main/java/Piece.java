public class Piece {
    private Color pieceColor;
    private PieceType pieceType;
    private Square square;

    public Piece(Color color, PieceType type){

    }

    /**
     * Metoda podle typu figurky vrací možné tahy (políčka).
     * @return pole dostupných políček.
     *
     * @author xnguye17
     * @version etapa 2
     */
    protected Square[] availableMovement() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Metoda přesune figurku na zvolené políčko.
     * @param row je písmeno v rozsahu a - h.
     * @param col je číslo v rozsahu 1 - 8.
     *
     * @author xnguye17
     */
    public void moveTo(char row, int col) {

    }
}
