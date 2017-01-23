package hue04hue05.BinaereBaum.hue04;

import java.util.LinkedList;

public class BinearTreeFaktory<T extends Comparable<T>> {
/*
 * from an Array make a Tree<>
 */
	/**
	 * @param values
	 * @return tree
	 */
	public Tree<T> getInstance(T[] values)
	{
		Tree<T> result = new BinearTree<T>();
		Node<T> currentNode = new Node<T>();
		LinkedList<Node<T>> queue = new LinkedList<>();
		int i = 1;
		if (result.get_root() == null) {
			result.set_root(new Node<T>(values[1]));
			currentNode = result.get_root();
		}
		int leftPosition;
		int rightPosition;
		
		for(; 2 * i +1 < values.length; i++) {
			leftPosition = 2 * i;
			rightPosition = leftPosition +1;
			currentNode.set_leftChild(new Node<T>(values[leftPosition]));

			if (values[rightPosition] != null) {
				currentNode.set_rightChild(new Node<T>(values[rightPosition]));
			}
			if (currentNode.get_leftChild() != null) {
				queue.add(currentNode.get_leftChild());
			}
			if (currentNode.get_rightChild() != null) {
				queue.add(currentNode.get_rightChild());
			}
			currentNode = queue.poll();
		}
		
		return result;
	}
	

	private Node<T> convert(Node<T> binTreeRoot, Node<T> binSearchTreeRoot) {
		if (binTreeRoot == null) {
		return binSearchTreeRoot;
		} else {
		binSearchTreeRoot = convert(binTreeRoot.get_leftChild(), binSearchTreeRoot);
		binSearchTreeRoot = convert(binTreeRoot.get_rightChild(), binSearchTreeRoot);
		binSearchTreeRoot = convertInsert(binSearchTreeRoot, binTreeRoot);
		}
		return binSearchTreeRoot;
		}
	

		private Node<T> convertInsert(Node<T> neuSearchTree, Node<T> oldBinearTreeNode) {
		if (neuSearchTree == null) {
		neuSearchTree = oldBinearTreeNode;
		neuSearchTree.set_leftChild(null);
		neuSearchTree.set_rightChild(null);
		} else {
			if(oldBinearTreeNode.getData().compareTo(neuSearchTree.getData())>1){
				neuSearchTree.set_rightChild(convertInsert(neuSearchTree.get_rightChild(), oldBinearTreeNode));
			}else{
				neuSearchTree.set_leftChild(convertInsert(neuSearchTree.get_leftChild(), oldBinearTreeNode));
			}
		}
		return neuSearchTree;
		}
		public BinearSearchTree<T> convertBinearTreeToBinearSearchTree(BinearTree<T> bintree){
			
			
			 BinearSearchTree<T>searchTree =new BinearSearchTree<T>();
			 searchTree.set_root(bintree.get_root());
			 return searchTree;
			
		}
	public String encode(DecodeBinearTree tree, String binearString) {
		return tree.encode(binearString);
	}
	
	
}
