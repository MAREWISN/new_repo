package Library.DB_CONNECTION;

import java.sql.*;

public class ConnectDB {
    private static String url = "jdbc:mysql://localhost:3306/ksiegarnia?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String user = "root";
    private static String password = "35Rdaf2fxtb3e8bz";

    public static void checkBooks ()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();
            String sql = "select * from ksiazki";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next())
                System.out.println("Tytuł "+rs.getString(2)+"\n Autor "+
                        rs.getString(3) + " "+rs.getString(4)+" \n Wydawnictwo "+
                        rs.getString(5) + "\n Rodzaj "+rs.getString(6)+" Data wydania "+rs.getInt(7)
                        + " \n Cena " + rs.getFloat(8)
                );
        }
            catch (Exception e) {
                System.out.println(e);
            }
    }
    public static void main(String[] args) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();
            stmt.executeUpdate("insert into ksiazki (nazwa_ksiazki,imie_autora,nazwisko_autora" +
                    ",wydawnictwo,rodzaj_ksiazki,rok_wydania) " +
                    "values ('W pustyni i w puszczy','Henryk','Sienkiewicz'," +
                    "'Nowa Era','Przygodowa','2003')");
            String sql = "select * from ksiazki";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next())
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+
                        rs.getString(3) + " "+rs.getString(4)+" "+
                        rs.getString(5) + " "+rs.getString(6)+" "+rs.getInt(7)
                );
            con.close();
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
