package net.techythomas.game.ResourceDefender;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import net.techythomas.game.ResourceDefender.controls.Keyboard;
import net.techythomas.game.ResourceDefender.entities.Player;
import net.techythomas.game.ResourceDefender.items.ItemGun;
import net.techythomas.game.ResourceDefender.items.ItemResource;
import net.techythomas.game.ResourceDefender.projectiles.Bullet;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class ResourceDefender extends BasicGame {
	
	private static int width = 1280;
	private static int height = 720;
	private static boolean fullscreen = false;
	
	private Rectangle rect;
	private Bullet bullet;
	private ItemResource resource;
	public int RESOURCE_COUNT = 0;
	private String RESOURCE_STRING = "Resources: ";
	
	private Player player;
	private World world;
	private LevelEditor editor;
	private Keyboard keyboard;
	
	//private ArrayList<Bullet> bullets;

    public ResourceDefender() {
        super("Resource Defender");
    }
    
    public boolean collidingWithWall() throws SlickException {
    	for (int i = 0; i < world.walls.size(); i++) {
    		Rectangle w = (Rectangle) world.walls.get(i);
    		if (player.getBounds().intersects(w)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public void checkCollisions() throws SlickException {
		if (collidingWithWall()) {
			player.isColliding = true;
		}
		else {
			player.isColliding = false;
		}
		
		for (int i = 0; i < world.resources.size(); i++) {
    		Rectangle r = (Rectangle) world.resources.get(i);
    		if (player.getBounds().intersects(r)) {
    			world.resources.remove(i);
    			RESOURCE_COUNT += 1;
    		}
    	}
		
		if (player.getBounds().intersects(world.workbench.getBounds())) {
			player.isInWorkbenchRadius = true;
			keyboard.e(this);
		}
		else {
			player.isInWorkbenchRadius = false;
		}
	}
    
    public void addWalls (World world, InputStream stream) {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
    	String line;
    	
    	try {
    		while ((line = reader.readLine()) != null) {
    			if (line.startsWith("#") || line.trim().length() < 1) continue;
    			String[] coords = line.split(" ", 4);
    			Rectangle rect = new Rectangle(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]), Integer.parseInt(coords[2]), Integer.parseInt(coords[3]));
    			world.addWalls(rect);
    		}
    	}
    	catch (IOException e) {
    		System.out.println("Couldn't load walls!");
    		e.printStackTrace();
    	}
    }
    
    public void addResources (World world, InputStream stream) {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
    	String line;
    	
    	try {
    		while ((line = reader.readLine()) != null) {
    			if (line.startsWith("#") || line.trim().length() < 1) continue;
    			String[] coords = line.split(" ", 2);
    			Rectangle rect = new Rectangle(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]), 32, 32);
    			world.addResources(rect);
    		}
    	}
    	catch (IOException e) {
    		System.out.println("Couldn't load resource items!");
    		e.printStackTrace();
    	}
    }
    
    @Override
    public void init(GameContainer container) throws SlickException {
    	player = new Player(new Image("res/player.png"), 70, 92);
    	world = new World();
    	rect = new Rectangle(player.getWidth(), player.getHeight(), player.getX(), player.getY());
    	editor = new LevelEditor();
    	bullet = new Bullet(player.getWidth() / 2, player.getHeight() / 2);
    	keyboard = new Keyboard(container, player);
    	
    	//bullets = player.getBullets();
    	container.getInput().addMouseListener(editor);
    	
    	addWalls(world, getClass().getResourceAsStream("walls.txt"));
    	addResources(world, getClass().getResourceAsStream("resources.txt"));
    	
    	//BufferedReader reader = new BufferedReader("res/collisions.txt");
    	//reader.readLine();
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
    	
    	ArrayList<Bullet> bullets = player.getBullets();
    	for (int w = 0; w < bullets.size(); w++) {
    		Bullet bullet = (Bullet) bullets.get(w);
    		if (bullet.getVisible() == true) {
    			bullet.update();
    		}
    		else
    			bullets.remove(w);
    	}
    	player.update(container);
    	checkCollisions();
    	//world.update(container);
    	
    	Input input= container.getInput();
    	if (world.allowDebugging()) {
    		if (input.isKeyDown(input.KEY_F5)) {
    			world.resources.clear();
    			addResources(world, getClass().getResourceAsStream("resources.txt"));
    			RESOURCE_COUNT = 0;
			}
    	}
    }

    
    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        world.render(g);
        
        ArrayList<Bullet> bullets = player.getBullets();
        for (int w = 0; w < bullets.size(); w++) {
        	Bullet bullet = bullets.get(w);
        	bullet.draw(bullet.getX(), bullet.getY());
        }
        
        player.render();
        
        g.setColor(Color.white);
        g.drawString(RESOURCE_STRING + RESOURCE_COUNT, 5, 5);
    }

    public static void main(String[] args) throws SlickException {
        
            AppGameContainer app = new AppGameContainer(new ResourceDefender());
            app.setDisplayMode(width, height, fullscreen);
            app.setTargetFrameRate(60);
            app.setShowFPS(false);
            app.setMaximumLogicUpdateInterval(17);
            app.setMinimumLogicUpdateInterval(17);
            app.start();
        
    }
}