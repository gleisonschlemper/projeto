package Classe.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {

    public static Connection conectaBanco() {
        String driver = "org.postgresql.Driver";
        String URL = "jdbc:postgresql://db.xadmfzoocdgvffqevayf.supabase.co/postgres";
        String USER = "postgres";
        String PASS = "gsml1508@4200";
        Connection conexao = null;
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Driver não localizado: " + e.getMessage());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Deu erro na conexão com a fonte de dados: " + e.getMessage());
        }
        return conexao;
    }
}
