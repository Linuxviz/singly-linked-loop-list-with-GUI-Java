package laba1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;


public class MainWindow extends Window {
    //Выделение памяти
    //Элементы консоли
    Container LeftInnerContainer;
    Container RightInnerContainer;
    JTextArea OutputText;
    JScrollPane ScrollPane;
    JTextField TextField;
    //Интерактивные элементы
    private final JButton Filler;
    private final JButton MakeEmpty;
    private final JButton ShowData;
    private final JButton SearchKey;
    private final JButton SearchID;
    private final JButton Remove;
    private final JButton Insert;
    private final JButton Edit;
    //Список и его итератор
    LinkedList<String> theList;
    LinkedListIterator<String> theItr;
    //Флаги действий
    boolean[] flags = {false, false, false, false, false};


    MainWindow(String title) {
        //Создание экземпляра структуры
        super(title);
        theList = new LinkedList<>();
        theItr = theList.first();
        //Настройка главного окна
        setPreferredSize(new Dimension(1150, 500));
        setLayout(new GridLayout(1, 2));
        //Создание элементов окна
        RightInnerContainer = new Container();
        LeftInnerContainer = new Container();

        Filler = new JButton("Заполнить список");
        MakeEmpty = new JButton("Очистить список");
        ShowData = new JButton("Вывести список");
        SearchKey = new JButton("Найти элемент по ключу");
        SearchID = new JButton("Найти элемент по индексу");
        Remove = new JButton("Удалить элемент по индексу");
        Insert = new JButton("Вставить элемет по индексу");
        Edit = new JButton("Изменить элемент по индексу");
        TextField = new JTextField();
        OutputText = new JTextArea();
        ScrollPane = new JScrollPane(OutputText);
        OutputText.setEditable(false);

        //Установка положения
        add(RightInnerContainer);
        add(LeftInnerContainer);
        LeftInnerContainer.setLayout(new BorderLayout());
        RightInnerContainer.setLayout(new GridLayout(4, 4));

        RightInnerContainer.add(Filler);
        RightInnerContainer.add(MakeEmpty);
        RightInnerContainer.add(ShowData);
        RightInnerContainer.add(SearchKey);
        RightInnerContainer.add(SearchID);
        RightInnerContainer.add(Remove);
        RightInnerContainer.add(Insert);
        RightInnerContainer.add(Edit);
        LeftInnerContainer.add(ScrollPane, BorderLayout.CENTER);
        LeftInnerContainer.add(TextField, BorderLayout.SOUTH);

        //События нажатия кнопок и Enter
        ActionListener checker = new Handler();
        KeyListener key_checker = new InputHendler();

        Filler.addActionListener(checker);
        MakeEmpty.addActionListener(checker);
        ShowData.addActionListener(checker);
        SearchKey.addActionListener(checker);
        SearchID.addActionListener(checker);
        Remove.addActionListener(checker);
        Insert.addActionListener(checker);
        Edit.addActionListener(checker);

        TextField.addKeyListener(key_checker);
    }

    public void consoleOut(String newStr) {
        String past_text = OutputText.getText();
        OutputText.setText(past_text + newStr + "\n");
    }

    private class Handler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(SearchKey)) {
                consoleOut("Введите ключ:");
                Arrays.fill(flags, false);
                flags[0] = true;
            }

            if (e.getSource().equals(SearchID)) {
                consoleOut("Введите индекс:");
                Arrays.fill(flags, false);
                flags[1] = true;
            }

            if (e.getSource().equals(MakeEmpty)) {
                theList.makeEmpty();
                consoleOut("Структура очищена");
            }

            if (e.getSource().equals(ShowData)) {
                String res = LinkedList.printList(theList);
                consoleOut(res);
                int listSize = LinkedList.listSize(theList);
                if (listSize > 0)
                    consoleOut("Размер структуры: " + listSize + "\n");
            }
            if (e.getSource().equals(Filler)) {
                for (int i = 0; i < 5; i++) {
                    theList.push(RandString.GenerateRandomString());
                }
                consoleOut("Список заполнен");
            }

            if (e.getSource().equals(Remove)) {
                consoleOut("Введите индекс удаляемого элемента:");
                Arrays.fill(flags, false);
                flags[2] = true;
            }

            if (e.getSource().equals(Insert)) {
                consoleOut("Введите индекс под которым нужно добавть ключ и (через пробел) содержимое элемента:");
                Arrays.fill(flags, false);
                flags[3] = true;
            }

            if (e.getSource().equals(Edit)) {
                consoleOut("Введите индекс изменяемого элемента и (через пробел) содержимое изменённого элемента:");
                Arrays.fill(flags, false);
                flags[4] = true;
            }
        }
    }

    public class InputHendler implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                if (flags[0]) {
                    flags[0] = false;
                    String SearchKey = TextField.getText();
                    TextField.setText("");
                    consoleOut(SearchKey);
                    if (theList.find(SearchKey).isValid()) {
                        theList.find(SearchKey);
                        consoleOut("Ключ " + SearchKey + " найден под номером " + theList.num);
                    } else {
                        consoleOut("Элемент не найден");
                    }
                } else if (flags[1]) {
                    flags[1] = false;
                    String SearchKey = TextField.getText();
                    TextField.setText("");
                    consoleOut(SearchKey);
                    try {
                        int SearchIDint = Integer.parseInt(SearchKey);
                        if (LinkedList.listSize(theList) > SearchIDint) {
                            theItr = theList.first();
                            for (int i = 0; i < SearchIDint; i++) theItr.advance();
                            consoleOut("Ключ " + theItr.retrieve() + " найден под номером " + SearchIDint);
                        } else {
                            consoleOut("Элемент не найден");
                        }
                    } catch (Exception err) {
                        consoleOut("Ошибка, введены неверные данные. Ожидалось число");
                    }
                } else if (flags[2]) {
                    flags[2] = false;
                    String SearchKey = TextField.getText();
                    TextField.setText("");
                    consoleOut(SearchKey);
                    try {
                        int removeInt = Integer.parseInt(SearchKey);
                        if (LinkedList.listSize(theList) > removeInt) {
                            theItr = theList.first();
                            for (int i = 0; i < removeInt; i++) theItr.advance();
                            theList.remove(theItr.retrieve());
                            consoleOut("Ключ " + theItr.retrieve() + " под индексом " + removeInt + " удалён");
                        } else {
                            consoleOut("Элемент не найден");
                        }
                    } catch (Exception err) {
                        consoleOut("Ошибка, введены неверные данные. Ожидалось число");
                    }
                } else if (flags[3]) {
                    flags[3] = false;
                    String inputText = TextField.getText();
                    TextField.setText("");
                    consoleOut(inputText);
                    try {
                        String[] subStr;
                        String delimiter = " "; // Разделитель
                        subStr = inputText.split(delimiter); // Разделение строки str с помощью метода split()

                        int InsertInt = Integer.parseInt(subStr[0]);
                        if (LinkedList.listSize(theList) + 1 > InsertInt) {
                            theItr = theList.first();
                            for (int i = 0; i < InsertInt; i++) theItr.advance();
                            theList.insert(subStr[1], theList.findPrevious(theItr.retrieve()));
                            consoleOut("Ключ " + subStr[1] + " добавлен под номером " + InsertInt);
                        } else {
                            consoleOut("Невозможно добавить элемент по заданной позиции");
                        }
                    } catch (Exception err) {
                        consoleOut("Ошибка, введены неверные данные");
                    }
                } else if (flags[4]) {
                    flags[4] = false;
                    String inputText = TextField.getText();
                    TextField.setText("");
                    consoleOut(inputText);
                    try {
                        String[] subStr;
                        String delimiter = " "; // Разделитель
                        subStr = inputText.split(delimiter); // Разделение строки str с помощью метода split()

                        int InsertInt = Integer.parseInt(subStr[0]);

                        if (LinkedList.listSize(theList) > InsertInt) {
                            theItr = theList.first();
                            for (int i = 0; i < InsertInt; i++) theItr.advance();
                            theList.insert(subStr[1], theList.findPrevious(theItr.retrieve()));
                            theList.remove(theItr.retrieve());
                            consoleOut(InsertInt + " Элемент изменён на " + subStr[1]);
                        } else {
                            consoleOut("Элемент не найден");
                        }
                    } catch (Exception err) {
                        consoleOut("Ошибка, введены неверные данные.");
                    }
                } else {
                    String inputText = TextField.getText();
                    TextField.setText("");
                    consoleOut(inputText);
                    consoleOut("Неверная команда");
                }
            }
        }

        //commandText =  TextField.getText();
        @Override
        public void keyReleased(KeyEvent e) {
        }
    }
}