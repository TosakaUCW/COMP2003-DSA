/* Requirement:
	(1) UML of Stack(03 Stacks.pptx, page 9):
		|-----------------------------------------------|
		|                    Stack                      |
		|-----------------------------------------------|
		|   - values: Double[]                          |
		|   - top: int                                  |
		|-----------------------------------------------|
		|   + Stack(int size)                           |
		|   + isEmpty(): boolean                        |
		|   + isFull(): boolean                         |
		|   + top(): Double                             |
		|   + push(double x): Double                    |
		|   + pop(): Double                             |
		|   + displayStack(): void                      |
		|-----------------------------------------------|
	
	(2) You are NOT allowed to modify the code originally given in Stack.java
	(3) You are NOT allowed to modify the filename of Stack.java
	(4) You are NOT allowed to use Chinese characters in codes or comments
	(5)	You should add some comments and indentations to make the codes user friendly
	(6) Following is sample output after running main() in Stack.java:
	
		true
		The stack has 2 items:
		top -->	|	  5.0000	|
				|	 -3.0000	|
				+---------------+
		The stack has 4 items:
		top -->	|	  2.0000	|
				|	  1.0000	|
				|	  5.0000	|
				|	 -3.0000	|
				+---------------+
		The top is: 2.0
		true
		The stack is empty:
		top -->	+---------------+
		
	*/
public class Stack {

    private int top;
    private Double[] values;

    public Stack(int size) {
        values = new Double[size];
        top = -1;
    }

    public boolean isEmpty() {
        // top range [0, values.length)
        return top == -1;
    }

    public boolean isFull() {
        // top range [0, values.length)
        return top == values.length - 1;
    }

    public double top() {
        // return the top value
        return values[top];
    }

    public Double push(double x) {
        if (isFull())
            return null; // if full, cannot push
        values[++top] = Double.valueOf(x);
        return top();
    }

    public Double pop() {
        if (isEmpty())
            return null; // if empty, cannot pop
        return values[top--];
    }

    public void displayStack() {
        System.out.print("top -->");
        // iterate this stack
        for (int i = top; i >= 0; i--)
            // Display the values in the stack
            System.out.printf("\t|  %8.4f\t|\n", values[i]);
        System.out.println("\t+---------------+");
    }

    // begin Programming Assignment 1

    public static int computePostfix(String postfix) {
        // assume the length of postfix will not exceed 50
        Stack stack = new Stack(50);

        // split by ','
        String[] tokens = postfix.split(",");

        for (String token : tokens) {

            // check is Digit or operator
            boolean isDigit = true;
            for (char c : token.toCharArray()) {
                if (!Character.isDigit(c)) {
                    isDigit = false;
                    break;
                }
            }

            if (isDigit) {
                stack.push(Double.parseDouble(token));
            } else {
                // get top 2 value in stack
                Double b = stack.pop();
                Double a = stack.pop();
                Double result = 0.00;

                switch (token) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        result = a / b;
                        break;
                    default:
                        throw new IllegalArgumentException("IllegalArgumentException: " + token);
                }

                // push the result
                stack.push(result);
            }
        }

        // the top is the ans
        return stack.pop().intValue();
    }

    // end Programming Assignment 1

    public static void main(String[] args) {
        // Stack myStack = new Stack(4);
        // System.out.println(myStack.isEmpty());
        // myStack.push(-3);
        // myStack.push(5);
        // System.out.println("The stack has 2 items:");
        // myStack.displayStack();
        // myStack.push(1);
        // myStack.push(2);
        // myStack.push(-1);
        // System.out.println("The stack has 4 items:");
        // myStack.displayStack();
        // System.out.println("The top is: " + myStack.top());
        // System.out.println(myStack.isFull());
        // myStack.pop();
        // myStack.pop();
        // myStack.pop();
        // myStack.pop();
        // System.out.println("The stack is empty:");
        // myStack.displayStack();

        String postfix1 = "11,1,3,*,/";
        String postfix2 = "2,10,+,9,6,-,/";

        System.out.println(computePostfix(postfix1));
        System.out.println(computePostfix(postfix2));
    }

}
