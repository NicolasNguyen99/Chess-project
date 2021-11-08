package cz.mendelu.pef.pjj.xnguye17.greenfoot;

import cz.mendelu.pef.pjj.xnguye17.Game;
import greenfoot.Greenfoot;
import greenfoot.World;

public class ChessWorld extends World {
    private int time;

    private void prepare() {
        this.time = 3300;
    }

    private String calculateTime(int time) {
        int minutes = time/60;
        int seconds = time - (minutes*60);
        return minutes + " : " + (seconds/10 == 0 ? "0" + seconds : seconds);
    }

    public ChessWorld() {
        super(10, 8, 75);
        Greenfoot.setSpeed(18);
        prepare();
        setBackground("images/Board.png");

        Game game = new Game();
        game.prepareGame();

        //Rozmisteni figurek na sachovnici
        for (int col = 0; col < 8; col++) {
            for (int row = 0; row < 2; row++) {
                addObject(new PieceActor(row, col), col, row);
            }
        }
        for (int col = 0; col < 8; col++) {
            for (int row = 7; row > 5; row--) {
                addObject(new PieceActor(row, col), col, row);
            }
        }
    }

    //countdown
    public void act() {
        time--;
        showText(calculateTime(time), 9, 3);
        if (time == 0) {
            Greenfoot.stop();
        }
    }
}
