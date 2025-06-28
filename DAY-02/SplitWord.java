package basic;

import java.util.Scanner;

public class SplitWord {
	public static void main(String args[]) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the sentence:");
		String a=scanner.nextLine();
		String[] word=a.split(" ");	
		for(int i=0;i<word.length;i++) {
			System.out.println(word[i]);
		}
	}
}