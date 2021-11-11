package cz.mendelu.pef.pjj.xnguye17.pieces;

import cz.mendelu.pef.pjj.xnguye17.Board;
import cz.mendelu.pef.pjj.xnguye17.Color;
import cz.mendelu.pef.pjj.xnguye17.Coor;
import cz.mendelu.pef.pjj.xnguye17.Square;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {

    public Bishop(Color pieceColor) {
        super(pieceColor, PieceType.BISHOP);
    }

    @Override
    public List<Square> availableMovement() {
        Coor coor = new Coor(this.getSquare().getRow(), Board.calculateCoor(this.getSquare().getCol()));
        List<Square> availableSquares = new ArrayList<>();
        int row, col;
        boolean foundPiece;

        //leva horni diagonala
        row = coor.row;
        col = coor.col;
        foundPiece = false;
        while (!foundPiece) {
            if (row < 8 && col > 1) {
                row++;
                col--;
                if ((Board.getSquare(row, col).getPiece() == null)) {
                    availableSquares.add(Board.getSquare(row, col));
                } else if (Board.getSquare(row, col).getPiece().getPieceColor() != this.getPieceColor()) {
                    availableSquares.add(Board.getSquare(row, col));
                    foundPiece = true;
                } else
                    foundPiece = true;
            } else
                foundPiece = true;
        }

        //prava horni diagonala
        row = coor.row;
        col = coor.col;
        foundPiece = false;
        while (!foundPiece) {
            if (row < 8 && col < 8) {
                row++;
                col++;
                if ((Board.getSquare(row, col).getPiece() == null) || (Board.getSquare(row, col).getPiece().getPieceColor() != this.getPieceColor()))
                    availableSquares.add(Board.getSquare(row, col));
                else
                    foundPiece = true;
            } else
                foundPiece = true;
        }

        //prava dolni diagonala
        row = coor.row;
        col = coor.col;
        foundPiece = false;
        while (!foundPiece) {
            if (row > 1 && col < 8) {
                row--;
                col++;
                if ((Board.getSquare(row, col).getPiece() == null) || (Board.getSquare(row, col).getPiece().getPieceColor() != this.getPieceColor()))
                    availableSquares.add(Board.getSquare(row, col));
                else
                    foundPiece = true;
            } else
                foundPiece = true;
        }

        //leva dolni diagonala
        row = coor.row;
        col = coor.col;
        foundPiece = false;
        while (!foundPiece) {
            if (row > 1 && col > 1) {
                row--;
                col--;
                if ((Board.getSquare(row, col).getPiece() == null) || (Board.getSquare(row, col).getPiece().getPieceColor() != this.getPieceColor()))
                    availableSquares.add(Board.getSquare(row, col));
                else
                    foundPiece = true;
            } else
                foundPiece = true;
        }

        return availableSquares;
    }
}
