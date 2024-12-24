// Main File
import LanguageBricks.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Input text and character for sorting
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the text:");
        String inputText = scanner.nextLine();

        System.out.println("Enter the character for sorting:");
        char targetChar = scanner.next().toLowerCase().charAt(0);

        // Process the text
        Text text = new Text(inputText);
        String result = text.process(targetChar);

        // Print the result
        System.out.println("Result:");
        System.out.println(result);

        scanner.close();
    }
}
