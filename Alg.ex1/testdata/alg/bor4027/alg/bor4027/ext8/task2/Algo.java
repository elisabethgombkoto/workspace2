package alg.bor4027.ext8.task2;

import java.util.List;

/**
 * @author Bernd
 *
 */
public abstract class Algo {
	Graph _graph;
	Node _startNode;
	List<Node> _destNodeList;
	Integer[] _costs;

	/**
	 * Initialisiert _cost[] mit MAX_VALUE (Infinity) und Index am StartNode mit
	 * 0;
	 */
	public void initialAlgo() {
		for (int i = 0; i < _costs.length; i++) {
			_costs[i] = Integer.MAX_VALUE;
		}
		_costs[_destNodeList.indexOf(_startNode)] = 0;
	}

	public abstract void startAlgo(Node currentNode, Integer cost);

	public void printCost() {
		System.out.println(getClass().getSimpleName());
		System.out.println("Shortest Path from " + _startNode.getLabel());
		for (Node n : _destNodeList) {
			System.out.print(" to " + n.getLabel());
			System.out.println(" cost: " + _costs[_destNodeList.indexOf(n)]);
		}
	}

}
