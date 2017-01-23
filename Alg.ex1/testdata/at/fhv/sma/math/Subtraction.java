package at.fhv.sma.math;

public class Subtraction extends Calculation {
	
	public Subtraction(int operand) {
		super(operand);
	}

	@Override
	public int calculate(int value) {
		int diff = value - _operand;
		return diff;
	}

}
