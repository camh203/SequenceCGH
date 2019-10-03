//imports
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
* This is where you'd put a brief description of what this class is supposed to do.
* In this case, the class exists to show you how I expect you to comment * your code.
*
* @author Your Name Here * @version Today's date * Style Guide Project
* Semester/Year
*/

public class Application extends Manual{
	
	public static String fileName; //holds entered name of file
	public static String subseq; //holds the entered subsequence from the user
	public static String seq;	//holds the entered sequence from the user
	public static LinkedStack<Character> subFile=new LinkedStack<Character>(); //linked stack to hold entered subsequence broken down into characters
	public static LinkedStack<Character> seqFile=new LinkedStack<Character>(); //linked stack to hold entered sequence broken down into characters
	public static Character a; //holds character from subsequence being compared to character from sequence
	public static Character b; //holds character from sequence being compared to character from subsequence
	public static boolean File; //tells if entered subsequence is a subsequence of sequence or not
	
	public static void main(String [] args) {
		
		/* Asks if user wants to enter sequences manually or from a file
		 * if M is entered manualSubsequence is called
		 * if F is entered fileSubsequence is called
		 */
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Would you like to enter the sequences manually or from a file? (M/F): ");
		String input = scan.nextLine();
		
		if(input.contentEquals("M")) {
			
			manualSubsequence();
			
		}//close if statement
		else {
			
			fileSubsequence();
			
		}//close else statement
		
	}
	
	public static void fileSubsequence() { //asks for name of file 
		
		Scanner name = new Scanner(System.in);
		System.out.print("\nEnter the name of the file to process: ");
		fileName = name.nextLine(); //sets fileName to entered file name
	
		try{
		
			Scanner fileData = new Scanner(new File(fileName)); //accesses entered file
		
			while (fileData.hasNextLine()) { //makes sure we stop attempting to pull values from file after we've gone through each line
				
				subFile.clear(); //resets subFile linked stack for next subsequence
				seqFile.clear(); //resets seqFile linked stack for next sequence
				
				String line = fileData.nextLine(); //goes to next line and sets String line to this line
				
				int x = line.indexOf(","); //finds index of comma
				int y = line.length(); //finds length of whole first line
				
				int subLetter = x - 1; //last char of first sequence is char right before comma hence x-1
				int seqLetter = y - 1; //last char of second sequence, -1 because index of string starts and 0 but length() gives amount of characters which starts at 1.
				
				for(int i = 1; i < x; i++) { //loops backwards through entered subsequence and adds each separate letter to subList using Character wrapper class
					
					Character j = line.charAt(subLetter);  //sets j to current character, pushes this character to subFile, then decrements subLetter
					subFile.push(j);
					subLetter = subLetter - 1;
					
				} //end for loop
				
				for(int k = 1; k < y - (x +2) ; k++) { //loops backwards through entered sequence and adds each separate letter to subList using Character wrapper class
					
					Character l = line.charAt(seqLetter); //sets l to current character, pushes this character to seqFile, then decrements seqLetter
					seqFile.push(l);
					seqLetter = seqLetter - 1;	
					
				} //end for loop
				
				fileCheck();
		            
			} // end while
			
		          fileData.close();
		}
		
		catch (FileNotFoundException e) {
	
		}
	}
	
	public static void fileCheck() {
		
		/*if both subFile and seqFile are not empty we pop a char from each 
		 * then head down to fileCompare() to do evaluations if one or both are 
		 * empty we go down to the if and else if statements to see if the entered 
		 * subsequence is or isn't a subsequence of the sequence*/
		
		if(!subFile.isEmpty() && !seqFile.isEmpty()) { //makes sure we don't attempt to pop chars from empty LinkedStack
		
			a = subFile.pop();
			b = seqFile.pop();
			fileCompare();
			
		} //close if statement
		
		else if(seqFile.isEmpty() || (subFile.isEmpty() && seqFile.isEmpty())) { //if seqlist winds up empty or both seqList and sublist wind up empty, every value from seqList found a matching value from subList
			
			File = true;
			Answer();
			
		}//close else if statement
		
		else {
			
			File = false;
			Answer();
			
		}//close else statement
		
	}
	
	public static void fileCompare() { //sees if the current chars a and b are equal or not
		
		if(!subFile.isEmpty() && !seqFile.isEmpty()) { //makes sure we don't attempt to pop chars from empty LinkedStack
			
			if(a.equals(b)) { //if they are equal we go back to manualCheck() to either pop 2 more chars or see if entered subsequence is or isn't a subsequence of the sequence
				
				fileCheck();
				
			}//close if statement
			
			else { //if a and b aren't equal we pop another b value then go back to start of fileCompare()
				
				b = seqFile.pop();
				fileCompare();
				
			}//close else statement
			
		}//close if statement
		
		else if(seqFile.isEmpty() && !subFile.isEmpty()) { //only time we don't have a subsequence is if seqFile is empty while subFile is not
			
			File = false;
			Answer();
			
		}//close else if statement
		
		else {
			
			File = true;
			Answer();
			
		}//close else statement
		
	}
	
	public static void Answer() {
		
		if(File) {
			
			System.out.println("\n" + subseq + " IS A SUBSEQUENCE of " + seq + ".");
			
		}//close if statement
		
		else {
			
			System.out.println("\n" + subseq + " IS NOT A SUBSEQUENCE of " + seq + ".");
			
		}//close else statement
		
	}
	
}

