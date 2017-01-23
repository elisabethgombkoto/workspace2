package alg.bor4027.ext8.task2;

import java.util.LinkedList;

public class PrimAlgo extends Algo{

	public PrimAlgo(Graph graph, Node startNode){
		_graph = graph;
		_startNode = startNode;
		_destNodeList = new LinkedList<Node>(graph.get_nodeSet().values());
		_costs = new Integer[_destNodeList.size()];
		
		initialAlgo();
		startAlgo(startNode, 0);
	}

	/* 
	 * startet PrimAlgo mit übergebenen StartNode und 
	 */
	@Override
	public void startAlgo(Node currentNode, Integer cost) {
		if(!currentNode.isVisited()){
			LinkedList<Edge> edges = currentNode.get_adjList();
			while (!edges.isEmpty()){
				Edge min = edges.getFirst();
				for (Edge e : edges){
					if (min.getCost() > e.getCost()){
						min = edges.get(edges.indexOf(e));
					}
				}
				min = edges.remove(edges.indexOf(min));
				if (_costs[_destNodeList.indexOf(min.getDestNode())] == Integer.MAX_VALUE
					|| _costs[_destNodeList.indexOf(min.getDestNode())] > cost + min.getCost()){
					_costs[_destNodeList.indexOf(min.getDestNode())] = cost + min.getCost();
					
				}
				currentNode.setVisited(true);
				startAlgo(min.getDestNode(), cost + min.getCost());
					
			}
	
		}
		
	}
}
