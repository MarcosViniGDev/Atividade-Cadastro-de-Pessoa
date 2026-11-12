/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastropessoa;

/**
 *
 * @author Professor
 */
public abstract class Pessoa {
    private String nome;
    private String endereco;
    private String email;
    private Integer id;

    public Pessoa(String nome, String endereco, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.id = 0;
    }
    //criando construtor vazio
    public Pessoa(){}

    public Integer getId(){
        return this.id;
    }
    public void setId(Integer id){
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public abstract String getDocumento();
    public abstract String getTipoPessoa();
    public abstract String getNomeFantasia();

    @Override
    public String toString() {
        return "Tipo: "      + getTipoPessoa() + "\n" +
               "Nome: "      + this.nome       + "\n" +
               (getTipoPessoa().equals("Pessoa Jurídica") ? "Nome fantasia: " + getNomeFantasia() + "\n" : "") +
               "Endereço: "  + this.endereco   + "\n" +
               "E-mail: "    + this.email      + "\n" +
               "Documento: " + getDocumento();
    }
    
    
    
    
}
