package teste;

import entidade.Material;
import java.sql.SQLException;
import negocio.NMaterial;

public class testeCadastroMaterial {
    public static void main(String[] args) throws SQLException {
        NMaterial nMaterial = new NMaterial();
        Material material = new Material();
        material.setDescricao("MATERIAL UM");
        material.setQuantidade(500);
        material.setValor(10);
        
        Material material2 = new Material();
        material2.setDescricao("MATERIAL DOIS");
        material2.setQuantidade(100);
        material2.setValor(60);
        
        Material material3 = new Material();
        material3.setDescricao("MATERIAL QUATRO");
        material3.setQuantidade(666);
        material3.setValor(23);
        
        nMaterial.salvar(material);
        nMaterial.salvar(material2);
        nMaterial.salvar(material3);
    }
}
