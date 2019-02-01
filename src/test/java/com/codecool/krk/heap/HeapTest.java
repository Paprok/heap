package com.codecool.krk.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

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
}
