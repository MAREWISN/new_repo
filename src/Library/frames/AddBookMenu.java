package Library.frames;

import Library.Genres;

import javax.swing.*;
import java.awt.event.*;

public class AddBookMenu extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField bookName;
    private JLabel returnLabel;
    private JTextField publishingHouse;
    private JComboBox genreBox;
    private JTextField publishingYear;
    private JTextField price;
    private JTextField authorName;
    private JTextField authorSurname;
    private JLabel bookNameLabel;
    private JLabel publishingHouseNameLabel;
    private JLabel genreLabel;
    private JLabel yearLabel;
    private JLabel priceLabel;
    private JLabel authorNameLabel;
    private JLabel authorSurnameLabel;

    public AddBookMenu() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        genreBox.setModel(new DefaultComboBoxModel(Genres.values()));
        pack();

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
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

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        AddBookMenu dialog = new AddBookMenu();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
