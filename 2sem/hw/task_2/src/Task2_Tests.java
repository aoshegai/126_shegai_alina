import org.junit.*;

public class Task2_Tests extends Assert {

    class TestComparator implements MyComparator<Integer> {
        @Override
        public int compare (Integer first, Integer second) {
            return first - second;
        }
    }

    // BubbleSort

    @Test
    public void  test_BubbleSort_iAndComparator(){
        Integer[] data = {1, 2, 3};
        BubbleSort<Integer> bs = new BubbleSort();
        bs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {1, 2, 3}, data);
    }

    @Test
    public void  test_BubbleSort_sps(){
        Integer[] data = {2, 1};
        BubbleSort<Integer> bs = new BubbleSort();
        bs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {1, 2}, data);
    }

    // InsertionSort

    @Test
    public void  test_InsertionSort_comparatorAndCur(){
        Integer[] data = {1, 2};
        InsertionSort<Integer> is = new InsertionSort();
        is.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {1, 2}, data);
    }

    // SelectionSort

    @Test
    public void  test_SelectionSort_dataLength(){
        Integer[] data = {1, 1, 2};
        SelectionSort<Integer> ss = new SelectionSort();
        ss.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {1, 1, 2}, data);
    }

    @Test
    public void  test_SelectionSort_sortedSize(){
        Integer[] data = {1,3,2};
        SelectionSort<Integer> ss = new SelectionSort();
        ss.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {1,2,3}, data);
    }

    @Test
    public void  test_SelectionSort_maxInd(){
        Integer[] data = {2,1,3};
        SelectionSort<Integer> ss = new SelectionSort();
        ss.sort(data, new TestComparator());
        assertArrayEquals(new Integer[] {1,2,3}, data);
    }
}