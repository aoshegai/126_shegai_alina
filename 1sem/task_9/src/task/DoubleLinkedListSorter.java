package task;

public class DoubleLinkedListSorter {
    public static <T extends Comparable<T>> void sort(DoubleLinkedList<T> list) {
        for (int i = 0; i < list.getSize(); i++) {
            DoubleLinkedListItem maxItem = list.getLast();
            DoubleLinkedListItem item = list.getLast();
            for (int j = 0; j < list.getSize() - i; j++) {
                if (item.getData().compareTo(maxItem.getData()) > 0) {
                    maxItem = item;
                }
                item = item.getPrev();
            }
            list.remove(maxItem);
            list.insertBefore(list.getFirst(), (T)maxItem.getData());
        }
    }
}
