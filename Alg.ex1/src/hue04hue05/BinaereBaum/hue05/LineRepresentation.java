package hue04hue05.BinaereBaum.hue05;

import java.awt.Color;
import java.awt.Graphics;

public class LineRepresentation {
	int startX;
	int startY;
	int endX;
	int endY;
	
	public LineRepresentation(int startX, int startY, int endX, int endY)
	{
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawLine(startX, startY, endX, endY);
	}
}
