public class Board {
    private static Square[][] squares;

    /**
     * Metoda získá políčko na šachovnici pomocí zadaných souřadnic.
     * @param row je písmeno v rozsahu a - h.
     * @param col je číslo v rozsahu 1 - 8.
     * @return Vrátí příslušné políčko.
     * @throws IndexOutOfBoundsException pokuď je políčko mimo rozsah.
     *
     * @author xnguye17
     * @version etapa 2
     */
    public static Square getSquare(char row, int col) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Metoda provolá Board#createBoard() a Board#fillBoard().
     * Výsledkem bude připavená hra.
     *
     * @author xnguye17
     */
    public static void prepareGame(){
        createBoard();
        fillBoard();
    }

    /**
     * Metoda vytvoří prázdnou šachovnici.

     * @author xnguye17
     * @version etapa 2
     */
    public static void createBoard() {
    }

    public static void fillBoard() {

    }


}
