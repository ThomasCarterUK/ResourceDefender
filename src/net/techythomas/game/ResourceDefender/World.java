package net.techythomas.game.ResourceDefender;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import net.techythomas.game.ResourceDefender.entities.Player;

public class World {
	
	private float gravity = 0.7f;
	private Player player;
	private Image background;
	private boolean ALLOW_DEBUGGING = true;
	private float height = 720;
	private float width = 1280;
	
	public static Rectangle rect;
	private Rectangle rect2;
	
	public ArrayList walls;
	
	public World() throws SlickException {
		background = new Image("res/background.png");
		rect = new Rectangle(133, 119, 280, 20);
		rect2 = new Rectangle(393, 139, 20, 90);
	}
	
	public boolean allowDebugging() {
		return ALLOW_DEBUGGING;
	}
	
	public void addCollision(Rectangle rectangle) {
		walls.add(rectangle);
	}
	
	public float getHeight() {
		return height;
	}
	
	public void update(GameContainer container) {
		
		
	}	
	
	public void render(Graphics g) {
		background.draw();
		
		if(ALLOW_DEBUGGING) {
			g.setColor(Color.black);
			g.drawRect(player.getX(), player.getY(), player.getWidth(), player.getHeight());
			g.draw(rect);
			g.draw(rect2);
		}
	}

}
