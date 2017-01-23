package alg.bor4027.ext8.task2;

import java.util.LinkedList;

/**
 * @author Bernd
 *
 */
public class DijkstraAlgo extends Algo {

	public DijkstraAlgo(Graph graph, Node startNode) {
		_graph = graph;
		_startNode = startNode;
		_destNodeList = new LinkedList<Node>(graph.get_nodeSet().values());
		_costs = new Integer[_destNodeList.size()];

		initialAlgo();
		startAlgo(startNode, 0);

	}
	@Override
	public void startAlgo(Node currentNode, Integer cost) {
		if (!currentNode.isVisited()) {
			LinkedList<Edge> edges = currentNode.get_adjList();
			if (!edges.isEmpty()) {
				for (Edge e : edges) {
					if (_costs[_destNodeList.indexOf(e.getDestNode())] == Integer.MAX_VALUE
							|| _costs[_destNodeList.indexOf(e.getDestNode())] > cost + e.getCost()) {
						_costs[_destNodeList.indexOf(e.getDestNode())] = cost + e.getCost();
					}
					currentNode.setVisited(true);
					startAlgo(e.getDestNode(), cost + e.getCost());

				}

			}

		}
	}

}
