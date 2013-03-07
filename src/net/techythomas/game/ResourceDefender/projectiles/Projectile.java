package net.techythomas.game.ResourceDefender.projectiles;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Projectile {
	
	private Image image;
	public float x;
	public float y;
	private boolean isVisible;
	private float projectileSpeed = 0.5f * 17;
	
	public Projectile(float startX, float startY) throws SlickException {
		this.x = startX;
		this.y = startY;
		image = new Image("res/bullet.png");
		isVisible = true;
	}
	
	public Image getImage() {
		return image;
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
		x += projectileSpeed;
	}

}
