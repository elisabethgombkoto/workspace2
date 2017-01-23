package test.at.fhv.sma.util;

public class FileUtil {
	
	public static int[] stringToIntArray(String[] sa) {
		int[] ia = new int[sa.length];
		
		for(int i = 0; i < sa.length; i++) {
			ia[i] = Integer.parseInt(sa[i]);
		}
		
		return ia;
	}

}
