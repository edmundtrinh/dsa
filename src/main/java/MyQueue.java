import java.util.Arrays;

public class MyQueue<E> {
    private static final int DEFAULT_SIZE = 10;
    private int size;
    private Object elements[];
    private int first;
    private int last;

    public MyQueue() {
        this.elements = new Object[DEFAULT_SIZE];
        this.size = 0;
        this.first = -1;
        this.last = -1;
    }

    public void enqueue(E e) {
        // make sure there is enough space in the queue array
        ensureSize();
        
        // if queue is empty, add first element
        if (isEmpty()) {
            first = 0;
            last = 0;
        // or, add to end of array
        } else {
            this.last++;
        }
        this.elements[last] = e;
        // increment size by 1
        this.size++;
    }

    public E dequeue() {
        // 0 elements -> throw error
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        // 1 element -> reset to empty array -> first & last = -1
        else if (this.first == this.last) {
            this.first = -1;
            this.last = -1;
        }
        // 2+ elements -> move index of first to the right
        else {
            //first++;
            first = (first + 1) % this.size;
        }
        // decrease size by 1
        this.size--;
    }

    public boolean isEmpty() {
        return (this.first == -1 && this.last == -1);
    }

    public E first() {
        return this.elements[first];
    }

    private void increaseSize() {
        if (this.size == this.elements.length) {
            int doubleSize = this.elements.length * 2;
            this.elements = Arrays.copyOf(elements, doubleSize);
        }
    }

    /*
    public static void main(String[] args) {
        System.out.println("Hi.");
    }
    */
}