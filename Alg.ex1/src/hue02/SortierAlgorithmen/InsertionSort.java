package hue02.SortierAlgorithmen;

public class InsertionSort implements Sort {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Comparable[] sort(Comparable[] sortieren) {

		int anzahlFeldzugriff = 0;
		int anzahlSchleifen = 0;
		Comparable temp;
		for (int i = 1; i < sortieren.length; i++) {
			anzahlSchleifen++;
			temp = sortieren[i];
			anzahlFeldzugriff++;
			int j = i;
			while (j > 0 && sortieren[j - 1].compareTo(temp) > 0) {
				// a.compareTo(b) -->
				// case >0 : a > b,
				// case 0: a == b,
				// case <0: a < b

				anzahlSchleifen++;

				sortieren[j] = sortieren[j - 1];
				j--;
				anzahlFeldzugriff += 3;

			}
			sortieren[j] = temp;
			anzahlFeldzugriff++;
		}
		// Grobanalyse:
		System.out.println("Gesamtanzahl der Schleifendurchlaeufe bei InsertionSort: " + anzahlSchleifen);
		System.out.println("Gesamtanzahl der Feldzugriffe bei InsertionSort: " + anzahlFeldzugriff);
		return sortieren;
	}

}
