package task;

public class DoubleLinkedList<T extends Comparable<T>> {
    private DoubleLinkedListItem first;
    private DoubleLinkedListItem last;
    private int size;

    public DoubleLinkedList() {
        size = 0;
    }
    public DoubleLinkedListItem findFirstItem(T data) {
        DoubleLinkedListItem item = first;
        while (item.getData() != data) {
            item = item.getNext();
        }
        return item;
    }
    public DoubleLinkedListItem findLastItem(T data) {
        DoubleLinkedListItem item = last;
        while (item.getData() != data) {
            item = item.getPrev();
        }
        return item;
    }
    public void insertAfter (DoubleLinkedListItem item, T data){
        DoubleLinkedListItem nextItem = new DoubleLinkedListItem(data);
        if ((item == null) && (size == 0)) {
            first = nextItem;
            last = nextItem;
        } else if ((item == null) && (size != 0)) {
            insertBefore (first,data);
            size--;
        } else if (item.getNext() == null) {
            item.setNext(nextItem);
            nextItem.setPrev(item);
            last = nextItem;
        } else {
            nextItem.setNext(item.getNext());
            nextItem.setPrev(item);
            item.getNext().setPrev(nextItem);
            item.setNext(nextItem);
        }
        size++;
    }
    public void insertBefore(DoubleLinkedListItem item, T data) {
        DoubleLinkedListItem nextItem = new DoubleLinkedListItem(data);
        if ((item == null) && (size == 0)) {
            first = nextItem;
            last = nextItem;
        } else if ((item == null) && (size != 0)) {
            insertAfter(last, data);
            size--;
        } else if (item.getPrev() == null) {
            item.setPrev(nextItem);
            nextItem.setNext(item);
            first = nextItem;
        } else {
            nextItem.setNext(item);
            nextItem.setPrev(item.getPrev());
            item.getPrev().setNext(nextItem);
            item.setPrev(nextItem);
        }
        size++;
    }
    public void remove (DoubleLinkedListItem item) {
        if ((item.getNext() == null) && (item.getPrev() == null)) {
            first = null;
            last = null;
        } else if (item.getNext() == null) {
            item.getPrev().setNext(null);
            last = item.getPrev();
        } else if (item.getPrev() == null) {
            item.getNext().setPrev(null);
            first = item.getNext();
        } else {
            item.getNext().setPrev(item.getPrev());
            item.getPrev().setNext(item.getNext());
            item.setNext(null);
            item.setPrev(null);
        }
        size--;
    }
    public int getSize() {
        return size;
    }
    public DoubleLinkedListItem getFirst() {
        return first;
    }
    public DoubleLinkedListItem getLast() {
        return last;
    }
}
