package hue06.Graph_int_primitive;

import java.io.IOException;

import hue06.Graph_int_primitive.Graph.AdjacencyStructureType;

public class MainGraph {

	public static void main(String[] args) {
		Graph graph;
		try {
			// graph = Graph.createGraph("testdata\\has_no_path.txt", AdjacencyStructureType.LIST);
			//graph = Graph.createGraph("testdata\\HouseOfNicolaus.txt", AdjacencyStructureType.LIST);
			graph=Graph.createGraph("testdata\\HouseOfNicolaus.txt", AdjacencyStructureType.MATRIX);
			//graph= Graph.createGraph("testdata\\has_no_path.txt", AdjacencyStructureType.MATRIX);
			
			graph.print();
			 
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
