/**
 * 
 */
package hue09.Graph.Dijkstra;

/**
 * @author Elisabeth
 *
 */
public class NodeAlreadyDefinedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9103238218368882739L;

	public NodeAlreadyDefinedException(){
		super("Node bereits definiert");
	}
}
