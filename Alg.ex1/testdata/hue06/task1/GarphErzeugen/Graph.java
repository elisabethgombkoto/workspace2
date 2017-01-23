package hue06.task1.GarphErzeugen;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.management.InvalidAttributeValueException;


public class Graph  {
	private int _amountOfEdges=0;
	private int _amountOfVertices;
	
	private List<LinkedList<Edge>> _edges = new ArrayList<LinkedList<Edge>>();
	
	/**
	 * Constructor
	 * 
	 * erzeugt einen Graph als adjacencyList
	 *  mit bestimmten Anzahl von Vertex
	 * @param amountOfVertices
	 */
	public Graph(int amountOfVertices) {
		for(int i = 0; i < amountOfVertices; i++) {
			_edges.add(new LinkedList<>());
			
			}
		}
	
	
	
	/**
	 * fügt kanten zu den Graph dazu
	 * @param Edge edge
	 * @throws InvalidAttributeValueException
	 */
	
	public void addEdgeToGarph(Edge edge) throws InvalidAttributeValueException {
		
		_edges.get((edge.get_vertexFrom()).intValue()).add(edge);
		_edges.get((edge.get_vertexTo()).intValue()).add(edge);
		_amountOfEdges++;
	}
	
	/**
	 * findet der Weg mit dem geringsten kosten zum Drache 
	 * @param Integer startIndex
	 * @param Integer endVertex
	 * @param Integer cost
	 * @return {@link Path} {@link LinkedList} of {@link Edge}
	 * @throws InvalidAttributeValueException
	 */
	
	public Path findKlotmildeMinCostPath(Integer startVertex, Integer endVertex, Integer cost) throws InvalidAttributeValueException {
		
		Algoritmus algoritmus = new Klotmilde_minCost();
		findPossiblePath(startVertex, endVertex, new Path(cost), algoritmus, null);
		 return algoritmus.get_path();		
	}
	
	
	
	/**
	 * findet der Weg mit spezielen Kosten zum Drache 
	 * @param Integer startIndex
	 * @param Integer endVertex
	 * @param Integer cost
	 * @return {@link Path} {@link LinkedList} of {@link Edge}
	 * @throws InvalidAttributeValueException 
	 */
	
	public Path findKlothilde_999Cost(Integer startVertex, Integer endVertex, Integer cost) throws InvalidAttributeValueException {
		
		Algoritmus algoritmus = new Klothilde_999Cost();
		findPossiblePath(startVertex, endVertex, new Path(cost), algoritmus, null);
		return algoritmus.get_path();	
	}
	
	
	
	/**
	 * findet der Weg mit dem höchsten kosten zum Drache 
	 * @param Integer startIndex
	 * @param Integer endVertex
	 * @param Integer cost
	 * @return {@link Path} {@link LinkedList} of {@link Edge}
	 * @throws InvalidAttributeValueException 
	 */
	
	public Path findKlotwilde_MaxCost(Integer startVertex,Integer endIndex, Integer cost) throws InvalidAttributeValueException {
		Algoritmus algoritmus = new Klotwilde_MaxCost();
		findPossiblePath(startVertex, endIndex, new Path(cost), algoritmus, null);
		 return algoritmus.get_path();		
	}
	
	/**
	 * Backtacking findet den Path und wenn Path gefunden ist, dann
	 * wird es in Algoritmus geschpeichert, und dort verglichen ob es brauchbar ist,
	 * sprich den kriterien enspricht
	 * 
	 * @param currentVertex
	 * @param endVertex
	 * @param currentPath
	 * @param algoritmus
	 * @param visitedEdges
	 * @throws InvalidAttributeValueException
	 */
	private void findPossiblePath(int currentVertex, int endVertex, Path currentPath, Algoritmus algoritmus, Set<Edge> visitedEdges) throws InvalidAttributeValueException {
		
		Path partPath = null;
		
		if(currentVertex == endVertex) {
			algoritmus.setPath(currentPath);
			return;
		}
		Set<Edge> edgesVisited = visitedEdges != null ? visitedEdges : new HashSet<Edge>();
		
//Itariere alle Kanten durch und wenn es noch nicht markiert ist,
//und die ergebniss von den durchführende Operation ein positives ganz zahl ist so
//markiere diese Kante als besucht
		for(Edge edge : _edges.get(currentVertex)) {
			
			if(!edgesVisited.contains(edge) && edge.get_weight().get_operation().resultFor(currentPath.getCost())>=0){
				
				edgesVisited.add(edge);
				partPath = new Path(currentPath);				
				partPath.addEdge(edge);
			//nehme die andere Vertex von den selbe Edge und rufe die Funktion rekursive nochmals auf	
					if(edge.get_vertexTo().equals(currentVertex)) {
						findPossiblePath(edge.get_vertexFrom(), endVertex, partPath, algoritmus, edgesVisited);
					} else {
						findPossiblePath(edge.get_vertexTo(), endVertex, partPath, algoritmus, edgesVisited);
					}
					
					edgesVisited.remove(edge);
			}
		}
		
	}

	/**
	 * @return the _edges
	 */
	public List<LinkedList<Edge>> get_edges() {
		return _edges;
	}



	public int get_amountOfEdges() {
		return _amountOfEdges;
	}

	public int get_amountOfVertices() {
		return _amountOfVertices;
	}


	public List<Edge> getEdgesFromGarph(int vertex) {
	
		return _edges.get(vertex);
	}



	






	
	
	
}

