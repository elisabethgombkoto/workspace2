package hue06.task1.GarphErzeugen;

import javax.management.InvalidAttributeValueException;

/**
 * @author Elisabeth Gombkötö
 * @since 10.12.2016
 *
 */
public class DracheMain {

	public static void main(String[] args) throws InvalidAttributeValueException {
		
Graph g = new Graph(12);
		
		g.addEdgeToGarph(new Edge(0, 1,new Calculate("+",42)));
		g.addEdgeToGarph(new Edge(0, 2, new Calculate("*",5)));
		g.addEdgeToGarph(new Edge(0, 3, new Calculate("-",19)));
		
		g.addEdgeToGarph(new Edge(1, 2, new Calculate("/",3)));
		g.addEdgeToGarph(new Edge(1, 4, new Calculate("-",17)));		
		g.addEdgeToGarph(new Edge(2, 3, new Calculate("+",121)));
		
		g.addEdgeToGarph(new Edge(2, 5, new Calculate("*",4)));		
		g.addEdgeToGarph(new Edge(3, 6, new Calculate("+",171)));		
		g.addEdgeToGarph(new Edge(4, 7, new Calculate("*",24)));
		
		g.addEdgeToGarph(new Edge(4, 8, new Calculate("+",285)));		
		g.addEdgeToGarph(new Edge(5, 6, new Calculate("/",5)));
		g.addEdgeToGarph(new Edge(5, 7, new Calculate("-",21)));
		
		g.addEdgeToGarph(new Edge(6, 10, new Calculate("*",3)));		
		g.addEdgeToGarph(new Edge(7, 8, new Calculate("-",265)));
		g.addEdgeToGarph(new Edge(7, 11, new Calculate("+",317)));
		
		g.addEdgeToGarph(new Edge(7, 9, new Calculate("/",8)));		
		g.addEdgeToGarph(new Edge(8, 11, new Calculate("*",3)));		
		g.addEdgeToGarph(new Edge(9, 10, new Calculate("*",12)));
		
		g.addEdgeToGarph(new Edge(9, 11, new Calculate("/",3)));			
		g.addEdgeToGarph(new Edge(10, 11, new Calculate("-",9)));
		
//System.out.println(g.get_amountOfEdges());
System.out.println(g.findKlotwilde_MaxCost(0,11,33).getCost());
System.out.println(g.findKlotwilde_MaxCost(0, 11,33).toString());

System.out.println(g.findKlotmildeMinCostPath(0,11,33).getCost());
System.out.println(g.findKlotmildeMinCostPath(0,11, 33).toString());

System.out.println(g.findKlothilde_999Cost(0, 11, 33).getCost());
System.out.println(g.findKlothilde_999Cost(0,11,33).toString());


//Path _path= new Path(33);
//
//_path.addEdge(new Edge(1,2,new Calculate("'", 2)));
//System.out.println(_path.getCost().toString());
//
//_path.addEdge(new Edge(1,3,new Calculate("/",5)));
//System.out.println(_path.getCost().toString());
//
//_path.addEdge(new Edge(3,4,new Calculate("/",5)));
//System.out.println(_path.getCost().toString());
//


	}

}
