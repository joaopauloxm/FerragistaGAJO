package teste;

import entidade.Material;
import java.sql.SQLException;
import negocio.NMaterial;

public class teste {
    public static void main(String[] args) throws SQLException {
        NMaterial negMat = new NMaterial();
        Material mat = new Material();
        mat.setDescricao("PARAFUSO FENDA 3MM FERRO");
        mat.setValor(0.3);
        mat.setQuantidade(100);
        negMat.salvar(mat);
    }
}
