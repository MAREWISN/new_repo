package Library;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class KsiegarniaFrame extends JFrame {
    private final static int DEFAULT_WIDTH = 300;
    private final static int DEFAULT_HEIGHT = 200;
    private JPanel panel;

    public KsiegarniaFrame ()
    {
        Ksiegarnia ksiegarnia = new Ksiegarnia();
        setTitle("Księgarnia");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton addBookButton = new JButton("Dodaj książkę");
        JButton checkBooks = new JButton("Pokaż zbiór książek");
        panel = new JPanel();

        panel.add(addBookButton);
        panel.add(checkBooks);
        add(panel);

        addBookButton.addActionListener(actionEvent ->
        {
            String nazwa;
            Ksiazka ksiazka = new Ksiazka("W pustyni i w puszczy", "Przygodowa", 2007);
            ksiegarnia.dodajKsiazke(ksiazka);
            nazwa = ksiazka.getNazwa();
            System.out.println("Dodano " + nazwa);
        });

        checkBooks.addActionListener(actionEvent ->
        {
            ksiegarnia.getZbior();

        });

    }

}
