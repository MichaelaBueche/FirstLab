package lab1;

import java.util.ArrayList;

/**
 * CS 2003 - Lab 1. Code to compute the average of doubles from an input
 * file.  NOTE: add data members and methods at your convenience. Use
 * the most accurate data types. You can reuse bits of code from
 * the class Lab1a.
 *
 * @author Michaela Bueche
 * @since 9/1/17
 * @version 2
 */

import java.util.Scanner;
import java.util.Vector;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Lab1b {

	// data members

	/**
	 * Constructor: calls method readFile that reads the doubles contained in the
	 * file "<code>filename</code>" and computes the average of the elements.
	 * 
	 * @param filename
	 *            name of the file containing doubles.
	 */
	public Lab1b(String filename) {
		readFile(filename);
	}

	/**
	 * Reads double from a file named <code>filename</code> and computes the average
	 * of the elements contained in the file
	 * 
	 * @param filename
	 *            name of the file containing the doubles
	 */
	public void readFile(String filename) {
		// reads file, creates an ArrayList of the doubles in the file, calls average() and prints result
		File fileIn = new File(filename);
		Scanner input=null;
		try {
			input = new Scanner(fileIn);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ArrayList<Double> numbers=new ArrayList<Double>();
		while(input.hasNextDouble()) {
			numbers.add(input.nextDouble());
		}
		System.out.println(average(numbers));
		input.close();
	} // end readFile()
	
	/**
	 * Computes average of ArrayList of doubles
	 * 
	 * @param nums ArrayList of doubles 
	 * @return average = (double) sum/nums.size()
	 */
	public double average(ArrayList<Double> nums) {
		double sum=0;
		for(int i=0;i<nums.size();i++) {
			sum+=nums.get(i);
		}//sum of ArrayList of doubles
		return sum/nums.size();
	} // end average()

	/**
	 * main : creates a Lab1b Object with the filename passed in argument
	 */
	public static void main(String args[]) {
		if (args.length == 0) 
			System.err.println("enter the data file name!");
		else
			new Lab1b(args[0]);
	} // end main

} // end class Lab1b

