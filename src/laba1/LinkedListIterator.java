package laba1;

public class LinkedListIterator {
    ListNode current;    // Текущая позиция
    //Конструктор итератора theNode любой элемент списк.
    LinkedListIterator(ListNode theNode) {
       current = theNode;
    }
    //Проверка на ненулевой элемент
    public boolean isValid() {
        return current != null;
    }

   //Возврат элемента по позиции
    public Object retrieve() {
        return isValid() ? current.element : null;
    }

    //Перемещение итератора на следующий элемент
    public void advance() {
        if (isValid())
        current = current.next;
    }
}





