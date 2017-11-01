package com.ProtocolsEx;

public class StackImplArray<E> implements Stack<E> {
    protected E[] array;
    int top = -1;

    //init size of the stack
    public StackImplArray(int size){
        array = (E[])new Object[size];
    }

    @Override
    public void push(E value) {
        if (top == array.length - 1) {
            throw new NoSpaceException("No more space in the stack");
        }
        top++;
        array[top] = value;
    }

    @Override
    public E pop() {
        if (top == -1) {
            return null;
        }
        top--;
        return array[top + 1];

    }

    @Override
    public E peek() {
        if (top == -1) {
            return null;
        }
        return array[top];
    }

    public static void main(String[] args) {
        StackImplArray stack = new StackImplArray(4);

        stack.push(4);
        stack.push(6);
        stack.push(1);
        stack.push(9);


        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(stack.peek());

        stack.push(99);

        System.out.println(stack.peek());
    }
}
