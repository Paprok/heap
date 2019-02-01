package com.codecool.krk.heap;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Heap {
    private int[] heap;
    private int end;

    public Heap(int size) {
        this.heap = new int[size];
        this.end = 0;
    }

    public void addList(int[] array) {
        for (int i = 0; i < array.length; i++) {
            enqueue(array[i]);
        }
    }

    public void enqueue(int value) {
        if (end >= heap.length) {
            doubleHeap();
        }
        heap[end] = value;
        traverseUp(end);
        ++end;
    }

    private void doubleHeap() {
        throw new NotImplementedException();
    }

    private void traverseUp(int index) {
        while (isWrongPositionUp(index)) {
            int parent = parent(index);
            switchNodes(index, parent);
            index = parent;
        }
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private boolean isWrongPositionUp(int index) {
        int parentIdx = parent(index);
        return index > 0 && heap[index] > heap[parentIdx];
    }

    private void switchNodes(int childId, int parentId) {
        int temp = heap[parentId];
        heap[parentId] = heap[childId];
        heap[childId] = temp;
    }

    public int dequeue() {
        int popped = pop();
        traverseDown();
        return popped;
    }

    private int pop() {
        int popped = heap[0];
        heap[0] = heap[--end];
        return popped;
    }

    private void traverseDown() {
        int index = 0;
        boolean isWrongPosition = true;
        while (isWrongPosition) {
            int leftChild = leftChild(index);
            int rightChild = rightChild(index);
            if(leftChild>rightChild){
                // TODO
            }
        }
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public int[] getHeap() {
        return heap;
    }
}
