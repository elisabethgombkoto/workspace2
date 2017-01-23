/**
 * 
 */
package hue09.Graph.Dijkstra;

/**
 * @author Elisabeth
 *
 */
public class RunMe {

	/**
	 * @param args
	 */
	public static void init (Graph g) {

		try {
			g.addNode("s");
			g.addNode("x");
			g.addNode("u");
			g.addNode("v");
			g.addNode("y");
			//g.addNode("s");

		} catch (NodeAlreadyDefinedException e) {
			
			e.printStackTrace();
		}

		g.addEdge("s", "x", 5);
		g.addEdge("s", "u", 10);
		g.addEdge("u", "x", 2);
		g.addEdge("x", "u", 3);
		g.addEdge("u", "v", 1);
		g.addEdge("x", "y", 2);
		g.addEdge("y", "v", 6);
		g.addEdge("v", "y", 5);
		g.addEdge("y", "s", 7);

		
	}

	public static void main(String[] args) {
		Graph g = new Graph();
		init(g);
		Algo a;
	a = new DijkstraAlgo(g, g.getNode("s"));
a.printCost();
		
		a = new PrimAlgo(g, g.getNode("s"));
		a.printCost();
		
	
		/**
		 * for (Entry n : g.get_nodeSet().entrySet()){
		 * 
		 * 
		 * System.out.println(n.toString());
		 * 
		 * }
		 */
		
	}

}
