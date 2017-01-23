package hue04hue05.BinaereBaum.hue04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

public class run {
	/**
	 * @author Elisabeth Gombkötö
	 * @since 10.11.2016 geendert am 28.11.2016
	 * 
	 */
	public run() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
//		BinearTreeFaktory<Integer> btf = new BinearTreeFaktory<Integer>();
//		Tree<Integer> result = null;
//		Integer[] values = null;
//		try {
//			values = getArrayFromFile(new File("C:\\Users\\Elisabeth\\workspace2\\Alg.ex1\\src\\hue04hue05\\BinaereBaum\\hue04\\ue01testdata.txt"));
//			
//			result=btf.getInstance(values);
//			System.out.println("***********************");
//			result.printTree(PrintPossibilitis.inOrder);
//			
//			Tree<Integer> bst= new BinearSearchTree<>();
//			//bst= btf.convertBinearTreeToBinearSearchTree(result);
//			
//			//result=new BinearSearchTree<>();			
//	
//			System.out.println("***********************");
//			int heigth=result.heightOfTree();
//			System.out.println(heigth);
//			
//			
//			
//			
//			
//			 
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//	/*
//	 * Read file and give a Integer[] back, 
//	 */
//	private static Integer[] getArrayFromFile(File file) throws FileNotFoundException {
//		List<Integer> values = new ArrayList<Integer>();
//		//values.add(null);
//		Scanner scanner = new Scanner(file);
//		while (scanner.hasNextInt()) {
//			values.add(scanner.nextInt());
//		}
//		scanner.close();
//		Integer[] v = new Integer[values.size() + 1];
//		/*
//		 * first pos in Array keep empty because we have to calculate the children later
//		 */
//		for(int i = 0; i < values.size(); i++)
//		{
//			v[i+1] = values.get(i);
//		}
//		for(int j=1; j<v.length;j++){
//			System.out.println(v[j]);
//		}
//		
//		return v;
//	}
	
	Integer[] values = { 10, 5, 15,124,33,154,60,6,12,9,7,13,54,1,54,1,24,7867,34,1,54 };
	Tree<Integer> tree = new BinearSearchTree<Integer>();
	for(int i = 0; i < values.length; i++)
	{
		tree.insert(values[i]);
	}
	tree.InorderTreeTraversalIterativ(tree.get_root());
	



}
}
