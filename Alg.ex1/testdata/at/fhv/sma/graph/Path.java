package at.fhv.sma.graph;

import java.util.LinkedList;

public class Path {
	
	private LinkedList<Edge> _edges = new LinkedList<>();
//	private int _cost = 0;
	private int _startCost = 0;
	
	public Path(int startCost) {
		_startCost = startCost;
	}
	
	public Path(Path p) {
		_startCost = p._startCost;
		_edges = new LinkedList<Edge>();
		for(Edge e : p._edges) {
			_edges.add(new Edge(e.getIndex1(), e.getIndex2(), e.getCalculation()));
		}
	}
	
	public int getCost() {
		int cost = _startCost;
		
		for(Edge e : _edges) {
			cost = e.calculate(cost);
		}
		return cost;
	}
	
	public void addEdge(Edge e) {
		_edges.add(e);
	}
	
	public void removeLastEdge() {
		_edges.removeLast();
	}
	
	@Override
	public String toString() {
		
		String path = "[0 ";
		
		int current = 0;
		
		for(Edge e : _edges) {
			if(current == e.getIndex1()) {
				path = path.concat(Integer.toString(e.getIndex2()) + " ");
				current = e.getIndex2();
			} else {
				path = path.concat(Integer.toString(e.getIndex1()) + " ");
				current = e.getIndex1();
			}
		}
		path = path.trim();
		path = path.concat("]");
		return path;
//		
//		
//		
//		String path = "[ ";
//		
//		for(Edge e : _edges) {
//			path = path.concat(e.toString() + " ");
//		}
//		
//		path = path.concat("]");
//		return path;
	}

}
