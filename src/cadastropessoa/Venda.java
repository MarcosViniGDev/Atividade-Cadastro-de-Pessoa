/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastropessoa;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author marco
 */
public class Venda {
    private Integer id;
    private LocalDateTime dataVenda;
    private PessoaFisica cliente;
    private List<ItemVenda> itens = new ArrayList<>();
    
    public Venda(){
        this.id = 0;
    }
    
    public Venda(PessoaFisica cliente){
        this.id = 0;
        this.cliente = cliente;
    }
    
     public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDateTime dataVenda) {
        this.dataVenda = dataVenda;
    }

    public PessoaFisica getCliente() {
        return cliente;
    }

    public void setCliente(PessoaFisica cliente) {
        this.cliente = cliente;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }
    
    public double getTotal() {
        double total = 0;
        for (ItemVenda item : itens) {
            total += item.getSubtotal();
        }
        return total;
    }
    
     public int getQuantidadeDoProduto(Produto produto) {
        int soma = 0;
        for (ItemVenda item : itens) {
            if (item.getProduto().getId().equals(produto.getId())) {
                soma += item.getQuantidade();
            }
        }
        return soma;
    }
}
