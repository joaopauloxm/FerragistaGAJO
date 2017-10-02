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
        material.setDescricao("MATERIAL DOIS");
        material.setQuantidade(100);
        material.setValor(60);
        
        Material material3 = new Material();
        material.setDescricao("MATERIAL QUATRO");
        material.setQuantidade(666);
        material.setValor(23);
        
        nMaterial.salvar(material);
        nMaterial.salvar(material2);
        nMaterial.salvar(material3);
    }
}
