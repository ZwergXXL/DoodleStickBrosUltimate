import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerConnection {

  Socket socket;
  BufferedReader in;
  PrintWriter out;
  ClientInput clientInput;

  ServerConnection(ClientInput clientInput) {
    try {
      this.socket = new Socket("127.0.0.1", 12345);
      this.clientInput = clientInput;

      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      out = new PrintWriter(socket.getOutputStream(), true);
    } 
    catch (IOException e) {
      e.printStackTrace();
    }
  }


  // Sends Userinput to Server
  void sendUserInput() {
    boolean[] userInputs = clientInput.keysPressed;
    String[] input = new String[3];
    for (int i = 0; i < input.length; i++) {
      input[i] = "/";
    }

    //checks for jump
    if (userInputs[0]) { //W
      input[1] = "W";
    }

    // w a s d
    if (userInputs[2]) { //S
      input[0] = "S";
    } else if (!(userInputs[1]&&userInputs[3])) { //A
      if (userInputs[1]) {
        input[0] = "A";
      }
      if (userInputs[3]) {
        input[0] = "D";
      }
    }

    out.println(input[0] + "_" + input[1] + "_" + input[2]);
  }
  
  
  
  String readServerData()  throws IOException{
    String data = in.readLine();
    if(data == null){
      return readServerData();
    }
    return data;
  }
  
  void disconnect() {
    try {
      socket.close();
    }
    catch(IOException e) {
    }
  }
}
