/**
 * 
 */
package hue09.Graph.Dijkstra;

/**
 * @author Elisabeth Gombkötö
 *
 */
public class RunMeDij {

	/**
	 * @param args
	 */
	public static void init (Graph g) {

		try {
			g.addNode("f");
			g.addNode("c");
			g.addNode("a");
			g.addNode("b");
			g.addNode("d");
			g.addNode("g");
			g.addNode("e");
			g.addNode("h");
			g.addNode("i");

		} catch (NodeAlreadyDefinedException e) {
			
			e.printStackTrace();
		}

		g.addEdge("a", "b", 1);
		g.addEdge("a", "c", 7);
		
		g.addEdge("b", "d", 2);
		g.addEdge("b", "e", 6);
		
		g.addEdge("c", "e", 5);
		g.addEdge("c", "f", 5);
		
		g.addEdge("f", "h", 1);
		
		g.addEdge("e", "h", 3);
		g.addEdge("e", "g", 1);
		
		g.addEdge("d", "g", 2);
		
		g.addEdge("g", "i", 1);
		g.addEdge("h", "i", 1);
		
	}

	public static void main(String[] args) {
		Graph g = new Graph();
		init(g);
		Algo a;
	a = new DijkstraAlgo(g, g.getVertex("a"));
	a.printCost();
		
		a = new PrimAlgo(g, g.getVertex("a"));
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
