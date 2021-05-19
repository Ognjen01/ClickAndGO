package collections.list;

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

    public void add(T element) {
        ListNode<T> node = new ListNode<T>(element);
        System.out.println(element + " " + node);
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

    // Briše prvi isti element na koji naiđe

    public void remove(T del){

        ListNode<T> toRemove = new ListNode<T>(del);
        if (head == null || del == null) {
                return;
            }

            ListNode<T> current = head;
            while(current.getNext() != null){

                if (current.getElement() == toRemove.getElement()){
                    current.getPrevious().setNext(current.getNext());
                    current.getNext().setPrevious(current.getPrevious());
                    current = null;
                    break;

                } else {
                    current = current.getNext();
                }
            }
    }

    public ListNode<T> getHead(){
        return head;
    }

    public ListNode<T> getLast(){
        return tail;
    }

    @Override
    public Iterator<T> iterator() {
        return new DoublyLinkedListIterator<T>(this);
    }
}
