package cz.mendelu.pef.pjj.xnguye17.greenfoot;

import cz.mendelu.pef.pjj.xnguye17.Color;
import cz.mendelu.pef.pjj.xnguye17.Game;
import greenfoot.Greenfoot;
import greenfoot.World;

import java.awt.*;

public class ChessWorld extends World {

    public ChessWorld() {
        super(10, 8, 75);
        setBackground("images/Board.png");

        Game game = new Game();
        game.prepareGame();

        //vygenerovani policek
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if ((row%2 == 0 && col%2 == 0) || (row%2 != 0 && col%2 != 0))
                    addObject(new SquareActor(Color.WHITE, row, col), col, row);
                else
                    addObject(new SquareActor(Color.BLACK, row, col), col, row);
            }
        }

        //Rozmisteni bilych figurek na sachovnici
        for (int col = 0; col < 8; col++) {
            for (int row = 0; row < 1; row++) { //prehodit na 1 pri zkouseni, zpet na 2
                addObject(new PieceActor(row, col), col, row);
            }
        }

        //Rozmisteni cernych figurek na sachovnici
        for (int col = 0; col < 8; col++) {
            for (int row = 7; row > 6; row--) { //prechodit na 6 pri zkouseni, zpet na 5
                addObject(new PieceActor(row, col), col, row);
            }
        }

        //zobrazeni jmena hracu (prozatim jmeno kostruktorem)
        addObject(new LabelActor(game.getPlayers()[0]), 9, 0);
        addObject(new LabelActor(game.getPlayers()[1]), 9, 7);

        //zobrazeni barvy hracu
        addObject(new PlayerColorActor(game.getPlayers()[0]), 8, 0);
        addObject(new PlayerColorActor(game.getPlayers()[1]), 8, 7);

        //countdown
        addObject(new TimerActor(), 9, 3);
        addObject(new TimerActor(), 9, 4);
    }
}
