package at.fhv.sma.draw;

import java.awt.Canvas;
import java.awt.Graphics;

/**
 * Reprents a panel/canvas to draw the tree on.
 * 
 * @author Sebastian Malin
 *
 */
public class TreePanel extends Canvas {

	private static final long serialVersionUID = 1L;
	
	private Integer[] _seqTree;
	private Node2D[] _nodes;
	
	/**
	 * Uses a sequential tree represented by an array to calculated and draw the tree.
	 * 
	 * @param seqTree an array representing a sequential binary tree
	 * @param width the width of the panel to draw on.
	 */
	public TreePanel(Integer[] seqTree, int width) {
		_seqTree = seqTree;
		_nodes = new Node2D[_seqTree.length];
		calculate(width);
	}
	
	/**
	 * Calculates the coordinates of every Node.
	 * Iterates through the given sequential tree.
	 * 
	 * First the level is calculated with the index of the node value in the sequential tree represented by an array.
	 * 
	 * level = ld(index)+1
	 * 
	 * The level is used to calculate the factor to multiply with the given with.
	 * 
	 * factor = powerOf(2, level)
	 * 
	 * - factor for root is 1/2
	 * - factor for the next level is 1/4
	 * - factor for the 3rd level is 1/8
	 * - etc.
	 * 
	 * The x value of the node depends on the x value of its parent node.
	 * The algorithm checks if the node is the left or the right child of, its parent node by a modulo operation with 2.
	 * 
	 * left childnode: index mod 2 == 0
	 * right childnode: index mod 2 != 0
	 * 
	 * Now calculate the x value:
	 * 
	 * left childnode: substract the delta x value from the x-value of its parent
	 * right childnode: add the delta x value to the x-value of its parent
	 * 
	 * Now calculate the y value:
	 * 
	 * The y value depends on the y value of its parent node. The radius is given in the Node2D class.
	 * 
	 * y = parent.Y + (4 * radius)
	 *
	 * 
	 * @param width the width of the panel/canvas to draw on
	 */
	private void calculate(int width) {
		int w = width;
		_nodes[1] = new Node2D(((int) (w/2)), (Node2D.radius + 2), _seqTree[1]);
		int deltaX = 0;
		int x = 0;
		int y = 0;
		
		for(int i = 2; i < _seqTree.length; i++) {
			if(_seqTree[i] != null) {
				deltaX = w * 1/((int)(Math.pow(2, ((int)(Math.log10(i)/Math.log10(2))) + 1)));
				if((i%2) == 0) {
					x = _nodes[i/2].getX() - deltaX;
				} else {
					x = _nodes[i/2].getX() + deltaX;
				}
				y = _nodes[i/2].getY() + (4 * Node2D.radius);
				_nodes[i] = new Node2D(x, y, _seqTree[i]);
			}
		}
		
	}
	
	/**
	 * First the edges are drawn from every childnode to its parent.
	 * Afterwards the nodes draw the self, by iterating through the array with the 2D Nodes calculated before.
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		// draw edges
		for(int i = 2; i < _nodes.length; i++) {
			int parent = 0;
			if(_nodes[i] != null) {
				parent = i/2;
				g.drawLine(_nodes[i].getX(), _nodes[i].getY(), _nodes[parent].getX(), _nodes[parent].getY());
			}
			
		}
		
		// draw nodes
		for(Node2D n : _nodes) {
			if(n != null) {
				n.paint(g);
			}
		}
	}
	
	

}
