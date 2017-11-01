package com.cogsPulleysEx;

import java.util.Iterator;

/*
  A circular linked list is an ordinary linked list,
  except that the last element holds the reference to the first element as its next element.
  This helps when there is a round robin fashion implemented.
 */
public class CircularLinkedList<E> extends LinkedList<E>{


    @Override
    public Node<E> appendFirst(E value) {
        Node<E> newNode = super.appendFirst(value);
        last.next = first;
        return newNode;
    }
    @Override
    public Node<E> appendLast(E value) {
        Node<E> newNode = super.appendLast(value);
        last.next = first;
        return newNode;
    }

    @Override
    public Node<E> removeFirst(){
        Node<E> newNode = super.removeFirst();
        last.next = first;
        return newNode;
    }
    public void rotate() {
        last = first;
        first = first.next;
    }

    public static void main(String[] args) {
        CircularLinkedList<Integer> circularLinkedList = new CircularLinkedList<>();

        circularLinkedList.appendFirst(4);
        circularLinkedList.appendFirst(1);
        circularLinkedList.appendFirst(2);
        circularLinkedList.appendFirst(3);
        circularLinkedList.appendLast(8);
        circularLinkedList.appendLast(7);
        circularLinkedList.appendLast(18);

        Iterator<Integer> iterator = circularLinkedList.iterator();

        for (int i = 0; i < 30; i++) {
            System.out.print(" "+iterator.next());
        }
        System.out.println();

        for (int i = 0; i < 30; i++) {
            System.out.print(" " + circularLinkedList.first);
            circularLinkedList.rotate();
        }
    }

}
