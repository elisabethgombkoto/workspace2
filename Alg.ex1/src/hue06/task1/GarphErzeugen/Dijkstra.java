/**
 * 
 */
package hue06.task1.GarphErzeugen;



import java.util.LinkedList;

import javax.management.InvalidAttributeValueException;
import javax.print.attribute.standard.RequestingUserName;

/**
 * @author Elisabeth Gombkoto
 * @since 17.12.2016
 *
 */
public class Dijkstra  implements Relaxationable  {
	private Graph graph;
    private Integer startVertex;
    boolean[] closeList;
    private Integer[] costs;	
    int V;
    private static final Integer POSITIVE_INFINITY = Integer.MAX_VALUE;	

    public Dijkstra(Graph g, Integer start){
        
    	V= g.get_amountOfEdges();
     costs= new Integer[V];
    	closeList= new boolean[V];
    	Path path= new Path();
    }

/**
 * @param Integer startVertex
 * @param Graph graph
 * @return Path path
 * @throws InvalidAttributeValueException 
 * 
 */
public Path dijksta(Integer startVertex, Graph graph) throws InvalidAttributeValueException{
	

Path path= new Path(0);

V=graph.get_amountOfEdges();
	for( int v=0; v<V; v++){
		costs[v]=POSITIVE_INFINITY;
		closeList[v]=false;
		}	
	costs[startVertex]=0;	

	
	for(int i=0;i<V;i++){
		
		Integer currentV =get_UnvisitedMinVertex(costs,closeList,V);	
		closeList[currentV]=true;
		for(Edge edge:graph.getEdgesFromGarph(currentV)){
			if(costs[edge.get_vertexTo()]>costs[currentV]+ edge.get_weight().get_operand()){ 
				costs[edge.get_vertexTo()]=costs[currentV]+ edge.get_weight().get_operand();				
				path.addEdge(edge);
				}
			}
		}
	return path;	
}

/**
 * @param Integer[] costs, the cost another Vertex
 * @param boolean[] closeList ->array[index] is a Vertex, if  visited than true, else false
 * @param int V ->amountOfEdges
 * @return int minIndex
 */   
private int get_UnvisitedMinVertex (Integer[] costs, boolean[] closeList, int V){
	
    // Initialize min value
    int min = POSITIVE_INFINITY;
    int min_index=-1;

    for (int v = 0; v < V; v++)
        if (closeList[v] == false && costs[v] <= min)
        {
            min = costs[v];
            min_index = v;
        }

    return min_index;
}



/* (non-Javadoc)
 * @see hue06.task1.GarphErzeugen.Relaxationable#relaxation()
 */
@Override
public Integer relaxation(Edge edge, Integer[] costs, Integer currentV) {
	if(costs[edge.get_vertexTo()]>costs[currentV]+ edge.get_weight().get_operand()){ 
		return costs[edge.get_vertexTo()]=costs[currentV]+ edge.get_weight().get_operand();
}else{
	return costs[currentV];
	
}


}
/**
 * @return the v
 */
public int getV() {
	return V;
}
}
