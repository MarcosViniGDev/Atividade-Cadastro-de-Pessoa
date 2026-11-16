/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastropessoa;

/**
 *
 * @author marco
 */
public class ItemVenda {
    private Integer id;
    private Produto produto;
    private int quantidade;
    private double valorUnitario;
    
    public ItemVenda(){
        this.id = 0;
    }
    
    public ItemVenda(Produto produto, int quantidade, double valorUnitario) {
        this.id = 0;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    
    public double getSubtotal() {
        return quantidade * valorUnitario;
    }
    
}
