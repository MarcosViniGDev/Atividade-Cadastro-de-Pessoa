/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastropessoa;

/**
 *
 * @author marco
 */
public class Produto {
    private Integer id;
    private String nome;
    private double preco;
    private int estoque;
    private PessoaJuridica fornecedor;
    
    public Produto(String nome, double preco, int estoque, PessoaJuridica fornecedor) {
        
        this.id = 0;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.fornecedor = fornecedor;
    }
    public Produto() {
        this.id = 0;
    }
    
     public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public PessoaJuridica getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(PessoaJuridica fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    @Override
    public String toString(){
        return nome;
    }
    
    
    
    
    
}
