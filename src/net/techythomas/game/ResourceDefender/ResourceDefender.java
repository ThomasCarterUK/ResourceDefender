package net.techythomas.game.ResourceDefender;

import java.io.BufferedReader;
import java.util.ArrayList;

import net.techythomas.game.ResourceDefender.control.Keyboard;
import net.techythomas.game.ResourceDefender.entities.Player;
import net.techythomas.game.ResourceDefender.projectiles.Bullet;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.geom.Rectangle;

public class ResourceDefender extends BasicGame {
	
	private static int width = 1280;
	private static int height = 720;
	private static boolean fullscreen = false;
	
	private Rectangle rect;
	private Bullet bullet;
	
	private Player player;
	private World world;
	private LevelEditor editor;
	private Keyboard keyboard;

    public ResourceDefender() {
        super("Resource Defender");
    }
    
    public void checkCollisions() {
		
	}
    
    @Override
    public void init(GameContainer container) throws SlickException {
    	player = new Player(new Image("res/player.png"), 80, 112);
    	world = new World();
    	rect = new Rectangle(player.getWidth(), player.getHeight(), player.getX(), player.getY());
    	editor = new LevelEditor();
    	bullet = new Bullet(player.getX(), player.getWidth());
    	keyboard = new Keyboard();
    	container.getInput().addMouseListener(editor);
    	
    	//BufferedReader reader = new BufferedReader("res/collisions.txt");
    	//reader.readLine();
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
    	ArrayList bullets = player.getBullets();
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
    	
    	
    }

    
    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        world.render(g);
        player.render();
        
        ArrayList bullets = player.getBullets();
        for (int w = 0; w < bullets.size(); w++) {
        	Bullet bullet = (Bullet) bullets.get(w);
        	bullet.draw(50, 30);
        }
    }

    public static void main(String[] args) throws SlickException {
        
            AppGameContainer app = new AppGameContainer(new ResourceDefender());
            app.setDisplayMode(width, height, fullscreen);
            app.setTargetFrameRate(60);
            app.setMaximumLogicUpdateInterval(3);
            app.setMinimumLogicUpdateInterval(3);
            app.start();
        
    }
}