import character.BetaBoy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Player extends Thread{

    final Socket socket;
    final int key;

    BufferedReader in;
    PrintWriter out;

    BetaBoy betaBoy;

    Player(Socket socket, int key){
        this.socket = socket;
        this.key = key;

        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }



        betaBoy = new BetaBoy();
    }

    @Override
    public void run() {
        inMenu();
    }

    void inMenu(){

    }



    void getInputData(){
        try {
            String[] input  = in.readLine().split("_");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
