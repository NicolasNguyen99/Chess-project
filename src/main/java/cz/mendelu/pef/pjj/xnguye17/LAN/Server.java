package cz.mendelu.pef.pjj.xnguye17.LAN;

import cz.mendelu.pef.pjj.xnguye17.Board;
import cz.mendelu.pef.pjj.xnguye17.Game;
import cz.mendelu.pef.pjj.xnguye17.greenfoot.worlds.ChessWorld;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.Arrays;

public class Server extends Thread{
    private final Game game;
    private int port;

    public Server(Game game) {
        this.game = game;
        choosePort();
    }

    @Override
    public void run() {
        try {
            var ss = new ServerSocket(port);

            while(!isInterrupted()) {
                var cs = ss.accept();

                try (var dis = new DataInputStream(cs.getInputStream())) {
                    String str = dis.readUTF();
                    BufferedWriter writer = new BufferedWriter(new FileWriter("texts/" + game.getGamename()));
                    writer.write(str);
                    writer.close();
                    game.prepareGame(game.getGamename());
                    Board.switchResreshGame();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void choosePort() {
        try {
            var ss = new ServerSocket(4000);
            port = 4000;
            ss.close();
        } catch (IOException e) {
            port = 4001;
        }
    }

    public int getPort() {
        return port;
    }
}
