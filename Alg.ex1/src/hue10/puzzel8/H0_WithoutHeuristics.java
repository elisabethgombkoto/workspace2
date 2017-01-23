/**
 * 
 */
package hue10.puzzel8;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


/**
 * @author ElisabethElisabeth Gombkötö
 *14.01.2017WS_2016
 */
public class H0_WithoutHeuristics extends PuzzelSolver {
	
	/* (non-Javadoc)
	 * @see hue10.puzzel8.PuzzelSolver#getNextState(hue10.puzzel8.Puzzel8)
	 */
	@Override
	protected Queue<Puzzle8> getOpenList(Puzzle8 end) {
		return new LinkedList<Puzzle8>();
	}
}
