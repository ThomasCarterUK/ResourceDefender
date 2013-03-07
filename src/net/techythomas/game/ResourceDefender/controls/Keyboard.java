package net.techythomas.game.ResourceDefender.controls;

import net.techythomas.game.ResourceDefender.entities.Player;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

public class Keyboard {
	
	private Player player;
	private Input input;
	private float movementSpeed = 0.25f * 17;
	private GameContainer container;
	
	public Keyboard(GameContainer container, Player player) {
		input = container.getInput();
		this.player = player;
		this.container = container;
	}
	
	public void up() {
		if ((input.isKeyDown(input.KEY_W) || input.isKeyDown(input.KEY_UP)) && (player.y > 20) && player.allowMoveUp) {
			player.setY(player.y -= movementSpeed);
			player.animType = player.ANIM_TYPE_WALKING_FU;
		}
	}
	
	public void down() {
		if ((input.isKeyDown(input.KEY_S) || input.isKeyDown(input.KEY_DOWN)) && (player.y < player.ground) && player.allowMoveDown) {
			player.setY(player.y += movementSpeed);
			player.animType = player.ANIM_TYPE_WALKING_FD;
		}
	}
	
	public void left() {
		if ((input.isKeyDown(input.KEY_A) || input.isKeyDown(input.KEY_LEFT)) && (player.x > 20) && player.allowMoveLeft) {
			player.setX(player.x -= movementSpeed);
			player.animType = player.ANIM_TYPE_WALKING_FL;
		}
	}
	
	public void right() {
		if ((input.isKeyDown(input.KEY_D) || input.isKeyDown(input.KEY_RIGHT)) && player.x < 
				(container.getWidth() - (player.width + 20)) && player.allowMoveRight) {
			player.setX(player.x += movementSpeed);
			player.animType = player.ANIM_TYPE_WALKING_FR;
		}
	}

}
