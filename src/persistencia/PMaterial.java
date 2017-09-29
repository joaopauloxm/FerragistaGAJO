package persistencia;

import entidade.Material;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import util.Conexao;

public class PMaterial {

    public void incluir(Material parametro) throws SQLException {
        Connection cnn = Conexao.getConexao();
        String sql = "INSERT INTO material"
                + "(descricao, valor, quantidade) VALUES"
                + "(?,?,?);";
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setString(1, parametro.getDescricao());
        prd.setDouble(2, parametro.getValor());
        prd.setInt(3, parametro.getQuantidade());
        prd.execute();
        String sql2 = "SELECT currval('material_codigo_seq') as codigo";
        Statement stm = cnn.createStatement();
        ResultSet rs = stm.executeQuery(sql2);
        if (rs.next()) {
            parametro.setCodigo(rs.getInt("codigo"));
        }
        rs.close();
        cnn.close();
    }

    public void alterar(Material parametro) throws SQLException {
        Connection cnn = Conexao.getConexao();
        String sql = "UPDATE material SET "
                + "descricao = ?, "
                + "valor = ?, "
                + "quantidade = ? "
                + "WHERE codigo = ?;";
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setString(1, parametro.getDescricao());
        prd.setDouble(2, parametro.getValor());
        prd.setInt(3, parametro.getQuantidade());
        prd.setInt(4, parametro.getCodigo());
        prd.execute();
    }

    public void excluir(int codigo) throws SQLException {
        Connection cnn = Conexao.getConexao();
        String sql = "DELETE FROM material WHERE codigo = ?;";
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, codigo);
        prd.execute();
    }

    public Material consultar(int codigo) throws SQLException {
        String sql = "SELECT * FROM material WHERE codigo = ?;";
        Connection cnn = Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, codigo);
        ResultSet rs = prd.executeQuery();
        Material objeto = null;
        if (rs.next()) {
            objeto = new Material();
            objeto.setCodigo(rs.getInt("codigo"));
            objeto.setDescricao(rs.getString("descricao"));
            objeto.setValor(rs.getDouble("valor"));
            objeto.setQuantidade(rs.getInt("quantidade"));
        }
        prd.close();
        rs.close();
        cnn.close();
        return objeto;
    }

    public ArrayList<Material> listar() throws SQLException {
        String sql = "SELECT * FROM material ORDER BY codigo;";
        Connection cnn = Conexao.getConexao();
        Statement stm = cnn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<Material> lista = null;
        while (rs.next()) {
            if (lista == null) {
                lista = new ArrayList<>();
            }
            Material objeto = new Material();
            objeto.setCodigo(rs.getInt("codigo"));
            objeto.setDescricao(rs.getString("descricao"));
            objeto.setValor(rs.getDouble("valor"));
            objeto.setQuantidade(rs.getInt("quantidade"));
            lista.add(objeto);
        }
        stm.close();
        rs.close();
        cnn.close();
        return lista;
    }
}
