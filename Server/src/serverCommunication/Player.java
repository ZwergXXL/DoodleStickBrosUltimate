package serverCommunication;

import game.fighter.Fighter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Player extends Thread{

    final Socket socket;
    final int key;

    int gameEngineIndex;



    boolean inGame;
    Fighter fighter;

    Server server;
    BufferedReader in;
    PrintWriter out;

    Player(Socket socket, int key, Server server){
        this.server = server;
        this.socket = socket;
        this.key = key;
        inGame = false;

        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void run() {
        //inMenu();
    }

    void inMenu(){
        String input;
        try {
            while (true) {
                input = in.readLine();
                if(input != null){
                    System.out.println(input);

                    switch (input){
                        case "idk":
                            break;

                            // start game with space
                        case " ":
                            startGame();
                            return;
                        default: System.out.println("ServerCommunication.Menu Input nicht vorhanden: " + input);
                    }


                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /****** INGAME *****************/

    void startGame(){
        inGame = true;
        server.joinLobby(this);
    }

    public void setFighter(Fighter fighter){
        this.fighter = fighter;
    }

    public void getInputData(){
        try {
            String[] input  = in.readLine().split("_");  // Movement Jump Ability

            switch (input[0]){
                case "A":
                    break;
                case "S":
                    break;
                case "D":
                    break;
                case "/":
                    break;
            }

            switch (input[1]){
                case "W":
                    break;
                case "/":
                    break;
            }

            switch (input[2]){
                case "Q":
                    break;
                case "":
                    break;
                case "D":
                    break;
                case "/":
                    break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }








    public int getGameEngineIndex() {
        return gameEngineIndex;
    }

    public void setGameEngineIndex(int gameEngineIndex) {
        this.gameEngineIndex = gameEngineIndex;
    }

    public boolean isInGame() {
        return inGame;
    }

    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }

    public Fighter getFighter() {
        return fighter;
    }
}
