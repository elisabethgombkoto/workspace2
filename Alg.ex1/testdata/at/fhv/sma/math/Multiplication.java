package at.fhv.sma.math;

public class Multiplication extends Calculation {
	
	public Multiplication(int operand) {
		super(operand);
	}

	@Override
	public int calculate(int value) {
		int prod = value * _operand;
		return prod;
	}

}
