package Library.GUI;

import Library.DB_CONNECTION.ConnectDB;
import Library.Genre;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;

public class AddBookDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField bookNameField;
    private JTextField publishingHouseField;
    private JTextField publishingYearField;
    private JComboBox genreComboBox;
    private JTextField priceField;
    private JTextField quantityField;
    private JTextField authorsNameField;
    private JTextField authorsSurnameField;
    private JLabel bookNameLabel;
    private JLabel publishingHouseLabel;
    private JLabel genreLabel;
    private JLabel yearButton;
    private JLabel priceLabel;
    private JLabel quantityLabel;
    private JLabel authorsnameLabel;
    private JLabel authorsSurnameLabel;
    private String booksName;
    private String publishingHouse;
    private String bookGenre;
    private int publishingYear;
    private double price;
    private int numberOfBooks;
    private String authorsName;
    private String authorsSurname;

    public AddBookDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        pack();
        setTitle("Add Books Menu");

        genreComboBox.setModel(new DefaultComboBoxModel(Genre.values()));

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onOK();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() throws SQLException, ClassNotFoundException {
        boolean everythingOK = true;
        if (bookNameField.getText().length() == 0)
        {
            bookNameLabel.setText("This field is empty!");
            everythingOK = false;
        }
        else
        {
            booksName = bookNameField.getText();
        }
        if (publishingHouseField.getText().length() == 0)
        {
            publishingHouseLabel.setText("This field is empty!");
            everythingOK = false;
        }
        else
        {
            publishingHouse = publishingHouseField.getText();
        }
        bookGenre = genreComboBox.getSelectedItem().toString();
        if (publishingYearField.getText().length() == 0)
        {
            yearButton.setText("This field is empty!");
            everythingOK = false;
        }
        else
        {
            publishingYear = Integer.parseInt(publishingYearField.getText());
        }
        if (priceField.getText().length() == 0)
        {
            priceLabel.setText("This field is empty!");
            everythingOK = false;
        }
        else
        {
            price = Double.parseDouble(priceField.getText());
        }
        if (quantityField.getText().length() == 0)
        {
            quantityLabel.setText("This field is empty!");
            everythingOK = false;
        }
        else
        {
            numberOfBooks = Integer.parseInt(quantityField.getText());
        }
        if (authorsNameField.getText().length() == 0)
        {
            authorsnameLabel.setText("This field is empty!");
            everythingOK = false;
        }
        else
        {
            authorsName = authorsNameField.getText();
        }
        if (authorsSurnameField.getText().length() == 0)
        {
            authorsSurnameLabel.setText("This field is empty!");
            everythingOK = false;
        }
        else
        {
            authorsSurname = authorsSurnameField.getText();
        }
        if (everythingOK) {
            int authorsID;
            int bookID;
            int quantity;
            if (ConnectDB.getAuthorsId(authorsName, authorsSurname) == 0) {
                ConnectDB.addAuthor(authorsName, authorsSurname);
            }
            // add your code here
            authorsID = ConnectDB.getAuthorsId(authorsName, authorsSurname);
            if (ConnectDB.getBookId(booksName, publishingHouse, bookGenre, publishingYear,
                    price, authorsID) == 0)
            {
                ConnectDB.addBook(booksName, publishingHouse, bookGenre, publishingYear,
                        price, numberOfBooks, authorsID);
            }
            else
            {
                bookID = ConnectDB.getBookId(booksName, publishingHouse, bookGenre, publishingYear,
                        price, authorsID);
                quantity = ConnectDB.getQuantity(bookID);
                int realQuantity = quantity + numberOfBooks;
                System.out.println(quantity);
                System.out.println(numberOfBooks);
                System.out.println(realQuantity);
                ConnectDB.updateQuantity(bookID, realQuantity);
            }
            ConnectDB.closeConnection();
            dispose();
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

//    public static void main(String[] args) {
//        AddBookDialog dialog = new AddBookDialog();
//        dialog.pack();
//        dialog.setVisible(true);
//        System.exit(0);
//    }
}
