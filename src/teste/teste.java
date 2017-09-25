package teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import util.Conexao;

public class teste {
    public static void main(String[] args) throws SQLException {
        Connection cnn = Conexao.getConexao();
        String sql = "INSERT INTO material"
                + "(descricao, valor, quantidade) VALUES"
                + "(?,?,?);";
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setString(1, "joelho");
        prd.setDouble(2, 50.0);
        prd.setInt(3, 1);
        prd.execute();
        cnn.close();
        System.out.print("foi");
    }
}
