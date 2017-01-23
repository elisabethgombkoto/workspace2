package hue06.task1.GarphErzeugen;



import javax.management.InvalidAttributeValueException;

public class Calculate  {

private String _operator;
private Integer _operand;
private Operation _operation;

//TODO HashMap probieren, das es nicht jedesmal neue Object
//erzeugt wird sonder eine was in HashMap ist wird immer wieder verwendet

protected Calculate (Integer operand){
	_operand=operand;
}
	/**
	 * Constructor
	 * abhängig von den eingabe parameter erzeugt
	 *  ein Object von den inneren Klassen
	 *  oder wirft den exeption, falls ungültige String
	 * {@link Addition}
	 * {@link Subtraction} 
	 * {@link Division} 
	 * {@link Multiplication}
	
	 * @param String operator 
	 * @param  Integer operand
	 * @throws InvalidAttributeValueException
	 */
	protected Calculate(String operator, Integer operand){
//TODO anstatt diese switch case bauen für get _operator
// _operator = operator;
		
		
		switch(operator){
	    
	    case "+":
	    	set_operation(new Addition(operand));   	
	        break;
	        
	    case "-":
	    	set_operation(new Subtraction(operand));
	        break;
	        
	    case "*":
	    	set_operation(new Multiplication(operand));
	    break;

	    case "/":
	    	set_operation(new Division(operand));	   	
	    	break;
	    	
	    default:
			try {
				throw new InvalidAttributeValueException("That isn't a mathematical function");
			} catch (InvalidAttributeValueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	}
	




class Multiplication implements Operation {
   
    public Multiplication(Integer operand) {
		_operand=operand;
	}
    /**
     * fürt multiplikation durch
     * @param  Integer operand
     */
	public int resultFor(int currentValue) {
        return currentValue * get_operand();
    }
}


class Addition implements Operation {
	
	public Addition(Integer operand) {
		_operand=operand;
	}
	 /**
     * fürt addition durch
     * @param  Integer operand
     */
	public int resultFor(int currentValue) {
        return currentValue + get_operand();
    }
}

class Subtraction implements Operation {
	 /**
     * führt subtraction nur dann durch falls 
     * minuend>=subtrahend ist,
     * alle anderen fällen gibt -1 zurück
     * abfrage ist nicht notwendig hier;)
     * 
     * @param  Integer operand
     */
	public Subtraction(Integer operand) {
		_operand=operand;
	}

	public int resultFor(int currentValue) {
		if(currentValue>=get_operand()){
        return currentValue - get_operand();
    }else{
    	return -1;
    }

	}
}


class Division implements Operation {
	
	public Division(Integer operand) {
		_operand=operand;
	}
	 /**
     * fürt division nur dann durch
     * wenn ein hanz zahl herauskommt,
     * wenn rest nicht 0 ist so gibt -1 zurück
     * @param  Integer operand
     */

	public int resultFor(int currentValue) {
		if(currentValue%get_operand()==0){
        return currentValue / get_operand();
        }
		return -1;		
    }
}
public String get_operator() {
	return _operator;
}


public void set_operator(String _operator) {
	this._operator = _operator;
}



public Integer get_operand() {
	return _operand;
}


public void set_operand(Integer _operand) {
	this._operand = _operand;
}



public Operation get_operation() {
	return _operation;
}



private void set_operation(Operation _operation) {
	this._operation = _operation;
}



}

