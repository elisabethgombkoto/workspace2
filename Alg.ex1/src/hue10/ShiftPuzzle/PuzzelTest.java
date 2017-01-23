/**
 * 
 */
package hue10.ShiftPuzzle;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author ElisabethElisabeth Gombk�t�
 *17.01.2017WS_2016
 */
public class PuzzelTest {

public static AchterPuzzle start, end;
	
	@BeforeClass
	public static void setUpBeforeClass()
	{
		int[] startData, endData;
		endData = new int[]
//				{
//					1, 2, 3,
//					8, 0, 4,
//					7, 6, 5
//				};
				{
					1, 2, 3,
					4, 5, 6,
					7, 8, 0
				};
		startData = new int[]
//				{
//					2, 8, 1,
//					4, 6, 3,
//					0, 7, 5
//				};
				{
					3, 6, 4,
					2, 7, 8,
					5, 1, 0
				};
//				{
//					0, 1, 2,
//					5, 6, 3,
//					4, 7, 8
//				};
		end = new AchterPuzzle(endData);
		start = new AchterPuzzle(startData);
	}
	
	@Test
	public void testUninformed() { 
		System.out.println("uninformed:");
		ResultCollection rs = new H0Uninformed().solveProblem(start, end);
		rs.printSummary();
	}
	
	@Test
	public void testH1()
	{	
		System.out.println("h1:");
		ResultCollection rs = new H1AchterPuzzleSolver().solveProblem(start, end);
		rs.printSummary();
		System.out.println();
	}
	
	@Test
	public void testH2()
	{	
		System.out.println("h2:");
		ResultCollection rs = new H2AchterPuzzleSolver().solveProblem(start, end);
		rs.printSummary();
		System.out.println();
		//for more details:
		//rs.printSolutionNodes(); 
		//rs.printVisitedNodes(); //unreadable when amount of nodes visited is high
	}

}
