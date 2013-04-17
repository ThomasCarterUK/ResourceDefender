package net.techythomas.game.ResourceDefender.items;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Point;

public class Item {
	
	protected Image texture;
	private String name;
	private Point location;
	
	public Item(Image texture, String name) {
		this.texture = texture;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setLocation(Point location) {
		this.location = location;
	}
	
	public Point getLocation() {
		return location;
	}
	
	public float getWidth() {
		return texture.getWidth();
	}
	
	public float getHeight() {
		return texture.getHeight();
	}
	
	public void render(GameContainer container) {
		float yBobbing = (float) Math.sin(container.getTime() / 1000f * 6);
		texture.draw(location.getX(), location.getY() + yBobbing, texture.getWidth(), texture.getHeight());
	}

}
