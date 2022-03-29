import org.junit.*;

public class Task3_Tests extends Assert {

    class TestComparator implements MyComparator<Integer> {
        @Override
        public int compare (Integer first, Integer second) {
            return first - second;
        }
    }

    // HeapSort

    @Test
    public void  test_HeapSort_swapSecondIndex(){
        Integer[] data = {2, 1};
        HeapSort<Integer> hs = new HeapSort();
        hs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {1, 2}, data);
    }

    @Test
    public void  test_HeapSort_statementTwoExpectZero(){
        Integer[] data = {1, 2};
        HeapSort<Integer> hs = new HeapSort();
        hs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {1, 2}, data);
    }

    @Test
    public void test_HeapSort_heapifySiftDownLeftAndRightPlusOne(){
        Integer[] data = {2, 1, 3};
        HeapSort<Integer> hs = new HeapSort();
        hs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {1, 2, 3}, data);
    }

    @Test
    public void  test_HeapSort_SiftDownSize(){
        Integer[] data = {3, 1, 1, 1, 1, 2};
        HeapSort<Integer> hs = new HeapSort();
        hs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {1, 1, 1, 1, 2, 3}, data);
    }

    @Test
    public void  test_HeapSort_SiftDownLeftAndRightPlusOne(){
        Integer[] data = {4,1,1,3,3,4,4,2};
        HeapSort<Integer> hs = new HeapSort();
        hs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {1,1,2,3,3,4,4,4}, data);
    }

    // MergeSort

    @Test
    public void  test_MergeSort_BlockSizeOneAndComparator(){
        Integer[] data = {2, 1};
        MergeSort<Integer> ms = new MergeSort();
        ms.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {1, 2}, data);
    }

    @Test
    public void  test_MergeSort_bufferSortingOne(){
        Integer[] data = {2, 1, 3};
        MergeSort<Integer> ms = new MergeSort();
        ms.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {1, 2, 3}, data);
    }

    @Test
    public void  test_MergeSort_firstFocusPlus(){
        Integer[] data = {3, 1, 1, 1, 1, 2};
        MergeSort<Integer> ms = new MergeSort();
        ms.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {1, 1, 1, 1, 2, 3}, data);
    }

    @Test
    public void  test_MergeSort_bufferSortingTwo(){
        Integer[] data = {4, 1, 1, 3, 3, 4, 4, 2};
        MergeSort<Integer> ms = new MergeSort();
        ms.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {1, 1, 2, 3, 3, 4, 4, 4}, data);
    }

    @Test
    public void  test_MergeSort_resPosPlus(){
        Integer[] data = {1, 1, 2, 3};
        MergeSort<Integer> ms = new MergeSort();
        ms.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {1, 1, 2, 3}, data);
    }

    // QuickSort

    @Test
    public void  test_QuickSort_baseAndSplitSwap(){
        Integer[] data = {2, 1};
        QuickSort<Integer> qs = new QuickSort();
        qs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {1, 2}, data);
    }

    @Test
    public void  test_QuickSort_checkErrorsWithoutChange(){
        Integer[] data = {9,8,9,4,5,1,2,1,5,3};
        QuickSort<Integer> qs = new QuickSort();
        qs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {1,1,2,3,4,5,5,8,9,9}, data);
    }
}