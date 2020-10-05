package laba1;

import javax.swing.*;

public class Laba1 {
    public static void main(String[] args)
    {
        Window w = new MainWindow("Список");
        w.setVisible ( true );
        w.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        w.pack();
        w.setLocationRelativeTo ( null );
    }
}