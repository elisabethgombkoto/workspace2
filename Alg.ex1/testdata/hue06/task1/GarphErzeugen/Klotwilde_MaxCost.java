package hue06.task1.GarphErzeugen;

import javax.management.InvalidAttributeValueException;

/**
 * @author Elisabeth Gombkötö
 * @since 10.12.2016
 */

public class Klotwilde_MaxCost extends Algoritmus {

	/* 
	 * Path wird nur dann durch den schon gefundenen Path
	 * ersetzt, wenn die newPath eine höhere Cost erzielt hat.
	 * (non-Javadoc)
	 * @see hue06.task1.GarphErzeugen.Algoritmus#setPath(hue06.task1.GarphErzeugen.Path)
	 */
	@Override
	public void setPath(Path possiblePath) throws InvalidAttributeValueException {
		if(_path==null){
			_path= new Path(possiblePath);
		} else {
			if(_path.getCost().compareTo(possiblePath.getCost())<0) {
				_path = new Path(possiblePath);
			}
		
		}

	}
}
