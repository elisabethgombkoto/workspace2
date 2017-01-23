package test.at.fhv.sma.struct;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import test.at.fhv.sma.struct.Graph.AdjacencyStructureType;

public class TestGraph {
	
	private Graph gPathMatrix = null;
	private Graph gPathList = null;
	private Graph gNoTourNoPathMatrix = null;
	private Graph gNoTourNoPathList = null;
	private Graph gTourList = null;
	private Graph gTourMatrix = null;
	
	@Before
	public void init() {
		try {
			gPathMatrix = Graph.createGraph(".//resources//house_of_nicolaus.txt", AdjacencyStructureType.MATRIX);
			gPathList = Graph.createGraph(".//resources//house_of_nicolaus.txt", AdjacencyStructureType.LIST);
			gNoTourNoPathMatrix = Graph.createGraph(".//resources//graph_noPath_noTour.txt", AdjacencyStructureType.MATRIX);
			gNoTourNoPathList = Graph.createGraph(".//resources//graph_noPath_noTour.txt", AdjacencyStructureType.LIST);
			gTourList = Graph.createGraph(".//resources//graph_euler_tour.txt", AdjacencyStructureType.LIST);
			gTourMatrix = Graph.createGraph(".//resources//graph_euler_tour.txt", AdjacencyStructureType.MATRIX);
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

}
