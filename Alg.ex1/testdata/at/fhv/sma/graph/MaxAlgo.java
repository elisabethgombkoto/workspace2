package at.fhv.sma.graph;

public class MaxAlgo extends PathAlgorithm {

	@Override
	public void setPath(Path newPath) {
		if(_path == null) {
			_path = new Path(newPath);
		} else {
			if(_path.getCost() < newPath.getCost()) {
				_path = new Path(newPath);
			}
		}
	}

}
