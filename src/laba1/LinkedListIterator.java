package laba1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListIterator<T extends Comparable<T>> implements Iterator<T> {
    ListNode<T> current;    // Текущая позиция
    ListNode<T> head;
    int i;

    // Конструктор итератора theNode любой элемент списк.
    LinkedListIterator(ListNode theNode) {
       current = theNode;
       head = theNode;
       i = 0;
    }

    // Проверка на ненулевой элемент
    public boolean isValid() {
        return current != null;
    }

   // Возврат элемента по позиции
    public T retrieve() {
        return isValid() ? current.element : null;
    }

    // Проверка наличия следующего элемента
    public boolean hasNext() {
        return current != null && (this.current != head || i == 0);
    }

    // Переключение на следующий элемент списка
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T value = current.element;
        current = current.next;
        i++;
        return value;
    }

    // Перемещение итератора на следующий элемент
    public void advance() {
        if (isValid()) {
            current = current.next;
        }
    }
}





