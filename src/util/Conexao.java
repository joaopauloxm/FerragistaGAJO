package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static Connection conexao;

    private Conexao () {}
    
    public static Connection getConexao() {
        try {
            if (conexao == null || conexao.isClosed()) {
                conexao = conectar();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return conexao;
    }

    private static Connection conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://192.168.200.66:5432/ferragistaGAJO", "postgres", "@GgUu142697");
        } catch (ClassNotFoundException e) {
            System.out.println("A aplicação não contém o driver para o banco.");
            return null;
        } catch (SQLException e) {
            System.out.println("Erro na conexao com o banco. Verifique a url, o usuário e a senha.");
            return null;
        }
    }
}
