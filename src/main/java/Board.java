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
        return squares[calculateCoor(row)][calculateCoor(col)];
    }

    private static int calculateCoor(int coor) {
        if (coor >= 'a' && coor <= 'h')
            return coor-(int)'a';
        return coor-1;
    }

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
        squares = new Square[8][8];
    }

    public static void fillBoard() {

    }

}
