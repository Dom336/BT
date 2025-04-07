public class TestMyIntStack {
    public static void main(String[] args) {
        System.out.println("Testing basic stack operations:");
        MyIntStack stack = new MyIntStack(3);
        stack.pushWithStatus(1);
        stack.pushWithStatus(2);
        stack.pushWithStatus(3);
        
        System.out.println("Stack size: " + stack.size());
        System.out.println("Top element: " + stack.peek());
        
        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }

        System.out.println("\nTesting push with exception:");
        MyIntStack exceptionStack = new MyIntStack(2);
        try {
            exceptionStack.pushWithException(1);
            exceptionStack.pushWithException(2);
            exceptionStack.pushWithException(3); // Should throw exception
        } catch (IllegalStateException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        System.out.println("\nTesting push with status:");
        MyIntStack statusStack = new MyIntStack(2);
        System.out.println("Push 1: " + statusStack.pushWithStatus(1));
        System.out.println("Push 2: " + statusStack.pushWithStatus(2));
        System.out.println("Push 3: " + statusStack.pushWithStatus(3)); // Should return false

        System.out.println("\nTesting expandable stack:");
        MyIntStack expandableStack = new MyIntStack(2, true);
        expandableStack.pushWithExpansion(1);
        expandableStack.pushWithExpansion(2);
        System.out.println("Capacity before expansion: " + expandableStack.capacity());
        expandableStack.pushWithExpansion(3); // Should expand
        System.out.println("Capacity after expansion: " + expandableStack.capacity());
        System.out.println("Current size: " + expandableStack.size());
    }
}