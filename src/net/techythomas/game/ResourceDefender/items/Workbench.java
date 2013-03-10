package net.techythomas.game.ResourceDefender.items;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Workbench {
	
	private Image texture;
	private Rectangle rect;
	private float x;
	private float y;
	
	public Workbench(float x, float y) throws SlickException {
		this.texture = new Image("/res/items/workbench.png");
		this.x = x;
		this.y = y;
		this.rect = new Rectangle(x - 25, y - 25, texture.getWidth() + 50, texture.getHeight() + 50);
	}
	
	public Rectangle getBounds() {
		return rect;
	}
	
	public void render() {
		texture.draw(x, y);
	}

}
