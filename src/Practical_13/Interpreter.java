package Practical_13;

import java.text.DecimalFormat;
import java.util.Stack;
import java.util.StringTokenizer;

public class Interpreter {

    private Stack<Double> operandStack;
    private DecimalFormat decimalFormat;

    public Interpreter() {
        this.operandStack = new Stack<>();
        this.decimalFormat = new DecimalFormat("#.##");
    }

    public void processPostFixExpression(String postFixExpression) {
        // Separate tokens
        StringTokenizer tokenizer = new StringTokenizer(postFixExpression, " ");
        String token;

        // Process input
        while (tokenizer.hasMoreElements()) {
            token = tokenizer.nextToken();

            try {
                // Check if token is numeric
                Double tmpDouble = Double.parseDouble(token);
                System.out.println("Rule 2: Operand (" + formatResult(tmpDouble) + ") := " + tmpDouble);
                operandStack.push(tmpDouble);
                System.out.println("Stack: " + formatStack(operandStack));
            } catch (NumberFormatException nfe) {
                // Process token as text
                System.out.println("Rule 1: Operator (" + token + ") := " + token);

                if (operandStack.size() >= 2) {
                    Double operand2 = operandStack.pop();
                    Double operand1 = operandStack.pop();
                    Double result = performOperation(operand1, operand2, token);

                    if (result != null) {
                        operandStack.push(result);
                        System.out.println("Rule 3: Operand(" + formatResult(result) + ") := Operand(" + formatResult(operand1) +
                                ") Operand(" + formatResult(operand2) + ") Operator(" + token + ")");
                        System.out.println("Stack: " + formatStack(operandStack));
                    } else {
                        System.out.println("Invalid expression: Division by zero");
                        return;
                    }
                }
            }
        }

        // Print final result when StringTokenizer is empty
        if (tokenizer.countTokens() == 0 && operandStack.size() == 1) {
            Double finalResult = operandStack.pop();
            System.out.println("Final result: " + formatResult(finalResult));
        } else {
            System.out.println("Invalid expression: Stack not empty or tokens remaining");
        }
    }

    private Double performOperation(Double operand1, Double operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    return null; // Division by zero
                }
                return operand1 / operand2;
            default:
                return null; // Invalid operator
        }
    }

    private String formatResult(double result) {
        return decimalFormat.format(result);
    }

    private String formatStack(Stack<Double> stack) {
        StringBuilder formattedStack = new StringBuilder("[");
        for (double element : stack) {
            formattedStack.append(formatResult(element)).append(", ");
        }
        if (!stack.isEmpty()) {
            formattedStack.setLength(formattedStack.length() - 2); // Remove trailing comma and space
        }
        formattedStack.append("]");
        return formattedStack.toString();
    }

    public static void main(String[] args) {
        Interpreter interpreter = new Interpreter();
        String postFixExpression = "4.3 25 +  1.7 2 * - 3.2 / ";
        interpreter.processPostFixExpression(postFixExpression);
    }
}