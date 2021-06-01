package collections.list;

import korisnici.Osoba;

import java.util.Iterator;
import java.util.List;

public class DoublyLinkedList<T> implements Iterable<T>{

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

    public void setElement(T element, T zaZamjenu){

        ListNode<T> current = head;
        while(current.getNext() != null){

            if (current.getElement() == zaZamjenu){
                current.setElement(element);
            } else {
                current = current.getNext();
            }
        }
    }

    // Nije radilo za sortiranje
    public void swapElements(T element1, T element2){

        if (head == null || element1 == null) {
            return;
        }

        ListNode<T> current = head;
        while(current.getNext() != null){

            if (current.getElement() == element1 && current.getElement() != element2){
                current.setElement(element2);
                System.out.println("Zamjnena 1 el1 " + element1 + " sa el2 " + element2 + " el2 ne smije biti " + current.getElement());

            }
            else {
                current = current.getNext();

            }
        }

        ListNode<T> current1 = head;
        while(current1.getNext() != null){

            if (current1.getElement() == element2 && current1.getElement() != element1){
                current1.setElement(element1);
                System.out.println("Zamjnena 2 el2 "  + element2 + " sa el1 " + element1 + " el1 ne smije biti " + current.getElement());

            } else {
                current1 = current1.getNext();
            }
        }

    }

    public T getElement(int index){
        if(index < 0 || index >= listSize){
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }
        int i = 0;
        ListNode<T> currentNode = head;

        while (currentNode != null){
            if(index == i){
                return currentNode.getElement();
            }

            currentNode = currentNode.getNext();
            i++;
        }

        return null;
    }

    public void set(int index, T element){
        if(index < 0 || index >= listSize){
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }
        int i = 0;
        ListNode<T> currentNode = head;

        while (currentNode != null){
            if(index == i){
                currentNode.setElement(element);
            }

            currentNode = currentNode.getNext();
            i++;
        }

    }

    public int indexOf(T element){
        int index = 0;
        ListNode<T> current = head;
        while(current != null){
            if (current.getElement().equals(element)){
                return index;
            }
            current = current.getNext();
            index ++;
        }
        return -1;

    }

    public ListNode<T> getElement(T element){
        ListNode<T> toRemove = new ListNode<T>(element);
        if (head == null || element == null) {
            return null;
        }

        ListNode<T> current = head;
        while(current.getNext() != null){

            if (current.getElement() == toRemove.getElement()){
                return current;
            } else {
                current = current.getNext();
            }
        }
        return current;
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
