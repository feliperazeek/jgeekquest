package com.zeekmod.jgeekquest.sort.quicksort;

public class QuickSort<T extends Comparable<T>> {

	private T[] numbers;
	private int number;

	public void sort(T[] values) {
		// Check for empty or null array
		if (values == null || values.length == 0) {
			return;
		}
		this.numbers = values;
		number = values.length;
		quicksort(0, number - 1);
	}

	private void quicksort(int low, int high) {
		int i = low, j = high;
		// Get the pivot element from the middle of the list
		T pivot = numbers[(low + high) / 2];

		// Divide into two lists
		while (i <= j) {
			// If the current value from the left list is smaller then the pivot
			// element then get the next element from the left list
			while (i >= 0 && numbers[i].compareTo(pivot) < 0) {
				i++;
			}
			// If the current value from the right list is larger then the pivot
			// element then get the next element from the right list
			while (j >= 0 && numbers[j].compareTo(pivot) >= 0) {
				j--;
			}

			// If we have found a values in the left list which is larger then
			// the pivot element and if we have found a value in the right list
			// which is smaller then the pivot element then we exchange the
			// values.
			// As we are done we can increase i and j
			if (i <= j) {
				exchange(i, j);
				i++;
				j--;
			}
		}
		
		// Recursion
		if (low < j)
			quicksort(low, j);
		if (i < high)
			quicksort(i, high);
	}
	
	private T[] exchange(int i, int j) {
		T temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
		return numbers;
	}
	
	public T[] sortItems(T[] list) {
		return sortItems(list, 0, list.length-1);
	}
	
	public T[] sortItems(T[] list, int start, int end) {
		// Keep values to be used later
		int low = start;
		int high = end;
		
		// Find Pivot
		int middle = (start+end) / 2;
		T pivot = list[middle];
		
		T leftItem = list[start];
		T rightItem = list[end];
		
		if ( pivot.compareTo(leftItem) < 0 ) {
			start++;
		}
		
		if ( pivot.compareTo(rightItem) > 0 ) {
			end--;
		}
			
		if (start <= end) {
			list = swap(list, start, end);
		} else {
			return list;
		}
		
		// if (start < low) {
			// quicksort(start, low);
		// }
		// if (i < high) {
			// quicksort(i, high);
		// }
		
		return list;
	}
	
	private T[] swap(T[] list, int start, int end) {
		T temp = list[start];
		list[start] = list[end];
		list[end] = temp;
		return list;
	}

	// test client
	public static void main(String[] args) {
		
		Integer[] list1 = {1, 4, 6, 7, 8, 9, 3, 4, 5, 10};
		QuickSort<Integer> s = new QuickSort<Integer>();
		s.sortItems(list1);

		// display results using select
		System.out.println("start");
		for (Integer i : list1) {
			System.out.print(i + " ");
		}
		System.out.println("done");
	}
}
