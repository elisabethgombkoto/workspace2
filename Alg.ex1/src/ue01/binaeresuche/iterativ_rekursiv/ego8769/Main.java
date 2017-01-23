package ue01.binaeresuche.iterativ_rekursiv.ego8769;

public class Main {
	/*
	 * Laufzeitanalyse: Z�hlen der Anzahl der Vergleiche
	 * 
	 * � Best-Case: sofortiger Treffer: T(n) = 1, also T(n) = O(1) � Worst-Case:
	 * Suchbereich muss solange halbiert werden, bis er nur noch 1 Element
	 * enth�lt, � also im schlechtesten Fall logarithmisch oft : T(n) = T(n/2)
	 * <= -1 = log(n + 1), T(n) = �(log n)
	 */

	/*
	 * Bin�re suche wird empfohlen wenn, Statische, nicht oder sehr selten
	 * �ndernde, kleine Datenmenge,mit h�ufige Zugriffe/Suchoperationen darauf
	 * L�sung: Vorsortiertes O(n log n) Feld, bin�res Suchen O(log n)
	 */

	public int binaereSucheIterativ(int searchNummber, int[] array)
			throws NummberNotFoundExceptions, ArrayIsEmptyException {

		int pos = 0;
		int length = array.length;
		if ((length == 0) || (array == null)) {
			throw new ArrayIsEmptyException();
		}
		while (searchNummber != array[pos]) {
			if (searchNummber < array[pos]) {
				pos = pos - (pos / 2);
			} else {
				pos = pos + (pos / 2);
			}
		}
		if (searchNummber == array[pos])
			return pos;
		else
			throw new NummberNotFoundExceptions();
	}

	/*
	 * Rekursive Algorithmen:  zu jedem rekursiv formulierten Algorithmus gibt
	 * es einen �quivalenten iterativen Algorithmus Vorteile rekursiver
	 * Algorithmen k�rzere Formulierung leichter verst�ndliche L�sung Einsparung
	 * von Variablen teilweise sehr effiziente Probleml�sungen (z.B. Quicksort)
	 * Bei rekursiven Datenstrukturen (zum Beispiel B�ume, Graphen) besonders
	 * empfehlenswert Nachteile rekursiver Algorithmen weniger effizientes
	 * Laufzeitverhalten (Overhead bei Funktionsaufruf) Verst�ndnisprobleme bei
	 * Programmieranf�ngern Konstruktion rekursiver Algorithmen
	 * "gew�hnungsbed�rftig"
	 */
	public boolean binaereSucheRekursive(int searchNummber, int[] array, int lowerBound, int upperBound)
			throws ArrayIsEmptyException {
		int middle = 0;

		if ((array.length == 0) || (array == null)) {
			throw new ArrayIsEmptyException();
		}

		while (upperBound >= lowerBound) {
			middle = (lowerBound + upperBound) / 2;
			if (array[middle] == searchNummber) {
				return true;
			} else if (array[middle] > searchNummber)
				return binaereSucheRekursive(searchNummber, array, lowerBound, middle - 1);
			return binaereSucheRekursive(searchNummber, array, middle + 1, upperBound);
		}
		return false;
	}

}
