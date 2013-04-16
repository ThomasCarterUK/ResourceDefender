package net.techythomas.game.ResourceDefender.text;

import org.newdawn.slick.geom.Point;

public class TextInfo extends TextScreen {
	
	private TextScreen text;
	
	public TextInfo() {
		text = new TextScreen();
	}
	
	public void drawText(String string, Point location) {
		text.drawText(string, location);
	}

}
