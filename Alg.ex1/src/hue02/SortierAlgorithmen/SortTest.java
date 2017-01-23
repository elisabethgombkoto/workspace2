package hue02.SortierAlgorithmen;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SortTest {

	@Test
	public void testQuickSortMIX() {
		Integer[] array = { 9, 6, 5, 5, 7, 7, 5, 8, 7, 4 };
		Integer[] expecteds = { 4, 5, 5, 5, 6, 7, 7, 7, 8, 9 };

		Sort sort = new QuickSort();
		@SuppressWarnings("rawtypes")
		Comparable[] result = sort.sort(array);
		assertArrayEquals(expecteds, result);
	}

	@Test
	public void testSelectionSortMIX() {
		Integer[] array = { 9, 6, 5, 5, 7, 7, 5, 8, 7, 4 };
		Integer[] expecteds = { 4, 5, 5, 5, 6, 7, 7, 7, 8, 9 };

		Sort sort = new SelectionSort();
		@SuppressWarnings("rawtypes")
		Comparable[] result = sort.sort(array);
		assertArrayEquals(expecteds, result);
	}

	@Test
	public void testInsertionSortMIX() {
		Integer[] array = { 9, 6, 5, 5, 7, 7, 5, 8, 7, 4 };
		Integer[] expecteds = { 4, 5, 5, 5, 6, 7, 7, 7, 8, 9 };

		Sort sort = new InsertionSort();
		@SuppressWarnings("rawtypes")
		Comparable[] result = sort.sort(array);
		assertArrayEquals(expecteds, result);
	}

	@Test
	public void testQuickSortAbstergent() {
		Integer[] array = { 9, 8, 7, 7, 7, 6, 5, 5, 5, 4 };
		Integer[] expecteds = { 4, 5, 5, 5, 6, 7, 7, 7, 8, 9 };

		Sort sort = new QuickSort();
		@SuppressWarnings("rawtypes")
		Comparable[] result = sort.sort(array);
		assertArrayEquals(expecteds, result);
	}

	@Test
	public void testSelectionSortAbstergent() {
		Integer[] array = { 9, 8, 7, 7, 7, 6, 5, 5, 5, 4 };
		Integer[] expecteds = { 4, 5, 5, 5, 6, 7, 7, 7, 8, 9 };

		Sort sort = new SelectionSort();
		@SuppressWarnings("rawtypes")
		Comparable[] result = sort.sort(array);
		assertArrayEquals(expecteds, result);
	}

	@Test
	public void testInsertionSortAbstergent() {
		Integer[] array = { 9, 8, 7, 7, 7, 6, 5, 5, 5, 4 };
		Integer[] expecteds = { 4, 5, 5, 5, 6, 7, 7, 7, 8, 9 };

		Sort sort = new InsertionSort();
		@SuppressWarnings("rawtypes")
		Comparable[] result = sort.sort(array);
		assertArrayEquals(expecteds, result);
	}

	@Test
	public void testQuickSortAscending() {
		Integer[] array = { 4, 5, 5, 5, 6, 7, 7, 7, 8, 9 };
		Integer[] expecteds = { 4, 5, 5, 5, 6, 7, 7, 7, 8, 9 };

		Sort sort = new QuickSort();
		@SuppressWarnings("rawtypes")
		Comparable[] result = sort.sort(array);
		assertArrayEquals(expecteds, result);
	}

	@Test
	public void testSelectionSortAscending() {
		Integer[] array = { 4, 5, 5, 5, 6, 7, 7, 7, 8, 9 };
		Integer[] expecteds = { 4, 5, 5, 5, 6, 7, 7, 7, 8, 9 };

		Sort sort = new SelectionSort();
		@SuppressWarnings("rawtypes")
		Comparable[] result = sort.sort(array);
		assertArrayEquals(expecteds, result);
	}

	@Test
	public void testInsertionSortAscending() {
		Integer[] array = { 4, 5, 5, 5, 6, 7, 7, 7, 8, 9 };
		Integer[] expecteds = { 4, 5, 5, 5, 6, 7, 7, 7, 8, 9 };

		Sort sort = new InsertionSort();
		@SuppressWarnings("rawtypes")
		Comparable[] result = sort.sort(array);
		assertArrayEquals(expecteds, result);
	}

}
