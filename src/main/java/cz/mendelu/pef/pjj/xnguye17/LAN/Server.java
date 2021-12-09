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

//    private ChessWorld chessGame;

    public Server(Game game) {
        this.game = game;
        choosePort();
//        this.chessGame = chessGame;
    }

    @Override
    public void run() {
        try {
            var ss = new ServerSocket(port);
            System.out.println("Server is running on port: " + port);

            while(!isInterrupted()) {
                var cs = ss.accept();
                System.out.println("Client accepted: " + cs);

                try (var dis = new DataInputStream(cs.getInputStream())) {
                    String str = dis.readUTF();
                    System.out.println(str);
                    BufferedWriter writer = new BufferedWriter(new FileWriter("texts/" + game.getGamename(), false));
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
