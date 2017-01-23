/**
 * 
 */
package hue10.ShiftPuzzle;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ElisabethElisabeth Gombkötö
 *17.01.2017WS_2016
 */
public class H0Uninformed extends AchterPuzzleSolver {
	@Override
	protected Queue<AchterPuzzle> getOpenListInstance(AchterPuzzle end) {
		return new LinkedList<AchterPuzzle>();
	}
	
}
