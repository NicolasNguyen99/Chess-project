import java.util.ArrayList;
import java.util.List;

public class Board {
    /**
     * READ ME
     * Rozmer matice je 9x9, i kdyz je herni plocha jenom 8x8.
     * Implementovano z duvodu, lepsi predstavy nad problemy spojene se sachy.
     *
     * @author xnguye17
     */
    private static final int vertexCount = 9;
    private static List<List<Square>> squares = new ArrayList<>(vertexCount);

    /**
     * Metoda ziska policko na sachovnici pomoci zadanych souradnic.
     * @param row je pismeno v rozsahu a - h.
     * @param col je cislo v rozsahu 1 - 8.
     * @return Vrati prislusne policko.
     * @throws IndexOutOfBoundsException pokud je policko mimo rozsah.
     *
     * @author xnguye17
     * @version etapa 2
     */
    public static Square getSquare(char row, int col) {
        Square square = null;
        try {
            square = squares.get(calculateCoor(row)).get(col);
        } catch (Exception e) {
            throw new IndexOutOfBoundsException();
        }
        return square;
    }

    private static int calculateCoor(char coor) {
        return (int)coor-96;
    }

    private static char calculateCoor(int coor) {
        coor += 96;
        return (char)coor;
    }

    public static void prepareGame(){
        createBoard();
        fillBoard();
    }

    /**
     * Metoda vytvori prazdnou sachovnici.

     * @author xnguye17
     * @version etapa 2
     */
    public static void createBoard() {
        //inicializace prazdne matice
        for (int i = 0; i < vertexCount; i++) {
            squares.add(new ArrayList<>(vertexCount));
        }

        //vyplneni 0. radku a sloupce NULL, pro zarovnani matice
        for (int row = 0; row < vertexCount; row++) {
            if (row == 0) {
                for (int col = 0; col < vertexCount; col++) {
                    squares.get(row).add(null);
                }
            } else {
                squares.get(row).add(null);
            }
        }

        //vyplneni matice SQUARE
        Square newSquare;
        for (int row = 1; row < vertexCount; row++) {
            for (int col = 1; col < vertexCount; col++) {
                newSquare = new Square(calculateCoor(row), col);
                squares.get(row).add(newSquare);
            }
        }
    }

    public static void fillBoard() {

    }

}