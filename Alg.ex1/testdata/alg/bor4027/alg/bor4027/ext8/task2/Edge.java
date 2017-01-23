package alg.bor4027.ext8.task2;

/**
 * @author Bernd
 *
 */
public class Edge {
	
	Node _dest;
	int _cost;
	
	public Edge(Node n, int c){
		_dest = n;
		_cost = c;
	}
	
	public Node getDestNode(){
		return _dest;
	}
	
	public int getCost(){
		return _cost;
	}

}
