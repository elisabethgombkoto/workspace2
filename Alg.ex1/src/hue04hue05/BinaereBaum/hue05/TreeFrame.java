package hue04hue05.BinaereBaum.hue05;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.ScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import hue04hue05.BinaereBaum.hue04.Tree;

public class TreeFrame<T extends Comparable<T>> extends Frame {

	private static final long serialVersionUID = -546205076703209567L;

	public TreeFrame(Tree<T> tree, Dimension size) {
		setTitle("Draw BinaryTree");
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				e.getWindow().dispose();
				System.exit(0);
			}
		});
		ScrollPane scroll=new ScrollPane();
		scroll.add(new TreePanel<T>(tree, size));
		add(scroll);
		setMinimumSize(size);
		setVisible(true);
	}
}
