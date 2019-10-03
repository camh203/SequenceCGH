//imports
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

/**
* This class takes a subsequence and a sequence from the user, places them in a linked stack character by character,
* then checks to see if the entered subsequence is a subsequnce of the entered sequence.
*
* @author Cameron Herbert * @version October 3rd, 2019 * Determining Subsequences Project
* Semester 1/2019
*/
	
public class Manual extends LinkedStack {
	
	public static String subseq; //holds the entered subsequence from the user
	public static String seq;	//holds the entered sequence from the user
	public static LinkedStack<Character> subList=new LinkedStack<Character>(); //linked stack to hold entered subsequence broken down into characters
	public static LinkedStack<Character> seqList=new LinkedStack<Character>(); //linked stack to hold entered sequence broken down into characters
	public static Character a; //holds character from subsequence being compared to character from sequence
	public static Character b; //holds character from sequence being compared to character from subsequence
	public static boolean Manual; //tells if entered subsequence is a subsequence of sequence or not
	
	public static void manualSubsequence() {
		
		subList.clear(); //resets linkedstack for next subsequence
		seqList.clear(); //resets linkedstack for next sequence
		
		Scanner manual = new Scanner(System.in);
		
		System.out.print("\nEnter the first sequence:   ");
		subseq = manual.nextLine();
		
		System.out.print("Enter the second sequence:  ");
		seq = manual.nextLine();
		
		manualLinkedstack(); 
	} //close manual subsequence
	
	public static void manualLinkedstack() {
		
		int subLetter = subseq.length() - 1; //last index of subsequence string
		int seqLetter = seq.length() - 1; //last index of sequence string
		
		for(int i = 1; i < subseq.length(); i++) { //loops backwards through entered subsequence and adds each separate letter to subList using Character wrapper class
			
			Character x = subseq.charAt(subLetter); //sets x to current character, pushes this character to subList, then decrements subLetter
			subList.push(x);
			subLetter = subLetter - 1;
			
		} //close for loop
		
		for(int k = 1; k < seq.length(); k++) { //loops backwards through entered sequence and adds each separate letter to subList using Character wrapper class
			
			Character y = seq.charAt(seqLetter); //sets y to current character, pushes this character to seqList, then decrements seqLetter
			seqList.push(y);
			seqLetter = seqLetter - 1;	
			
		} //close for loop
		
	manualCheck();
	
	} //close manualLinkedStack
	
	public static void manualCheck() {
		
		/*if both subList and seqList are not empty we pop a char from each 
		 * then head down to manualCompare() to do evaluations if one or both are 
		 * empty we go down to the if and else if statements to see if the entered 
		 * subsequence is or isn't a subsequence of the sequence*/
		
		if(!subList.isEmpty() && !seqList.isEmpty()) { //makes sure we don't attempt to pop chars from empty LinkedStack
		
			a = subList.pop();
			b = seqList.pop();
			manualCompare();
			
		} //close if statement
		
		else if(seqList.isEmpty() || (subList.isEmpty() && seqList.isEmpty())) { //if seqlist winds up empty or both seqList and sublist wind up empty, every value from seqList found a matching value from subList
			
			Manual = true;
			Answer();
			
		} //close else if statement
		
		else { 
			
			Manual = false;
			Answer();
			
		} //close else statement
		
	} //close manual check
	
	public static void manualCompare() { //sees if the current chars a and b are equal or not
		
		if(!subList.isEmpty() && !seqList.isEmpty()) { //makes sure we don't attempt to pop chars from empty LinkedStack
			
			if(a.equals(b)) { //if they are equal we go back to manualCheck() to either pop 2 more chars or see if entered subsequence is or isn't a subsequence of the sequence
				
				manualCheck();
				
			} //close if statement
			
			else {
				
				b = seqList.pop(); //if current char a doesn't equal current char b we pop another b then go back to check if char a equals new char b
				manualCompare();    
				
			} //close else statement
			
		} //close if statement
		
		else if(seqList.isEmpty() && !subList.isEmpty()) { //only time we don't have a subsequence is if seqList is empty while subList is not
			
			Manual = false;
			Answer();
			
		} //close else if statement
		
		else {
			
			Manual = true;
			Answer();
			
		} //close else statement
		
	}
	
	public static void Answer() {
		
		
		if(Manual) {
			
			System.out.println("\n" + subseq + " IS A SUBSEQUENCE of " + seq + ".");
			
		} //close if statement
		
		else {
			
			System.out.println("\n" + subseq + " IS NOT A SUBSEQUENCE of " + seq + ".");
			
		} //close else statement
		
			Scanner answer = new Scanner(System.in);
			System.out.print("\nWould you like to enter more sequences? (Y/N): ");
			String input = answer.nextLine();
	
		if(input.contentEquals("Y")) {
			
			manualSubsequence();
			
		} //close if statement
		
		else {
			
			System.out.print("\n<END RUN>");
			
		} //close else statement
		
	} //close answer
	
}
