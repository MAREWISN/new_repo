package Library.DB_CONNECTION;

import java.sql.*;

public class ConnectDB {
    private static String url = "jdbc:mysql://localhost:3306/ksiegarnia?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String user = "root";
    private static String password = "35Rdaf2fxtb3e8bz";

    public static void closeConnection() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, password);
        con.close();
    }
    public static Statement connectDB() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, password);
        return con.createStatement();
    }

    public static int getBookId(String bookName, String publishingHouse, String genre, int publishingYear,
                                double price, int authorsId)
    {
        int bookId = 0;
        try {
            Statement stmt = ConnectDB.connectDB();
            String sql = "select idksiazki from ksiazki where nazwa_ksiazki='" + bookName + "' AND wydawnictwo='" + publishingHouse +
                    "' AND rodzaj_ksiazki='" + genre + "' AND rok_wydania='" + publishingYear +
                    "' AND cena='" + price + "' AND idautora='" + authorsId + "';";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next())
                bookId = rs.getInt(1);
        }
        catch (SQLException | ClassNotFoundException e)
        {
            bookId = 0;
        }
        return bookId;
    }
    public static void addBook(String bookName, String publishingHouse, String genre, int publishingYear,
                                double price, int quantity, int authorsId)
    {
        try {
            Statement stmt = ConnectDB.connectDB();
            String sql = "insert into ksiazki (nazwa_ksiazki,wydawnictwo,rodzaj_ksiazki,rok_wydania,cena," +
                    "ilosc_ksiazek,idautora) values ('" + bookName + "','" + publishingHouse + "','" + genre + "','"
                    + publishingYear + "','" + price + "','" + quantity + "','" + authorsId + "');";
            stmt.executeUpdate(sql);
            System.out.println("Dodano książkę");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static int getQuantity (int bookId)
    {
        int quantity = 0;
        try {
            Statement stmt = ConnectDB.connectDB();
            String sql = "select ilosc_ksiazek from ksiazki where idksiazki=" + bookId + ";";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next())
                quantity = rs.getInt(1);
        }
        catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return quantity;
    }

    public static void updateQuantity (int bookId, int quantity)
    {
        try {
            Statement stmt = ConnectDB.connectDB();
            String sql = "update ksiazki set ilosc_ksiazek = '" + quantity + "' where idksiazki = " +
                    bookId + ";";
            stmt.executeUpdate(sql);
            System.out.println("Dodano książki");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Nie udało się dodać książek");
        }
    }

    public static int getAuthorsId(String name, String surname) {
        int authorsId = 0;
        try {
            Statement stmt = ConnectDB.connectDB();
            String sql = "select idautora from autor where imie_autora='" + name + "' AND nazwisko_autora='" + surname + "';";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next())
            authorsId = rs.getInt(1);
        }
        catch (SQLException | ClassNotFoundException e)
        {
            authorsId = 0;
        }
        return authorsId;
    }

    public static void addAuthor(String name, String surname) {
        try {
            Statement stmt = ConnectDB.connectDB();
            String sql = "insert into autor (imie_autora,nazwisko_autora) values ('" + name + "','" + surname + "');";
            stmt.executeUpdate(sql);
            System.out.println("Dodano autora");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Nie udało się dodać autora");
        }
    }

    public static String checkBooks ()
    {
        String s = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();
            String sql = "select * from ksiazki";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next())
               s = ("ID " + rs.getInt(1) + " Book Name " +
                        rs.getString(2) + " Publishing House " + rs.getString(3) +
                        " Genre " + rs.getString(4) + " Publishing Year " + rs.getInt(5) +
                        " Price " + rs.getDouble(6) + " Quantity " + rs.getInt(7));
        }
            catch (Exception e) {
                s = e.toString();
            }
        return s;
    }
}
