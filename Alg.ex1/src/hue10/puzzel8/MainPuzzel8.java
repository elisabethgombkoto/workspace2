/**
 * 
 */
package hue10.puzzel8;

/**
 * @author ElisabethElisabeth Gombk�t�
 *17.01.2017WS_2016
 */
public class MainPuzzel8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] start={{1,2,3},
						{4,5,6},
						{7,8,0}};
		int[][] end={{1,2,3},
					{4,5,0},
					{7,8,6}};
		Puzzle8 s= new Puzzle8(start);
		Puzzle8 e= new Puzzle8(end);
		PuzzelSolver h1= new H1();
		PuzzelSolver h0= new H0_WithoutHeuristics();

		h1.solv(s, e);
		
		Solutions solutions = h1.solv(s, e);
		solutions.printSummary();
		
		
		

	}

}
