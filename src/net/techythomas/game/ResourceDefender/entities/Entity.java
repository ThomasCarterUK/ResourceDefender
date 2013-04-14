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
	
	private int animIndex;
	private int animCount;
	public int animType;
	private int frame = 0;
	public int ANIM_TYPE_WALKING_FU = 0;
	public int ANIM_TYPE_WALKING_FD = 1;
	public int ANIM_TYPE_WALKING_FL = 2;
	public int ANIM_TYPE_WALKING_FR = 3;
	
	public static boolean allowMoveUp = true;
	public boolean allowMoveDown = true;
	public boolean allowMoveRight = true;
	public boolean allowMoveLeft = true;
	
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
