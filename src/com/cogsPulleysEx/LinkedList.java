package com.cogsPulleysEx;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
1. Store each element in different object
2. Hold a reference to the next element
3. Creating the element
4. Attaching the element at the end of the original linked list
 */
public class LinkedList<E> implements Iterable<E> {

    int length = 0;
    Node<E>[] lastModifiedNode;
    Node<E> first;
    Node<E> last;



    public static class Node<E> {
        protected E value;
        protected Node next;

        public E getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
    protected Node<E> getNewNode() { // Creation of new node
        Node<E> node = new Node<>();
        lastModifiedNode = new Node[]{node};

        return node;
    }
/*
No Loop
One time operations --> O(1)
constant time = O(n) since creation is O (n) n = size of this the array
 */
    public Node<E> appendLast(E value) { // Insertion at the end
        Node node = getNewNode();
        node.value = value;

        if (last != null) {
            last.next = node;
            last = node;
        }
        if (first == null) {
            first = node;
        }
        length++;
        return node;
    }

    public Node<E> appendFirst(E value) { // Insertion at the end
        Node node = getNewNode();
        node.value = value;
        node.next = first;
        first = node;

       if (length == 0) {
           last = node;
       }
        length++;
        return node;
    }

    public Node<E> insert(int index, E value) {
        Node<E> node = getNewNode();

        if (index < 0 || index > length) {
            throw new IllegalArgumentException("invalid index for insertion");
        }else if (index == length) {
            return appendLast(value);
        }else if (index == 0) {
            return appendFirst(value);
        }else {
            //append at desired position
            Node<E> result = first;
            while (index > 1) {
                index--;
                result = result.next;
            }
            node.value = value;
            node.next = result.next;
            result.next = node; //result will be behind out node which we add right now

            length++;
            return node;
        }
    }
    public E findAtIndex(int index) {
        Node<E> result = first;
        while (index >=0 ) {
            if (result == null) {
                throw new NoSuchElementException();
            }else if (index == 0) {
                return result.value;
            }else {
                index--;
                result = result.next;
            }
        }
        return null;
    }
    //remove the first
    public Node<E> removeFirst() {
        if (length == 0) {
            throw new NoSuchElementException();
        }
        //assign the reference to the next elem
        Node<E> origFirst = first;
        first = first.next;
        length--;
        //if no more element left
        if (length == 0) {
            last = null;
        }
        return origFirst;
    }




    //remove at index
    protected Node<E> removeAtIndex(int index) {
        if (index >= length || index < 0) {
            throw new NoSuchElementException();
        }
        if (index == 0) {
            Node<E> nodeRemoved = first;
            removeFirst();
            return nodeRemoved;
        }
        Node justBeforeIt = first;
        while (--index > 0) {
            justBeforeIt = justBeforeIt.next;
        }
        Node<E> nodeRemoved = justBeforeIt.next;
        if (justBeforeIt.next == last) {
            last = justBeforeIt.next.next;
        }
        justBeforeIt.next = justBeforeIt.next.next;
        length--;
        return nodeRemoved;
    }

    public int getLength() {
        return length;
    }

    public Node<E> getFirst() {
        return first;
    }

    public Node<E> getLast() {
        return last;
    }
    //iteration
    protected class ListIterator implements Iterator<E> {
        protected Node<E> nextNode = first;
        protected Node<E> currentNode = null;
        protected Node<E> prevNode = null;

        @Override
        public boolean hasNext(){
            return nextNode != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new  IllegalStateException();
            }
            prevNode = currentNode;
            currentNode = nextNode;
            nextNode = nextNode.next;
            return currentNode.value;
        }
    }
    @Override
    public Iterator<E> iterator() {
        return new ListIterator();
    }

    public static void main(String[] args) {
        LinkedList<Integer> anotherList = new LinkedList<>();

        anotherList.appendFirst(4);
        anotherList.appendFirst(1);
        anotherList.appendFirst(2);
        anotherList.appendFirst(3);
        anotherList.appendFirst(8);
        anotherList.appendFirst(7);
        anotherList.appendFirst(1);
        anotherList.appendFirst(2);
        anotherList.appendFirst(3);
        anotherList.appendFirst(18);
        anotherList.insert(2,99);

        for (Integer x: anotherList) {
            System.out.println(x);
        }
        System.out.println("First element" + anotherList.getFirst());
        System.out.println("Last element" + anotherList.getLast());

        System.out.println("After removing the first element and the element at index 4");
        anotherList.removeFirst();
        anotherList.removeAtIndex(4);

        for (Integer x: anotherList) {
            System.out.println(x);
        }
        System.out.println("Element at index 2: " + anotherList.findAtIndex(2));
    }
}
