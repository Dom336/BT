public class MyIntStack {
    private int[] contents;
    private int tos;  // Top of the stack
    private static final int DEFAULT_CAPACITY = 10;
    private boolean expandable;

    // Constructors
    public MyIntStack(int capacity) {
        contents = new int[capacity];
        tos = -1;
        expandable = false;
    }

    public MyIntStack(int capacity, boolean expandable) {
        contents = new int[capacity];
        tos = -1;
        this.expandable = expandable;
    }

    // Modification 1: Throws exception when full
    public void pushWithException(int element) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full");
        }
        contents[++tos] = element;
    }

    // Modification 2: Returns boolean status
    public boolean pushWithStatus(int element) {
        if (isFull()) {
            return false;
        }
        contents[++tos] = element;
        return true;
    }

    // Modification 3: Automatically expands capacity
    public void pushWithExpansion(int element) {
        if (isFull()) {
            if (expandable) {
                int[] newContents = new int[contents.length * 2];
                System.arraycopy(contents, 0, newContents, 0, contents.length);
                contents = newContents;
            } else {
                throw new IllegalStateException("Stack is full and not expandable");
            }
        }
        contents[++tos] = element;
    }

    // Original methods
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return contents[tos--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return contents[tos];
    }

    public boolean isEmpty() {
        return tos < 0;
    }

    public boolean isFull() {
        return tos == contents.length - 1;
    }

    public int size() {
        return tos + 1;
    }

    public int capacity() {
        return contents.length;
    }
}