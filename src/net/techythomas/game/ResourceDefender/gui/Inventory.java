package net.techythomas.game.ResourceDefender.gui;

import java.util.ArrayList;

import org.newdawn.slick.SlickException;

import net.techythomas.game.ResourceDefender.items.Item;

public class Inventory {
	
	private ArrayList<Item> items;
	private int MAX_SLOTS;
	private int size;
	
	public Inventory(int size) {
		items = new ArrayList<Item>();
		this.size = size;
		MAX_SLOTS = size;
	}
	
	public void add(Item item) {
		if (items.size() < MAX_SLOTS) {
			items.add(item);
			System.out.println(item.getName() + " was added to your inventory");
		}
	}
	
	public void remove(Item item) {
		items.remove(item);
		System.out.println(item.getName() + " was removed from your inventory");
	}
	
	public String get(int index) throws SlickException {
		return items.get(index).getName();
	}
	
	public ArrayList<Item> getItems() {
		return items;
	}
	
	public int getNumberOfItems() {
		return items.size();
	}
	
	public int getSize() {
		return size;
	}

}
