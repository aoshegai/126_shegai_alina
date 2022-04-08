import org.junit.*;

public class Task1_Tests extends Assert {

    // class Node

    @Test
    public void test_Node_Ctor_getNext() {
        var prev = new Node<>(0);
        var next = new Node<>(0);
        var node = new Node<>(1, next, prev);
        assertEquals(next, node.getNext());
    }

    @Test
    public void test_Node_Ctor_getPrev() {
        var prev = new Node<>(0);
        var next = new Node<>(0);
        var node = new Node<>(1, next, prev);
        assertEquals(prev, node.getPrev());
    }

    // class DoubleLinkedList

    @Test
    public void test_DoubleLinkedList_isEmpty() {
        var list = new DoubleLinkedList<>();
        assertTrue(list.isEmpty());
        list.insertAfter(list.getHead(), 0);
        assertFalse(list.isEmpty());
    }

    @Test
    public void test_DoubleLinkedList_getHead() {
        var list = new DoubleLinkedList<>();
        list.insertBefore(list.getHead(), 0);
        var node = list.insertBefore(list.getHead(), 0);
        assertEquals(node, list.getHead());
    }

    @Test
    public void test_DoubleLinkedList_getTail() {
        var list = new DoubleLinkedList<>();
        list.insertBefore(list.getTail(), 0);
        var node = list.insertAfter(list.getTail(), 0);
        assertEquals(node, list.getTail());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_DoubleLinkedList_get_outOfBounds() {
        var list = new DoubleLinkedList<>();
        list.get(0);
    }

    @Test
    public void test_DoubleLinkedList_get() {
        var list = new DoubleLinkedList<>();
        list.insertAfter(list.getHead(), 0);
        var node = list.insertAfter(list.getHead(), 0);
        assertEquals(node, list.get(1));
    }

    @Test
    public void test_DoubleLinkedList_insertAfter_size() {
        var list = new DoubleLinkedList<>();
        list.insertAfter(list.getHead(), 2);
        assertEquals(1, list.getSize());
    }

    @Test
    public void test_DoubleLinkedList_pushFront() {
        var list = new DoubleLinkedList<>();
        list.pushFront(0);
        list.pushFront(0);
        var node = list.pushFront(0);
        assertEquals(node, list.get(0));
    }

    @Test
    public void test_DoubleLinkedList_pushBack() {
        var list = new DoubleLinkedList<>();
        list.pushBack(0);
        list.pushBack(0);
        var node = list.pushBack(0);
        assertEquals(node, list.get(2));
    }

    @Test
    public void test_DoubleLinkedList_remove_getNext() {
        var list = new DoubleLinkedList<>();
        list.pushBack(0);
        var node = list.pushBack(0);
        list.pushBack(0);
        list.remove(node);
        assertEquals(list.getTail(), list.getHead().getNext());
    }

    @Test
    public void test_DoubleLinkedList_remove_getPrev() {
        var list = new DoubleLinkedList<>();
        list.pushBack(0);
        var node = list.pushBack(0);
        list.pushBack(0);
        list.remove(node);
        assertEquals(list.getHead(), list.getTail().getPrev());
    }

    @Test
    public void test_DoubleLinkedList_insertListAfter_self() {
        var list = new DoubleLinkedList<>();
        list.pushBack(0);
        list.insertListAfter(list.getHead(), list);
        assertFalse(list.isEmpty());
    }

    @Test
    public void test_DoubleLinkedList_insertListAfter_listPrev() {
        var list1 = new DoubleLinkedList<>();
        list1.pushBack(0);
        list1.pushBack(0);

        var list2 = new DoubleLinkedList<>();
        var node = list2.pushBack(0);
        list2.pushBack(0);

        list1.insertListAfter(list1.getHead(), list2);
        assertEquals(list1.getHead(), node.getPrev());
    }

    @Test
    public void test_DoubleLinkedList_insertListAfter_listNext() {
        var list1 = new DoubleLinkedList<>();
        list1.pushBack(0);
        list1.pushBack(0);

        var list2 = new DoubleLinkedList<>();
        list2.pushBack(0);
        var node = list2.pushBack(0);

        list1.insertListAfter(list1.getHead(), list2);
        assertEquals(list1.getTail(), node.getNext());
    }

    @Test
    public void test_DoubleLinkedList_insertListBefore_self() {
        var list = new DoubleLinkedList<>();
        list.pushBack(0);
        list.insertListBefore(list.getHead(), list);
        assertFalse(list.isEmpty());
    }

    @Test
    public void test_DoubleLinkedList_insertListBefore_listPrev() {
        var list1 = new DoubleLinkedList<>();
        list1.pushBack(0);
        list1.pushBack(0);

        var list2 = new DoubleLinkedList<>();
        var node = list2.pushBack(0);
        list2.pushBack(0);

        list1.insertListBefore(list1.getTail(), list2);
        assertEquals(list1.getHead(), node.getPrev());
    }

    @Test
    public void test_DoubleLinkedList_insertListBefore_listNext() {
        var list1 = new DoubleLinkedList<>();
        list1.pushBack(0);
        list1.pushBack(0);

        var list2 = new DoubleLinkedList<>();
        list2.pushBack(0);
        var node = list2.pushBack(0);

        list1.insertListBefore(list1.getTail(), list2);
        assertEquals(list1.getTail(), node.getNext());
    }

    // class DynamicArray

    @Test
    public void test_DynamicArray_DefaultCtor() {
        var arr = new DynamicArray<>();
        assertEquals(0, arr.getSize());
    }

    @Test
    public void test_DynamicArray_SizeCtor() {
        var arr = new DynamicArray<>(1);
        arr.set(0, 0);
        assertEquals(0, arr.get(0));
    }

    @Test
    public void test_DynamicArray_resize_throw() {
        var arr = new DynamicArray<>();
        var thrown = assertThrows(NegativeArraySizeException.class, () -> arr.resize(-1));
        assertEquals("Size can not be negative", thrown.getMessage());
    }

    @Test
    public void test_DynamicArray_resize_size() {
        var arr = new DynamicArray<>();
        arr.resize(1);
        assertEquals(1, arr.getSize());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_DynamicArray_get_throw() {
        var arr = new DynamicArray<>();
        arr.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_DynamicArray_set_throw() {
        var arr = new DynamicArray<>();
        arr.set(0, 0);
        assertEquals(0, arr.get(0));
    }

    @Test
    public void test_DynamicArray_insert_get() {
        var arr = new DynamicArray<>();
        arr.insert(0, 0);
        assertEquals(0, arr.get(0));
    }

    @Test
    public void test_DynamicArray_insert_grow() {
        var arr = new DynamicArray<>(1);
        arr.insert(0, 0);
        assertEquals(0, arr.get(0));
    }

    @Test
    public void test_DynamicArray_insert_growZero() {
        var arr = new DynamicArray<>(0);
        arr.insert(0, 0);
        assertEquals(0, arr.get(0));
    }

    @Test
    public void test_DynamicArray_insert_growZeroCap() {
        var arr = new DynamicArray<>(0);
        arr.insert(0, 0);
        arr.insert(0, 0);
        assertEquals(0, arr.get(0));
    }

    @Test
    public void test_DynamicArray_pushBack() {
        var arr = new DynamicArray<>();
        arr.pushBack(0);
        assertEquals(0, arr.get(0));
    }

    @Test
    public void test_DynamicArray_pushBack_growZero() {
        var arr = new DynamicArray<>(0);
        arr.pushBack(0);
        assertEquals(0, arr.get(0));
    }

    @Test
    public void test_DynamicArray_pushBack_growZeroCap() {
        var arr = new DynamicArray<>(0);
        arr.pushBack(0);
        arr.pushBack(0);
        assertEquals(0, arr.get(0));
    }

    @Test
    public void test_DynamicArray_pushBack_grow() {
        var arr = new DynamicArray<>(1);
        arr.pushBack(1);
        assertEquals(1, arr.get(1));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_DynamicArray_popBack_throw() {
        var arr = new DynamicArray<>();
        arr.popBack();

    }

    @Test
    public void test_DynamicArray_remove_throw() {
        var arr = new DynamicArray<>();
        var thrown = assertThrows(IndexOutOfBoundsException.class, () -> arr.remove(0));
        assertEquals("Index out of bounds", thrown.getMessage());
    }
}
