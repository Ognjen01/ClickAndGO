package collections.list;

public class ListNode<T> {

    private T element;
    private ListNode<T> next;
    private ListNode<T> previous;

    public ListNode(){}

    public ListNode(T element){
        this.element = element;
    }

    public ListNode(T element, ListNode<T> next){
        this.element = element;
        this.next = next;
    }

    public ListNode(T element, ListNode<T> next, ListNode<T> previous){
        this.previous = previous;
        this.element = element;
        this.next = next;
    }

    // Da li dodati konstruktor sa prethodnim elementom



    public T getElement() {
        return element;
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
