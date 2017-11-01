package com.cogsPulleysEx;
/*
1. Contiguous memory
2. Required to compute the offset to access element
3. Limited and fixed Size
4. Insert new element:
    Create a new array with one more element
    copy the entire original data
 */
public class Array {
    public static void printAllElements(int[] anIntArray) {
        for (int i = 0; i < anIntArray.length; i++) {
            System.out.print(anIntArray[i] + " ");
        }
        System.out.println();
    }

    //move an existing element to a new position  startIndex -> targetIndex
    // O(n)
    public static void moveElmenttoNewPosition(int[] array, int startIndex, int targetIndex) {
        int value = array[startIndex];
        if (startIndex == targetIndex) {
            return;
        }else if (startIndex < targetIndex) {
            for (int i = startIndex + 1; i <= targetIndex; i++) {
                array[i - 1] = array[i];
            }
            array[targetIndex] = value;
        }else {
            for (int i = startIndex - 1; i >= targetIndex; i--) {
                array[i + 1] = array[i];
            }
            array[targetIndex] = value;
        }

    }
    //O(n)
    public static int[] insetExtraElementAtIndex(int[] array, int index, int value) {
        int[] newArray = new int[array.length + 1];
        for (int i = 0; i < index; i++) {
            newArray[i] = array[i];
        }
        newArray[index] = value;

        for (int i = index + 1; i < newArray.length; i++) {
            newArray[i] = array[i - 1];
        }
        return newArray;
    }

    public static int[] appendElement(int[] array, int value) {
        return insetExtraElementAtIndex(array, array.length, value);
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        printAllElements(array);

        moveElmenttoNewPosition(array, 1,5);
        printAllElements(array);

       array = insetExtraElementAtIndex(array, 4, 9);
       printAllElements(array);

       array = appendElement(array, 100);
       printAllElements(array);


    }
}
