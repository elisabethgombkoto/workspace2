package at.fhv.sma;

import at.fhv.sma.graph.Edge;
import at.fhv.sma.graph.Graph;
import at.fhv.sma.graph.Path;
import at.fhv.sma.math.Addition;
import at.fhv.sma.math.Division;
import at.fhv.sma.math.Multiplication;
import at.fhv.sma.math.Subtraction;

public class Run {
	
	private static final int SPECIFIC_COST = 999;

	public static void main(String[] args) {
		Graph g = new Graph(12);
		
		g.addEdge(new Edge(0, 1, new Addition(42)));
		g.addEdge(new Edge(0, 2, new Multiplication(5)));
		g.addEdge(new Edge(0, 3, new Subtraction(19)));
		
		g.addEdge(new Edge(1, 2, new Division(3)));
		g.addEdge(new Edge(1, 4, new Subtraction(17)));
		
		g.addEdge(new Edge(2, 3, new Addition(121)));
		g.addEdge(new Edge(2, 5, new Multiplication(4)));
		
		g.addEdge(new Edge(3, 6, new Addition(171)));
		
		g.addEdge(new Edge(4, 7, new Multiplication(24)));
		g.addEdge(new Edge(4, 8, new Addition(285)));
		
		g.addEdge(new Edge(5, 6, new Division(5)));
		g.addEdge(new Edge(5, 7, new Subtraction(21)));
		
		g.addEdge(new Edge(6, 10, new Multiplication(3)));
		
		g.addEdge(new Edge(7, 8, new Subtraction(265)));
		g.addEdge(new Edge(7, 11, new Addition(317)));
		g.addEdge(new Edge(7, 9, new Division(8)));
		
		g.addEdge(new Edge(8, 11, new Multiplication(3)));
		
		g.addEdge(new Edge(9, 10, new Multiplication(12)));
		g.addEdge(new Edge(9, 11, new Division(3)));
		
		g.addEdge(new Edge(10, 11, new Subtraction(9)));
		
		Path maxPath = g.findMax(0, 11, 33);
		System.out.println("### Maximum ###");
		System.out.println("Cost " + maxPath.getCost());
		System.out.println("Path " + maxPath);
		
		Path minPath = g.findMin(0, 11, 33);
		System.out.println("### Minimum ###");
		System.out.println("Cost " + minPath.getCost());
		System.out.println("Path " + minPath);
		
		Path specifictPath = g.findSpecificPath(0, 11, 33, SPECIFIC_COST);
		if(specifictPath != null) {
			System.out.println("### Specific " + SPECIFIC_COST + " ###");
			System.out.println("Cost " + specifictPath.getCost());
			System.out.println("Path " + specifictPath);
		} else {
			System.out.println("No path found!");
		}
	}

}
