import java.util.EmptyStackException;
import java.util.Stack;
import java.util.StringTokenizer;

public class PostfixEvaluator {
    public String expression;

    PostfixEvaluator(String expression) {
        this.expression = expression;
    }

    public double evalPostFixExpression() throws InvalidPostFixExpressionException {
        if (this.expression.isBlank()) {
            return 0;
        }

        if (!this.expression.contains(" ")) {
            throw new InvalidPostFixExpressionException();
        }

        this.expression = this.expression.trim();

        Stack<Double> stack = new Stack<>();

        StringTokenizer stringTokenizer = new StringTokenizer(expression, " ");

        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
            // only digits 
            if (token.matches("[0-9]+")) {
                stack.push(Double.parseDouble(token));
                continue;
            } 


            if (token.length() == 1 && token.matches("\\+|\\/|\\*|\\-")) {
                try {
                    double first = stack.pop();
                    double second = stack.pop();
                    if (token.equals("+")) {
                        stack.push(first + second);
                    } else if (token.equals("-")) {
                        stack.push(first - second);
                    } else if (token.equals("*")) {
                        stack.push(first * second);
                    } else if (token.equals("/")) {
                        stack.push(first / second);
                    }
                } catch (EmptyStackException emptyStackException) {
                    throw new InvalidPostFixExpressionException();
                }
            } else {
                throw new InvalidPostFixExpressionException();
            }
            
        }
        if (stack.size() > 1 || stack.isEmpty()) {
            throw new InvalidPostFixExpressionException();
        }

        return stack.pop();
    }
}
