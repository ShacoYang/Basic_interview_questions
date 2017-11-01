package com.ProtocolsEx;

import com.cogsPulleysEx.LinkedList;

public class StackImplLinkedList<E> implements Stack<E>{

    protected LinkedList<E> list = getNewLinkedList();

    protected LinkedList<E> getNewLinkedList(){
        return new LinkedList<>();
    }

    @Override
    public void push(E value) {
        list.appendFirst(value);
    }

    @Override
    public E pop() {
        if(list.getLength() == 0) {
            return null;
        }
        E value = list.getFirst().getValue();
        list.removeFirst();
        return value;
    }

    @Override
    public E peek() {
        if (list.getLength() ==0) {
            return null;
        }
        E value = list.getFirst().getValue();
        return value;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new StackImplLinkedList<>();

        stack.push(4);
        stack.push(3);
        stack.push(2);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.push(1000);
        System.out.println(stack.peek());
    }
}
