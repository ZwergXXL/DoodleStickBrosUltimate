ClientInput clientInput;

void setup(){
  size(300, 300);
  background(0);
  clientInput = new ClientInput();
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
