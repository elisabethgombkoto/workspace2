package ILIAS;
/**
 * 
 */

/**
 * @author Elisabeth
 *
 */
public class NodeAlreadyDafinedException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NodeAlreadyDafinedException(){
		super("Node bereits definiert");
	}
}
