package Library;

import Library.DB_CONNECTION.ConnectDB;
import Library.GUI.MainMenuFrame;
import com.sun.tools.javac.Main;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KsiegarniaTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        EventQueue.invokeLater(() ->
//        {
//            KsiegarniaFrame frame = new KsiegarniaFrame();
//            frame.setVisible(true);
//        });


        EventQueue.invokeLater(() ->
        {
            MainMenuFrame frame = new MainMenuFrame();
        });
    }
}
