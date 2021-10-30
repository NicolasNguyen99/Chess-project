import javax.swing.border.Border;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Board.createBoard();
        King king = new King(Color.WHITE);
        Square square = Board.getSquare(1, 'd');
        square.setPiece(king);
        System.out.println(square.toString());

        List<Square> squares = king.availableMovement();
        System.out.println(squares.size());
        System.out.println(squares.toString());
    }
}
