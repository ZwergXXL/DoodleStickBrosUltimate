package entities;

public class Entity {

	int id, length, height, x, y, xAcc, yAcc, xVel, yVel, maxVel, frameID;
	byte direction;
	
	
	Entity(int id, int x, int y, int height, int length, int xAcc , int yAcc, byte direction){
		
	}
	
	public void nextFrame() {
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setxAcc(int xAcc) {
		this.xAcc = xAcc;
	}

	public void setyAcc(int yAcc) {
		this.yAcc = yAcc;
	}

	public void setFrameID(int frameID) {
		this.frameID = frameID;
	}

	public void setDirection(byte direction) {
		this.direction = direction;
	}

}
