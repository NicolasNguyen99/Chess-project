package cz.mendelu.pef.pjj.xnguye17.pieces;
import cz.mendelu.pef.pjj.xnguye17.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pawn extends Piece {
    private boolean isFirstMove = true;
    private boolean isOnEnd = false;

    public Pawn(Color pieceColor, int key) {
        super(pieceColor, PieceType.PAWN, key);
    }
    /**
     * @author xnguye17
     * @version etapa 3
     */
    @Override
    public List<Square> availableMovement() {
        Coor coor = new Coor(this.getSquare().getRow(), Board.calculateCoor(this.getSquare().getCol()));
        int tBorder, rBorder, lBorder;

        //urceni smeru figurek
        if (this.getPieceColor() == Color.BLACK)
            tBorder = (coor.row < 8) ? coor.row+1 : coor.row;
        else
            tBorder = (coor.row > 1) ? coor.row-1 : coor.row;

        rBorder = (coor.row != 8 && coor.row != 1 && coor.col < 8) ? coor.col +1 : coor.col ;
        lBorder = (coor.row != 8 && coor.row != 1 && coor.col  > 1) ? coor.col -1 : coor.col ;

        List<Square> availableSquares = new ArrayList<>();
        //kontrola jestli je diagonalne vlevo o jedno enemy figurka
        if (!(tBorder == 9 || tBorder == 0) && (Board.getSquare(tBorder, lBorder).getPiece() != null) && (Board.getSquare(tBorder, lBorder).getPiece().getPieceColor() != this.getPieceColor())) {
            availableSquares.add(Board.getSquare(tBorder, lBorder));
        }

        if (Board.getSquare(tBorder, coor.col).getPiece() == null) {
            //kontrola jestli je o policko vpred volne policko
            if (isFirstMove) {
                if (this.getPieceColor() == Color.BLACK && Board.getSquare(tBorder+1, coor.col).getPiece() == null)
                    availableSquares.add(Board.getSquare(tBorder+1, coor.col));
                else if (Board.getSquare(tBorder-1, coor.col).getPiece() == null)
                    availableSquares.add(Board.getSquare(tBorder-1, coor.col));
            }
            availableSquares.add(Board.getSquare(tBorder, coor.col));
        }
        //kontrola jestli je diagonalne vpravo o jedno enemy figurka
        if ((Board.getSquare(tBorder, rBorder).getPiece() != null) && (Board.getSquare(tBorder, rBorder).getPiece().getPieceColor() != this.getPieceColor()))
            availableSquares.add(Board.getSquare(tBorder, rBorder));

        return availableSquares;
    }

    @Override
    public void moveTo(int row, char col) {
        super.moveTo(row, col);
        if (getIsFirstMove())
            switchIsFirstMove();
        else if (row == 8 || row == 1) {
            changePawn(PieceType.QUEEN);
        }
    }

    public boolean getIsFirstMove() {
        return isFirstMove;
    }

    public void switchIsFirstMove() {
        isFirstMove = false;
    }

    public void changePawn(PieceType pieceType) {
        if (pieceType == PieceType.QUEEN) {
            int key = getPieceColor() == Color.WHITE ? 22 : 2;
            if (!Board.getPieces().containsKey(key)) {
                Piece piece = new Queen(Board.getPieces().get(getKey()).getPieceColor(), key);
                int row, col;
                row = Board.getPieces().get(getKey()).getSquare().getRow();
                col = Board.calculateCoor(Board.getPieces().get(getKey()).getSquare().getCol());
                Board.removePiece(Board.getPieces().get(getKey()));
                Board.getPieces().put(key, piece);
                Board.getSquare(row, col).setPiece(piece);
                Board.switchResreshGame();
            } else {
                System.out.println("You already have queen");
            }
        }

    }
}
