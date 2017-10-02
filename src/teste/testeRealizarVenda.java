package teste;

import entidade.Material;
import entidade.Venda;
import java.sql.SQLException;
import java.util.Date;
import negocio.NMaterial;
import negocio.NVenda;

public class testeRealizarVenda {
    public static void main(String[] args) throws SQLException {
        NVenda nVenda = new NVenda();
        Venda venda = new Venda();
        venda.setDataHora(new Date());
        NMaterial nMaterial = new NMaterial();
        Material m1, m2, m3;
        m1 = nMaterial.consultar(1);
        m1.setQuantidade(1);
        m2 = nMaterial.consultar(2);
        m2.setQuantidade(1);
        m3 = nMaterial.consultar(3);
        m3.setQuantidade(1);
        venda.getMateriais().add(m1);
        venda.getMateriais().add(m2);
        venda.getMateriais().add(m3);
        venda.setValorTotal((m1.getValor() * m1.getQuantidade()) + (m2.getValor() * m2.getQuantidade()) + (m3.getValor() * m3.getQuantidade()));
        nVenda.salvar(venda);
    }
}
