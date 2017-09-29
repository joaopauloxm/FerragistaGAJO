package entidade;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Venda {
    private int codigo;
    private Date dataHora;
    private double valorTotal;
    private ArrayList<Material> materiais;
    
    public Venda() { }

    public Venda(int codigo, Date dataHora, double valorTotal, ArrayList<Material> materiais) {
        this.codigo = codigo;
        this.dataHora = dataHora;
        this.valorTotal = valorTotal;
        this.materiais = materiais;
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

    public ArrayList<Material> getMateriais() {
        return materiais;
    }

    public void setMateriais(ArrayList<Material> materiais) {
        this.materiais = materiais;
    }
}
