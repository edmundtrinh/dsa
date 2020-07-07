import java.util.Arrays;

public class MyStack<E> {
    private static final int DEFAULT_SIZE = 10;
    private int size;
    private Object elements[];
    
    public MyStack() {
        this.elements[] = new Object[DEFAULT_SIZE];
        this.size = 0;
    }

    public void push(E e) {
        // make sure there is enough space in the stack
        if (size == this.elements.length) {
            increaseSize();
        }
        // increase size of stack by one after adding one element
        this.size++;
        // set the last value of the stack (index size) to the input e
        this.elements[size] = e;
    }

    public E pop() {
        // empty stack -> return -1
        if (this.size == 0) {
            throw new EmptyStackException("The stack is empty.");
        }
        
        // temporarily save last element
        E lastElement = elements[size];
        // set last element to null
        elements[size] = null;
        this.size--;

        return lastElement;
    }

    public E peek() {
        return elements[size];
    }

    public boolean isEmpty() {
        return this.elements.length == 0;
    }

    private void increaseSize() {
        int doubleSize = this.elements.length * 2;
        this.elements = Arrays.copyOf(elements, doubleSize);
    }
    
    /*
    // Test Cases
    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }
    */
}