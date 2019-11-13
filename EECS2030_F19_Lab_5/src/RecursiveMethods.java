import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Requirement:
 * You are required to implement all methods recursively.
 * You receive a zero if there is any occurrence of a loop (e.g., for, while).  
 * See under doc/index.html for the API of methods.
 * This lab requires definitions of recursive helper methods. 
 * You may review the recording of parts of Lecture 14 (October 28): 
 * 		https://youtu.be/J2CB3QHinQU 
 */
public class RecursiveMethods {
	/**
	 * Return an array storing the first n numbers in an arithmetic sequence, with
	 * initial term 'start' and common difference 'difference'. You can assume that n is
	 * non-negative (larger than or equal to 0). e.g., arithmeticArray(2, 3, 5)
	 * returns an array {2, 5, 8, 11, 14}.
	 * 
	 * @param start
	 *            the first term in an arithmetic sequence
	 * @param difference
	 *            the common difference between terms in an arithmetic sequence
	 * @param n
	 *            the first n numbers in an arithmetic sequence
	 * @return an array representing the first n numbers in the specified arithmetic
	 *         sequence
	 * 
	 *         <b>You are forbidden to use the arithmeticList method below to solve
	 *         this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public int[] arithmeticArray(int start, int difference, int n) {

		int[] temp = new int[n];
		if (n == 0)
			return temp;
		temp[0] = start;
		arithmeticArrayHelper(1, difference, temp);

		return temp;
	}

	/**
	 * This is a recursive helper method expected to be used by arithmeticArray.
	 * 
	 * @param i
	 *            position in `seq` to be assigned to
	 * @param difference
	 *            common difference of the arithmetics sequence
	 * @param seq
	 *            a partially filled arithmetic sequence
	 * 
	 *            Each recursive call to this helper method stores at index `i` of
	 *            the resulting arithmetic sequence `seq`, which is assumed to have
	 *            been partially filled at indices 0, 1, ..., i - 1.
	 */
	void arithmeticArrayHelper(int i, int difference, int[] seq) {

		int size = seq.length;
		if (i == size) {
			int temp;
		} else {
			seq[i] = seq[i - 1] + difference;
			arithmeticArrayHelper(i + 1, difference, seq);
		}

	}

	/**
	 * Return a list storing the first n numbers in an arithmetic sequence, with
	 * initial term 'start' and common difference 'difference'. You can assume that n is
	 * non-negative (larger than or equal to 0). e.g., arithmeticList(2, 3, 5)
	 * returns a list {2, 5, 8, 11, 14}.
	 * 
	 * @param start
	 *            the first term in an arithmetic sequence
	 * @param difference
	 *            the common difference between terms in an arithmetic sequence
	 * @param n
	 *            the first n numbers in an arithmetic sequence
	 * @return a list representing the first n numbers in the specified arithmetic
	 *         sequence
	 * 
	 *         <b>You are forbidden to use the arithmeticArray method above to solve
	 *         this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public List<Integer> arithmeticList(int start, int difference, int n) {
		/*
		 * Your Task: Make use of the recursive method arithmeticListHelper.
		 */
		List<Integer> l = new ArrayList<Integer>();
		if (n == 0)
			return l;
		l.add(start);
		if (n == 1)
			return l;
		arithmeticListHelper(1, difference, l, n - 1);
		l.add(l.get(l.size() - 1) + difference);
		return l;
	}

	/**
	 * This is a recursive helper method expected to be used by arithmeticList.
	 * 
	 * @param i
	 *            position in `seq` to be assigned to
	 * @param difference
	 *            common difference of the arithmetics sequence
	 * @param seq
	 *            a partially filled arithmetic sequence
	 * @param n
	 *            size of the arithmetic sequence to be built eventually
	 * 
	 *            Each recursive call to this helper method stores at index `i` of
	 *            the resulting arithmetic sequence `seq`, which is assumed to have
	 *            been partially filled at indices 0, 1, ..., i - 1.
	 */
	void arithmeticListHelper(int i, int difference, List<Integer> seq, int n) {
		if (n == 0)
			return;
		if (i == n) {
			return;
		}
		seq.add(seq.get(i - 1) + difference);
		arithmeticListHelper(i + 1, difference, seq, n);
	}

	/**
	 * Return whether or not an array represents the first n numbers of an
	 * arithmetic sequence. An arithmetic sequence has a common difference between
	 * every two adjacent terms. The array may or may not be empty. e.g.,
	 * isArithmeticArray({1, 3, 5, 8, 10}) returns false and isArithmeticArray({1,
	 * 3, 5, 7, 9}) returns true (because the common difference is 2).
	 * 
	 * @param a
	 *            an array
	 * @return true if input array a represents an arithmetic sequence; false
	 *         otherwise.
	 * 
	 *         <b>You are forbidden to use the isArithmeticList method below to
	 *         solve this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public boolean isArithmeticArray(int[] a) {
		if (a.length <= 1)
			return true;
		int difference = a[1] - a[0];
		return isArithmeticArrayHelper(1, difference, a);
	}

	/**
	 * This is a recursive helper method expected to be used by isArithmeticArray.
	 * 
	 * @param i
	 *            position in `seq`, starting from which the remaining sub-sequence
	 *            is an arithmetic sequence
	 * @param difference
	 *            common difference of the arithmetics sequence
	 * @param a
	 *            an array which may or may not be an arithmetic sequence
	 * @return whether or not the sub-sequence of `a` with indices i - 1, i, i + 1,
	 *         ..., a.length - 1 is an arithmetic sequence
	 * 
	 *         Each recursive call to this helper method considers if elements of
	 *         `a` at indices `i - 1` and `i` make two valid adjacent elements in
	 *         the arithmetic sequence, i.e., their difference is equal to the
	 *         common difference `difference`. Also, it considers if the remaining
	 *         sub-sequence (indices i + 1, i + 2, ..., a.length - 1) is an
	 *         arithmetic sequence with common difference `difference`.
	 */
	boolean isArithmeticArrayHelper(int i, int difference, int[] a) {

		int tempDiff = a[i] - a[i - 1];
		if (i == a.length - 1) {
			if (tempDiff != difference)
				return false;
			return true;
		}
		if (tempDiff != difference)
			return false;
		else {
			return isArithmeticArrayHelper(i + 1, tempDiff, a);
		}

	}

	/**
	 * Return whether or not a list represents the first n numbers of an arithmetic
	 * sequence. An arithmetic sequence has a common difference between every two
	 * adjacent terms. The list may or may not be empty. e.g., isArithmeticList({1,
	 * 3, 5, 8, 10}) returns false and isArithmeticList({1, 3, 5, 7, 9}) returns
	 * true (because the common difference is 2).
	 * 
	 * @param l
	 *            a list
	 * @return true if input list l represents an arithmetic sequence; false
	 *         otherwise.
	 * 
	 *         <b>You are forbidden to use the isArithmeticArray method above to
	 *         solve this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public boolean isArithmeticList(List<Integer> l) {
		if (l.size() <= 1)
			return true;
		int difference = l.get(1) - l.get(0);
		return isArithmeticListHelper(1, difference, l);
	}

	/**
	 * This is a recursive helper method expected to be used by isArithmeticList.
	 * 
	 * @param i
	 *            position in `seq`, starting from which the remaining sub-sequence
	 *            is an arithmetic sequence
	 * @param difference
	 *            common difference of the arithmetics sequence
	 * @param l
	 *            a list which may or may not be an arithmetic sequence
	 * @return whether or not the sub-sequence of `l` with indices i - 1, i, i + 1,
	 *         ..., l.size() - 1 is an arithmetic sequence
	 * 
	 *         Each recursive call to this helper method considers if elements of
	 *         `l` at indices `i - 1` and `i` make two valid adjacent elements in
	 *         the arithmetic sequence, i.e., their difference is equal to the
	 *         common difference `difference`. Also, it considers if the remaining
	 *         sub-sequence (indices i + 1, i + 2, ..., l.size() - 1) is an
	 *         arithmetic sequence with common difference `difference`.
	 */
	boolean isArithmeticListHelper(int i, int difference, List<Integer> l) {
		int tempDiff = l.get(i) - l.get(i - 1);
		if (i == l.size() - 1) {
			if (tempDiff != difference) {
				return false;
			}
			return true;
		}
		if (tempDiff != difference) {
			return false;
		}else {
			return isArithmeticListHelper(i + 1, tempDiff, l);
		}
	}

	/**
	 * Given a sorted input array a, return a sorted array of size a.length + 1,
	 * consisting of all elements of array a and integer i.
	 * 
	 * @param a
	 *            an array that is sorted in a non-descending order
	 * @param i
	 *            an integer
	 * @return a sorted array of size a.length + 1, consisting of all elements of
	 *         array a and integer i. e.g., insertIntoSortedArray({1, 2, 4, 5}, 3)
	 *         returns a sorted array {1, 2, 3, 4, 5}.
	 * 
	 *         <b>You are forbidden to use the insertIntoSortedList method below to
	 *         solve this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public int[] insertIntoSortedArray(int[] a, int i) {
		int[] temp = new int[a.length + 1];
		if (a.length == 0) {
			temp[0] = i;
			return temp;
		}
		insertIntoSortedArrayHelper(a, temp, i, 0);
		return temp;
	}

	void insertIntoSortedArrayHelper(int[] a, int[] temp, int i, int n) {

		if (a.length == n) {
			temp[a.length] = i;
			return;
		}

		if (i < a[n]) {
			temp[n] = i;
			i = a[n];
		} else {
			temp[n] = a[n];
		}
		insertIntoSortedArrayHelper(a, temp, i, n + 1);

	}

	/**
	 * Given a sorted input list, return a sorted list of size list.size() + 1,
	 * consisting of all elements of the input list and integer i.
	 * 
	 * @param list
	 *            a list that is sorted in a non-descending order
	 * @param i
	 *            an integer
	 * @return a sorted list of size list.size() + 1, consisting of all elements of
	 *         the input list and integer i. e.g., insertIntoSortedList({1, 2, 4,
	 *         5}, 3) returns a sorted list {1, 2, 3, 4, 5}.
	 * 
	 *         <b>You are forbidden to use the insertIntoSortedArray method above to
	 *         solve this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public List<Integer> insertIntoSortedList(List<Integer> list, int i) {
		if (list.size() == 0) {
			list.add(i);

			return list;
		} else if (list.get(0) > i) {
			list.add(0, i);
			return list;
		}
		insertIntoSortedListHelper(list, i, 0);
		return list;
	}

	void insertIntoSortedListHelper(List<Integer> list, int n, int i) {
		if (list.get(i) == n) {
			list.add(i, n);
			return;
		}
		if (i == list.size() - 2) {
			if (list.get(i + 1) >= n)
				list.add(i + 1, n);
			if (list.get(i + 1) < n)
				list.add(i + 2, n);
			return;
		}
		if (list.get(i) < n && list.get(i + 1) > n) {
			list.add(i + 1, n);
			return;
		}
		insertIntoSortedListHelper(list, n, i + 1);
	}

	/**
	 * Given two sorted arrays left and right, where left is sorted in a
	 * non-descending order and right is sorted in a ***non-ascending*** order,
	 * return an array (of size left.length + right.length) sorted in a
	 * non-descending order, consisting of all elements of arrays left and right.
	 * 
	 * @param left
	 *            an array sorted in a non-descending order
	 * @param right
	 *            an array sorted in a non-ascending order
	 * @return a sorted array of size left.length + right.length, consisting of all
	 *         elements of arrays left and right. e.g., mergeSortedArraysV2({1, 3,
	 *         5, 7}, {8, 6, 4, 2}) returns a sorted array {1, 2, 3, 4, 5, 6, 7, 8}.
	 * 
	 *         <b>You are forbidden to use the mergeSortedListsV2 method below to
	 *         solve this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public int[] mergeSortedArrays(int[] left, int[] right) {
		int[] temp = new int[left.length + right.length];
		if (temp.length == 0)
			return temp;
		mergeSortedArraysHelper(temp, left, right, 0, 0, right.length - 1);
		return temp;
	}

	void mergeSortedArraysHelper(int[] temp, int[] left, int[] right, int f, int l, int r) {
		if ((l == left.length) && (r < 0))
			return;

		if (l == left.length) {
			temp[f] = right[r];
			mergeSortedArraysHelper(temp, left, right, f + 1, l, r - 1);
		} else if (r < 0) {
			temp[f] = left[l];
			mergeSortedArraysHelper(temp, left, right, f + 1, l + 1, r);
		} else if (left[l] > right[r]) {
			temp[f] = right[r];
			mergeSortedArraysHelper(temp, left, right, f + 1, l, r - 1);
		} else if (left[l] < right[r]) {
			temp[f] = left[l];
			mergeSortedArraysHelper(temp, left, right, f + 1, l + 1, r);
		}

	}
	//
	// int[] mergeSortedArraysHelper(int[] arr, int n) {
	//
	//
	//
	// }

	/**
	 * Given two sorted lists left and right, where left is sorted in a
	 * non-descending order and right is sorted in a ***non-ascending*** order,
	 * return a list (of size left.length + right.length) sorted in a non-descending
	 * order, consisting of all elements of lists left and right.
	 * 
	 * @param left
	 *            a list sorted in a non-descending order
	 * @param right
	 *            a list sorted in a non-ascending order
	 * @return a sorted list of size left.size() + right.size(), consisting of all
	 *         elements of lists left and right. e.g., mergeSortedListsV2({1, 3, 5,
	 *         7}, {8, 6, 4, 2}) returns a sorted list {1, 2, 3, 4, 5, 6, 7, 8}.
	 * 
	 *         <b>You are forbidden to use the mergeSortedArraysV2 method above to
	 *         solve this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public List<Integer> mergeSortedLists(List<Integer> left, List<Integer> right) {
		List<Integer> temp = new ArrayList<Integer>();
		if (left.size() == 0) {
			Collections.reverse(right);
			temp.addAll(right);
			return temp;
		} else if (right.size() == 0) {
			temp.addAll(left);
			return temp;
		}
		if (left.get(0) > right.get(right.size() - 1)) {
			temp.add(right.remove(right.size() - 1));
		}else if (left.get(0) < right.get(right.size() - 1)) {
			temp.add(left.remove(0));
		}
		temp.addAll(mergeSortedLists(left, right));
		return temp;
	}
}