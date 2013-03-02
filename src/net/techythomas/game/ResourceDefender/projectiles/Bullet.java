package net.techythomas.game.ResourceDefender.projectiles;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Bullet {
	
	private Image image;
	private float x;
	private float y;
	private boolean isVisible;
	private float bulletSpeed = 0.5f;
	
	public Bullet(float x, float y) throws SlickException {
		image = new Image("res/bullet.png");
		this.x = x;
		this.y = y;
		isVisible = true;
	}
	
	public void draw(float x, float y) {
		image.draw(x, y);
	}
	
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public boolean getVisible() {
		return isVisible;
	}

	public void update() {
		x += bulletSpeed;
		
	}

}
