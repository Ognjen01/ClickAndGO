package list;

import java.util.Iterator;
import java.util.List;

public class DoublyLinkedList<T> implements Iterable<T> {

    private ListNode<T> head;
    private ListNode<T> tail;
    private int listSize;

    public int size(){
        return listSize;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void addFirst(T element){

        ListNode<T> node = new ListNode<T>(element);
        if (head == null){
            head = node;
        } else {
            head.setPrevious(node);
            node.setNext(head);
            head = node;
        }

        listSize++;
    }

    public void addLast(T element) {
        ListNode<T> node = new ListNode<T>(element);

        if(head == null){
            head = node;
        } else {
            ListNode<T> current = head;
            while (current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(node);
            node.setPrevious(current);
        }

        listSize++;
    }


    public void removeFirst(){
        head = head.getNext();
        head.setPrevious(null);

    }

    public  void removeLast(){

        if(this.head != null) {
            if(this.head.getNext() == null) {
                this.head = null;
            } else {
                ListNode<T> temp = new ListNode<T>();
                temp = this.head;

                while(temp.getNext().getNext() != null) {
                    temp = temp.getNext();
                }

                ListNode<T> lastNode = temp.getNext();
                temp.setNext(null);
                lastNode = null;
            }
        }
    }

    public void remove(ListNode<T> del){

            if (head == null || del == null) {
                return;
            }

            if (head == del) {
                head = head.getNext();
            }

            if (del.getNext() != null) {
                del.getNext().setPrevious(del.getPrevious());
            }

            if (del.getPrevious() != null) {
                del.getPrevious().setNext(del.getNext());
            }


    }

    public ListNode<T> getHead(){
        return head;
    }

    public ListNode<T> getLast(){
        return tail;
    }

    public void clear(){

    }

    @Override
    public Iterator<T> iterator() {
        return new DoublyLinkedListIterator<T>(this);
    }
}
