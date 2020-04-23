import processing.net.*; 


ClientInput clientInput;

void setup(){
  size(300, 300);
  background(0);
  clientInput = new ClientInput();


  /**** Connect to Server ****/
  Client socket = new Client(this, "127.0.0.1", 12345);
}

void draw(){
}

void keyPressed(){
  switch(keyCode){
    case 87: clientInput.keysPressed[0] = true; //W
    break;
    case 65: clientInput.keysPressed[0] = true; //A
    break;
    case 83: clientInput.keysPressed[0] = true; //S
    break;
    case 68: clientInput.keysPressed[0] = true; //D
    break;
    default: println(keyCode);
  }
}

void keyReleased(){
  switch(keyCode){
    case 87: clientInput.keysPressed[0] = false; //W
    break;
    case 65: clientInput.keysPressed[0] = false; //A
    break;
    case 83: clientInput.keysPressed[0] = false; //S
    break;
    case 68: clientInput.keysPressed[0] = false; //D
    break;
    default: println(keyCode);
  }
}
