package test.at.fhv.sma.struct;

import java.io.IOException;

public class Run {
	public static void main(String[] args) {
		Graph g;
		try {
//			g = Graph.createGraph(".//resources//graph_noPath_noTour.txt", AdjacencyStructureType.LIST); // graph.txt
//			g = Graph.createGraph(".//resources//graph_euler_tour.txt", AdjacencyStructureType.LIST);
			g = Graph.createGraph(".//resources//house_of_nicolaus.txt", test.at.fhv.sma.struct.Graph.AdjacencyStructureType.LIST);
			g.print();
//			System.out.println(g.hasEulerPath());
			System.out.println(g.hasEulerTour());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
