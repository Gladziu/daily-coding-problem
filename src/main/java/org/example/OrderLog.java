// Problem #16
package org.example;

public class OrderLog {
    /* You run an e-commerce website and want to record the last N order ids in a log.
    Implement a data structure to accomplish this, with the following API:
    record(order_id): adds the order_id to the log
    get_last(i): gets the ith last element from the log. i is
    guaranteed to be smaller than or equal to N.

    You should be as efficient with time and space as possible. */

    public static void main(String[] args) {
        Order item = new Order(10);

        item.record(111);
        item.record(222);
        System.out.println(item.getLast(1));
    }
}

class Order {
    private final int maxSize;
    private final int[] buffer;
    private int index;

    public Order(int n) {
        this.maxSize = n;
        this.buffer = new int[n];
        this.index = 0;
    }

    public void record(int orderId) {
        buffer[index] = orderId;
        index = (index + 1) % maxSize;
        }

    public int getLast(int i) {
        return buffer[(index - i) % maxSize];
    }
}