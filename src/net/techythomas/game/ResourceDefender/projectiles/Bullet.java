package net.techythomas.game.ResourceDefender.projectiles;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Bullet {
	
	private Image image;
	public float x;
	private float y;
	private boolean isVisible;
	private float bulletSpeed = 0.5f * 17;
	
	public Bullet(float x, float y) throws SlickException {
		image = new Image("res/bullet.png");
		this.x = x;
		this.y = y;
		isVisible = true;
	}
	
	public Image getImage() {
		return image;
	}
	
	public void draw(float x, float y) {
		image.draw(x, y);
	}
	
	public void drawFlipped(GameContainer container, float x, float y) {
		Graphics g = container.getGraphics();
		g.drawImage(image.getFlippedCopy(true, false), x, y);
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
		if (x > 1280) {
			isVisible = false;
		}
	}

}
