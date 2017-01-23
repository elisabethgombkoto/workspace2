/**
 * 
 */
package hue09.Graph.Dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;



/**
 * @author Elisabeth
 *
 */
public class Kruskal extends Algo implements Relaxationable{
	Graph graph;
	private ArrayList<DisjoinSets> setsOfDisjoinSets;
	
	public Kruskal(){
		
	}



	public void kruskal(Graph graph){
		
		 List<LinkedList<Edge>> edges=graph.get_edges();
		 LinkedList<Edge> pureEdge=new LinkedList<>();
		 LinkedList<Edge> kuskalEdges= new LinkedList<>();
		 ArrayList<DisjoinSets> setsFromDisjoinSets= new ArrayList<>();
		
		 for(int i=0;i<edges.size();i++){
			 for(int j=0; j<edges.get(i).size(); j++){
			pureEdge.add( edges.get(i).get(j));
			 }
		 } 
		
		 Collections.sort(pureEdge);
		 for(int i=0; i< graph.get_amountOfVertices(); i++){
		 DisjoinSets disjointSets= new DisjoinSets();
		 setsFromDisjoinSets.add(disjointSets);
		 
		 }
		 
		 while(!pureEdge.isEmpty()&& disjointSets.getArray().size()>1){
			 Edge e= findminEdgeNotVisited(pureEdge);
			 if(disjointSets.findSets(e.get_vertexFrom())!=disjointSets.findSets(e.get_vertexTo())){
				disjointSets.union(e.get_vertexFrom(), e.get_vertexTo()); 
		kuskalEdges.add(e);
			 }
		 }
//	 	 
//
//	}
//
//	public Edge findminEdgeNotVisited(LinkedList<Edge> pureEdge){
//		
//		Edge edge=pureEdge.getFirst();
//		pureEdge.removeFirst();
//		return edge;	
//	}
//	
//	/* (non-Javadoc)
//	 * @see hue09.Graph.Dijkstra.Algo#startAlgo(hue09.Graph.Dijkstra.Vertex, java.lang.Integer, java.util.Set)
//	 */
//	@Override
//	public void startAlgo(Vertex currentNode, Integer cost, Set<Vertex> visitedEdges) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	/* (non-Javadoc)
//	 * @see hue09.Graph.Dijkstra.Algo#relaxation(hue09.Graph.Dijkstra.Edge, java.lang.Integer)
//	 */
//	@Override
//	public void relaxation(Edge min, Integer cost) {
//		// TODO Auto-generated method stub
//		
	}



}
