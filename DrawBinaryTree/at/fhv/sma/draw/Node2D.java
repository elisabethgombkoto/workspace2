package at.fhv.sma.draw;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Represents a 2D TreeNode.
 * 
 * @author Sebastian Malin
 *
 */
public class Node2D {
	
	public static final int radius = 20;
	
	private int _x = 0;
	private int _y = 0;
	private Integer _value = 0;
	
	public Node2D(int x, int y, int value) {
		_x = x;
		_y = y;
		_value = value;
	}
	
	public int getX() {
		return _x;
	}
	
	public void setX(int value) {
		_x = value;
	}
	
	public Integer getY() {
		return _y;
	}
	
	public void setY(int value) {
		_y = value;
	}
	
	public Integer getValue() {
		return _value;
	}
	
	/**
	 * A method to draw the Node on a Canvas/Panel.
	 * 
	 * @param g a graphics object to draw with
	 */
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval(_x-radius, _y-radius, radius*2, radius*2);
		g.setColor(Color.BLACK);
		g.drawOval(_x-radius, _y-radius, radius*2, radius*2);
		g.drawString(Integer.toString(_value), _x-4, _y+4);
	}
	
}
