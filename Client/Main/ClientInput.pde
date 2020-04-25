public class ClientInput{

	boolean[] keysPressed;
	
	ClientInput(){
		keysPressed = new boolean[5]; // W A S D Space
		for(int i = 0; i < keysPressed.length; i++){
	    keysPressed[i] = false;
		}
	}
}
