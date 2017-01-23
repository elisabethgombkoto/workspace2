package at.fhv.sma.math;

/**
 * Represents an abstract class of a calculation.
 * Specific classes can be extend like the following example:
 * 
 * Addition - if the calculate method is called, it adds the operand to the given value and returns the sum.
 * 
 * @author Sebastian Malin
 *
 */
public abstract class Calculation {
	
	protected int _operand = 0;
	
	public Calculation(int operand) {
		_operand = operand;
	}
	
	public int getOperand() {
		return _operand;
	}
	
	/**
	 * Performs the calculation depending on the implementation.
	 * Uses the operand and the given value to calculate the result.
	 * 
	 * @param value the value to calculate with
	 * @return the result of the calculation 
	 */
	public abstract int calculate(int value);

}
