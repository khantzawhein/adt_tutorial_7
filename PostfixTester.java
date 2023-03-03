import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PostfixTester {
    public static void main(String[] args) {

        if (args.length != 1) {
            String usage = """
                    Usage: java PostfixTester <input file path>
                    eg. java PostfixTester input1.txt
                    """;
            System.out.print(usage);
            return;
        }

        File file = new File(args[0]);
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isBlank()) {
                    continue;
                }
                PostfixEvaluator postfixEvaluator = new PostfixEvaluator(line);
                try {
                    double result = postfixEvaluator.evalPostFixExpression();
                    System.out.println(line + " is a valid postfix expression. Result is: " + result);
                } catch (InvalidPostFixExpressionException invalidPostFixExpressionException) {
                    System.out.println(line + " is a invalid postfix expression, hint: you need to separate operands and operators with a space!.");
                }
            }
            scanner.close();
            System.out.println("Program terminated gracefully.");
        } catch (FileNotFoundException exception) {
            System.out.println("File not found");
            return;
        }
    }
}