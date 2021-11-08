package cz.mendelu.pef.pjj.xnguye17;

import bh.greenfoot.runner.GreenfootRunner;
import cz.mendelu.pef.pjj.xnguye17.greenfoot.ChessWorld;

public class Runner extends GreenfootRunner {
    public static void main(String[] args) {
        bootstrap(Runner.class,
                Configuration.forWorld(ChessWorld.class)
                        .projectName("Chess")
                        .hideControls(true)
        );
        GreenfootRunner.main(args);
    }
}
