
/*import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Sequence extends LinkedStack{
	
	public static String subseq;
	public static String seq;
	public static LinkedStack<Character> subFile=new LinkedStack<Character>();
	public static LinkedStack<Character> seqFile=new LinkedStack<Character>();
	public static Character a;
	public static Character b;
	public static boolean File;
	public static String fileName;
	
	public static void fileSubsequence() {
	
		Scanner name = new Scanner(System.in);
		System.out.print("Enter the name of the file to process: ");
		fileName = name.nextLine();
	
		try{
		
			Scanner fileData = new Scanner(new File(fileName)); 
		
			while (fileData.hasNextLine()) {
				
				String line = fileData.nextLine();
				int x = line.indexOf(",");
				int y = line.length();
				
				int subLetter = x - 2;
				int seqLetter = y - 1;
				
				for(int i = 1; i < subseq.length(); i++) {
					
					Character j = subseq.charAt(subLetter);
					subFile.push(x);
					subLetter = subLetter - 1;
				}
				for(int k = 1; k < seq.length(); k++) {
					
					Character l = seq.charAt(seqLetter);
					seqFile.push(y);
					seqLetter = seqLetter - 1;		
				}
				fileCheck();
		            
			} // end while
		          fileData.close();
		}
		catch (FileNotFoundException e) {
	
		}
	}
	public static void fileCheck() {
		
		if(!subFile.isEmpty() && !seqFile.isEmpty()) {
		
			a = subFile.pop();
			b = seqFile.pop();
			fileCompare();
		} 
		else if(seqFile.isEmpty() || (subFile.isEmpty() && seqFile.isEmpty())) {
			File = true;
			
			Answer();
		}
		else {
			File = false;
			
			Answer();
		}
	}
	public static void fileCompare() {
		
		if(!subFile.isEmpty() && !seqFile.isEmpty()) {
			if(a.equals(b)) {
				fileCheck();
			}
			else {
				b = seqFile.pop();
				fileCompare();
			}
		}
		else if(seqFile.isEmpty() && !subFile.isEmpty()) {
			File = false;
			Answer();
		}
		else {
			File = true;
			Answer();
		}
	}
	public static void Answer() {
		if(File) {
		System.out.println("\n" + subseq + " IS A SUBSEQUENCE of " + seq + ".");
		}
		else {
			System.out.println("\n" + subseq + " IS NOT A SUBSEQUENCE of " + seq + ".");
		}
	}
}*/