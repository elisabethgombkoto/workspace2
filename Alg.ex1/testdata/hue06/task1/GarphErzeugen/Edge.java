package hue06.task1.GarphErzeugen;


import java.util.Comparator;

import javax.management.InvalidAttributeValueException;


/**
 * @author Elisabeth Gombkötö
 * 
 *Wenn als default Wert Integer 0 bei Kantengewicht nicht akzeptabel 
 *sollte je nach Parametizierung default wert neu implementiert werden.
 *
 * @param <Intger>
 * @param default parameter Integer 0, if WeightOfEdge<T> _weight do not exist
 * 
 */
public class Edge implements Comparable<Edge>{
	
		private Integer _vertexFrom;
		private Integer _vertexTo;		
		private Calculate _weight;
		
		
		/**
		 * @param from--> Kante startet von diesen Object
		 * @param to--> Kante endet bei diesen Object
		 * @param weight--> kantengewicht besteht aus operator und operand {@link Calculate}
		 * @throws InvalidAttributeValueException 
		 * @see {@link Calculate}
		 */
		public Edge( Integer vertexFrom, Integer vertexTo, Calculate weight ) throws InvalidAttributeValueException{
			_vertexFrom=vertexFrom;
			_vertexTo=vertexTo;
			_weight=weight;
			
			
		}


		public Integer get_vertexFrom() {
			return _vertexFrom;
		}


		public void set_vertexFrom(Integer _vertexFrom) {
			this._vertexFrom = _vertexFrom;
		}


		public Calculate get_weight() {
			return _weight;
		}


		public void set_weight(Calculate _weight) {
			this._weight = _weight;
		}
		
		
		/**
		 * @return the _vertexTo
		 */
		public Integer get_vertexTo() {
			return _vertexTo;
		}


		/**
		 * @param _vertexTo the _vertexTo to set
		 */
		public void set_vertexTo(Integer _vertexTo) {
			this._vertexTo = _vertexTo;
		}


		/**
		 * vergleicht nur die Haswerte von den Objecten
		 * @see java.lang.Object#equals(java.lang.Object)
		 * @see  {@link Edge} @Override hashCode()
		 */
		@Override
		public boolean equals(Object obj) {
		return hashCode() == obj.hashCode();
		}
		/**
		 * die Kante mit <xfrom, yto> und <yto, xfrom>
		 * bekomment den gleichen hashwerte
		 * 
		 * @see java.lang.Object#hashCode()
		 * @see {@link Edge} @Override equals()
		 */
		
	@Override
	public int hashCode() {
		
		int hash = 5;
		
		int min = get_vertexFrom() < get_vertexTo() ? get_vertexFrom() : get_vertexTo();
		int max = min == get_vertexFrom() ? get_vertexTo() : get_vertexFrom();
		
		hash = 89*hash + min;
		hash = 89*hash + max;
		
	return hash;
	}


//		/* (non-Javadoc)
//		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
//		 */
//		@Override
		public int compare(Edge o1, Edge o2) {
			if(o1.get_weight().get_operand()<o2.get_weight().get_operand()){
				return-1;
				
			}else if(o1.get_weight().get_operand().equals(o2.get_weight().get_operand())){
			return 0;
			
			}else{
			return 1;
			}
			
		}


		/* (non-Javadoc)
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(Edge o) {
			if(this.get_weight().get_operand()<o.get_weight().get_operand()){
				return-1;
				
			}else if(this.get_weight().get_operand().equals(o.get_weight().get_operand())){
			return 0;
			
			}else{
			return 1;
			}
		}


		
		
		
	}
	