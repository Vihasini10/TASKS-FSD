package basic;
import java.util.Scanner;

public class StringAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

       
        input = input.trim();//remove a space and leading
        //input.trim create a new string without spaces  at the beginning or end.

      
        String[] words = input.split("\\s+");
        int wordCount = input.isEmpty() ? 0 : words.length;

        
        int charCount = 0;
        for (char ch : input.toCharArray()) {
            if (ch != ' ') {
                charCount++;
            }
        }

        
        String reversed = new StringBuilder(input).reverse().toString();

     
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

       
        System.out.println("\n--- String Analyzer ---");
        
        System.out.println("Word Count        : " + wordCount);
        System.out.println("Character Count   : " + charCount);
        System.out.println("Reversed Sentence : " + reversed);
        System.out.println("Longest Word      : " + longestWord);

        scanner.close();
    }
}