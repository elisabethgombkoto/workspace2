package hue06.Graph_int_primitive;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Graph {
	private int amountOfEdges = 0;
	
	//TODO Tiefen und breitensuche implementieren
	
	/**
	 * {@link AdjacencyStructureType} werden bestimmt
	 * @author Elisabeth Gombkötö
	 *
	 */
	protected enum AdjacencyStructureType {
		MATRIX, LIST
	}
	
	private AdjacencyStructure _adjstruct = null;
	
	/**
	 * Constructor.
	 * je nach parameter wird die {@link AdjacencyStructureType} ausgewählt
	 * bestimmt ob die eingelesene Parameter in List oder in Matrix sich speichern
	 * 
	 * @param numOfVertices
	 * @param adjType
	 */
	protected Graph(int numOfVertices, AdjacencyStructureType adjType) {
		switch (adjType) {
		case MATRIX:
			_adjstruct = new AdjacencyMatrix(numOfVertices);
			break;
		case LIST:
			_adjstruct = new AdjacencyList(numOfVertices);
			break;
		default:
			break;
		}
	}
	

	/**
	 * Factory methode
	 * liest die Daten von einem .txt file ein wandelt zu einem int array um 
	 * und gibt die werte von den Vertices und Edges zu den jeweiligen {@link AdjacencyStructure}
	 * weiter wo die nacher hinterlegt werden
	 * 
	 * @param filename
	 * @param adjType
	 * @return new Graph object
	 * @throws IOException
	 * 
	 */
	public static Graph createGraph(String filename, AdjacencyStructureType adjType) throws IOException {
		
	
		BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
		FileUtil fileUtil =new FileUtil(filename);
		String line = "";
	
		line = bufferedReader.readLine();	// read first line in .txt file, vertex line
		String[] stringVertices = line.substring(line.indexOf('{')+1, line.lastIndexOf('}')).split(",");
		int[] iVertices = fileUtil.stringToIntArray(stringVertices);
		
		Graph graph = new Graph(iVertices.length + 1, adjType);
		
		line = bufferedReader.readLine();	// read second line in .txt file, edge line
		String[] stringEdges = line.substring(line.indexOf('{')+2, line.lastIndexOf('}')-1).split("\\],\\[");
		
		int[] iEdge = null;
		for(String e : stringEdges) {
			iEdge = fileUtil.stringToIntArray(e.split(","));
			graph.addEdgeToGraph(iEdge[0], iEdge[1], iEdge[2]);
			graph.amountOfEdges++;
		}
		graph.amountOfEdges /= 2;
		
		bufferedReader.close();
		return graph;
	}
	
	/**
	 * Ein (ungerichteter zusammenhängender) Graph enthält genau dann einen Eulerweg,
	 * wenn zwei oder keiner seiner Knoten von ungeradem Grad sind;
	 *  
	 * @return TRUE wenn eine EurerPath gibts, und FALSE wenn keine vorhanden ist
	 * @see degree()
	 */
	public boolean hasEulerPath() {
		int oddNodes = 0;
		int numOfVert = _adjstruct.getNumOfVertices();
		
		for(int i = 1; i < numOfVert; i ++) {
			if((_adjstruct.degreeOfVertex(i) % 2) != 0) {
				oddNodes++;
			}
		}
			
		if((oddNodes == 0) || (oddNodes == 2)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Ein (ungerichteter zusammenhängender) Graph enthält genau dann einen Eulerweg,
	 * wenn zwei oder keiner seiner Knoten von ungeradem Grad sind;	 
	 * hat kein Knoten ungeraden Grad, handelt es sich bei dem Eulerweg um einen Eulerkreis.
	 * 
	 *@return TRUE wenn eine EurerKreis gibts, und FALSE wenn keine vorhanden ist
	 * @see degree()
	 */
	public boolean hasEulerTour() {
		int oddNodes = 0;
		int numOfVert = _adjstruct.getNumOfVertices();
		
		for(int i = 1; i < numOfVert; i ++) {
			if((_adjstruct.degreeOfVertex(i) % 2) != 0) {
				oddNodes++;
			}
		}
			
		if(oddNodes == 0) {
			return true;
		}
		return false;
	}
	
	public LinkedList<Integer> findEulerPathIterativ(Graph graph, int v){
//		ArrayList<Integer> path = new ArrayList<>();
//		path.add(v);
//		int startVertex=v;
//		
//		do {
//			List<Edge> edges = _adjstruct.getEdges(v);
//			Edge currentedge= edges.get(v);
//			v=currentedge.getNode2();
//			_adjstruct.removeEdgeFromAdjacensy(currentedge.getNode1(),currentedge.getNode2());
//			path.add(v);
//			
//		} while(v!=startVertex);
//	//gebe das erste element zu path
//	int index
//		
//		
		return null;
		
		
	}
	
	/**
	 * Liefert  eine Liste von den besuchten Knoten
	 *  in den reinfolge wie die im Graph besucht wurden
	 *  
	 * @param startVertex
	 * @param visitedEdges
	 * @return LinkedList<Integer> EulerPath
	 * @see {@link Edge} @Override equals() 
	 * @see {@link Edge} @Override hashCode() 
	 */
	public LinkedList<Integer> findEulerPath(int startVertex,Set<Edge> visitedEdges ) {
		
		//prüfe ob eine Path gibt, wenn ja fahre vor wenn nicht breche ab;
		if(!hasEulerPath())
		{
			return null;
		}
		//wenn alle Kanten besucht wurden dann, aber die liste von den besuchten Kanten nicht leer ist, 
		//steige auf und gebe mir die Knote in eine Liste zurück
		
		if(visitedEdges != null && visitedEdges.size() == this.amountOfEdges)
		{
			LinkedList<Integer> list = new LinkedList<>();
			list.add(startVertex);
			return list;
		}
		
		Set<Edge> edgesVisited = visitedEdges != null ? visitedEdges : new HashSet<Edge>();// visited true
		List<Edge> edgesWithNull = _adjstruct.getEdges(startVertex);
		List<Edge> edges = new LinkedList<Edge>();
		
		//sortire aus wo keine kanten vorhanden ist
		for (Edge edge : edgesWithNull) {
			if(edge != null)
			{
				edges.add(edge);
			}
		}
		// suche mir in den Kanten, die nicht mit null inizialieziert sind nach eulerPath
		//und wenn du alle Kanten besucht hast, dann steige wieder auf und füge von den Liste 
		//die einzelne Knoten dazu
		//wenn du keine Path gefunden hast so werden die besuchte Kanten von der liste
		//mit dem besuchten Kanten wieder entfernt
		
		for (int i = 0; i < edges.size(); i++) {
			Edge curEdge = edges.get(i);
			// es wurde .equals und .hash() überschreiben
			//weil es eine ungerichtete Graph ist und die Kanten waren deswegen doppelt vorhanden
			//hier werden jetzt <1,2> und <2,1> als gleichwertig erkannt
			if(!edgesVisited.contains(curEdge))
			{
				edgesVisited.add(curEdge);
				LinkedList<Integer> returnList = findEulerPath(curEdge.getSecondVertexFromEdge(), edgesVisited);
				if(returnList != null)
				{
					returnList.addFirst(startVertex);
					return returnList;
				}
				else
				{
				 	edgesVisited.remove(curEdge);
				}
			}
		}	
		
		return null;		
	}
	
	/**
	 * fügt je nach {@link AdjacencyStructureType} fügt knoten zu jewilige Kanten zu
	 * 
	 * @param from Vertex
	 * @param to Vertex
	 * @param weight of Vertex
	 * @see addEdgeToAdjacensyListOrMatrix(from, to, weight)
	 * 
	 */
	private void addEdgeToGraph(int from, int to, int weight) {
		_adjstruct.addEdgeToAdjacensyListOrMatrix(from, to, weight);
	}
	
	
	/**
	 * gibt am Bildschirm die jeweilige Graph aus,
	 *  je nach  * {@link AdjacencyStructureType}
	 * 
	 * @see {@link AdjacencyMatrix} print() 
	 * @see {@link AdjacencyList} print() 
	 */
	
	public void print() {
		_adjstruct.print();
	}
}

