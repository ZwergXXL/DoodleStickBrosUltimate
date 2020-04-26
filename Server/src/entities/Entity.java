package entities;

public class Entity {

	int id, length, height, x, y, frameID;
	double xAcc, yAcc, xVel, yVel, maxVel;
	byte direction;
	

	public Entity(int id, int length, int height, int x, int y, double xAcc, double yAcc, double xVel, double yVel, double maxVel) {
		this.id = id;
		this.length = length;
		this.height = height;
		this.x = x;
		this.y = y;
		this.xAcc = xAcc;
		this.yAcc = yAcc;
		this.xVel = xVel;
		this.yVel = yVel;
		this.maxVel = maxVel;
	}

	public Entity(int id, int length, int height, int x, int y, int xAcc, int yAcc, int xVel, int yVel, int maxVel, int frameID, byte direction) {
		this.id = id;
		this.length = length;
		this.height = height;
		this.x = x;
		this.y = y;
		this.xAcc = xAcc;
		this.yAcc = yAcc;
		this.xVel = xVel;
		this.yVel = yVel;
		this.maxVel = maxVel;
		this.frameID = frameID;
		this.direction = direction;
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
