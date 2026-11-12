/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastropessoa;

/**
 *
 * @author Professor
 */
public class PessoaJuridica extends Pessoa{
    //Argumento
    private String cnpj;
    private String nomeFantasia;
    
    //construtor
    public PessoaJuridica(String nome, String endereco, 
            String email, String cnpj, String nomeFantasia){
        super(nome, endereco, email);
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
    }
    
    //getters setters
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String getDocumento() {
        return "CNPJ: " + this.cnpj;
    }

    @Override
    public String getTipoPessoa() {
        return "Pessoa Jurídica";
    }
    
    @Override
    public String getNomeFantasia(){
        return this.nomeFantasia;
    }
 
    
    
}
