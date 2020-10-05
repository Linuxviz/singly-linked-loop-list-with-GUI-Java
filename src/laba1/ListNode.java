package laba1;

class ListNode<T extends Comparable<T>> implements Comparable<ListNode<T>> {
    // Элемент списка и ссылка на следующий
    public T element;
    public ListNode next;

    // Конструктор элемента без ссылки
    public ListNode(T theElement) {
        this(theElement, null);
    }

    // Конструктор элемента с ссылкой на следующий
    public ListNode(T element, ListNode next) {
        this.element = element;
        this.next = next;
    }

    // Метод для сравнения двух элементов списка
    @Override
    public int compareTo(ListNode<T> comparableNode) {
       return this.element.compareTo(comparableNode.element);
    }
}