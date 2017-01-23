package hue06.task1.GarphErzeugen;

import java.util.LinkedList;

import javax.management.InvalidAttributeValueException;

/**
 * @author Elisabeth Gombkötö
 * @since 10.12.2016
 */
public class Path {
	
private LinkedList<Edge> _edges= new LinkedList<>();

private int _cost=0;

/**
 * Constructor
 * erzeugt neu Path object 
 * @param startCost
 */
public Path(int startCost){
	_cost=startCost;
}

public Path(Edge edge) throws InvalidAttributeValueException{
	_cost=edge.get_weight().get_operand()+_cost;
	
	_edges.add(new Edge(edge.get_vertexFrom(), edge.get_vertexTo(),edge.get_weight()));
}
/**
 * Constructor
 * 
 * erzeugt neu {@link Path} Object durch die erweiterung den alten
 * cost wird übernommen und die {@link Edge} werden in einem 
 * {@link LinkedList} gespeichert
 * 
 * @param path
 * @throws InvalidAttributeValueException
 */
public Path(Path path) throws InvalidAttributeValueException {
	_cost = path._cost;
	_edges = new LinkedList<Edge>();
	for(Edge edge : path._edges) {
		_edges.add(new Edge(edge.get_vertexFrom(), edge.get_vertexTo(),edge.get_weight()));
	}
}
public Path(){
	
}
/**
 * rechnet jede einzelne Edge koste aus und summirt die
 *  
 * @return Integer Cost from Path
 */
public Integer getCost() {	
	int cost = _cost;
	
	for(Edge edge : _edges) {		
		    cost = edge.get_weight().get_operation().resultFor(cost);	
	}	
	
	return cost;
}

/**
 * fügt nach FiFo->weil {@link LinkedList} 
 * {@link Edge} zu {@link Path} dazu
 * 
 * @param Edge edge
 */
public void addEdge(Edge edge) {
	_edges.add(edge);
}

/**
 * entfernt nach FiFo->weil {@link LinkedList} 
 * {@link Edge} von {@link Path} 
 */
public void removeLastEdge() {
	_edges.removeLast();
}

/**
 * gibt der letzte {@link Edge} in 
 * {@link LinkedList} also von {@link Path}
 * zurück
 *   
 * @return Edge edge
 */
public Edge getEdge(){
	return _edges.getLast();
}


/* 
 * ermöglicht die übersichliche ausgabe von den Path was 
 * ein Algorimus erzeugt hat 
 * 
 * (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
	public String toString() {
	String path="Path besteht aus folgende Vertices: [0-> ";
	int current=0;
		for(Edge p:_edges){
			if(current==p.get_vertexFrom()){
				path=path.concat(Integer.toString(p.get_vertexTo())+" -> ");
				current=p.get_vertexTo();
			}else{
				path=path.concat(Integer.toString(p.get_vertexFrom())+" -> ");
				current=p.get_vertexFrom();
			}
			
		}
		path=path.trim();
		path=path.substring(0, path.length()-3);
		path=path.concat("]");
		return path;
	}
}
