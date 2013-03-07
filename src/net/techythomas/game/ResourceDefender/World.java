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
	
	public boolean allowMoveUp = true;
	
	public Rectangle rect;
	
	public ArrayList<Rectangle> walls;
	
	public World() throws SlickException {
		background = new Image("res/background.png");
		walls = new ArrayList<Rectangle>();
	}
	
	public boolean allowDebugging() {
		return ALLOW_DEBUGGING;
	}
	
	public Rectangle getWallBounds() {
		return new Rectangle(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
	}
	
	public void addWalls(Rectangle rectangle) {
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
			g.setColor(Color.blue);
			g.drawRect(player.getX(), player.getY(), player.getWidth(), player.getHeight());
			
			for (Rectangle rectangle : walls) {
				g.setColor(Color.red);
				g.draw(rectangle);
				this.rect = rectangle;
			}
			
		}
	}

}
