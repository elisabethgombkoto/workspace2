package at.fhv.sma.graph;

public class SpecificAlgo extends PathAlgorithm {
	
	private int _specificValue = 0;
	
	public SpecificAlgo(int specificValue) {
		_specificValue = specificValue;
	}

	@Override
	public void setPath(Path newPath) {
		if(newPath.getCost() == _specificValue) {
			_path = new Path(newPath);
		}
	}

}
