package hue06.task1.GarphErzeugen;

import javax.management.InvalidAttributeValueException;

public class Klothilde_999Cost extends Algoritmus {
	
private static Integer _properValue=999;

/* 
 * Path wird nur dann gesetzt, wenn die newPath die genaue Cost erzielt hat.
 * (non-Javadoc)
 * @see hue06.task1.GarphErzeugen.Algoritmus#setPath(hue06.task1.GarphErzeugen.Path)
 */
@Override
public void setPath(Path possiblePath) throws InvalidAttributeValueException {
	if(_path==null){
		_path=new Path(possiblePath);
		} else {
			if(possiblePath.getCost().equals(_properValue)){
				_path= new Path(possiblePath);			
		}
	}
	
}



}
