package teste;

import entidade.Material;
import java.sql.SQLException;
import negocio.NMaterial;

public class testeModificarMaterial {
    public static void main(String[] args) throws SQLException {
        NMaterial nMaterial = new NMaterial();
        Material material = nMaterial.consultar(3);
        material.setDescricao("MATERIAL TRES");
        nMaterial.salvar(material);
    }
}
