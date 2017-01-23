package ILIAS;

public class RunMe {
	/**
	 * @param args
	 */
	public static void init (Graph g) {

		try {
			g.addNode("s");
			g.addNode("a");
			g.addNode("u");
			g.addNode("v");
			g.addNode("c");
		

		} catch (NodeAlreadyDafinedException e) {
			
			e.printStackTrace();
		}

		g.addEdge("s", "a", 5);
		g.addEdge("s", "u", 10);
		g.addEdge("u", "a", 2);
		g.addEdge("a", "u", 3);
		g.addEdge("u", "v", 1);
		g.addEdge("a", "c", 2);
		g.addEdge("c", "v", 6);
		g.addEdge("v", "c", 5);
		g.addEdge("c", "s", 7);

		
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
