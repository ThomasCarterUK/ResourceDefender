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
	
	public static Rectangle rect;
	private Rectangle rect2;
	
	public ArrayList collisions;
	
	public World() throws SlickException {
		background = new Image("res/background.png");
		rect = new Rectangle(232, 578, 94, 10);
		rect2 = new Rectangle(480, 520, 90, 10);
	}
	
	public boolean allowDebugging() {
		return ALLOW_DEBUGGING;
	}
	
	public void addCollision(Rectangle rectangle) {
		collisions.add(rectangle);
	}
	
	public void update(GameContainer container) {
		
		
	}	
	
	public void render(Graphics g) {
		background.draw();
		
		if(ALLOW_DEBUGGING) {
			g.setColor(Color.white);
			g.drawRect(player.getX(), player.getY(), player.getWidth(), player.getHeight());
			g.drawRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
			g.drawRect(rect2.getX(), rect2.getY(), rect2.getWidth(), rect2.getHeight());
		}
	}

}
