public class Game {
    private Player players[];

    /**
     * Metoda vytvori novou rozmistnenou sachovnici.
     *
     * @author xnguye17
     */
    private void prepareGame() {
        Board.prepareGame();
    }

    /**
     * Metoda, ktera kontroluje konec.
     * Konec hry nastane, kdyz hrac dostane mat, vzda se nebo ve hre zustanou posledni dve figurky a zadna ze stran nemuze zvitezit.
     * @return Boolean (true = konec hry, false = hra pokracuje)
     *
     * @author xnguye17
     * @version etapa 2
     */
    public boolean isGameOver() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Metoda presune figurku na zvolene souradnice (policko).
     * @param piece je figurka z jednoho mozneho typu PieceType.
     * @param row je pismeno v rozsahu a - h.
     * @param col je cislo v rozsahu 1 - 8.
     *
     * @author xnguye17
     */
    public void movePiece(Piece piece, char row, int col) {

    }

    public Player[] getPlayers () {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
