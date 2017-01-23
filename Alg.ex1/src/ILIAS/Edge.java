package ILIAS;
/**
 * 
 */

/**
 * @author Elisabeth
 *
 */
public class Edge {

	Vertex target;
	int _cost;
	
	public Edge(Vertex n, int c){
		target = n;
		_cost = c;
	}
	
	public Vertex getTargetVertex(){
		return target;
	}
	
	public int getCost(){
		return _cost;
	}
}
