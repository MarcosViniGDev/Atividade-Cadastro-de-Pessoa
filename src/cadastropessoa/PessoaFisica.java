/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastropessoa;

/**
 *
 * @author Professor
 */
public class PessoaFisica extends Pessoa {
    //Argumento
    private String cpf;
    
    //construtor
    public PessoaFisica(String nome, String endereco, String email, String cpf){
        super(nome, endereco, email);
        this.cpf = cpf;
    }
    
    //getters setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String getDocumento() {
        return "CPF: " + this.cpf;
    }

    @Override
    public String getTipoPessoa() {
        return "Pessoa Física";
    }

    @Override
    public String getNomeFantasia() {
        return "";
    }
    
    
    
    
    
    
}
