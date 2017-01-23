package at.fhv.sma.math;

public class Division extends Calculation {
	
	public Division(int operand) throws IllegalArgumentException {
		super(operand);
		if(operand == 0) {
			throw new IllegalArgumentException("Division by zero (0) is not allowed.");
		}
	}

	@Override
	public int calculate(int value) {
		if((value % _operand) != 0) {
			return -1;
		}
		int quotient = value/_operand;
		
		return quotient;
	}

}
