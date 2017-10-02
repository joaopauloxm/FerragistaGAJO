package persistencia;

import entidade.Material;
import entidade.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import util.Conexao;

public class PVenda {

    public void incluir(Venda venda) throws SQLException {
        try (Connection cnn = Conexao.getConexao()) {
            String sql = "INSERT INTO venda"
                    + "(datahora, valortotal) VALUES"
                    + "(?,?);";
            PreparedStatement prd = cnn.prepareStatement(sql);
            prd.setTimestamp(1, new Timestamp(venda.getDataHora().getTime()));
            prd.setDouble(2, venda.getValorTotal());
            prd.execute();
            prd.close();
            sql = "SELECT currval('venda_codigo_seq') AS codigo";
            Statement stm = cnn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                venda.setCodigo(rs.getInt("codigo"));
            }
            rs.close();
            sql = "INSERT INTO materialvenda"
                    + "(codvenda, codmaterial, quantidade, valorepoca) VALUES"
                    + "(?, ?, ?, ?);";
            prd = cnn.prepareStatement(sql);
            prd.setInt(1, venda.getCodigo());
            PMaterial pMaterial = new PMaterial();
            for (Material material : venda.getMateriais()) {
                prd.setInt(2, material.getCodigo());
                prd.setInt(3, material.getQuantidade());
                prd.setDouble(4, material.getValor());
                prd.execute();
                Material oldMaterial = pMaterial.consultar(material.getCodigo());
                oldMaterial.setQuantidade(oldMaterial.getQuantidade() - material.getQuantidade());
                pMaterial.alterar(oldMaterial);
            }
            prd.close();
        }
    }

    public Venda consultar(int codigo) throws SQLException {
        String sql = "SELECT * FROM venda WHERE codigo = ?;";
        Connection cnn = Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, codigo);
        ResultSet rs = prd.executeQuery();
        Venda objeto = null;
        if (rs.next()) {
            objeto = new Venda();
            objeto.setCodigo(rs.getInt("codigo"));
            objeto.setDataHora(rs.getDate("datahora"));
            objeto.setValorTotal(rs.getDouble("valortotal"));
            objeto.setMateriais(getMateriaisByVenda(objeto.getCodigo()));
        }
        prd.close();
        rs.close();
        return objeto;
    }

    public ArrayList<Venda> listar() throws SQLException {
        String sql = "SELECT * FROM venda ORDER BY codigo;";
        Connection cnn = Conexao.getConexao();
        Statement stm = cnn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<Venda> lista = null;
        while (rs.next()) {
            if (lista == null) {
                lista = new ArrayList<>();
            }
            Venda objeto = new Venda();
            objeto.setCodigo(rs.getInt("codigo"));
            objeto.setDataHora(rs.getDate("datahora"));
            objeto.setValorTotal(rs.getDouble("valortotal"));
            objeto.setMateriais(getMateriaisByVenda(objeto.getCodigo()));
            lista.add(objeto);
        }
        stm.close();
        rs.close();
        return lista;
    }

    private ArrayList<Material> getMateriaisByVenda(int codigoVenda) throws SQLException {
        String sql = "SELECT * FROM materialvenda WHERE codvenda = ? ORDER BY codigo;";
        Connection cnn = Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, codigoVenda);
        ResultSet rs = prd.executeQuery();
        ArrayList<Material> lista = null;
        PMaterial pMaterial = null;
        while (rs.next()) {
            if (lista == null) {
                lista = new ArrayList<>();
            }
            if (pMaterial == null) {
                pMaterial = new PMaterial();
            }
            Material objeto = new Material();
            objeto.setCodigo(rs.getInt("codigo"));
            objeto.setDescricao(pMaterial.consultar(objeto.getCodigo()).getDescricao());
            objeto.setQuantidade(rs.getInt("quantidade"));
            objeto.setValor(rs.getDouble("valorepoca"));
            lista.add(objeto);
        }
        prd.close();
        rs.close();
        return lista;
    }
}
