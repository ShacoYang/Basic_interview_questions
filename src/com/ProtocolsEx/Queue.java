package com.ProtocolsEx;

public interface Queue<E> {
    void enqueue(E value);
    E dequeue();
    E peek();
}
