package hue04hue05.BinaereBaum.hue05;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import hue04hue05.BinaereBaum.hue04.Node;
import hue04hue05.BinaereBaum.hue04.Tree;

public class TreePanel<T extends Comparable<T>> extends Canvas {

	private static final long serialVersionUID = 4058237464335945043L;
	private Tree<T> _tree;
	private int deltaY;

	private List<NodeRepresentation<T>> nodes;
	private List<LineRepresentation> lines;

	public TreePanel(Tree<T> tree, Dimension size) {
		_tree = tree;
		deltaY = (int) size.getHeight() / (tree.heightOfTree() + 1);
		setMinimumSize(size);
		setSize(size);
		prepareRepresentation();
		//paint wird von alleine ausgeführt
	}

	private void prepareRepresentation() {
		if(_tree==null)
			return;
		nodes = new LinkedList<NodeRepresentation<T>>();
		lines = new LinkedList<LineRepresentation>();

		prepareRepresentations(_tree.get_root(), 0, this.getWidth(), deltaY);
	}

	private void prepareRepresentations(Node<T> node, int lowerBound, int upperBound, int Y) {
		if (node == null) {
			return;
		}
		int X = (upperBound - lowerBound) / 2 + lowerBound;
		nodes.add(new NodeRepresentation<T>(X, Y, node));

		int nextY = Y + deltaY;
		int nextX = 0;
		if (node.get_leftChild() != null) {
			nextX = (X-lowerBound)/2+lowerBound;
			lines.add(new LineRepresentation(X, Y, nextX, nextY));
			prepareRepresentations(node.get_leftChild(), lowerBound, X, nextY);
		}
		if (node.get_rightChild() != null) {
			nextX = (upperBound-X)/2+X;
			lines.add(new LineRepresentation(X, Y, nextX, nextY));
			prepareRepresentations(node.get_rightChild(), X, upperBound, nextY);
		}
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		for (LineRepresentation line : lines) {
			line.paint(g);
		}
		for (NodeRepresentation<T> node : nodes) {
			node.paint(g);
		}
	}
}
