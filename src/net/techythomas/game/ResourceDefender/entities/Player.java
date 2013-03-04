package net.techythomas.game.ResourceDefender.entities;

import java.util.ArrayList;

import net.techythomas.game.ResourceDefender.ResourceDefender;
import net.techythomas.game.ResourceDefender.World;
import net.techythomas.game.ResourceDefender.projectiles.Bullet;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;

public class Player {
	
	private World world;
	public static Rectangle rect;
	protected Rectangle frameSize;
	private static float width;
	private static float height;
	public static float defaultGround;
	public static float ground;
	public static float x = 30;
	public static float y = 30 ;
	private Image image;
	private float movementSpeed = 0.25f * 17;
	protected SpriteSheet sheet;
	private int animIndex;
	private int animCount;
	private int frame = 0;
	
	public static boolean allowMoveUp = true;
	public boolean allowMoveDown = true;
	public boolean allowMoveRight = true;
	public boolean allowMoveLeft = true;
	public int FACING = 3;
	
	public static boolean isJumping  = false;
	public boolean isColliding = false;
	public boolean isOnGround = false;
	public static boolean hasWeapon = false;
	public static ArrayList bullets;
	
	private float gravity = 0.6f;
	
	public Player(Image image, float width, float height) throws SlickException {
		this.image = image;
		this.width = width;
		this.height = height;
		rect = new Rectangle(x, y, width, height);
		frameSize = new Rectangle(x, y, width, height);
		bullets = new ArrayList();
		world = new World();
		defaultGround = world.getHeight() - (height + 25);
		ground = defaultGround;
		sheet = new SpriteSheet(new Image("res/spritesheets/player.png"), 70, 92);
		animCount = (int) (sheet.getWidth() / frameSize.getWidth());
	}
	
	public static ArrayList getBullets() {
		return bullets;
	}
	
	public static void fire() throws SlickException {
		Bullet bullet = new Bullet(rect.getX(), rect.getY());
		bullets.add(bullet);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}
	
	public void Animation(SpriteSheet frames, int duration) {
		
	}
	
	public void update(GameContainer container) throws SlickException {
		Input input = container.getInput();
		
		if (y >= defaultGround) {
			isOnGround = true;
			
		}
		else {
			isOnGround = false;
		}
		
		if (hasWeapon) {
			image = new Image("res/player_weapon.png");
		}
		
		if (y < ground) {
			//y += gravity;
		}
	
		if (isColliding) {
			if (FACING == 0) {
				allowMoveUp = false;
			}
			else if (FACING == 1) {
				allowMoveDown = false;
			}
			else if (FACING == 2) {
				allowMoveLeft = false;
			}
			else if (FACING == 3) {
				allowMoveRight = false;
			}
		}
		else {
			allowMoveUp = true;
			allowMoveDown = true;
			allowMoveLeft = true;
			allowMoveRight = true;
		}
		
		if ((input.isKeyDown(input.KEY_W) || input.isKeyDown(input.KEY_UP)) && (y > 20) && allowMoveUp) {
			setY(y -= movementSpeed);
			FACING = 0;
		}
		else if ((input.isKeyDown(input.KEY_S) || input.isKeyDown(input.KEY_DOWN)) && (y < ground) && allowMoveDown) {
			setY(y += movementSpeed);
			FACING = 1;
		}
		if ((input.isKeyDown(input.KEY_A) || input.isKeyDown(input.KEY_LEFT)) && (x > 20) && allowMoveLeft) {
			setX(x -= movementSpeed);
			FACING = 2;
		}
		else if ((input.isKeyDown(input.KEY_D) || input.isKeyDown(input.KEY_RIGHT)) && x < (container.getWidth() - (width + 20)) && allowMoveRight) {
			setX(x += movementSpeed);
			FACING = 3;
		}
		if (input.isKeyDown(input.KEY_LSHIFT)) {
			for (int frame = 0; frame < 4; frame++) {
				image = sheet.getSprite(frame, 1);
			}
		}
		else {
			
		}
		if (input.isKeyPressed(input.KEY_SPACE)) {
			if (hasWeapon) {
				
			}
			
		}
		
	}
	
	public static void setAllowMoveUp(boolean bool) {
		allowMoveUp = bool;
	}
	
	public static float getX() {
		return x;
	}
	
	public static float getMaxX() {
		return rect.getMaxX();
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
	
	public void render() throws SlickException {
		frame++;
		if (frame % 10 == 0) animIndex = ((animIndex + 1) % animCount);
		
		sheet.startUse();
		sheet.renderInUse((int) x, (int) y, animIndex, FACING);
		sheet.endUse();

		//image.draw(x, y, width, height);
	}

}
