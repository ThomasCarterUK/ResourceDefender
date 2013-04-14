package net.techythomas.game.ResourceDefender;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Rectangle;

import net.techythomas.game.ResourceDefender.entities.Player;
import net.techythomas.game.ResourceDefender.items.*;

public class World {
	
	private float gravity = 0.7f;
	private Player player;
	private Image background;
	private boolean ALLOW_DEBUGGING = false;
	private float height = 720;
	private float width = 1280;
	
	private ItemResource resource;
	public Workbench workbench;
	
	public boolean allowMoveUp = true;
	
	public Rectangle rect;
	public Rectangle rect2;
	public Rectangle rect3;
	
	private Item item;
	private String itemName;
	
	public ArrayList<Rectangle> walls;
	public ArrayList<Rectangle> resources;
	public ArrayList<Item> worldItems;
	
	public World() throws SlickException {
		background = new Image("res/background.png");
		walls = new ArrayList<Rectangle>();
		resource = new ItemResource(0, 0);
		resources = new ArrayList<Rectangle>();
		worldItems = new ArrayList<Item>();
		workbench = new Workbench(1128, 373);
	}
	
	public boolean allowDebugging() {
		return ALLOW_DEBUGGING;
	}
	
	public void setDebugging(Boolean bool) {
		ALLOW_DEBUGGING = bool;
	}
	
	public Rectangle getWallBounds() {
		return new Rectangle(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
	}
	
	public Rectangle getResourceBounds() {
		return new Rectangle(rect2.getX(), rect2.getY(), rect2.getWidth(), rect2.getHeight());
	}
	
	public Rectangle getCollidedItemBounds() {
		return rect3;
	}
	
	public Item getCollidedItem() {
		return item;
	}
	
	public void addWalls(Rectangle rectangle) {
		walls.add(rectangle);
	}
	
	public void addResources(Rectangle rectangle) {
		resources.add(rectangle);
	}
	
	public void addResourcesFromFile (InputStream stream) {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
    	String line;
    	
    	try {
    		while ((line = reader.readLine()) != null) {
    			if (line.startsWith("#") || line.trim().length() < 1) continue;
    			String[] coords = line.split(" ", 2);
    			Rectangle rect = new Rectangle(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]), 32, 32);
    			addResources(rect);
    		}
    	}
    	catch (IOException e) {
    		System.out.println("Couldn't load resource items!");
    		e.printStackTrace();
    	}
    }
	
	public void addItem(Item item, Point point) {
		worldItems.add(item);
		item.setLocation(point);
		this.item = item;
	}
	
	public void removeItem(Item item) {
		worldItems.remove(item);
	}
	
	public void renderItems() {
		for (Item item : worldItems) {
			item.render();
		}
	}
	
	public ArrayList<Item> getItems() {
		return worldItems;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public float getHeight() {
		return height;
	}
	
	public void update(GameContainer container) {
		
	}	
	
	public void render(Graphics g) throws SlickException {
		background.draw();
		renderItems();
		workbench.render();
		
		if(ALLOW_DEBUGGING) {
			g.setColor(Color.blue);
			g.drawRect(player.rect.getX(), player.rect.getY(), player.rect.getWidth(), player.rect.getHeight());
			g.setColor(Color.magenta);
			g.draw(workbench.getBounds());
		}
			
			for (Rectangle rectangle : walls) {
				if (ALLOW_DEBUGGING) {
					g.setColor(Color.red);
					g.draw(rectangle);
				}
				this.rect = rectangle;
			}
			for (Rectangle rectangle : resources) {
				if (ALLOW_DEBUGGING) {
					g.setColor(Color.blue);
					g.draw(rectangle);
				}
				this.rect2 = rectangle;
				Image texture = new Image("res/items/resource.png");
				texture.draw(rectangle.getX(), rectangle.getY());
			}
			for (Item item : worldItems) {
				if (ALLOW_DEBUGGING) {
					g.setColor(Color.black);
					g.drawRect(item.getLocation().getX(), item.getLocation().getY(), item.getWidth(), item.getHeight());
				}
				this.rect3 = new Rectangle(item.getLocation().getX(), item.getLocation().getY(), item.getWidth(), item.getHeight());
				this.itemName = item.getName();
			}
			
		}
	
	}
