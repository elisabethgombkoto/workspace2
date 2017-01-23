
package hue06.task1.GarphErzeugen;

import javax.management.InvalidAttributeValueException;

/**
 * @author Elisabeth Gombkoto
 *
 */
public class Prime extends Algoritmus implements Relaxationable {

	private static final Integer POSITIVE_INFINITY = Integer.MAX_VALUE;
	
	public Path prime(Integer startVertex, Graph graph) throws InvalidAttributeValueException{
		
		int V= graph.get_amountOfEdges();
		Integer[] costs= new Integer[V];
		boolean[] closeList= new boolean[V];
		Path path= new Path(0);


			for( int v=0; v<V; v++){
				costs[v]=POSITIVE_INFINITY;
				closeList[v]=false;
				}	
			costs[startVertex]=0;	

			
			for(int i=0;i<V-1;i++){
				
				Integer currentV =get_UnvisitedMinVertex(costs,closeList,V);	
				closeList[currentV]=true;
				
				for(Edge edge:graph.getEdgesFromGarph(currentV)){
					
					if(costs[edge.get_vertexTo()]>costs[currentV]){ 
						costs[edge.get_vertexTo()]=costs[currentV];				
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
	        if (closeList[v] == false && costs[v] < min)
	        {
	            min = costs[v];
	            min_index = v;
	        }

	    return min_index;
	}
	
	
	/* (non-Javadoc)
	 * @see hue06.task1.GarphErzeugen.Algoritmus#setPath(hue06.task1.GarphErzeugen.Path)
	 */
	@Override
	public void setPath(Path possiblePath) throws InvalidAttributeValueException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see hue06.task1.GarphErzeugen.Relaxationable#relaxation(hue06.task1.GarphErzeugen.Edge, java.lang.Integer[], java.lang.Integer)
	 */
	@Override
	public Integer relaxation(Edge edge, Integer[] costs, Integer currentV) {
		if(costs[edge.get_vertexTo()]>costs[currentV]){ 
			return costs[edge.get_vertexTo()]=costs[currentV];
			
			}else{
				return costs[currentV];
			}
	}

}
