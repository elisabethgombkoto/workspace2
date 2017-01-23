package hue04hue05.BinaereBaum.hue04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public abstract class Tree<T extends Comparable<T>> {
/**
 * @author Elisabeth Gombkötö
 * @since 10.11.2016 geendert am 28.11.2016
 * 
 */
	
	protected Node<T> _root;

	public Tree() {
		set_root(null);
	}

	public Tree(Node<T> root) {
		set_root(root);
	}

	public Node<T> get_root() {
		return _root;
	}

	public Node<T> set_root(Node<T> root) {
		return _root = root;
	}
	/**
	 *1. ->Create an empty Stack stack.
	 *2. -> Initialize current node as root 
	 *3. -> Push the current node to S and set current = current->left until current is NULL 
	 *4. -> If current is NULL and stack is not empty then
	 * 4.1----> Pop the top item from stack.
	 * 4.2----> Print the popped item, set current = popped_item->right 
     * 4.3->Go to step 3.
     *5. ->If current is NULL and stack is empty then we are done.
     *
     *@param Node<T> root
     *
	 */
	
	public void InorderTreeTraversalIterativ (Node<T> root){
			
		if(root==null){
			return;
		}
		Stack <Node<T>> stack = new Stack<Node<T>>();
		Node<T> currentNode = root;
		
		while(currentNode!=null){
			stack.push(currentNode);
			currentNode=currentNode.get_leftChild();
		}
		while(stack.isEmpty()!=true){
		currentNode=stack.pop();
			System.out.println(currentNode.getData().toString());
			if(currentNode!=null){
			currentNode=currentNode.get_rightChild();
			}
			while(currentNode!=null){
				stack.push(currentNode);
				currentNode=currentNode.get_leftChild();
				}
		}
	}
/**
 * print all value in tree inOrder: left->root->right
 * @param Node<T> node
 * 
 */
	private void printInOrder(Node<T> node) {
		if (node == null)
			return;
		printInOrder(node.get_leftChild());
		System.out.println(node.getData());
		printInOrder(node.get_rightChild());
	}
/**
 * print all value in tree preOrder: root->left->right
 * @param node
 */
	private void printPreOrder(Node<T> node) {
		if (node == null)
			return;
		System.out.println(node.getData());
		printInOrder(node.get_leftChild());
		printInOrder(node.get_rightChild());
	}
/**
 * print all value in tree postOrder: left->right->root
 * @param node
 */
	private void printPostOrder(Node<T> node) {
		if (node == null)
			return;
		printInOrder(node.get_leftChild());
		printInOrder(node.get_rightChild());
		System.out.println(node.getData());
	}
	
/**
 * print all value in tree LevelByLevel
 * @param root
 */

public void printLevelByLevel(Node<T> root) {
	LinkedList<Node<T>> queue = new LinkedList<>();
	queue.add(root);
	while (!queue.isEmpty()) {
		Node<T> node = queue.poll();
		System.out.println(node.getData());
		if (node.get_leftChild() != null) {
			queue.add(node.get_leftChild());
		}
		if (node.get_rightChild() != null) {
			queue.add(node.get_rightChild());
		}
	}
}
/**
 * Gibt den Baum, sprich die Knoten je nach varible aus
 * Durch Enum lässt sich zwischen den vier verschidene ausgabemöglichkeiten Wählen
 * 
 * @param Enum caseToPrint
 */
	public void printTree(PrintPossibilitis caseToPrint){
        switch(caseToPrint) {
            case inOrder:
                printInOrder(_root);
                break;
            case preOrder:
                printPreOrder(_root);
                break;
            case postOrder:
                printPostOrder(_root);
                break;
            case levelByLevel:
                printLevelByLevel(_root);
                break;
            default:
                break;
        }
    }
/**
 * Die Methode wird von insert() aufgerufen, und wird von alle Unterklassen geerbt,
 * und dort je nach Baumeigenschaft implementiert.
 * 
 * @param node
 * @param data
 * @return node
 */
	protected abstract Node<T> insertRec(Node<T> node, T data);
/**
 * Fügt einen Wert den Baum zu, ruft die private Methode insertRec() auf
 * 
 * @param newValue
 * @return node
 * @see insertRec()
 */
	public Node<T> insert(T newValue) {
		return _root = insertRec(_root, newValue);
	}
	
	/**
	 * Entfernt Knoten beziehugsweise Daten von dem Baum werden nicht
	 * @param data
	 * @return TRUE-wenn den Wert aus den Baum entfernt ist
	 * FALSE-wenn der Wert konnte nicht aus den Baum entfernt werden
	 * @throws TreeIsEmptyExeption
	 * @see remove()
	 */
	protected abstract boolean removeRec(T data) throws IllegalArgumentException;
	
	public void remove(T data) throws IllegalArgumentException {
		if (removeRec(data)!=true){
			throw new IllegalArgumentException();
		}
	}

/**
 * Gibt als int Wert die Anzahl von Blätter in einem beliebigen Baum zurück, dafür ruft getAmoutLeaves(root) auf
 * @return amountLeaves
 * @see getAmountLeaves(root)
 */
	public int getAmountLeaves() {
		return getAmountLeaves(_root);
	}

	/**
	 * @param root
	 * @return amountLeaves
	 * 
	 */
	private int getAmountLeaves(Node<T> root) {
		if (root == null) {
			return 0;
		}
		LinkedList<Node<T>> queue = new LinkedList<>();
		queue.add(root);
		int i = 0;
		while (!queue.isEmpty()) {
			Node<T> node = queue.poll();

			if (node.get_leftChild() != null) {
				queue.add(node.get_leftChild());
			}
			if (node.get_rightChild() != null) {
				queue.add(node.get_rightChild());
			}
			if (node.get_leftChild() == null && node.get_rightChild() == null) {
				i++;
			}
		}
		return i;
	}
	
	
	/**
	 * 
	 * @return
	 * @see getMaxLevel()
	 */
	public int heightOfTree() {
		return getMaxLevel(_root, 0);
	}

	private int getMaxLevel(Node<T> x, int t) {
		if (x == null) {
			return t;
		}
		t = Math.max(getMaxLevel(x.get_leftChild(), t), getMaxLevel(x.get_rightChild(), t));
		return ++t;
	}
	
	public int findMaxWidth(Node<T> root){
		int maxWidth=0;
		Queue<Node<T>> q = new LinkedList<>();
		int levelNodes =0;
		if(root==null) return 0;
		q.add(root);

		
		
		while(!q.isEmpty()){
			levelNodes = q.size();
			if(levelNodes>maxWidth){
				maxWidth = levelNodes;
			}
			while(levelNodes>0){
				Node<T> n = (Node<T>)q.remove();
				if(n.get_leftChild()!=null) q.add(n.get_leftChild());
				if(n.get_rightChild()!=null) q.add(n.get_rightChild());
				levelNodes--;
			}
		}
		return maxWidth;
	}

	
	}

