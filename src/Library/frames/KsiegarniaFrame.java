package Library.frames;

import Library.DB_CONNECTION.ConnectDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

public class KsiegarniaFrame extends JFrame {
    private JPanel mainMenuPanel;
    private JButton addBookButton;
    private JButton checkBooksButton;
    private JPanel container;
    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 300;

    public KsiegarniaFrame()
    {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        add(mainMenuPanel);
        add(container);
        pack();
        setTitle("Main Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addBookButton.addActionListener(actionEvent ->
        {
            AddBookMenu dialog = new AddBookMenu();
            dialog.setVisible(true);
        });
        checkBooksButton.addActionListener(actionEvent ->
        {

        });
    }

}
