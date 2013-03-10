package net.techythomas.game.ResourceDefender.items;

import org.newdawn.slick.Image;

public class Item {
	
	private Image texture;
	private String name;
	
	public Item(Image texture, String name) {
		this.texture = texture;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

}
