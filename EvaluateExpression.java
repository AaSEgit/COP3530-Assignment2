import java.util.Scanner;
import java.util.StringTokenizer;

/* This program scans an arithmetic expression and evaluates it using two stacks */

public class EvaluateExpression 
{
    static int evaluateExpression (String input) {
        String x;                 // hold extracted element
        int val1, val2, temp;             //stores result of processing stacks
        Stack operandStack = new Stack();     // stores operands (ints)
        Stack operatorStack = new Stack();    // stores operators (binary arithmetic operators)

        StringTokenizer tk = new StringTokenizer(input, " ");
        while (tk.hasMoreTokens()) {
            x = tk.nextToken();
            if (Character.isDigit(x.charAt(0)))
            {
                val1 = Integer.parseInt(x);
                operandStack.push(val1);
            }
            else if (x.equals("*") || x.equals("/") || x.equals("+") || x.equals("-")) {
                if (operatorStack.isEmpty()) {
                    operatorStack.push(x);
                }
                else {
                    val1 = precedence(x);
                    val2 = precedence(operatorStack.peek());

                    while(!operatorStack.isEmpty() && val1 <= val2) {
                        temp = processStacks(operandStack, operatorStack);
                        operandStack.push(temp);
                    }
                    operatorStack.push(x);
                }    
            }
            else if (x.equals("(")) {
                operatorStack.push(x);
            }
            else if (x.equals(")")) {    
                while (!operatorStack.peek().equals("(")) {
                    temp = processStacks(operandStack, operatorStack);
                    operandStack.push(temp);
                }
                operatorStack.pop();  
            }
        }
        while(!operatorStack.isEmpty()) {
            temp = processStacks(operandStack, operatorStack);
            operandStack.push(temp);
        }

        return Integer.parseInt(operandStack.pop());
    }

    static int precedence(String operator) {
        switch(operator) {
            case "*":
            case "/":
                return 2;
            case "+":
            case "-":
                return 1;
        }
        return -1;
    }

    static int processStacks(Stack operands, Stack operators) {
        int val2 = Integer.parseInt(operands.pop());
        int val1 = Integer.parseInt(operands.pop());
        String operator = operators.pop();
        
        switch(operator) {
            case "+":
                return val1 + val2;
            case "-":
                return val1 - val2;
            case "*":
                return val1 * val2;
            case "/":
                if (val1 == 0)
                {
                    System.out.println("Cannot divide by zero");
                    return 0;
                }
                return val1 / val2;
        }
        return 0;
    }

    public static void main(String[] args) {

        String input;           // stores user input
        
            Scanner scanner = new Scanner(System.in);

            System.out.println("\nThis program evaluates an infix expression using stacks.");
            System.out.print("Enter a basic arithmetic expression. Separate each symbol with a space [e.g. ( 1 + 2 ) * 4 - 3]: ");

            input = scanner.nextLine();
            //input = "2 * ( 5 * ( 3 + 6 ) ) / 5 - 2";
            System.out.println();
            System.out.println("\nYour expression: " + input);

            System.out.println("Result: " + evaluateExpression(input) + "\n");
            //evaluateExpression(input);
            
            scanner.close();
        
    }
}