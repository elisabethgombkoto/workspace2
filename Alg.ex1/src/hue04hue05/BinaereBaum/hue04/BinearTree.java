package hue04hue05.BinaereBaum.hue04;

public class BinearTree<T extends Comparable<T>> extends Tree<T> {
	/**
	 * @author Elisabeth Gombkötö
	 * @since 10.11.2016 geendert am 28.11.2016
	 * 
	 */

	public BinearTree(){
		_root = null;
	}
	public BinearTree(Node<T> root){
		_root=root;
	}
	
	/**
	 * fügt recursive die Werte auf die linke Seite des Baumes ein, falls noch keine Knoten vorhanden ist so wird eine erzeugt, erzeugt zum schluss eine Liste
	 * @param Node<T>, T data
	 * @return Node<T>
	 */
	@Override
	protected Node<T> insertRec(Node<T> node, T data) {
		if(node == null)
		{
			node = new Node<T>(data);
			return node;
		}
		
		return node.set_leftChild(insertRec(node.get_leftChild(), data));
	}
	
	/**
	 * es werden die knoten nicht tatsächlich gelöscht sondern nur die Daten werden überschrieben
	 * @param data
	 * @return TRUE-wenn den Wert aus den Baum entfernt ist
	 * FALSE-wenn der Wert konnte nicht aus den Baum entfernt werden
	 */	
//	@Override
//	protected boolean removeRec(T data) throws IllegalArgumentException {
//		if (_root == null){
//	         return false;}
//	   else {
//	         if (_root.getData().equals(data)) {
//	               Node<T> parentNode = new Node<T>();
//	               parentNode.set_leftChild(_root);
//	               boolean result = _root.removeNodeDataInBinearTree( parentNode, data);
//	               _root = parentNode.get_leftChild();
//	               return result;
//	         } else {
//	               return _root.removeNodeDataInBinearTree( null, data);
//	         }
//	   }
//		      
//	}
//	
	@Override
	protected boolean removeRec(T data) throws IllegalArgumentException{	      
		 if (_root == null)
	         return false;
	   else {
	         if (_root.getData().equals(data)) {
	               Node<T> parentNode = new Node<T>();
	               parentNode.set_leftChild(_root);
	               boolean result = _root.removeNodeDataInBinearSearchTree( parentNode, data);
	               _root = parentNode.get_leftChild();
	               return result;
	         } else {
	               return _root.removeNodeDataInBinearSearchTree( null, data);
	         }
	   }
		      }

		
	}



