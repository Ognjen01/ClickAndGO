package collections.list;

public class ListNode<T> {

    private T element;
    private ListNode<T> next;
    private ListNode<T> previous;

    public ListNode(){}

    public ListNode(T element){
        this.element = element;
    }


    public T getElement() {
        return element;
    }

    // Možda nije potrebno

    public void setListNode(ListNode<T> node){
        this.element = node.getElement();
        this.next = node.getNext();
        this.previous = node.getPrevious();
    }

    public void setElement(T element) {
        this.element = element;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }

    public ListNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(ListNode<T> previous) {
        this.previous = previous;
    }
}
