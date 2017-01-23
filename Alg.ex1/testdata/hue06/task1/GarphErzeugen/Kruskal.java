/**
 * 
 */
package hue06.task1.GarphErzeugen;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Elisabeth
 *
 */
public class Kruskal {

Graph graph;



public void Kruskal(Graph graph){
	
	 List<LinkedList<Edge>> edges=graph.get_edges();
	 LinkedList<Edge> pureEdge=new LinkedList<>();
	 LinkedList<Edge> kuskalEdges= new LinkedList<>();
	
	 for(int i=0;i<edges.size();i++){
		 for(int j=0; j<edges.get(i).size(); j++){
		pureEdge.add( edges.get(i).get(j));
		 }
	 } 
	
	 Collections.sort(pureEdge);
	 DisjointSets disjointSets= new DisjointSets(graph.get_amountOfVertices());
	 
	 
	 while(!pureEdge.isEmpty()&& disjointSets.getArray().size()>1){
		 Edge e= findminEdgeNotVisited(pureEdge);
		 if(disjointSets.findSets(e.get_vertexFrom())!=disjointSets.findSets(e.get_vertexTo())){
			disjointSets.union(e.get_vertexFrom(), e.get_vertexTo()); 
	kuskalEdges.add(e);
		 }
	 }
 	 

}

public Edge findminEdgeNotVisited(LinkedList<Edge> pureEdge){
	
	Edge edge=pureEdge.getFirst();
	pureEdge.removeFirst();
	return edge;	
}
}
