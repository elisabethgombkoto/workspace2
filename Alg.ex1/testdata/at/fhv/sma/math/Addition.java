package at.fhv.sma.math;

public class Addition extends Calculation {
	
	public Addition(int operand) {
		super(operand);
	}

	@Override
	public int calculate(int value) {
		int sum = value + _operand;
		return sum;
	}

}
