/**
 * 
 */
package hue10.puzzel8;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


/**
 * @author ElisabethElisabeth Gombkötö
 *14.01.2017 WS_2016
 */


/**
 * @author ElisabethElisabeth Gombkötö
 *17.01.2017WS_2016
 */
public class Puzzle8 {
	
	private int[][] _state;
	private Directions _direction;
	private int _shift;
	private Puzzle8 _parent;
	private List<Puzzle8> _children = null;
	private Hole _hole; 
	
	
 public Puzzle8(int[][] state){
	 
	 
	 if(state==null){
		 throw new IllegalArgumentException("parameters may not be null");
	 }
	 if(state.length>3 ||  state[0].length>3 ){
		 throw new IllegalArgumentException("invalid array size, max array size 3");
	 }
	 boolean hasHole = false;
	 int holeCount = 0;
	 
	 for (int i = 0; i < 3; i++) {
	        for (int  j =0; j < 3; j++) {
	        	if(state[i][j]==0){
	        	 hasHole=true;//prüfen ob loch enthalten ist, prüfen ob nur ein loch enthalten ist
	        	 _hole = new Hole( i , j );
	        	 holeCount++;
	        	}
	        }
	 }
	 
	 if( holeCount != 1 )throw new IllegalArgumentException("Puzzle muss genau ein Loch haben");
	 
	 
		
	 _parent=null;
	_state=state;
	_shift=0;
	
 }
 
 
 
 

  private Puzzle8(Puzzle8 parent){
	  
	   int n = parent._state.length;
	   int[][] pState = parent._state;
	   int[][] childState = new int[n][n];
	   
	   for( int i = 0 ; i < n ; i++ ){
		   for( int j = 0 ; j < n ; j++ ){
			   
			   childState[ i ][ j ] = pState[ i ][ j ];
		   }
	   }
	  
		this._state = childState;
		this._shift = parent._shift + 1;
		this._parent = parent;

  }
  
  /**
 * @param parent
 * @return
 */
public List<Puzzle8> createListOfChildren(Puzzle8 parent) {
	
	if(_children==null){
		
		 _children = new LinkedList<Puzzle8>();
		 
		 Puzzle8 child = null;
		 
		 for(Directions dir : Directions.values()){
			
			if( this.IsValideDirection( dir ) ){
				
				child = new Puzzle8( parent );
				child._hole = findHole( child );
				shiftPuzzle( child , dir );
				_children.add( child );
			}
			 
		 }
	}
	return _children;	 
 }
/**
 * @param parent
 * @param direction
 * @return
 * @throws HoleNotExisteException 
 */
public void shiftPuzzle( Puzzle8 p , Directions direction) {
	
		
	Hole hole = p.get_hole();
	System.out.println( "Shift - Hole: " + p.get_hole().toString() );
	
	int [][] state = p._state;
	int x0 = hole.getX();
	int y0 = hole.getY();
	
	switch (direction) {
	case up:
		
		p._state[ x0 ][ y0 ] = state[ x0 -1 ][ y0 ];
		state[ x0 -1 ][ y0 ] = 0;
		p.set_hole( findHole( p ) );
		break;
		
	case down:
		state[ hole._x ][ hole._y ] = state[ hole._x +1 ][ hole._y ];
		state[ hole._x +1 ][ hole._y ] = 0;
		p.set_hole( findHole( p ) );
		break;
		
	case left:
		
		if( hole._y > 0 ){
		state[ hole._x ][ hole._y ] = state[ hole._x ][hole._y-1];
		state[ hole._x ][ hole._y - 1 ] = 0;
		}else{
			state[ hole._x ][ hole._y ]= state[ hole._x -1 ][ 2 ];
			state[ hole._x - 1 ][ 2 ] = 0;
		}
		p.set_hole( findHole( p ) );
	break;
	
	case right:
		
		if( hole._y < 2 ){
		state[ hole._x ][ hole._y ]= state[ hole._x ][hole._y + 1];
		state[ hole._x ][ hole._y + 1 ] = 0;
		}else{
			state[ hole._x ][ hole._y ]= state[ hole._x + 1 ][ 0 ];
			state[ hole._x + 1 ][ 0 ] = 0;
		}
		p.set_hole( findHole( p ) );
		break;
		
		
	default:
	break;
  }	
	

	}



/**
 * @param state
 * @return
 * @throws HoleNotExisteException 
 */
public Hole findHole( Puzzle8 p ) {
	
	int state[][] = p._state;
	
	Hole hole = null;

	for (int i = 0; i < 3; i++) {
        for (int  j =0; j < 3; j++) {
        	
        	if(state[i][j]==0){
        	hole = new Hole(i,j); 

        	}
        }
	}
	return hole;

}

/**
 * @author ElisabethElisabeth Gombkötö
 *17.01.2017WS_2016
 */
class Hole{
	private int _x;
	private int _y;
	private Hole (int x, int y){
		_x=x;
		_y=y;
	}
	
	public int getX(){
		return _x;
	}
	
	public int getY(){
		return _y;
	}
	
	public String toString(){
		
		return new String( _x + " " + _y );
	}
}



/**
 * @param direction, of the provided movement
 * @return true if the move allowed, else false 
 * @throws HoleNotExisteException 
 */
private boolean IsValideDirection(Directions direction) {

	
	 switch (direction) {
	 
		case up: return _hole._y > 0 ? true : false;
		case down: return _hole._y < 2 ? true : false;
		case left: return ( _hole._y > 0 || _hole._x > 0 ) ? true : false;		
		case right: return ( _hole._y < 2 || _hole._x < 2 ) ? true : false;

	  }
	return false;		
}


/**
 * @param gamefield
 * @return
 */
public int[][] copyContents() {
	int[][] original=this._state;
	int[][] copy= new int[3][3]; 

    for (int i = 0; i < 3; i++) {
        for (int  j =0; j < 3; j++) {
            copy[i][j] = original[i][j];  
        }
    }
	return copy;
}
public int H1Cost(Puzzle8 p){
	return get_shift()+getErrorField(p);
}


/**
 * @param end
 * @return
 */
private int getErrorField(Puzzle8 end) {
	int[][] p= end.get_state(); 
	int error =0;
	for(int i=0;i<3;i++){
		for(int j=0;j<3;j++){
			if(_state[i][j]!=p[i][j]){
				error++;
			}
			
		}
	}
	return error;
}

/**
 * @param p
 * @return
 */
public int H2Cost(Puzzle8 end){
	return get_shift()+getSteps(end);
}
/**
 * @param p
 * @return
 */
private int getSteps(Puzzle8 end) {
	int error=0;
	int[][] e=end.get_gamefield();
	int[] soll;
	int[] ist;
	for(int i=0; i<9; i++){
		soll=getCoordinate(e, i);
		ist=getCoordinate(_state, i);
		error+=Math.abs(soll[0]-ist[0]);
		error+=Math.abs(soll[1]-ist[1]);
	}
	return error;
}

/**
 * @param state
 * @param target
 * @return
 */
private int[] getCoordinate(int [][] state, int target){
	int[] coordinates = new int[2];
	for(int i = 0; i < 3; i++){
		for(int j = 0; j < 3; j++){
			if(state[i][j] == target){
				coordinates[0] = i;
				coordinates[1] = j;
				return coordinates;
			}
		}
	}	
	return null;
}

@Override
public String toString() {
	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < 3; i++) {
		for(int j=0; j<3; j++){
			sb.append(_state[i][j] + " " );
//			if(i!= _state.length)
//				sb.append(" ");
//				if (i==2){
//					sb.append("\n");
//				}
			}
		}
	return sb.toString();
}

@Override
public boolean equals(Object obj) {
	if(obj instanceof Puzzle8){
	if( obj.hashCode()==this.hashCode()){
		return true;
		}
	}
	return false;
}
//	for(int i=0; i<3; i++){
//		for(int j=0; j<3; j++){
//		if(other[i][j]!=_state[i][j]){
//			return false;
//		}
//		}
//	}
//	return true;
//}

@Override
public int hashCode() {
	
	StringBuilder sb = new StringBuilder();
	for(int i = 0; i < 3; i++){
		for(int j=0; j<3; j++){
			sb.append(_state[i][j]);	
		}
	}	
String temp = sb.toString();
System.out.println(temp);
return temp.hashCode();
}

/**
 * @return the _gamefield
 */
public int[][] get_gamefield() {
	return _state;
}

/**
 * @param _gamefield the _gamefield to set
 */
public void set_gamefield(int[][] _gamefield) {
	this._state = _gamefield;
}

/**
 * @return the _direction
 */
public Directions get_direction() {
	return _direction;
}

/**
 * @param _direction the _direction to set
 */
public void set_direction(Directions _direction) {
	this._direction = _direction;
}

/**
 * @return the _shift
 */
public int get_shift() {
	return _shift;
}

/**
 * @param _shift the _shift to set
 */
public void set_shift(int _shift) {
	this._shift = _shift;
}

/**
 * @return the _state
 */
public int[][] get_state() {
	return _state;
}

/**
 * @return the _parent
 */
public Puzzle8 get_parent() {
	return _parent;
}





public Hole get_hole() {
	return _hole;
}





public void set_hole(Hole _hole) {
	this._hole = _hole;
}
  
  
}
