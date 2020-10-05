package laba1;

import javax.swing.*;

public class Laba1 {
    public static void main(String[] args)
    {
        LinkedList<String> theList = new LinkedList<>();
        LinkedListIterator<String> theItr = theList.iterator();
        System.out.println("Создаем список из 10 элементов:");
        for (int i = 0; i < 10; i++) {
            theItr = theList.push(RandString.GenerateRandomString());
        }
        System.out.println(theList.printList());
        System.out.println("Вывод элемента на который указывает итератор: " + theItr.getElement());
        System.out.println("\nПоиск по ключу " + theItr.getElement());
        theList.find(theItr.getElement());
        System.out.println("Ключ " + theItr.getElement() + " найден под номером " + theList.num);
        System.out.println("\nПоиск по индексу : 4");
        theItr = theList.iterator();
        for (int i = 0; i < 4; i++) theItr.advance();
        System.out.println("Под номером 4 найден ключ " + theItr.getElement());
        System.out.println("\nДлинна списка: " + theList.listSize());
        System.out.println("\nВыполняем сортировку списка.");
        theList.sort();
        System.out.println("Сортировка выполнена. " + theList.printList());
        String newElement = RandString.GenerateRandomString();
        System.out.println("\nВставка " + newElement + " на 2 место.");
        theItr = theList.iterator();
        for (int i = 0; i < 2; i++) theItr.advance();
        theList.insert(newElement, theList.findPrevious(theItr.getElement()));
        System.out.println("Ключ " + newElement + " добавлен под номером " + 2 + ". " + theList.printList());
        System.out.println("\nУдаление элемента с индексом 5.");
        theItr = theList.iterator();
        for (int i = 0; i < 5; i++) theItr.advance();
        theList.remove(theItr.getElement());
        System.out.println("Элемент с индексом 5 удален. " + theList.printList());
        String newElement2 = RandString.GenerateRandomString();
        System.out.println("\nВставка " + newElement2 + " в конец списка.");
        theList.push(newElement2);
        System.out.println("Ключ " + newElement2 + " добавлен в конец списка. " + theList.printList());
        System.out.println("\nТестовый показ закончен. Спасибо за внимание!!!");
    }
}