ClientInput clientInput;
ServerConnection serverConnection;



void setup(){
  fullScreen();
  //size(1920,1080); 
  background(255);
  
  //clientInput = new ClientInput();
  //serverConnection = new ServerConnection(clientInput);
  
  new Map();
}

void draw(){
 
}





void keyPressed(){
  switch(keyCode){
    case 87: clientInput.keysPressed[0] = true; //W
    break;
    case 65: clientInput.keysPressed[1] = true; //A
    break;
    case 83: clientInput.keysPressed[2] = true; //S
    break;
    case 68: clientInput.keysPressed[3] = true; //D
    break;
    default: println(keyCode);
  }
}

void keyReleased(){
  switch(keyCode){
    case 87: clientInput.keysPressed[0] = false; //W
    break;
    case 65: clientInput.keysPressed[1] = false; //A
    break;
    case 83: clientInput.keysPressed[2] = false; //S
    break;
    case 68: clientInput.keysPressed[3] = false; //D
    break;
    default: println(keyCode);
  }
}
