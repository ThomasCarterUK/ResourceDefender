package net.techythomas.game.ResourceDefender.entities;

import java.util.ArrayList;

import net.techythomas.game.ResourceDefender.World;
import net.techythomas.game.ResourceDefender.controls.Keyboard;
import net.techythomas.game.ResourceDefender.gui.Inventory;
import net.techythomas.game.ResourceDefender.projectiles.Bullet;
import net.techythomas.game.ResourceDefender.projectiles.Projectile;
import net.techythomas.game.ResourceDefender.projectiles.ProjectileDirection;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;

public class Player extends Entity {
	
	private World world;
	public static Rectangle rect;
	protected Rectangle frameSize;
	public static float width;
	private static float height;
	public static float defaultGround;
	public static float ground;
	public static float x = 30;
	public static float y = 30 ;
	private Image image;
	public float movementSpeed = 0.25f * 17;
	protected SpriteSheet sheet;
	private Keyboard keyboard;
	public Inventory inventory;
	
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
	
	public static boolean isJumping  = false;
	public boolean isColliding = false;
	public boolean isOnGround = false;
	public boolean isInWorkbenchRadius = false;
	public static boolean hasWeapon = false;
	public static ArrayList<Bullet> bullets;
	public static ArrayList<Projectile> projectiles;
	
	private float gravity = 0.6f;
	
	public Player(Image image, float width, float height) throws SlickException {
		super(image, width, height);
		rect = new Rectangle(x + 10, y + 10, width - 20, height - 20);
		frameSize = new Rectangle(x, y, width, height);
		bullets = new ArrayList<Bullet>();
		projectiles = new ArrayList<Projectile>();
		world = new World();
		defaultGround = world.getHeight() - (height + 25);
		ground = defaultGround;
		sheet = new SpriteSheet(new Image("res/spritesheets/player.png"), 70, 92);
		animCount = (int) (sheet.getWidth() / frameSize.getWidth());
		inventory = new Inventory(20);
	}
	
	public static ArrayList<Bullet> getBullets() {
		return bullets;
	}
	
	public static ArrayList<Projectile> getProjectiles() {
		return projectiles;
	}
	
	public static void fireBullet(ProjectileDirection direction) throws SlickException {
		Bullet bullet = new Bullet(getX() + (getWidth() / 2), getY() + (getHeight() / 2));
		bullets.add(bullet);
		bullet.setBulletDirection(direction);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
	}
	
	public void update(GameContainer container) throws SlickException {
		keyboard = new Keyboard(container, this);
		
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
			if (animType == ANIM_TYPE_WALKING_FU) {
				allowMoveUp = false;
			}
			else if (animType == ANIM_TYPE_WALKING_FD) {
				allowMoveDown = false;
			}
			else if (animType == ANIM_TYPE_WALKING_FL) {
				allowMoveLeft = false;
			}
			else if (animType == ANIM_TYPE_WALKING_FR) {
				allowMoveRight = false;
			}
			keyboard.ctrl();
		}
		else {
			allowMoveUp = true;
			allowMoveDown = true;
			allowMoveLeft = true;
			allowMoveRight = true;
		}
		
		keyboard.up();
		keyboard.down();
		keyboard.left();
		keyboard.right();
		keyboard.space();
		keyboard.q();
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
		rect.setX(x + 10);
	}
	
	public static void setY(float y) {
		rect.setY(y + 10);
	}
	
	public void render() throws SlickException {
		frame++;
		if (frame % 10 == 0) animIndex = ((animIndex + 1) % animCount);
		
		sheet.startUse();
		sheet.renderInUse((int) x, (int) y, animIndex, animType);
		sheet.endUse();

		//image.draw(x, y, width, height);
	}

}
