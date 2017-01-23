package hue04hue05.BinaereBaum.hue05;

import java.awt.Color;
import java.awt.Graphics;

import hue04hue05.BinaereBaum.hue04.Node;

public class NodeRepresentation<T extends Comparable<T>> {

public static final int radius =25;

private int _xCoordinate=0;
private int _yCoordinate=0;
private Node<T> _node;



public NodeRepresentation(int xCoordinate, int yCoordinate, Node<T> node){
	_xCoordinate=xCoordinate;
	_yCoordinate=yCoordinate;
	_node = node;
}

public void paint(Graphics g) {
	g.setColor(Color.WHITE);
	g.fillOval(_xCoordinate-radius, _yCoordinate-radius, radius*2, radius*2);
	g.setColor(Color.BLACK);
	g.drawOval(_xCoordinate-radius, _yCoordinate-radius, radius*2, radius*2);
	g.drawString(_node.getData().toString(), _xCoordinate-4, _yCoordinate+4);
}


public int get_yCoordinate() {
	return _yCoordinate;
}

public void set_yCoordinate(int _yCoordinate) {
	this._yCoordinate = _yCoordinate;
}

public Node<T> get_node() {
	return _node;
}

public void set_node(Node<T> _node) {
	this._node = _node;
}

public static int getRadius() {
	return radius;
}

public int get_xCoordinate() {
	return _xCoordinate;
}

public void set_xCoordinate(int _xCoordinate) {
	this._xCoordinate = _xCoordinate;
}

public Integer get_value(Node<Integer> node) {
	return node.getData();
}

public Integer set_value(Node<Integer> _node) {
return _node.getData();
}
	
}
