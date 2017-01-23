/**
 * 
 */
package hue06.task1.GarphErzeugen;

import javax.management.InvalidAttributeValueException;

/**
 * @author Elisabeth
 *
 */
public class Drachenmain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Graph g = new Graph(7,6);
		try {
			g.addEdgeToGarph(new Edge(0, 1,new Calculate(42)));
		
		g.addEdgeToGarph(new Edge(0, 2, new Calculate(5)));
		g.addEdgeToGarph(new Edge(0, 3, new Calculate(19)));
		
		g.addEdgeToGarph(new Edge(1, 2, new Calculate(3)));
		g.addEdgeToGarph(new Edge(1, 4, new Calculate(17)));		
		g.addEdgeToGarph(new Edge(2, 3, new Calculate(121)));
		
		g.addEdgeToGarph(new Edge(2, 5, new Calculate(4)));	
		Dijkstra dijkstra= new Dijkstra(g, 0);
		System.out.println(dijkstra.dijksta(0, g));
		} catch (InvalidAttributeValueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
