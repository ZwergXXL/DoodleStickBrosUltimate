package server;

import game.Entity;
import game.fighter.Fighter;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class Player extends Thread{

    final Socket socket;
    final int key;

    int gameEngineIndex;



    boolean inGame;
    Fighter fighter;

    Server server;
    ObjectInputStream in;
    ObjectOutputStream out;

    Player(Socket socket, int key, Server server){
        this.server = server;
        this.socket = socket;
        this.key = key;
        inGame = false;

        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream((socket.getInputStream()));
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
                input = (String) in.readObject();
                if(input != null){
                    System.out.println(input);

                    switch (input){
                        case "idk":
                            break;

                            // start game with space
                        case " ":
                            startGame();
                            return;
                        default: System.out.println("Menu Input nicht vorhanden: " + input);
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
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
        String[] input = null;
        try {
            out.writeObject("sendInput");

            while (input == null) {
            input = ((String) in.readObject()).split("_");  // Movement Jump Ability
            }

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

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void sendGameData(int[][] map, ArrayList<Entity> entities){
        try {
            out.writeObject(map);
            out.writeObject(entities);
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
