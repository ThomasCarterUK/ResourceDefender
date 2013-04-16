package net.techythomas.game.ResourceDefender.controls;

import net.techythomas.game.ResourceDefender.ResourceDefender;
import net.techythomas.game.ResourceDefender.entities.Player;
import net.techythomas.game.ResourceDefender.items.Item;
import net.techythomas.game.ResourceDefender.items.ItemGun;
import net.techythomas.game.ResourceDefender.items.ItemSword;
import net.techythomas.game.ResourceDefender.projectiles.ProjectileDirection;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Keyboard {
	
	private Player player;
	private Input input;
	private float movementSpeed = 0.35f * 17;
	private GameContainer container;
	
	public Keyboard(GameContainer container, Player player) {
		input = container.getInput();
		this.player = player;
		this.container = container;
	}
	
	public void up() {
		if ((input.isKeyDown(Input.KEY_W) || input.isKeyDown(Input.KEY_UP)) && (Player.y > 20) && Player.allowMoveUp) {
			Player.setY(Player.y -= movementSpeed);
			player.animType = player.ANIM_TYPE_WALKING_FU;
		}
	}
	
	public void down() {
		if ((input.isKeyDown(Input.KEY_S) || input.isKeyDown(Input.KEY_DOWN)) && (Player.y < Player.ground) && player.allowMoveDown) {
			Player.setY(Player.y += movementSpeed);
			player.animType = player.ANIM_TYPE_WALKING_FD;
		}
	}
	
	public void left() {
		if ((input.isKeyDown(Input.KEY_A) || input.isKeyDown(Input.KEY_LEFT)) && (Player.x > 20) && player.allowMoveLeft) {
			Player.setX(Player.x -= movementSpeed);
			player.animType = player.ANIM_TYPE_WALKING_FL;
		}
	}
	
	public void right() {
		if ((input.isKeyDown(Input.KEY_D) || input.isKeyDown(Input.KEY_RIGHT)) && Player.x < 
				(container.getWidth() - (Player.width + 20)) && player.allowMoveRight) {
			Player.setX(Player.x += movementSpeed);
			player.animType = player.ANIM_TYPE_WALKING_FR;
		}
	}
	
	public void e(ResourceDefender game) throws SlickException {
		if (player.isInWorkbenchRadius) {
			if (input.isKeyPressed(Input.KEY_E)) {
				if (game.RESOURCE_COUNT >= 10) {
					ItemGun gun = new ItemGun();
					ItemSword sword = new ItemSword();
					player.inventory.add(gun);
					player.inventory.add(sword);
					game.RESOURCE_COUNT -= 10;
					Player.hasWeapon = true;
				}
				System.out.println("Crafting");
			}
		}
	}
	
	public void q() throws SlickException {
		if (input.isKeyPressed(Input.KEY_Q)) {
			if (player.inventory.getNumberOfItems() > 0) {
				for (Item item : player.inventory.getItems()) {
					System.out.println(item.getName());
				}
			}
		}
	}
	
	public void ctrl() {
		if (input.isKeyDown(Input.KEY_LCONTROL)) {
			if (player.animType == player.ANIM_TYPE_WALKING_FU) Player.setY(Player.y -=20);
			if (player.animType == player.ANIM_TYPE_WALKING_FD) Player.setY(Player.y += 20);
			if (player.animType == player.ANIM_TYPE_WALKING_FL) Player.setX(Player.x -= 20);
			if (player.animType == player.ANIM_TYPE_WALKING_FR) Player.setX(Player.x += 20);
		}
	}
	
	public void space() throws SlickException {
		if (input.isKeyPressed(Input.KEY_SPACE)) {
			if (player.hasWeapon) {
				if (player.animType == player.ANIM_TYPE_WALKING_FL) {
					player.fireBullet(ProjectileDirection.LEFT);
				}
				if (player.animType == player.ANIM_TYPE_WALKING_FR) {
					player.fireBullet(ProjectileDirection.RIGHT);
				}
			}
		}
	}

}
