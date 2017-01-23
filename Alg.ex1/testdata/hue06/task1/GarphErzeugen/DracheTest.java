package hue06.task1.GarphErzeugen;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import javax.management.InvalidAttributeValueException;

import org.junit.Test;

public class DracheTest {

	@Test
	public void test() {
		int result=0;
		try {
			Path p= new Path(33);
			Edge edge1= new Edge(1, 2, new Calculate("+",2));
			//Edge edge2= new Edge(2,1,new Calculate("+",2));
			LinkedList<Edge> edges= new LinkedList<>();
			edges.add(edge1);
			//edges.add(edge2);
			Path path= new Path(p);
			
			
			result=path.getCost();
			
		
		} catch (InvalidAttributeValueException e) {
			
			e.printStackTrace();
		}
System.out.println(result);
		assertEquals(Integer.valueOf(37), Integer.valueOf(result));
	}

}
