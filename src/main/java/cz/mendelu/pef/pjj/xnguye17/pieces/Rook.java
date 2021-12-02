package cz.mendelu.pef.pjj.xnguye17.pieces;

import cz.mendelu.pef.pjj.xnguye17.Board;
import cz.mendelu.pef.pjj.xnguye17.Color;
import cz.mendelu.pef.pjj.xnguye17.Coor;
import cz.mendelu.pef.pjj.xnguye17.Square;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {

    public Rook(Color pieceColor) {
        super(pieceColor, PieceType.ROOK);
    }

    @Override
    public List<Square> availableMovement() {
        Coor coor = new Coor(this.getSquare().getRow(), Board.calculateCoor(this.getSquare().getCol()));
        List<Square> availableSquares = new ArrayList<>();
        int row, col;
        boolean foundPiece;

        //smeru nahoru
        foundPiece = false;
        row = coor.row;
        while (row < Board.vertexCount-1 && !foundPiece) {
            row++;
            if (Board.getSquare(row, coor.col).getPiece() == null) {
                availableSquares.add(Board.getSquare(row, coor.col));
            } else if (Board.getSquare(row, coor.col).getPiece().getPieceColor() != this.getPieceColor()) {
                availableSquares.add(Board.getSquare(row, coor.col));
                foundPiece = true;
            } else {
                foundPiece = true;
            }
        }

        //kontrola smeru doprava
        foundPiece = false;
        col = coor.col;
        while (col < Board.vertexCount-1 && !foundPiece) {
            col++;
            if (Board.getSquare(coor.row, col).getPiece() == null) {
                availableSquares.add(Board.getSquare(coor.row, col));
            } else if (Board.getSquare(coor.row, col).getPiece().getPieceColor() != this.getPieceColor()) {
                availableSquares.add(Board.getSquare(coor.row, col));
                foundPiece = true;
            } else {
                foundPiece = true;
            }
        }

        //kontrola smeru dolu
        foundPiece = false;
        row = coor.row;
        while (row > 1 && !foundPiece) {
            row--;
            if (Board.getSquare(row, coor.col).getPiece() == null) {
                availableSquares.add(Board.getSquare(row, coor.col));
            } else if (Board.getSquare(row, coor.col).getPiece().getPieceColor() != this.getPieceColor()) {
                availableSquares.add(Board.getSquare(row, coor.col));
                foundPiece = true;
            } else {
                foundPiece = true;
            }
        }

        //kontrola smeru doleva
        foundPiece = false;
        col = coor.col;
        while (col > 1 && !foundPiece) {
            col--;
            if (Board.getSquare(coor.row, col).getPiece() == null) {
                availableSquares.add(Board.getSquare(coor.row, col));
            } else if (Board.getSquare(coor.row, col).getPiece().getPieceColor() != this.getPieceColor()) {
                availableSquares.add(Board.getSquare(coor.row, col));
                foundPiece = true;
            } else {
                foundPiece = true;
            }
        }
        return availableSquares;
    }
}
