/**
 * File name: Interpreter1.java
 * Author: Chris Fairhurst
 * Date: November 19, 2023
 * Description: This file contains the implementation of an interpreter
 * for mathematical expressions, based on Java’s Stack.
 */
package Practical_13;

import java.text.DecimalFormat;
import java.util.Stack;
import java.util.StringTokenizer;

public class Interpreter1 {
    /**
     * Stack for storing operands and operators.
     */
    Stack<String> stack;

    DecimalFormat decimalFormat;

    /**
     * Constructor for Interpreter1.
     */
    public Interpreter1() {
        this.stack = new Stack<>();
        this.decimalFormat = new DecimalFormat("#.##");
    }

    /**
     * Checks if the stack contains 3 operands and 1 operator.
     * @param stack Stack to be checked.
     * @return True if the stack contains 3 operands and 1 operator, false otherwise.
     */
    public boolean checkStack(Stack<String> stack) {
        if (this.stack.size() >= 4 && !this.stack.contains("+, -, *, /")) {
            System.out.println("Error: Input Error\n");
            return true;
        }

        return false;
    }

    /**
     * Processes a postfix expression.
     * @param postFixExpression Postfix expression to be processed.
     */
    public void processPostFixExpression(String postFixExpression) {
        // Tokenize input
        StringTokenizer tokenizer = new StringTokenizer(postFixExpression, " ");
        String token;
        // Process tokens
        while (tokenizer.hasMoreElements()) {
            token = tokenizer.nextToken();

            // Check if token is numeric
            try {
                Double tmpDouble = Double.parseDouble(token);
                System.out.println("Rule 2: Operand (" + tmpDouble + ") := " + tmpDouble);
                stack.push(String.valueOf(tmpDouble));
                System.out.println("Stack: " + stack);
                checkStack(stack);
                if (checkStack(stack)) {
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
                        System.out.println("Error: Input Error: Too many operands in sequence statement\n");
                        return;
                    }
                } else {
                    System.out.println("Error: Input Error: Operator in unappropriate position or statement is not valid\n");
                    break;
                }
            }
        }
    }

    /**
     * Performs an operation on two operands.
     * @param operand1 First operand.
     * @param operand2 Second operand.
     * @param operator Operator.
     * @return Result of the operation.
     */
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

    /**
     * Formats a result to two decimal places.
     * @param result Result to be formatted.
     * @return Formatted result.
     */
    private String formatResult(double result) {
        return decimalFormat.format(result);
    }

    /**
     * Main method for testing the Interpreter1.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        Interpreter1 interpreter = new Interpreter1();
        String postFixExpression = "4.3 25 + 1.7 2 * - 3.2 /";
        interpreter.processPostFixExpression(postFixExpression);
    }
}