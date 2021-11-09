package cz.mendelu.pef.pjj.xnguye17;
import cz.mendelu.pef.pjj.xnguye17.pieces.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    /**
     * READ ME
     * Rozmer matice je 9x9, i kdyz je herni plocha jenom 8x8.
     * Implementovano z duvodu, lepsi predstavy nad problemy spojene se sachy.
     *
     * @author xnguye17
     */
    public static final int vertexCount = 9;
    private static List<List<Square>> squares = new ArrayList<>(vertexCount);
    private static Map<Integer, Piece> pieces = new HashMap<>();

    /**
     * Metoda ziska policko na sachovnici pomoci zadanych souradnic.
     * @param row je cislo v rozsahu 1 - 8.
     * @param col je cislo v rozsahu a - h.
     * @return Vrati prislusne policko.
     * @throws IndexOutOfBoundsException pokud je policko mimo rozsah.
     *
     * @author xnguye17
     * @version etapa 3
     */
    public static Square getSquare(int row, int col) {
        Square square = null;
        try {
            square = squares.get(row).get(col);
        } catch (Exception e) {
            throw new IndexOutOfBoundsException();
        }
        return square;
    }

    /**
     * Metoda ziska policko na sachovnici pomoci zadanych souradnic.
     * Prekryti metody getSquare(int, int)
     * @param row je cislo v rozsahu 1 - 8.
     * @param col je pismeno v rozsahu a - h.
     * @return Vrati prislusne policko.
     *
     * @author xnguye17
     * @version etapa 3
     */
    public static Square getSquare(int row, char col) {
        return getSquare(row, calculateCoor(col));
    }

    /**
     * Metoda prepocita pismeno na integer. (a = 1, b = 2, c = 3...)
     * @param coor je znak v rozsahu a - h.
     * @return Vrati integer, ktery reprezentuje oznaceni sloupce na sachovnici.
     *
     * @author xnguye17
     */
    public static int calculateCoor(char coor) {
        return (int)coor-96;
    }

    /**
     * Metoda prepocita integer na pismeno. (1 = a, 2 = b, 3 = c...)
     * @param coor je cislo v rozsahu 1 - 8.
     * @return Vrati znak, ktery reprezentuje oznaceni sloupce na sachovnici.
     *
     * @author xnguye17
     */
    public static char calculateCoor(int coor) {
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
     * @version etapa 3
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
                newSquare = new Square(row, calculateCoor(col));
                squares.get(row).add(newSquare);
            }
        }
    }

    /**
     * Metoda naplni prazdnou sachovnici
     * Provizorni metoda, kvuli otestovani testu, bude predelana
     *
     * @author xnguye17
     */
    public static void fillBoard() {
        Map<Integer, Piece> entry = new HashMap<>();
        Piece piece = null;

        piece = new King(Color.BLACK);
        Board.getSquare(1, 'd').setPiece(piece);
        entry.put(1, piece);

        piece = new Queen(Color.BLACK);
        Board.getSquare(1, 'e').setPiece(piece);
        entry.put(2, piece);

        piece = new Bishop(Color.BLACK);
        Board.getSquare(1, 'c').setPiece(piece);
        entry.put(3, piece);

        piece = new Bishop(Color.BLACK);
        Board.getSquare(1, 'f').setPiece(piece);
        entry.put(4, piece);

        piece = new Knight(Color.BLACK);
        Board.getSquare(1, 'b').setPiece(piece);
        entry.put(5, piece);

        piece = new Knight(Color.BLACK);
        Board.getSquare(1, 'g').setPiece(piece);
        entry.put(6, piece);

        piece = new Rook(Color.BLACK);
        Board.getSquare(1, 'a').setPiece(piece);
        entry.put(7, piece);

        piece = new Rook(Color.BLACK);
        Board.getSquare(1, 'h').setPiece(piece);
        entry.put(8, piece);

//        for (int i = 1; i < vertexCount; i++) {
//            piece = new Pawn(Color.BLACK);
//            Board.getSquare(2, calculateCoor(i)).setPiece(piece);
//            entry.put(8+i, piece);
//        }

        piece = new King(Color.WHITE);
        Board.getSquare(8, 'd').setPiece(piece);
        entry.put(21, piece);

        piece = new Queen(Color.WHITE);
        Board.getSquare(8, 'e').setPiece(piece);
        entry.put(22, piece);

        piece = new Bishop(Color.WHITE);
        Board.getSquare(8, 'c').setPiece(piece);
        entry.put(23, piece);

        piece = new Bishop(Color.WHITE);
        Board.getSquare(8, 'f').setPiece(piece);
        entry.put(24, piece);

        piece = new Knight(Color.WHITE);
        Board.getSquare(8, 'b').setPiece(piece);
        entry.put(25, piece);

        piece = new Knight(Color.WHITE);
        Board.getSquare(8, 'g').setPiece(piece);
        entry.put(26, piece);

        piece = new Rook(Color.WHITE);
        Board.getSquare(8, 'a').setPiece(piece);
        entry.put(27, piece);

        piece = new Rook(Color.WHITE);
        Board.getSquare(8, 'h').setPiece(piece);
        entry.put(28, piece);

//        for (int i = 1; i < vertexCount; i++) {
//            piece = new Pawn(Color.WHITE);
//            Board.getSquare(7, calculateCoor(i)).setPiece(piece);
//            entry.put(28+i, piece);
//        }

        pieces.putAll(entry);
    }

    public static Map<Integer, Piece> getPieces() {
        return pieces;
    }

}