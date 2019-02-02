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
        while (isBiggerThanParent(index)) {
            int parent = parent(index);
            switchNodes(index, parent);
            index = parent;
        }
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private boolean isBiggerThanParent(int index) {
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
        if(end > 0) {
            int popped = heap[0];
            heap[0] = heap[--end];
            return popped;
        } else {
            throw new HeapUnderflow();
        }
    }

    private void traverseDown() {
        int index = 0;
        int biggerChildIdx = biggerChildIdx(index);
        while (isLessThanChild(index, biggerChildIdx)) {
            switchNodes(biggerChildIdx, index);
            index = biggerChildIdx;
            biggerChildIdx = biggerChildIdx(index);
        }
    }

    private boolean isLessThanChild(int index, int childIdx) {
    // TODO: Should i merge it with Up and make code look shitty and have more comparisons?
            return childIdx < end && heap[index] < heap[childIdx];
}

    private int biggerChildIdx(int index){
        int leftChildIdx = leftChild(index);
        int rightChildIdx = rightChild(index);
        if(isLessThanChild(rightChildIdx, leftChildIdx)) {
            return leftChildIdx;
        } else if (isLessThanChild(leftChildIdx, rightChildIdx)) {
            return rightChildIdx;
        } else {
            return end;
        }
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public int[] getHeap() {
        int[] actualHeap = new int[end];
        for(int i = 0; i<end; i++){
            actualHeap[i] = heap[i];
        }
        return actualHeap;
    }
}
