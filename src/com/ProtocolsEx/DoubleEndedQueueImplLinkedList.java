package com.ProtocolsEx;

import com.cogsPulleysEx.*;
import com.cogsPulleysEx.LinkedList;

public class DoubleEndedQueueImplLinkedList<E> extends StackImplLinkedList<E> implements DoubleEndedQueue<E> {

    protected LinkedList<E> list = getNewLinkedList();
    @Override
    protected LinkedList<E> getNewLinkedList() {
        return new DoublyLinkedList<>();
    }

    @Override
    public void inject(E value) {
        list.appendLast(value);
    }

    @Override
    public E eject() {
        if (list.getLength() == 0) {
            return null;
        }
        E value = list.getLast().getValue();
        list.removeLast();
        return value;
    }

    @Override
    public E peekLast() {
        if (list.getLength() == 0) {
            return null;
        }
        return list.getLast().getValue();
    }
}
