package cz.mendelu.pef.pjj.xnguye17.pieces;

import cz.mendelu.pef.pjj.xnguye17.Board;
import cz.mendelu.pef.pjj.xnguye17.Color;
import cz.mendelu.pef.pjj.xnguye17.Coor;
import cz.mendelu.pef.pjj.xnguye17.Square;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Bishop extends Piece {
    private interface myInterface {
        void resetValues();
    }

    //jenom na zkousku, bude upraveno (interface i lambda vyrazy)
    private interface myInterface2 {
        void testCondition();
    }

    public Bishop(Color pieceColor) {
        super(pieceColor, PieceType.BISHOP);
    }

    @Override
    public List<Square> availableMovement() {
        Coor coor = new Coor(this.getSquare().getRow(), Board.calculateCoor(this.getSquare().getCol()));
        List<Square> availableSquares = new ArrayList<>();
        AtomicInteger row = new AtomicInteger();
        AtomicInteger col = new AtomicInteger();
        AtomicBoolean foundPiece = new AtomicBoolean(false);

        myInterface r = () ->
        {
            row.set(coor.row);
            col.set(coor.col);
            foundPiece.set(false);
        };

        myInterface2 t = () ->
        {
            if ((Board.getSquare(row.get(), col.get()).getPiece() == null)) {
                availableSquares.add(Board.getSquare(row.get(), col.get()));
            } else if (Board.getSquare(row.get(), col.get()).getPiece().getPieceColor() != this.getPieceColor()) {
                availableSquares.add(Board.getSquare(row.get(), col.get()));
                foundPiece.set(true);
            } else
                foundPiece.set(true);
        };

        //leva horni diagonala
        r.resetValues();
        while (!foundPiece.get() && (row.get() < 8 && col.get() > 1)) {
            row.getAndIncrement();
            col.getAndDecrement();
            t.testCondition();
        }

        //prava horni diagonala
        r.resetValues();
        while (!foundPiece.get() && (row.get() < 8 && col.get() < 8)) {
            row.getAndIncrement();
            col.getAndIncrement();
            t.testCondition();
        }

        //prava dolni diagonala
        r.resetValues();
        while (!foundPiece.get() && (row.get() > 1 && col.get() < 8)) {
            row.getAndDecrement();
            col.getAndIncrement();
            t.testCondition();
        }

        //leva dolni diagonala
        r.resetValues();
        while (!foundPiece.get() && (row.get() > 1 && col.get() > 1)) {
            row.getAndDecrement();
            col.getAndDecrement();
            t.testCondition();
        }

        return availableSquares;
    }
}
