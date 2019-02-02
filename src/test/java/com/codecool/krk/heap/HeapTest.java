package com.codecool.krk.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HeapTest {

    @Test
    void testAddListToHeap() {
        int[] list = {2, 7, 26, 25, 19, 17, 1, 90, 3, 36};
        Heap heap = new Heap(list.length);
        heap.addList(list);

        int[] actual = heap.getHeap();
        int[] expected = {90, 36, 17, 25, 26, 7, 1, 2, 3, 19};

        assertArrayEquals(expected, actual);
    }

    @Test
    void testDequeueOnEmptyHeapThrowsException() {
        Heap heap = new Heap(5);

        assertThrows(HeapUnderflow.class,

                () -> heap.dequeue()
        );
    }

    @Test
    void testDequeueReturnsValidInt() {
        int[] list = {2, 7, 26, 25, 19, 17, 1, 90, 3, 36};
        Heap heap = new Heap(list.length);
        heap.addList(list);

        int expected = 90;
        int actual = heap.dequeue();

        assertEquals(expected, actual);
    }

    @Test
    void testHeapReturnsValidListAfterDequeue() {
        int[] list = {2, 7, 26, 25, 19, 17, 1, 90, 3, 36};
        Heap heap = new Heap(list.length);
        heap.addList(list);
        heap.dequeue();

        int[] actual = heap.getHeap();
        int[] expected = {36, 26, 17, 25, 19, 7, 1, 2, 3};

        assertArrayEquals(expected, actual);
    }
}
