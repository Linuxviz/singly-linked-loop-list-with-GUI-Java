package laba1;

class ListNode {
    // Элемент списка и ссылка на следующий
    public Object element;
    public ListNode next;

    // Конструктор элемента без ссылки
    public ListNode(Object theElement) {
        this(theElement, null);
    }
    // Конструктор элемента с ссылкой на следующий
    public ListNode(Object theElement, ListNode n) {
        element = theElement;
        next = n;
    }
}