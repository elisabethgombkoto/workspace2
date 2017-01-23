package hue06.Graph_int_primitive;

public class FileUtil {
private String _filename;

	public FileUtil(String filename) {
		_filename=filename;
	}

	public  int[] stringToIntArray(String[] stringArray) {
		int[] intArray = new int[stringArray.length];
		
		for(int i = 0; i < stringArray.length; i++) {
			intArray[i] = Integer.parseInt(stringArray[i]);
		}
		
		return intArray;
	}
}
