package negocio;

import entidade.Material;
import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.PMaterial;

public class NMaterial {

    PMaterial per;

    public NMaterial() {
        per = new PMaterial();
    }

    public void salvar(Material material) throws SQLException {
        if (material.getCodigo() == 0) {
            per.incluir(material);
        } else {
            per.alterar(material);
        }
    }

    public void excluir(int codigo) throws SQLException {
        per.excluir(codigo);
    }

    public Material consultar(int codigo) throws SQLException {
        return per.consultar(codigo);
    }

    public ArrayList<Material> listar() throws SQLException {
        return per.listar();
    }
}
