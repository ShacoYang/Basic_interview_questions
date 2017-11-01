package com.ProtocolsEx;

import com.cogsPulleysEx.DoublyLinkedList;

/*
Double ended queue is both a stack and queue
array-based impl for a queue was more complex than that for a stack due to rollover of the indexes

 */
public class DoubleEndedQueueImplArray<E> extends QueueImplArray<E> implements DoubleEndedQueue<E>{

    public DoubleEndedQueueImplArray(int size) {
        super(size);
    }

    @Override
    public void inject(E value) {
        enqueue(value);
    }

    @Override
    public E eject() {
        if (length <= 0) {
            return null;
        }
        //add array.length to void negative(end == 0)
        //it does not change the remainder when / by array.length;
        end = (end + array.length -1) % array.length;
        E value = array[end];
        length--;
        return value;
    }

    @Override
    public E peekLast() {
        if (length <= 0) {
            return null;
        }
        return array[(end + array.length - 1)% array.length];
    }

    @Override
    public void push(E value) {
        if (length >= array.length) {
            throw new NoSpaceException("No more space to add");
        }
        start = (start + array.length - 1) % array.length;
        array[start] = value;
        length++;
    }

    @Override
    public E pop() {
        return dequeue();
    }
}
