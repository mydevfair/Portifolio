package Practical_13;

import java.text.DecimalFormat;
import java.util.Stack;
import java.util.StringTokenizer;

public class Interpreter1 {
    // Stack to store operands during the expression evaluation
    private Stack<String> stack;
    // Decimal format for formatting doubles in the stack
    private DecimalFormat decimalFormat;

    // Constructor initializing the stack and decimal format
    public Interpreter1() {
        this.stack = new Stack<>();
        this.decimalFormat = new DecimalFormat("#.##");
    }

    public boolean checkStack(Stack<String> stack) {
        if (this.stack.size() == 3 && !this.stack.contains("+, -, *, /")) {
            System.out.println("Error: Input Error\n");
            return true;
        }

        return false;
    }

    //Method to process a postfix expression
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
                System.out.println("Rule 2: Operand (" + tmpDouble + ") := " + tmpDouble);
                stack.push(String.valueOf(tmpDouble));
                System.out.println("Stack: " + stack);
                checkStack(stack);
                if (checkStack(stack) == true) {
                    break;
                }

            } catch (NumberFormatException nfe) {
                // Process token as text
                System.out.println("Rule 1: Operator (" + token + ") := " + token);
                stack.push(token);
                System.out.println("Stack: " + stack);

                if (stack.size() >= 3) {
                    String operator = stack.pop();
                    Double operand2 = Double.valueOf(stack.pop());
                    Double operand1 = Double.valueOf(stack.pop());
                    Double result = performOperation(operand1, operand2, operator);
                    if (result != null) {
                        stack.push(String.valueOf(formatResult(result)));
                        System.out.println("Rule 3: Operand(" + formatResult(result) + ") := Operand("
                                + formatResult(operand1) + ") Operand(" + formatResult(operand2) + ") Operator(" + token + ")");
                        System.out.println("Stack: " + stack);
                    } else {
                        System.out.println("Error: Input Error\n");
                        return;
                    }
                } else {
                    System.out.println("Error: Input Error\n");
                    break;
                }
            }
        }
    }

    // Method to perform arithmetic operation based on the operator
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

    // Method to format a double using DecimalFormat
    private String formatResult(double result) {
        return decimalFormat.format(result);
    }

    // Main method to test the interpreter
    public static void main(String[] args) {
        Interpreter1 interpreter = new Interpreter1();
        String postFixExpression = "4.3 25 - 1.7 2 * - 3.2 /";
        interpreter.processPostFixExpression(postFixExpression);
    }
}