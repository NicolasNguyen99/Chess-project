public class Game {
    private Player players[];

    /**
     * Metoda vytvori novou sachovnici s figurkama.
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
     * @version etapa 3
     */
    public boolean isGameOver() {
        boolean isGameOver = false;



        return isGameOver;
    }

    /**
     * Metoda presune figurku na zvolene souradnice (policko).
     * @param piece je figurka z jednoho mozneho typu PieceType.
     * @param row je pismeno v rozsahu 1 - 8.
     * @param col je cislo v rozsahu a - h.
     *
     * @author xnguye17
     */
    public void movePiece(Piece piece, int row, char col) {

    }

    public Player[] getPlayers () {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
