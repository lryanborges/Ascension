package estruturadedados;

public interface MyStackInterface<T> {
    void push(T value);
    T pop();
    T peek();
    T search(int index);
    boolean isEmpty();
    boolean isFull();
    Object[] show();
    int size();
}
