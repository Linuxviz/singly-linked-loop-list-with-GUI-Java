package laba1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListIterator<T extends Comparable<T>> implements Iterator<T> {
    ListNode<T> current;    // Текущая позиция
    ListNode<T> head;   // Голова списка
    private int index;  // Индекс текущего элемента списка

    // Конструктор итератора theNode любой элемент списк. Также устанавливает
    // голову списка и индекс текущего элемента
    LinkedListIterator(ListNode current, ListNode head, int index) {
       this.current = current;
       this.head = head;
       this.index = index;
    }

    // Конструктор итератора theNode любой элемент списк. Голова списка и индекс
    // устанавлиавются автоматически
    LinkedListIterator(ListNode current) {
        this(current, current, 0);
    }

    // Проверка на ненулевой элемент
    public boolean hasNode() {
        return current != null;
    }

    // Проверка наличия следующего элемента
    public boolean hasNext() {
        return hasNode() && (this.current != head || index == 0);
    }

   // Возврат элемента по позиции
    public T getElement() {
        return hasNode() ? current.element : null;
    }

    // Переключение на следующий элемент списка. Используется для реализации forEach
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return advance();
    }

    // Перемещение итератора на следующий элемент
    public T advance() {
        if (hasNode()) {
            T value = current.element;
            current = current.next;
            index++;
            return value;
        }
        return null;
    }
}





