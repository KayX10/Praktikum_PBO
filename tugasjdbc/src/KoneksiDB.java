import java.sql.*;

public class KoneksiDB{
    String urldb ="jdbc:mysql://localhost/tugasjdbc";
    String dbusername = "root";
    String dbpassword = "";

    Connection koneksi;
    Statement statement;
    public KoneksiDB() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = (Connection) DriverManager.getConnection(urldb,dbusername,dbpassword);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            System.out.println("Koneksi gagal");
        }
    }
}