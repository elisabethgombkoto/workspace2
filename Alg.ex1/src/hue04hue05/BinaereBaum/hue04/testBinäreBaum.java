package hue04hue05.BinaereBaum.hue04;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.omg.CORBA.PRIVATE_MEMBER;

public class testBinäreBaum {
	/**
	 * @author Elisabeth Gombkötö
	 * @since 10.11.2016 geendert am 28.11.2016
	 * 
	 */
	@Test
	public void testRemoveRecLeaf() {
		Integer[] values = { 10, 5, 15 };
		Tree<Integer> tree = new BinearSearchTree<Integer>();
		for(int i = 0; i < values.length; i++)
		{
			tree.insert(values[i]);
		}
		Integer data=15;
		try {
			assertEquals(true, tree.removeRec(data));
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	@Test
	public void testRemoveRecLeafBinTree() {
		Integer[] values = { 10,5, 15 };
		Tree<Integer> tree = new BinearTree<Integer>();
		for(int i = 0; i < values.length; i++)
		{
			tree.insert(values[i]);
		}
		Integer data=15;
		try {
			assertEquals(true, tree.removeRec(data));
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	
	@Test
	public void testRemoveRoot() {
		Integer[] values = { 10, 5, 15 };
		Tree<Integer> tree = new BinearSearchTree<Integer>();
		for(int i = 0; i < values.length; i++)
		{
			tree.insert(values[i]);
		}
		Integer data=10;
		try {
			assertEquals(true, tree.removeRec(data));
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	@Test
	public void testRemoveInternalRoot() {
		Integer[] values = { 10, 5, 15,13,17};
		Tree<Integer> tree = new BinearSearchTree<Integer>();
		for(int i = 0; i < values.length; i++)
		{
			tree.insert(values[i]);
		}
		Integer data=15;
		try {
			assertEquals(true, tree.removeRec(data));
		} catch (IllegalArgumentException e) {
			//TODO
			e.printStackTrace();
		}
		}
	
		
	
	
	@Test
	public void testSENT() {
		String testString="1011010011";
		DecodeBinearTree tree= new DecodeBinearTree();
		String actuals = tree.encode(testString);
		char[]actual= actuals.toCharArray();
		String expecteds="SENT";
		char[] expected =expecteds.toCharArray();
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testTENNIS() {
		String testString="11010010010101011";
		DecodeBinearTree tree= new DecodeBinearTree();
		String actuals = tree.encode(testString);
		char[]actual= actuals.toCharArray();
		String expecteds="TENNIS";
		char[] expected =expecteds.toCharArray();
		assertArrayEquals(expected, actual);
	}


}
