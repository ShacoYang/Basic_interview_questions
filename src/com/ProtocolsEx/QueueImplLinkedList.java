package com.ProtocolsEx;

import com.cogsPulleysEx.LinkedList;

public class QueueImplLinkedList<E> implements Queue<E> {

    protected LinkedList<E> list = getNewLinkedList();

    protected LinkedList<E> getNewLinkedList() {
        return new LinkedList<>();
    }

    @Override
    public void enqueue(E value) {
        list.appendLast(value);
    }

    @Override
    public E dequeue() {
        if (list.getLength() == 0) {
            return null;
        }
        E value = list.getFirst().getValue();
        list.removeFirst();

        return value;
    }

    @Override
    public E peek() {
        if (list.getLength() == 0) {
            return null;
        }
        return list.getFirst().getValue();
    }
}
