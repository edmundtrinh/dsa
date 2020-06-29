import java.util.Arrays;

public class MyArrayList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 8;
    private Object elements[];

    public MyArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    public void add(final E e) {
        // if size == # elements, double array size
        if (this.size == this.elements.length) {
            expand();
        }
        // set the last element (increase size by 1) to parameter e
        elements[this.size++] = e;
    }

    // Removes element if it exists in MyArrayList. Shuffles the remaining elements
    // to maintain the list order
    public void remove(final E e) {

    }

    public E get(final int i) {
        if (i >= this.size || i < 0) {
            throw new IndexOutOfBoundsException("Index not valid.");
        }

        return this.elements[i];
    }

    private void expand() {
        // double array size
        final int newSize = elements.length * 2;
        // copy elements from old array into new
        elements = Arrays.copyOf(elements, newSize);
    }
}