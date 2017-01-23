package at.fhv.sma.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents a graph.
 * Every edge can be visited only once.
 * Every node can be visited more than one time.
 * 
 * @author Sebastian Malin
 *
 */
public class Graph {
	
	private List<LinkedList<Edge>> _edges = new ArrayList<LinkedList<Edge>>();
	
	/**
	 * Creates an instance of the graph class.
	 * 
	 * @param maxCap the maximum number of the nodes
	 */
	public Graph(int maxCap) {
		for(int i = 0; i < maxCap; i++) {
			_edges.add(new LinkedList<>());
		}
	}
	
	/**
	 * Adds a the given edge to graph which nodes it connects.
	 * 
	 * @param e the edge to add
	 */
	public void addEdge(Edge e) {
		_edges.get(e.getIndex1()).add(e);
		_edges.get(e.getIndex2()).add(e);
	}
	
	/**
	 * Finds the path with the lowest cost between two given nodes.
	 * 
	 * @param startIndex the index of the start node
	 * @param endIndex the index of the target node
	 * @param startCost the cost to start with
	 * @return the path with the lowest cost
	 */
	public Path findMin(int startIndex, int endIndex, int startCost) {
		PathAlgorithm algo = new MinAlgo();
		findPath(startIndex, endIndex, new Path(startCost), algo);
		return algo.getPath();
	}
	
	/**
	 * Finds the path with the highest cost between two given nodes.
	 * 
	 * @param startIndex the index of the start node
	 * @param endIndex the index of the target node
	 * @param startCost the cost to start with
	 * @return the path with the highest cost
	 */
	public Path findMax(int startIndex, int endIndex, int startCost) {
		PathAlgorithm algo = new MaxAlgo();
		findPath(startIndex, endIndex, new Path(startCost), algo);
		return algo.getPath();
	}
	
	/**
	 * Finds the path with the given cost between two given nodes.
	 * 
	 * @param startIndex the index of the start node
	 * @param endIndex the index of the target node
	 * @param startCost the cost to start with
	 * @param endCost the cost to find
	 * @return the path with the exact cost given
	 */
	public Path findSpecificPath(int startIndex, int endIndex, int startCost, int endCost) {
		PathAlgorithm algo = new SpecificAlgo(endCost);
		findPath(startIndex, endIndex, new Path(startCost), algo);
		return algo.getPath();
	}
	
	/**
	 * Recursive backtracking method to try to find the right path between to given nodes.
	 * 
	 * If the end node is reached, the algorithm checks the given condition.
	 * e.g. MaxAlgo - checks if the cost of current path is the path with the highest cost compared to all paths
	 * MinAlgo - check if the cost of current path is the lowest cost compared to all paths
	 * 
	 * @param currentIndex the index of the current node
	 * @param endIndex the index of the end node
	 * @param currentPath the path tracked till now
	 * @param algo an algorithm to check the condition
	 */
	private void findPath(int currentIndex, int endIndex, Path currentPath, PathAlgorithm algo) {
		
		Path subPath = null;
		
		if(currentIndex == endIndex) {	// end node reached
			algo.setPath(currentPath);
		}
		
		for(Edge e : _edges.get(currentIndex)) {	// iterate through all edges of the current node
			if(!e.isVisited() && e.calculate(currentPath.getCost()) >= 0) {
					e.setVisited(true);
					subPath = new Path(currentPath); // copy current path
					subPath.addEdge(e);
					if(e.getIndex2() == currentIndex) {		// recursive invocation
						findPath(e.getIndex1(), endIndex, subPath, algo);
					} else {
						findPath(e.getIndex2(), endIndex, subPath, algo);
					}
					e.setVisited(false);
			}
		}
		
	}
	
	
}
