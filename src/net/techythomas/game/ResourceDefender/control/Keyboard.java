package net.techythomas.game.ResourceDefender.control;

import net.techythomas.game.ResourceDefender.entities.Player;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Keyboard {
	
	private float movementSpeed = 0.7f;
	public static float x;
	public static float y;
	public static float ground;
	
	public Keyboard() {
		
	}
	
	public void getInput(GameContainer container, Player player) throws SlickException {
		Input input = container.getInput();
		
		ground = container.getHeight() - (player.getHeight() + 35);
		
		if ((input.isKeyDown(input.KEY_W) || input.isKeyDown(input.KEY_UP)) && y > 0) {
			player.setY(y -= movementSpeed);
			player.isJumping = true;
		}
		else if ((input.isKeyDown(input.KEY_S) || input.isKeyDown(input.KEY_DOWN)) && y < ground) {
			player.setY(y += movementSpeed);
		}
		if ((input.isKeyDown(input.KEY_A) || input.isKeyDown(input.KEY_LEFT)) && x > 0) {
			player.setX(x -= movementSpeed);
		}
		else if ((input.isKeyDown(input.KEY_D) || input.isKeyDown(input.KEY_RIGHT)) && x < (container.getWidth() - player.getWidth())) {
			player.setX(x += movementSpeed);
		}
		if (input.isKeyPressed(input.KEY_SPACE)) {
			if (player.hasWeapon) {
				player.fire();
			}
			
		}
	}

}
