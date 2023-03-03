public class Test {
    public static void main(String[] args) throws InvalidPostFixExpressionException {
        PostfixEvaluator postfixEvaluator = new PostfixEvaluator("1 2 +");
        System.out.println(postfixEvaluator.evalPostFixExpression());
    }
}
