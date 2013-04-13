package net.techythomas.game.ResourceDefender.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Entity {
	
	private static float width;
	private static float height;
	private Image texture;
	protected SpriteSheet sheet;
	
	public Entity(Image image, float width, float height) {
		this.texture = image;
		this.width = width;
		this.height = height;
	}
	
	public void update(GameContainer container) throws SlickException {
		
	}
	
	public void render() throws SlickException {
		
	}

}
