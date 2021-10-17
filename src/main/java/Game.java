public class Game {
    private Player players[];

    /**
     * Metoda vytvoří novou rozmístněnou šachovnici.
     *
     * @author xnguye17
     */
    private void prepareGame() {
        Board.prepareGame();
    }

    /**
     * Metoda, která kontroluje konec.
     * Konec hry nastane, když hráč dostane mat, vzdá se nebo ve hře zůstanou poslední dvě figurky a žádná ze stran nemůže zvítězit.
     * @return Boolean (true = konec hry, false = hra pokračuje)
     *
     * @author xnguye17
     * @version etapa 2
     */
    public boolean isGameOver() {
            throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Metoda přesune figurku na zvolené souřadnice (políčko).
     * @param piece je figurka z jednoho možného typu PieceType.
     * @param row je písmeno v rozsahu a - h.
     * @param col je číslo v rozsahu 1 - 8.
     *
     * @author xnguye17
     */
    public void movePiece(Piece piece, char row, int col) {

    }

    public Player[] getPlayers () {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
