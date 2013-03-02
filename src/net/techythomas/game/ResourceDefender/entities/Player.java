package net.techythomas.game.ResourceDefender.entities;

import java.util.ArrayList;

import net.techythomas.game.ResourceDefender.control.Keyboard;
import net.techythomas.game.ResourceDefender.projectiles.Bullet;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Player {
	
	private Keyboard keyboard;
	public static Rectangle rect;
	private static float width;
	private static float height;
	public static float ground;
	public static float x;
	public static float y;
	private Image image;
	private float movementSpeed = 0.7f;
	
	public static boolean isJumping  = false;
	public boolean isColliding = false;
	public static boolean hasWeapon = true;
	public static ArrayList bullets;
	
	private float gravity = 0.6f;
	
	public Player(Image image, float width, float height) {
		this.image = image;
		this.width = width;
		this.height = height;
		rect = new Rectangle(width, height, x, y);
		bullets = new ArrayList();
		keyboard = new Keyboard();
	}
	
	public static ArrayList getBullets() {
		return bullets;
	}
	
	public static void fire() throws SlickException {
		Bullet bullet = new Bullet(rect.getX(), rect.getY());
		bullets.add(bullet);
	}
	
	public void update(GameContainer container) throws SlickException {
		Input input = container.getInput();
		
		ground = container.getHeight() - (height + 35);
		
		if (hasWeapon) {
			image = new Image("res/player_weapon.png");
		}
		
		if (y < ground) {
			y += gravity;
		}
		
		if (y >= ground || isColliding) {
			isJumping = false;
		}
		
		if ((input.isKeyDown(input.KEY_W) || input.isKeyDown(input.KEY_UP) || input.isControllerUp(0)) && y > 0) {
			setY(y -= (movementSpeed + 0.6f));
			isJumping = true;
		}
		else if ((input.isKeyDown(input.KEY_S) || input.isKeyDown(input.KEY_DOWN)) && y < ground) {
			setY(y += movementSpeed);
		}
		if ((input.isKeyDown(input.KEY_A) || input.isKeyDown(input.KEY_LEFT)) && x > 0) {
			setX(x -= movementSpeed);
		}
		else if ((input.isKeyDown(input.KEY_D) || input.isKeyDown(input.KEY_RIGHT)) && x < (container.getWidth() - width)) {
			setX(x += movementSpeed);
		}
		if (input.isKeyPressed(input.KEY_SPACE)) {
			if (hasWeapon) {
				fire();
			}
			
		}
	}
	
	public static float getX() {
		return x;
	}
	
	public static float getY() {
		return y;
	}
	
	public static float getWidth() {
		return width;
	}
	
	public static float getHeight() {
		return height;
	}
	
	public static void setX(float x) {
		rect.setX(x);
	}
	
	public static void setY(float y) {
		rect.setY(y);
	}
	
	public void render() {
		image.draw(x, y);
	}
	
	

}
