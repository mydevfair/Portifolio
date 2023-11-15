package Practical_13;

import java.text.DecimalFormat;
import java.util.Stack;
import java.util.StringTokenizer;

public class Interpreter {

    private Stack<Object> mixedStack;
    private DecimalFormat decimalFormat;

    public Interpreter(){
        this.mixedStack = new Stack<>();
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
                System.out.println("Rule 2: Operand (" + tmpDouble + ") := " + tmpDouble);
                mixedStack.push(token);
            } catch (NumberFormatException nfe) {
                // Process token at text
                System.out.println("Rule 1: Operator (" + token + ") := " + token);
                mixedStack.push(token);
            }
            System.out.println("Stack :" + mixedStack);
        }
    }
    public static void main(String[] args) {
        Interpreter interpreter = new Interpreter();
        String postFixExpression = "4.3 25 + 1.7 2 * - 3.2 /";
        interpreter.processPostFixExpression(postFixExpression);

    }
}