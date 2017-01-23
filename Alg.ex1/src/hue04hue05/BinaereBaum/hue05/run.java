package hue04hue05.BinaereBaum.hue05;

import java.awt.Dimension;

import hue04hue05.BinaereBaum.hue04.BinearSearchTree;
import hue04hue05.BinaereBaum.hue04.Tree;

public class run {
	/**
	 * @author Elisabeth Gombkötö
	 * @since 10.11.2016 geendert am 28.11.2016
	 * 
	 */
	public static void main(String[] args) {
		Integer[] values = { 10, 5, 15,124,154,13,54,1,54,1,024,7867,34,1,54 };
		Tree<Integer> tree = new BinearSearchTree<Integer>();
		for(int i = 0; i < values.length; i++)
		{
			tree.insert(values[i]);
		}
		
		new TreeFrame<Integer>(tree, new Dimension(1024, 768));
	}

}
