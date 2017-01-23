package hue04hue05.BinaereBaum.hue04;

public class BinearSearchTree<T extends Comparable<T>> extends Tree<T> {
	
	/**
	 * @author Elisabeth Gombkötö
	 * @since 10.11.2016 geendert am 28.11.2016
	 * 
	 */
/**
*werden die Daten verglichen, dann in die richtige platz eingefügt
*@param
*@return
 */
	@Override
	protected Node<T> insertRec(Node<T> node, T data) {
		if(node == null)
		{
			node = new Node<T>(data);
		}
		else
		{
			if(data.compareTo(node.getData()) <= 0)
			{
				node.set_leftChild(insertRec(node.get_leftChild(), data));
			}
			else
			{
				node.set_rightChild(insertRec(node.get_rightChild(), data));
			}
		}
		return node;
	}


/**
 * @see hue04hue05.BinaereBaum.hue04.Tree#removeRec(java.lang.Comparable)
 */
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

	

