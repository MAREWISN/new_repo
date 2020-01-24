package Library.GUI;

import Library.DB_CONNECTION.ConnectDB;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class MainMenuFrame extends JFrame{
    private static final int DEFAULT_WIDTH = 500;
    private static final int DEFAULT_HEIGHT = 350;
    private JPanel mainPanel;
    private JButton addBookButton;
    private JButton checkBooksButton;
    private JPanel centerPanel;
    public MainMenuFrame()
    {
        mainPanel.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        getContentPane().add(mainPanel);
        setTitle("Main Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        checkBooksButton.addActionListener(actionEvent -> {
            String name = "Jan";
            String surname = "Wiśniowski";
            if (ConnectDB.getAuthorsId(name, surname) == 0)
            ConnectDB.addAuthor(name, surname);
            else
            System.out.println(ConnectDB.getAuthorsId(name, surname));
        });
    }
}
