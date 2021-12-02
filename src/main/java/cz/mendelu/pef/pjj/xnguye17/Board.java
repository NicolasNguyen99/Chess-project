package cz.mendelu.pef.pjj.xnguye17;
import cz.mendelu.pef.pjj.xnguye17.pieces.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Board {
    /**
     * READ ME
     * Rozmer matice je 9x9, i kdyz je herni plocha jenom 8x8.
     * Implementovano z duvodu, lepsi predstavy nad problemy spojene se sachy.
     *
     * @author xnguye17
     */
    public static final int vertexCount = 9;
    private static final List<List<Square>> squares = new ArrayList<>(vertexCount);
    private static final Map<Integer, Piece> pieces = new HashMap<>();

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

    /**
     * Metoda pripravi naplnenou sachovnici ze vstupniho souboru
     *
     * @author xnguye17
     */
    public static void prepareGame(){
        createBoard();
        loadBoard();
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

    private static Piece createPiece(String pieceType, String color){
        Color pieceColor = Objects.equals(color, "black") ? Color.BLACK : Color.WHITE;
        Piece piece;
        switch (pieceType) {
            case "king":
                piece = new King(pieceColor);
                break;
            case "queen":
                piece = new Queen(pieceColor);
                break;
            case "rook":
                piece = new Rook(pieceColor);
                break;
            case "knight":
                piece = new Knight(pieceColor);
                break;
            case "pawn":
                piece = new Pawn(pieceColor);
                break;
            case "bishop":
                piece = new Bishop(pieceColor);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + pieceType);
        }
        return piece;
    }

    /**
     * Metoda naplni prazdnou sachovnici ze vstupniho souboru
     * TODO Bude pridan vyber, jestli cist ze statovaciho souboru nebo ulozeneho napr. z predesle hry
     *
     * @author xnguye17
     * @version etapa 4
     */
    private static void loadBoard() {
        Map<Integer, Piece> entry = new HashMap<>();
        Piece piece;

        try (var r = new BufferedReader(new InputStreamReader(new FileInputStream("texts/piecesStartingLayout.txt"), StandardCharsets.UTF_8))) {
            Matcher matcher;
            String line;
            while ((line = r.readLine()) != null) {
                var pattern = Pattern.compile("^(\\w*)\\s(\\w*)\\s(\\d+)\\s(\\d\\D)");
                matcher = pattern.matcher(line);
                if (matcher.find()) {
                    piece = createPiece(matcher.group(1), matcher.group(2));
                    int row = Character.getNumericValue(matcher.group(4).charAt(0));
                    char col = matcher.group(4).charAt(1);
                    int key = Integer.parseInt(matcher.group(3));
                    Board.getSquare(row, col).setPiece(piece);
                    entry.put(key, piece);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        pieces.putAll(entry);
    }


    /**
     * Metoda ulozi rozehranou sachovnici do souboru
     *
     * @author xnguye17
     * @version etapa 4
     */
    public static void saveBoard() {
        try (var w = new FileWriter("texts/piecesSavedLayout.txt")) {
            String pieceType;
            String pieceColor;
            String pieceKey;
            String pieceCoors;
            for (int i = 1; i <= 36; i++ ) {
                if (pieces.get(i) != null) {
                    pieceType = ("" + pieces.get(i).getPieceType()).toLowerCase();
                    pieceColor = ("" + pieces.get(i).getPieceColor()).toLowerCase();
                    pieceKey = String.valueOf(i);
                    pieceCoors = String.format("%s%s", pieces.get(i).getSquare().getRow(), pieces.get(i).getSquare().getCol());
                    w.write(String.format("%s\t%s\t%s\t%s\n", pieceType, pieceColor, pieceKey, pieceCoors));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda presune figurku na zvolene souradnice (policko).
     * @param piece je figurka z jednoho mozneho typu PieceType.
     * @param row je pismeno v rozsahu 1 - 8.
     * @param col je cislo v rozsahu a - h.
     *
     * @author xnguye17
     */
    public static boolean movePiece(Piece piece, int row, char col) {
        if (piece.availableMovement().contains(Board.getSquare(row, col))) {
            piece.moveTo(row, col);
            piece.setChangedPosition(Board.getSquare(row, col));
            return true;
        } else
            return false;
    }

    public static Map<Integer, Piece> getPieces() {
        return pieces;
    }

}