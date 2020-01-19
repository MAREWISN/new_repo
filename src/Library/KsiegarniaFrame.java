package Library;

import Library.DB_CONNECTION.ConnectDB;

import javax.swing.*;
import java.sql.*;

public class KsiegarniaFrame extends JFrame {
    private final static int DEFAULT_WIDTH = 300;
    private final static int DEFAULT_HEIGHT = 200;

    public KsiegarniaFrame ()
    {
        Ksiegarnia ksiegarnia = new Ksiegarnia();
        setTitle("Księgarnia");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton addBookButton = new JButton("Dodaj książkę");
        JButton checkBooks = new JButton("Pokaż zbiór książek");
        JPanel panel = new JPanel();

        panel.add(addBookButton);
        panel.add(checkBooks);
        add(panel);

        addBookButton.addActionListener(actionEvent ->
        {

            JPanel nextPanel = new JPanel();
            JFrame frame = new JFrame();
            frame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
            frame.setTitle("Dodawanie nowej książki");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JTextField name = new JTextField(30);
            JTextField genre = new JTextField(30);
            JTextField year = new JTextField(4);
            JButton submitButton = new JButton("Potwierdź");
            JButton closeButton = new JButton("Zamknij");
            nextPanel.add(name);
            nextPanel.add(genre);
            nextPanel.add(year);
            nextPanel.add(submitButton);
            nextPanel.add(closeButton);
            frame.add(nextPanel);
            frame.setVisible(true);

            submitButton.addActionListener(actionEvent1 -> {
                String nazwa = name.getText();
                String rodzaj = genre.getText();
                int rok_wydania = Integer.parseInt(year.getText());
                try {
                    Ksiazka ksiazka = new Ksiazka(nazwa, rodzaj, rok_wydania);
                    ksiegarnia.dodajKsiazke(ksiazka);
                    nazwa = ksiazka.getNazwa();
                    System.out.println("Dodano książkę " + nazwa);
                }

                catch (NumberFormatException e) {
                    System.out.println(e);
                }
            });

            closeButton.addActionListener(actionEvent1 ->
            {
                frame.dispose();
            });

        });

        checkBooks.addActionListener(actionEvent ->
        {
            ConnectDB.checkBooks();
//            ksiegarnia.getZbior();

        });


    }
}
