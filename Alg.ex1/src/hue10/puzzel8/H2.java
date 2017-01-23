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
public class H2 extends PuzzelSolver{

	@Override
	protected Queue<Puzzle8> getOpenList(Puzzle8 end) {
		return new PriorityQueue<Puzzle8>(new Comparator<Puzzle8>() {
			@Override
			public int compare(Puzzle8 p1, Puzzle8 p2) {
				return (p1.H2Cost(end) - p2.H2Cost(end));
			}
		});
	}
	

	
//	@Override
//	protected Queue<Puzzle8> getNextState(Puzzle8 state) {
//		return new PriorityQueue<Puzzle8>(new Comparator<Puzzle8>() {
//			@Override
//			public int compare(Puzzle8 p1, Puzzle8 p2) {
//				int[][] endP1=p1.get_end();
//				int[] soll;
//				int[] ist;
//				int totalerrorP1=0;
//				int totalerrorP2=0;
//				for(int i=0; i<9;i++){
//					soll=p1.getCoordinate(endP1, i);
//					ist=p1.getCoordinate(p1.get_gamefield(), i);
//					totalerrorP1+= Math.abs(soll[0]-ist[0]);
//					totalerrorP1+= Math.abs(soll[1]-ist[1]);
//				}
//				for(int i=0; i<9;i++){
//					soll=p1.getCoordinate(endP1, i);
//					ist=p2.getCoordinate(p2.get_gamefield(), i);
//					totalerrorP2+= Math.abs(soll[0]-ist[0]);
//					totalerrorP2+= Math.abs(soll[1]-ist[1]);
//				}
//				if(totalerrorP1<totalerrorP2){
//					return -1;
//				}
//				if(totalerrorP1> totalerrorP2){
//					return 1;
//				}
//				return 0;
//		}
//		});
		
//	}

	
}