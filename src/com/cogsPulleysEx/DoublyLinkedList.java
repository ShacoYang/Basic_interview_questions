package com.cogsPulleysEx;

import java.util.Iterator;
import java.util.NoSuchElementException;

// No quick way to remove the element from the end of linked list
// need to start from the beginning
// need of a reference for updating it

/*
Singly List walk through the entire list O(n)
Doubly List updated in one step O(1)
 */
public class DoublyLinkedList<E> extends LinkedList<E> {
    protected static class DoublyLinkedNode<E> extends Node<E> {
        protected DoublyLinkedNode<E> prev;
    }

    @Override
    protected Node<E> getNewNode() {
        return new DoublyLinkedNode<>();
    }
    @Override
    public Node<E> appendFirst(E value) {
        Node<E> node = super.appendFirst(value);
        if (first.next != null) {
            ((DoublyLinkedNode<E>)first.next).prev = (DoublyLinkedNode<E>)first;
        }
        return node;
    }

    public Node<E> appendLast(E value) {
        DoublyLinkedNode<E> origLast = (DoublyLinkedNode<E>) this.last;
        Node<E> node = super.appendLast(value);
        if (origLast == null) {
            origLast = (DoublyLinkedNode<E>) first;
        }
        ((DoublyLinkedNode)this.last).prev = origLast;
        return  node;
    }

    public Node<E> insert(int index, E value) {
        DoublyLinkedNode<E> inserted = (DoublyLinkedNode<E>) super.insert(index,value);
        if (index != 0 && index != length) {
            if (inserted.next != null) {
                inserted.prev = ((DoublyLinkedNode<E>) inserted.next).prev;
                ((DoublyLinkedNode)inserted.next).prev = inserted;
            }
        }
        return inserted;
    }
    @Override
    public Node<E> removeFirst() {
        super.removeFirst();
        if (first != null) {
            ((DoublyLinkedNode)first).prev = null;
        }
        return first;
    }

    @Override
    public Node<E> removeAtIndex(int index) {
        if (index < 0 || index >= length) {
            throw new NoSuchElementException("index = " + index);
        }
        if (index == length -1) {
            return removeLast();
        }
        DoublyLinkedNode<E> nodeRemoved = (DoublyLinkedNode<E>) super.removeAtIndex(index);
        if ((DoublyLinkedNode<E>)nodeRemoved.next != null) {
            ((DoublyLinkedNode)nodeRemoved.next).prev = nodeRemoved.prev;
        }
        return nodeRemoved;
    }

    public Node<E> removeLast(){
        Node<E> origLast = last;
        if (last == null) {
            throw new IllegalStateException("Removing element from an empty list");
        }
        last = ((DoublyLinkedNode<E>) last).prev;
        if (last != null) {
            last.next = null;
            //new list is null
        } else {
            first = null;
        }
        length--;
        return origLast;
    }

    protected class ReversedListIterator extends ListIterator{
        public ReversedListIterator(){
            nextNode = last;
        }
        @Override
        public E next() {
            if (nextNode == null) {
                throw new IllegalStateException();
            }
            DoublyLinkedNode<E> nodeToReturn = (DoublyLinkedNode<E>) nextNode;
            nextNode = nodeToReturn.prev;
            return nodeToReturn.value;
        }
    }
    public Iterator<E> reverseIterator() {
        return new ReversedListIterator();
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.appendFirst(4);
        doublyLinkedList.appendFirst(1);
        doublyLinkedList.appendFirst(2);
        doublyLinkedList.appendFirst(3);
        doublyLinkedList.appendFirst(8);
        doublyLinkedList.appendFirst(7);
        doublyLinkedList.appendFirst(18);
        doublyLinkedList.appendFirst(3);
        doublyLinkedList.appendFirst(8);
        doublyLinkedList.appendFirst(7);
        doublyLinkedList.appendFirst(18);
        doublyLinkedList.insert(2,51);
        doublyLinkedList.insert(0,100);

        Iterator<Integer> reverseInterator = doublyLinkedList.reverseIterator();
        while (reverseInterator.hasNext()) {
            System.out.println(reverseInterator.next());
        }

    }
}
