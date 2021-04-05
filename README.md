# Реализация структуры двусвязный список, на языке Java.
# Implementation of a doubly linked list structure in Java.

*Задание:*  
Реализовать структуру данных двухсвязный список. Следующие операции должны потдерживаться: добавление в конец, получение, вставка и удаление по логическому номеру (индексу),
итератор forEach, сортировка.Разработать графическое оконное приложение, работающее со структурой данных . Функции: отображение состояния, сохранение и загрузка файла.

1. Шаблонный класс ListNode, который реализует интерфейс Comparable. Интерфейс Comparable имеет метод compareTo, который, в данном случае, используется для сравнения двух элементов списка. Экземпляром класса ListNode является элемент списка. ListNode включает в себя следующие поля и методы: 
- a) element – ключ элемента списка. Тип задается при создании элемента класса (в данном случае - String);
- b) next – ссылка на следующий элемент списка. Тип: ListNode;
- c) ListNode – конструктор класса. Параметры: element: T – ключ нового элемента, next: ListNode – ссылка на следующий элемент списка. Возвращает новый экземпляр класса типа ListNode;
- d) compareTo – функция для сравнения двух элементов списка. Параметры: comparableNode: ListNode – элемент списка, с которым нужно сравнить текущий элемент. Возвращает целое число, которое указывает отношение между текущим элементом и тем, который был передан в качестве параметра. 
2. Шаблонный класс LinkedListIterator, который реализует интерфейс Iterator. Интерфейс Iterator используется для реализации forEach. Экземпляром класса LinkedListIterator является итератор. LinkedListIterator содержит следующие поля и методы: 
- a) current – текущий элемент списка. Тип: ListNode; 
- b) head – первый элемент списка. Тип: ListNode;
- c) index – индекс текущего элемента. Тип: ListNode; 
- d) LinkedListIterator – конструктор класса. Параметры: current: ListNode – текущий элемент списка, head: ListNode – первый элемент списка, index: int – индекс текущего элемента. Возвращает новый экземпляр класса типа LinkedListIterator;
- e) hasNode – проверка наличия текущего элемента в итераторе. Возвращает true, если элемент присутствует; 
- f) hasNext – проверка наличия следующего элемента в списке. Т.к. список циклический, то проверяется наличие элемента и то, что следующий элемент не является головой списка. Возвращает true, если следующий элемент присутствует; 
- g) getElement – получение элемента списка, на который указывает итератор. Возвращает ключ текущего элемента;
- h) advance – перемещение итератора на следующий элемент списка. Возвращает предыдущий элемент списка;
- i) next – аналогично advance, но используется для реализации forEach. Поскольку список циклический, то используется проверка hasNext для того, чтобы определить, что мы дошли до конца списка. Возвращает предыдущий элемент списка.
3. Шаблонный класс LinkedList, который реализует интерфейс Iterable. Интерфейс Iterable используется для реализации forEach. Экземпляром класса LinkedList является циклический список. LinkedList содержит следующие поля и методы:
- a) head – ссылка на первый элемент списка. Тип: ListNode;
- b) tail – ссылка на последний элемент списка. Тип: ListNode;
- c) num – используется для определения индекса элемента списка. Тип: int;
- d) size – размер списка. Тип: int;
- e) LinkedList – конструктор класса. Возвращает новый экземпляр класса LinkedList;
- f) iterator – возвращает итератор, который указывает на первый элемент списка;
- g) last – возвращает итератор, который указывает на последний элемент списка;
- h) isEmpty – проверка списка на пустоту. Возвращает true, если список пустой;
- i) makeEmpty – очистка списка;
- j) push – добавление элемента в конец списка. Параметры: x: T – ключ нового элемента. Возвращает новый экземпляр класса LinkedListIterator, который указывает на новый элемент;
- k) unshift – добавление элемента в начало списка. Параметры: x: T – ключ нового элемента. Возвращает новый экземпляр класса LinkedListIterator, который указывает на новый элемент;
- l) insert – добавление элемента в любое место списка. Параметры: x: T – ключ нового элемента, p: LinkedListIterator – итератор на элемент, после которого происходит вставка. Возвращает новый экземпляр класса LinkedListIterator, который указывает на новый элемент;
- m) find – поиск элемента по ключу. Параметры: x: T – ключ искомого элемента. Возвращает новый экземпляр класса LinkedListIterator, который указывает на найденный элемент, либо на null, если элемент не был найден;
- n) findPrevious – как find, только на 1 элемент левее(выше). Параметры: x: T – ключ искомого элемента. Возвращает новый экземпляр класса LinkedListIterator, который указывает на найденный элемент, либо на null, если элемент не был найден;
- o) remove – удаление элемента списка. Параметры: x: T – ключ элемента, который нужно удалить;
- p) printList – вывод списка на экран(консоль). Возвращает строку, которая является текстовым представлением списка;
- q) listSize – возвращает размер списка;
- r) sort – сортировка списка. Параметры: theList: LinkedList – список, который нужно отсортировать;
- s) save – сохранение списка в файл;
- t) read – чтение списка из файла. Возвращает новый экземпляр класса LinkedList, который содержит список из файла.
4. Функции поддерживаемые в интерфейсе: 
- a) «Заполнить список / добавить элемент» - после нажатия ожидается ввод числа элементов, которые нужно добавить к списку если список уже создан, либо создать и заполнить если списка еще нет.
- b) «Очистить список» - удаляет все элементы из списка.
- c) «Вывести список» - распечатывает состояние списка в поле вывода.
- d) «Найти элемент по ключу» - ожидается ввод ключа в поле ввода и нажатие Enter, после распечатывает элемент с найденным ключом либо сообщение о том, что элемент не найден.
- e) «Найти элемент по индексу» - ожидается ввод индекса в поле ввода и нажатие Enter, после распечатывает элемент с найденным индексом либо сообщение о том, что элемент не найден.
- f) «Удалить элемент по индексу» - ожидается ввод индекса в поле ввода и нажатие Enter, после удаляет элемент с найденным индексом либо сообщение о том, что элемент не найден.
- g) «Вставить элемент по индексу» - ожидается ввод индекса и через пробел ключ в поле ввода и нажатие Enter, после вставляет элемент по индексу с заданным ключом.
- h) «Изменить элемент по индексу» - ожидается ввод индекса и через пробел ключ в поле ввода и нажатие Enter, после изменяет элемент по индексу на введенный ключ.
- i) «Добавить элемент в конец» - ожидается ввод ключа в поле ввода и нажатие Enter, после добавляется элемент с индексом n + 1.
- j) «Переместить итератор на следующий элемент» - перемещает итератор на следующий элемент списка.
- k) «Вывести элемент, на который указывает итератор» - распечатывает ключ элемента, на который указывает итератор.
- l) «Перевести итератор на первый элемент» - перемещает итератор на первый элемент списка.
- m) «Сортировать список» - производит сортировку списка.
- n) «Очистить консоль» - стирает содержимое поля вывода.
- o) «Сохранить список» - сохраняет список в текстовый документ в директорию программы.
- p) «Загрузить список» - загружает список из текстового файла.

Рисунок 1. Графическое окно приложения. 
1 - поле вывода, 2 – панель управления, 3 – поле ввода.

Рисунок 2. Панель управления приложением.
