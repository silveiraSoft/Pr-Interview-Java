import java.util.*;

public class PostfixExpressionEvaluatorV3 {

    public static void main(String[] args) {
        String expression = "3 + 4 * 2 / ( 1 - 5 )";

        List<String> postfix = infixToPostfix(expression);
        double result = evaluatePostfix(postfix);

        System.out.println("Infix:   " + expression);
        System.out.println("Postfix: " + postfix);
        System.out.println("Result:  " + result);
    }

    /* -----------------------------
       INFIX → POSTFIX
     ----------------------------- */

    public static List<String> infixToPostfix(String expression) {
        List<String> output = new ArrayList<>();
        Deque<String> operators = new ArrayDeque<>();

        String[] tokens = expression.split("\\s+");

        for (String token : tokens) {
            if (isNumber(token)) {
                output.add(token);

            } else if (token.equals("(")) {
                operators.push(token);

            } else if (token.equals(")")) {
                while (!operators.peek().equals("(")) {
                    output.add(operators.pop());
                }
                operators.pop(); // remove "("

            } else { // operator
                while (!operators.isEmpty()
                        && precedence(operators.peek()) >= precedence(token)) {
                    output.add(operators.pop());
                }
                operators.push(token);
            }
        }

        while (!operators.isEmpty()) {
            output.add(operators.pop());
        }

        return output;
    }

    /* -----------------------------
       POSTFIX EVALUATION
     ----------------------------- */

    public static double evaluatePostfix(List<String> postfix) {
        Deque<Double> stack = new ArrayDeque<>();

        for (String token : postfix) {
            if (isNumber(token)) {
                stack.push(Double.parseDouble(token));
            } else {
                double b = stack.pop();
                double a = stack.pop();
                stack.push(applyOperator(a, b, token));
            }
        }

        return stack.pop();
    }

    /* -----------------------------
       HELPERS
     ----------------------------- */

    private static boolean isNumber(String token) {
        return token.matches("-?\\d+(\\.\\d+)?");
    }

    private static int precedence(String operator) {
        return switch (operator) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> 0;
        };
    }

    private static double applyOperator(double a, double b, String operator) {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new IllegalArgumentException("Unknown operator: " + operator);
        };
    }
}
