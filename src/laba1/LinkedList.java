package laba1;

public class LinkedList {
    // Заголовок структуры
    private ListNode header;
    int num = 0;

    // Конструктор списка, создаётся заголовок списка
    public LinkedList() {
        header = new ListNode(null);
    }

    // Проверка элемента
    public boolean isEmpty() {
        return header.next == null;
    }

    //Очистка списка
    public void makeEmpty() {
        header.next = null;
    }

    // Помещаем указатель до первого элемента
    public LinkedListIterator prefirst() {
        return new LinkedListIterator(header);
    }

    // Помещаем указатель на первый элемент
    public LinkedListIterator first() {
        return new LinkedListIterator(header.next);
    }

    // Вставка по индексу
    public void insert(Object x, LinkedListIterator p) {
        if (p != null && p.current != null)
            p.current.next = new ListNode(x, p.current.next);
    }

    // Находим элемент по ключу и возвращаем ссылку на элемент
    public LinkedListIterator find(Object x) {
        ListNode itr = header.next;
        num = 0;
        while (itr != null && !itr.element.equals(x)) {
            itr = itr.next;
            num++;
        }
        return new LinkedListIterator(itr);
    }

    // Как find только на 1 элемент левее(выше)
    public LinkedListIterator findPrevious(Object x) {
        ListNode itr = header;
        while (itr.next != null && !itr.next.element.equals(x))
            itr = itr.next;
        return new LinkedListIterator(itr);

    }

    // Удаляет элемент содержащий переданный текст
    public void remove(Object x) {
        LinkedListIterator p = findPrevious(x);
        if (p.current.next != null)
            p.current.next = p.current.next.next;
    }

    // Вывод в консоль
    public static String printList(LinkedList theList) {
        String result;
        if (theList.isEmpty())
            return "Пустая структура";
        else {
            int i = 0;
            LinkedListIterator itr = theList.first();
            result = "Структура:\n\n";
            for (; itr.isValid(); itr.advance()) {
                result += ("    "+itr.retrieve() + "\t[" + i + "] \n");
                i++;
            }
            return result;
        }
    }


    // Определяет размер структуры
    public static int listSize(LinkedList theList) {
        LinkedListIterator itr;
        int size = 0;
        for (itr = theList.first(); itr.isValid(); itr.advance())
            size++;

        return size;

    }
}

