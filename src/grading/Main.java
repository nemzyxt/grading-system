// Author : Nemuel Wainaina

/*
 * The program takes the marks for the number of units specified by the user,
 * grades them and calculates the average
 * All the marks and grades for the units as well as the average are the displayed 
 * to the user in tabular format 
 */

package grading;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	// the main function
	public static void main(String[] args) {
		int n;
		ArrayList<Integer> marks = new ArrayList<Integer>();
		ArrayList<Character> grades = new ArrayList<Character>();
		System.out.print("Enter the number of units : ");
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		for(int i = 0; i < n; i++) {
			int mark = getMark(i, s);
			marks.add(mark);
			grades.add(gradeMark(mark));
		}
		int avg = calcAverage(marks);
		
		// Now display the results to the user
		System.out.println("----------------------------------------");
		System.out.println("UNIT\t\tMARK\t\tGRADE");
		System.out.println("----------------------------------------");
		for(int i = 0; i < n; i++) {
			String mk = Integer.toString(marks.get(i));
			System.out.println("Unit " + Integer.toString(i+1) + "\t\t" + mk + "\t\t" + grades.get(i));
		}
		System.out.println(""); // blank line
		System.out.println("AVG\t\t" + Integer.toString(avg) + "\t\t" + gradeMark(avg));
		System.out.println("----------------------------------------");
		
		s.close();
	}
	
	// collect the mark from the user, and add it to the ArrayList
	public static int getMark(int i, Scanner s) {
		System.out.print("Unit " + Integer.toString(i+1) + " : ");
		int mark = s.nextInt();
		if(mark < 0 || mark > 100) {
			System.out.println("Invalid mark, try again !");
			Main.getMark(i, s);
		}
		return mark;
	}
	
	// grade the mark and return its equivalent grade
	public static char gradeMark(int mark) {
		char grade;
		if(mark >= 70) {
			grade = 'A';
		} else if(mark >= 60 && mark < 70) {
			grade = 'B';
		} else if(mark >= 50 && mark < 60) {
			grade = 'C';
		} else if(mark >= 40 && mark < 50) {
			grade = 'D';
		} else {
			// pass, less than 40
			grade = 'P';
		}
		return grade;
	}
	
	// calculate and return the average of the marks entered by the user
	public static int calcAverage(ArrayList<Integer> marks) {
		int sum = 0;
		for(int m : marks) {
			sum += m;
		}
		int avg = sum / marks.size();
		return avg;
	}
}
