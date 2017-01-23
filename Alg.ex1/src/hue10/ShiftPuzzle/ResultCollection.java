/**
 * 
 */
package hue10.ShiftPuzzle;

import java.util.List;
import java.util.Set;

/**
 * @author ElisabethElisabeth Gombkötö
 *17.01.2017WS_2016
 */
public class ResultCollection {
	public final boolean hasSolution;
	public final List<AchterPuzzle> solutionNodes;
	public final int amountCreatedNodes;
	public final Set<AchterPuzzle> visitedNodes;

	/*
	 * branching factor: average different combinations per field corner: 4
	 * corners. 2 moves each. = 8 side: 4 sides. 3 moves each. = 12 middle: 1
	 * middle. 4 moves each. = 4 sum = 24 fields = 9 (4 + 4 + 1) branching
	 * factor: sum / fields
	 */
	public double effectiveBranchingFactor = 1.0;

	public ResultCollection(boolean hasSolution, List<AchterPuzzle> solutionNodes, int amountCreatedNodes,
			Set<AchterPuzzle> visitedNodes) {
		this.hasSolution = hasSolution;
		this.solutionNodes = solutionNodes;
		this.amountCreatedNodes = amountCreatedNodes;
		this.visitedNodes = visitedNodes;

		double n = amountCreatedNodes;
		double d = solutionNodes.size();
		this.effectiveBranchingFactor = EffectiveBranchingFactorCalculator.calculateNoCloseForm(n, d);
	}

	public void printSummary() {
		System.out.println("start node: ");
		System.out.println(solutionNodes.get(0));
		System.out.println("end node: ");
		System.out.println(solutionNodes.get(solutionNodes.size() - 1));
		System.out.println("solution found: " + hasSolution);
		System.out.println("optimal path: " + solutionNodes.size());
		System.out.println("nodes created: " + amountCreatedNodes);
		System.out.println("nodes visited: " + visitedNodes.size());
		System.out.println("effective brancing factor: " + effectiveBranchingFactor);

	}

	public void printSolutionNodes() {
		System.out.println("optimal path: ");
		for (AchterPuzzle p : solutionNodes) {
			System.out.println(p.toString() + "\n");
		}
	}

	public void printVisitedNodes() {
		System.out.println("visited nodes: ");
		for (AchterPuzzle p : visitedNodes) {
			System.out.println(p.toString() + "\n");
		}
	}
}
