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
 * @author ElisabethElisabeth Gombk�t�
 *14.01.2017WS_2016
 */
public class H1 extends PuzzelSolver  {

	/* (non-Javadoc)
	 * @see hue10.puzzel8.PuzzelSolver#getNextState(hue10.puzzel8.Puzzel8)
	 */
	
		
		@Override
		protected Queue<Puzzle8> getOpenList(Puzzle8 end) {
			return new PriorityQueue<Puzzle8>(new Comparator<Puzzle8>() {
				@Override
				public int compare(Puzzle8 p1, Puzzle8 p2) {
					return p1.H1Cost(end) - p2.H1Cost(end);
				}
			});
		}
//		@Override
//		public Queue<Puzzle8> getNextState(Puzzle8 end) {
//		return new PriorityQueue<Puzzle8>(new Comparator<Puzzle8>(){
//			@Override
//			public int compare(Puzzle8 p1, Puzzle8 p2) {
//				int p1Cost=p1.get_shift()+p1.getErrorField();
//				int p2cost=p2.get_shift()+p2.getErrorField();
//				if(p1Cost<p2cost){
//					return -1;
//				}
//				if(p1Cost> p2cost){
//					return 1;
//				}
//				return 0;
//			}	
//		});		
//	}
}
