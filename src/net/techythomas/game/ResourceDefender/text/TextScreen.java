package net.techythomas.game.ResourceDefender.text;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Point;

public class TextScreen {
	
	private String text = "";
	private Point location;
	
	public TextScreen() {
		location = new Point(10, 10);
	}
	
	public void drawText(String string, Point location) {
		this.text = string;
		this.location = location;
	}
	
	public void render(GameContainer container) {
		Graphics graphics = container.getGraphics();
		graphics.setColor(Color.white);
		graphics.drawString(text, location.getX(), location.getY());
	}

}
