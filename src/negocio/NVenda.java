package negocio;

import entidade.Venda;
import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.PVenda;

public class NVenda {

    PVenda per;

    public NVenda() {
        per = new PVenda();
    }

    public void salvar(Venda venda) throws SQLException {
        per.incluir(venda);
    }

    public Venda consultar(int codigo) throws SQLException {
        return per.consultar(codigo);
    }

    public ArrayList<Venda> listar() throws SQLException {
        return per.listar();
    }
}
