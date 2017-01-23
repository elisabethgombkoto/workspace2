/**
 * 
 */
package hue10.puzzel8;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * @author ElisabethElisabeth Gombk�t�
 *14.01.2017WS_2016
 */
public abstract class PuzzelSolver implements PuzzelSolveable {
/* (non-Javadoc)
 * @see hue10.puzzel8.PuzzelSolveable#solv(hue10.puzzel8.Puzzel8, hue10.puzzel8.Puzzel8)
 */
@Override
public Solutions solv(Puzzle8 start, Puzzle8 end) {
	boolean isSolved=start.equals(end);
	
	int expansion=0;
	Stack<Puzzle8> result=new Stack<Puzzle8>();
	Set<Puzzle8> closeList= new HashSet<Puzzle8>();
	
	Queue<Puzzle8> openList= getOpenList(end);
	Puzzle8 currentPuzzel8=start;
	openList.offer(start);
	
	while(!openList.isEmpty() && !isSolved){
		 currentPuzzel8=openList.poll();
		 closeList.add(currentPuzzel8);
		 for(Puzzle8 p: closeList){
		 System.out.println("closelist" + p.toString());
		 }
		 isSolved= currentPuzzel8.equals(end);
		 
		if(!isSolved){
			List<Puzzle8> children =currentPuzzel8.createListOfChildren(currentPuzzel8);
			for(Puzzle8 p: children){
				 System.out.println("openlist" + p.toString());
			}
			for(Puzzle8 child: children){
				if(!closeList.contains(child)){
					openList.offer(child);
					expansion++;
				}
			}
		}
	}
	if(isSolved){
		Puzzle8 current= currentPuzzel8;
		while(current!=null){
			result.push(current);
			current=current.get_parent();
		}
		Collections.reverse(result);
	}
	return new Solutions(isSolved, result, expansion, closeList);
}	
	
protected abstract Queue<Puzzle8> getOpenList(Puzzle8 end);

}
