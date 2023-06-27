import java.util.EmptyStackException;

//Queue Implementation using Array
public class ArrayQueue {
    private String[] queue;
    private int front;
    private int rear;
    private int size;

    public ArrayQueue(int capacity) {
        queue = new String[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(String s) {
        if (size == queue.length) {
            // need to resize the backing array
            String[] newArray = new String[2 * queue.length];
            int j = 0;
            for (int i = front; i <= rear; i++) {
                newArray[j++] = queue[i];
            }
            queue = newArray;
            front = 0;
            rear = size - 1;
        }

        rear = (rear + 1) % queue.length;
        queue[rear] = s;
        size++;
    }

    public String dequeue() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        String s = queue[front];
        queue[front] = null;
        front = (front + 1) % queue.length;
        size--;
        return s;
    }

    public String peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return queue[front];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printQueue() {
        int index = front;
        for (int i = 0; i < size; i++) {
            System.out.println(queue[index]);
            index = (index + 1) % queue.length;
        }
    }
}