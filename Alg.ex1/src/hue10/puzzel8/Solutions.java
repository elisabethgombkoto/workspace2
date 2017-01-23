/**
 * 
 */
package hue10.puzzel8;

import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * @author ElisabethElisabeth Gombk�t�
 *17.01.2017WS_2016
 */
public class Solutions {
	public  boolean _isSolved;
	public  List<Puzzle8> _result;
	public int _expansion;
	public  Set<Puzzle8> _closeList;
	public double _effectiveBranchingFactor;
	/**
	 * @param isSolved
	 * @param result
	 * @param expansion
	 * @param closeList
	 */
	public Solutions(boolean isSolved, Stack<Puzzle8> result, int expansion, Set<Puzzle8> closeList) {
		_isSolved=isSolved;
		_result=result;
		_expansion=expansion;
		_closeList=closeList;
		
		double n=expansion;
		double d=result.size();
		_effectiveBranchingFactor=BranchingFactorCalculator.calculate(n,d);
			
	}
	
	public void printSummary() {
		System.out.println("From this Puzzel8: " + get_result().get(0)+ "\n" + 
	"to this Puzzel8: " + get_result().get(_result.size() - 1) + "\n" +
				"solution found: " + _isSolved + "\n" +
				"optimale path has a" + get_result().size() +
				"size." + "\n" + " The number of the generated Puzzle8 intersates is " 
				+ get_expansion()+", "+ get_closeList().size() + " of these were visited." + "\n" +
				"The effective brancing factor is " + get_effectiveBranchingFactor() + ".");
	}

	/**
	 * @return the _isSolved
	 */
	public boolean is_isSolved() {
		return _isSolved;
	}

	/**
	 * @return the _result
	 */
	public List<Puzzle8> get_result() {
		return _result;
	}

	
	/**
	 * @return the _closeList
	 */
	public Set<Puzzle8> get_closeList() {
		return _closeList;
	}

	/**
	 * @return the _expansion
	 */
	public int get_expansion() {
		return _expansion;
	}

	/**
	 * @return the _effectiveBranchingFactor
	 */
	public double get_effectiveBranchingFactor() {
		return _effectiveBranchingFactor;
	}

}