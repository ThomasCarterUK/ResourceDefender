package net.techythomas.game.ResourceDefender.items;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class ItemResource {
	
	private float x;
	private float y;
	private Image texture;
	private Rectangle rect;
	
	public ItemResource(float x, float y) throws SlickException {
		this.x = x;
		this.y = y;
		this.texture = new Image("res/items/resource.png");
		this.rect = new Rectangle(x, y, texture.getWidth(), texture.getHeight());
	}
	
	public void render(Graphics g) {
		texture.draw(x, y);
		g.setColor(Color.blue);
		g.draw(rect);
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}

}
