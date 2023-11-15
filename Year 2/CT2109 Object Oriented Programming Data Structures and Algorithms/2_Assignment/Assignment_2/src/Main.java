import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String infix = readInput();
        String postfix = infixToPostfix(infix);
        System.out.println("Infix Expression: " + infix + "\nPostfix Expression: " + postfix);
        System.out.println("The Value: "+ evaluatePostfix(postfix));

    }

    // read input
    // try to get rid of all invalid inputs here
    public static String readInput() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Infix Expression");
        String uInput = sc.nextLine();  // Read user input
        // check if input length is 3-20 chars
        while ((uInput.length() < 3) || (uInput.length() > 20)) {
            System.out.println("Invalid length of the input. Input must be between 3 - 20");
            uInput = sc.nextLine();
        }

        // Check if inputs are characters
        for (int i = 0; i < uInput.length(); i++) {
            char ch = uInput.charAt(i);
            if (Character.isAlphabetic(ch)) {
                System.out.println("Invalid Input. Input Must Be Integers Only");
                uInput = sc.nextLine();
            }
        }

        // when done, return input
        return uInput;
    }

    // decide on what operation has higher order
    public static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    // using input, pass it to the satck in a way described in the assignment
    public static String infixToPostfix(String expression) {
        ArrayStack stack = new ArrayStack();
        StringBuilder outputString = new StringBuilder();
        // for length of expression
        for (int i = 0; i < expression.length(); i++) {
            // @ char i
            char ch = expression.charAt(i);
            // if char is digit
            if (Character.isDigit(ch)) {
                // push to stack
                outputString.append(ch);
            } else if (ch == '(') {
                // '(' could just continue

                // must stop at ')'
            } else if (ch == ')') {

                // check if stack is not empty
                while (!stack.isEmpty()) {
                    outputString.append(stack.pop());
                }

                if (!stack.isEmpty()) {
                    return null;
                } else {
                    stack.pop();
                }


            } else {
                // while current ch precedence is lower than on the stack, then append the string
                while (!stack.isEmpty() && precedence(ch) <= precedence((Character) stack.top())) {
                    outputString.append(stack.pop());
                }
                // if current precedence is higher, just push on top of the stack
                stack.push(ch);
            }
        }
        // append everything else
        while (!stack.isEmpty()) {
            outputString.append(stack.pop().toString());
        }
        return outputString.toString();
    }

    public static double evaluatePostfix(String expression) {
        ArrayStack stack = new ArrayStack();
        // the expression will be without of '(,)'
        // also, notation will be:
        // in a mirror reflection, last in first out
        for (int i = 0; i < expression.length();i++){
            char ch = expression.charAt(i);
            if(Character.isDigit(ch)){
                // pass a value to stack
                stack.push((double)Character.getNumericValue(ch));
            }
            else {
                double op1 = (double)stack.pop();
                double op2 = (double)stack.pop();
                // The stack inverts operations.
                // So we need to perform operation on operand2
                double result = performOperation(op2, op1, ch);
                stack.push(result);
            }
        }

        return (double)stack.top();
    }

    // perform operations
    public static double performOperation(double operand1, double operand2, char operation){
        switch (operation) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
            case '^':
                return Math.pow(operand1, operand2);
        }
        return 0;
    }
}