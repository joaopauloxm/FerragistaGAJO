package entidade;

import java.util.Date;

public class Venda {
    private int codigo;
    private Date dataHora;
    private double valorTotal;

    public Venda(int codigo, Date dataHora, double valorTotal) {
        this.codigo = codigo;
        this.dataHora = dataHora;
        this.valorTotal = valorTotal;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    
}
