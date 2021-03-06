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
	private float bulletSpeed = 0.35f * 17;
	private ProjectileDirection bulletDirection;
	
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
	
	public void setBulletDirection(ProjectileDirection direction) {
		this.bulletDirection = direction;
	}

	public void update() {
		x += bulletSpeed;
		if (x > 1280) {
			isVisible = false;
		}
		
		if (bulletDirection == ProjectileDirection.LEFT) {
			x -= bulletSpeed;
			//if (x < 0 - image.getWidth()) {
				//isVisible = false;
			//}
		}
		if (bulletDirection == ProjectileDirection.RIGHT) {
			x += bulletSpeed;
			if (x > 1280) {
				isVisible = false;
			}
		}
	}

}
