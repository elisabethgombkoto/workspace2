package hue04hue05.BinaereBaum.hue04;

public class Node<T extends Comparable<T>> {
	
	/**
	 * @author Elisabeth Gombkötö
	 * @since 10.11.2016 geendert am 28.11.2016
	 * 
	 */
	private T _data;

	private Node<T> _leftChild;
	private Node<T> _rightChild;

	public Node() {
		_data = null;
		_leftChild = null;
		_rightChild = null;

	}

	public Node(T zahl) {
		_data = zahl;
		_leftChild = null;
		_rightChild = null;

	}

	public T getData() {
		return _data;
	}

	public void setData(T zahl) {
		_data = zahl;
	}

	public Node<T> get_leftChild() {
		return _leftChild;
	}

	public Node<T> set_leftChild(Node<T> leftChild) {
		return _leftChild = leftChild;
	}

	public Node<T> get_rightChild() {
		return _rightChild;
	}

	public Node<T> set_rightChild(Node<T> rightChild) {
		return _rightChild = rightChild;
	}
/**
 * 
 */
	
	/**
	 * @param parent
	 * @param data
	 * @return TRUE wenn data im Baum gefunden wurde, und im Baum mit dem data des Nachfolger minValueToFindSuccessorNode() ermittelt wurde
	 *  FALSE wenn data könnte nicht gelöscht werden
	 * @see Comparable
	 */
	public boolean removeNodeDataInBinearSearchTree(Node<T> parent, T data) {
		//System.out.println("data " +data+ " _data "+_data);
		if (data.compareTo(_data)<0) {			
            if (_leftChild != null)
                  return _leftChild.removeNodeDataInBinearSearchTree(this, data);
            else
                  return false;
      } else if (data.compareTo(this._data)>0) {
            if (_rightChild != null)
                  return _rightChild.removeNodeDataInBinearSearchTree(this, data);
            else
                  return false;
      } else {
            if (_leftChild != null && _rightChild != null) {
                  this._data = _rightChild.minValueToFindSuccessorNode();
                  _rightChild.removeNodeDataInBinearSearchTree(this, this._data);
            } else if (parent._leftChild == this) {
                  parent._leftChild = (_leftChild != null) ? _leftChild : _rightChild;
            } else if (parent._rightChild == this) {
                  parent._rightChild = (_leftChild != null) ? _leftChild : _rightChild;
            }
            return true;
      }

	}
	
	private T minValueToFindSuccessorNode() {
		if (_leftChild == null)
            return this._data;
      else
            return _leftChild.minValueToFindSuccessorNode();
}

	
	}

	
	

 
