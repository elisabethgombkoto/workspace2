package hue06.Graph_int_primitive;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import hue06.Graph_int_primitive.Graph.AdjacencyStructureType;


public class GraphTest {

	private Graph gPathMatrix = null;
	private Graph gPathList = null;
	private Graph gNoTourNoPathMatrix = null;
	private Graph gNoTourNoPathList = null;
	private Graph gTourList = null;
	private Graph gTourMatrix = null;
	
	@Before
	public void init() {
		try {
			gPathMatrix = Graph.createGraph(".\\testdata\\HouseOfNicolaus.txt", AdjacencyStructureType.MATRIX);
			gPathList = Graph.createGraph(".\\testdata\\HouseOfNicolaus.txt", AdjacencyStructureType.LIST);
			gNoTourNoPathMatrix = Graph.createGraph(".\\testdata\\has_no_path.txt", AdjacencyStructureType.MATRIX);
			gNoTourNoPathList = Graph.createGraph(".\\testdata\\has_no_path.txt", AdjacencyStructureType.LIST);
			gTourList = Graph.createGraph(".\\testdata\\hasEulerPhade.txt", AdjacencyStructureType.LIST);
			gTourMatrix = Graph.createGraph(".\\testdata\\hasEulerPhade.txt", AdjacencyStructureType.MATRIX);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testListPrint() {
		gPathList.print();
	}
	
	@Test
	public void testMatrixPrint() {
		gPathMatrix.print();
	}

	@Test
	public void testListNoTourNoPath() {
		assertFalse(gNoTourNoPathList.hasEulerPath());
		assertFalse(gNoTourNoPathMatrix.hasEulerTour());
	}
	
	@Test
	public void testMatrixNoTourNoPath() {
		assertFalse(gNoTourNoPathMatrix.hasEulerPath());
		assertFalse(gNoTourNoPathMatrix.hasEulerTour());
	}
	
	@Test
	public void testListTour() {
		assertTrue(gTourList.hasEulerTour());
	}
	
	@Test
	public void testMatrixTour() {
		assertTrue(gTourMatrix.hasEulerTour());
	}
	
	@Test
	public void testListPath() {
		assertTrue(gPathList.hasEulerPath());
	}
	
	@Test
	public void testMatrixPath() {
		assertTrue(gPathMatrix.hasEulerPath());
	}
	
	@Test
	public void testMatrixFindEulerPhade(){
		LinkedList<Integer> list = gPathMatrix.findEulerPath(4, null);
		Integer[] arr = list.toArray(new Integer[9]);
		Integer[] expected = new Integer[]{4,2,1,3,2,5,3,4,5};
		assertArrayEquals(expected, arr);
	}
	
	@Test
	public void testListFindeEulerPhade(){
		LinkedList<Integer> list=gPathList.findEulerPath(4,null);
		Integer[] arr = list.toArray(new Integer[9]);
		Integer[] expected = new Integer[]{4,2,1,3,2,5,3,4,5};
		assertArrayEquals(expected, arr);
	}
}