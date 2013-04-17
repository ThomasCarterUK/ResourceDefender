package net.techythomas.game.ResourceDefender.items;

import net.techythomas.game.ResourceDefender.ResourceDefender;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class ItemResource {
	
	private Image texture;
	private Rectangle rect;
	
	public ItemResource(float x, float y) throws SlickException {
		this.texture = new Image("res/items/resource.png");
		this.rect = new Rectangle(x, y, texture.getWidth(), texture.getHeight());
	}
	
	public void render() {
		texture.draw(rect.getX(), rect.getY());
	}
	
	public Rectangle getBounds() {
		return rect;
	}
	
	public void setX(float x) {
		rect.setX(x);
	}
	
	public void setY(float y) {
		rect.setY(y);
	}

}
