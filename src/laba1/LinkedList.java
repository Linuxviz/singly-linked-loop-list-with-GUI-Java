package laba1;

import java.util.Iterator;

public class LinkedList<T extends Comparable<T>> implements Iterable<T> {
    // Заголовок структуры
    private ListNode<T> head;
    private ListNode<T> tail;
    int num;

    // Конструктор списка, создаётся заголовок списка
    public LinkedList() {
      head = null;
      tail = null;
      num = 0;
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator<T>(head);
    }

    // Проверка элемента
    public boolean isEmpty() {
        return head == null;
    }

    //Очистка списка
    public void makeEmpty() {
        head = null;
        tail = null;
    }

    // Помещаем указатель на первый элемент
    public LinkedListIterator first() {
        return new LinkedListIterator(head);
    }

    // Вставка элемента в конец списка
    public ListNode push(T x) {
        ListNode newNode = new ListNode(x);
        if (head == null) {
            head = newNode;
            newNode.next = newNode;
            tail = newNode;
            return newNode;
        }
        newNode.next = head;
        tail.next = newNode;
        tail = newNode;
        return newNode;
    }

    // Вставка элемента в начало списка
    public ListNode unshift(T x) {
        if (head == null) {
            return push(x);
        }
        ListNode newNode = new ListNode(x);
        newNode.next = head;
        tail.next = newNode;
        head = newNode;
        return newNode;
    }

    // Вставка по индексу.
    public void insert(T x, LinkedListIterator p) {
        if ( p == null) {
            return;
        }
        if (!p.isValid() && head == null) {
            ListNode newNode = push(x);
            p.current = newNode;
            return;
        }
        if (!p.isValid() && head != null) {
            ListNode newNode = unshift(x);
            p.current = newNode;
            return;
        }
        p.current.next = new ListNode(x, p.current.next);
    }

    // Находим элемент по ключу и возвращаем ссылку на элемент
    public LinkedListIterator find(T x) {
        if (head == null) {
            return new LinkedListIterator(null);
        }
        ListNode itr = head;
        num = 0;
        boolean isExisted = false;
        do {
            if (!itr.element.equals(x)) {
                itr = itr.next;
                num++;
            } else {
                isExisted = true;
            }
        } while (itr != head && !isExisted);
        return new LinkedListIterator(isExisted ? itr : null);
    }

    // Как find только на 1 элемент левее(выше)
    public LinkedListIterator findPrevious(T x) {
        boolean isExisted = false;
        if (head == null || head.element.equals(x)) {
            return new LinkedListIterator(null);
        }
        ListNode itr = head;
        do {
            if (!itr.next.element.equals(x)) {
                itr = itr.next;
            } else {
                isExisted = true;
            }
        } while (itr != head && !isExisted);
        return new LinkedListIterator(isExisted ? itr : null);
    }

    // Удаляет элемент содержащий переданный текст
    public void remove(T x) {
        if (head == null) {
            return;
        }
        LinkedListIterator p = findPrevious(x);
        if (!p.isValid()) {
            if (head.next == head) {
                makeEmpty();
                return;
            }
            head = head.next;
            tail.next = head;
            return;
        }
        if (p.current.next.next == head) {
            tail = p.current;
        }
        p.current.next = p.current.next.next;
    }

    // Вывод в консоль
    public static <T> String printList(LinkedList theList) {
        String result = "Структура:\n\n";
        if (theList.isEmpty()) {
            return "Пустая структура";
        }
        int i = 0;
        LinkedListIterator itr = theList.first();
        ListNode firstNode = itr.current;
        do {
            result += ("    " + itr.retrieve() + "\t[" + i + "] \n");
            i++;
            itr.advance();
        } while (!itr.current.equals(firstNode));
        return result;
    }


    // Определяет размер структуры
    public static int listSize(LinkedList theList) {
        int size = 0;
        if (theList.isEmpty()) {
            return size;
        }
        LinkedListIterator itr = theList.first();
        ListNode firstNode = itr.current;
        do {
            size++;
            itr.advance();
        } while (!itr.current.equals(firstNode));
        return size;
    }

    public void sort(LinkedList<T> theList) {
        ListNode<T> temp = head;
        int listSize = listSize(theList);
        for (int i = 1; i < listSize; i++) {
            ListNode<T> temp1 = temp;
            for (int j = 0; j < listSize - i - 1; j++) {
                int abc = temp1.compareTo(temp1.next);
                if (abc > 0) {
                    T element = (T) temp1.next.element;
                    temp1.next.element = temp1.element;
                    temp1.element = element;
                }
                temp1 = temp1.next;
            }
        }

    }
}

