package eecs2030.lab2;

import java.util.Objects;

/**
 * 
 * A class representing a Canadian nickel. The monetary value of nickel is
 * defined to be five cents. Nickels were first minted in the year 1858. A
 * nickel has an issue year which is the year in which the nickel was issued by
 * the mint.
 */
public class Nickel implements Comparable<Nickel> {

	private int year;

	/**
	 * The monetary value of a nickel in cents.
	 */
	public final int CENTS = 5;

	/**
	 * Initializes this nickel to have the specified issue year.
	 * 
	 * @param year
	 *            the year this coin was issued in
	 * 
	 * @throws IllegalArgumentException
	 *             if year is less than 1858
	 */
	public Nickel(int year) {
		this.year = year;
		if (year < 1858) {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Compares this nickel to another nickel by their issue year. The result is a
	 * negative integer if this nickel has an earlier issue year than the other
	 * nickel, a positive integer if this nickel has a later issue year than the the
	 * other nickel, and zero otherwise. Specifically, this method returns the
	 * difference of the issue year of this nickel and the issue year of the other
	 * nickel.
	 * 
	 * @return the difference of the issue year of this nickel and the issue year of
	 *         the other nickel
	 */
	public int compareTo(Nickel other) {
		if (this.year - other.year < 0) {
			if (this.year < other.year) {
				return this.year - other.year;
			} else if (other.year > this.year) {
				return other.year - this.year;
			} else {
				return 0;
			}
		} else if (this.year - other.year > 0) {
			if (this.year > other.year) {
				return this.year - other.year;
			} else if (other.year < this.year) {
				return other.year - this.year;
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}

	/**
	 * Compares this nickel to the specified object for equality. The result is true
	 * if obj is a nickel. The issue year is not considered when comparing two
	 * nickels for equality.
	 * 
	 * @param obj
	 *            the other nickel
	 * 
	 * @return true if object is a nickel
	 */
	public boolean equals(Nickel obj) {
		return true;
	}

	/**
	 * Returns a hash code for this nickel. Specifically, this method returns the
	 * issue year of this nickel.
	 * 
	 * @return the issue year of this nickel
	 * 
	 */
	public int hashCode() {
		return Objects.hash(this.year);
	}

	/**
	 * Returns the issue year of the coin.
	 * 
	 * @return the year the nickel was issued
	 */
	public int issueYear() {
		return year;
	}

}
