package hue02.SortierAlgorithmen;

public class SelectionSort implements Sort {

	@Override
	public Comparable[] sort(Comparable[] sortieren) {
		int i;
		int j = 0;
		int anzahlGesamtSchleifenDurchlauf = 0;
		int anzahlGesamtFeldZugriffe = 0;
		for (i = 0; i < sortieren.length - 1; i++) {
			anzahlGesamtSchleifenDurchlauf++;
			for (j = i + 1; j < sortieren.length; j++) {
				anzahlGesamtSchleifenDurchlauf++;
				if (sortieren[i].compareTo(sortieren[j]) > 0)
				// sortieren[i] > sortieren[j]
				{
					Comparable temp = sortieren[i];
					sortieren[i] = sortieren[j];
					sortieren[j] = temp;
					anzahlGesamtFeldZugriffe += 4;
				}
				anzahlGesamtFeldZugriffe += 2;

			}

		}
		System.out
				.println("Gesamtanzahl der Schleifendurchlaeufe bei SelectionSort: " + anzahlGesamtSchleifenDurchlauf);
		System.out.println("Gesamtanzahl der Feldzugriffe bei SelectionSort: " + anzahlGesamtFeldZugriffe);
		return sortieren;
	}

}
