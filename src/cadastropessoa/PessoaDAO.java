/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastropessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Professor
 */
public class PessoaDAO {
    
    // Função de inserir registro no BD
    public boolean inserir(Pessoa p){
        String sql = "INSERT INTO pessoa(nome, endereco, email) " +
                     "VALUES(?,?,?)";
        boolean resposta = false;
        try{
            Connection con = Conexao.getConexao();
            //1o gravar Pessoa, depois ver se é PJ ou PF e gravar
            PreparedStatement ps = con.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            //Agora inserir os parâmetros
            ps.setString(1, p.getNome());
            ps.setString(2, p.getEndereco());
            ps.setString(3, p.getEmail());
            ps.executeUpdate();
            ResultSet result = ps.getGeneratedKeys(); //retorna a chave primária
            result.next();
            // coloco no objeto 'p' o ID que foi criado no insert do BD
            p.setId(result.getInt(1)); 
            //Agorar gravar PF ou PJ
            if(p instanceof PessoaFisica){
                sql = "INSERT INTO pessoa_fisica(pessoa_id, cpf) " + 
                      "VALUES(?,?)";
                ps = con.prepareStatement(sql);
                //parâmetros:
                ps.setInt(1, p.getId());
                // o 'p' é por natureza somente Pessoa, mas por
                //  conta do Polimorfismo, ele tem os dados da PessoaFisica.
                //  Para acessar o campo da PessoaFisica, faço um processo
                //  chamado 'cast' que é 'conversão' de Pessoa para PessoaFisica
                ps.setString(2, ((PessoaFisica) p).getCpf());
            }else{
                sql = "INSERT INTO pessoa_juridica(pessoa_id, cnpj," + 
                        "nome_fantasia) VALUES(?,?,?)";
                ps = con.prepareStatement(sql);
                //parametros
                ps.setInt(1, p.getId());
                ps.setString(2, ((PessoaJuridica) p).getCnpj());
                ps.setString(3, ((PessoaJuridica) p).getNomeFantasia());                
            }
            ps.executeUpdate();            
            resposta = true;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, 
                    "Erro ao inserir: " + ex.getMessage());
            resposta = false;
        }
        return resposta;
    }
    
    //Função para atualizar uma pessoa
    public boolean atualizar(Pessoa p){
        String sql = "UPDATE pessoa SET " +
                     "nome = ?, " + 
                     "endereco = ?, " + 
                     "email = ? WHERE id = ?";        
        boolean resposta = false;
        try{
            Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(sql);
            //Parametros:
            ps.setString(1, p.getNome());
            ps.setString(2, p.getEndereco());
            ps.setString(3, p.getEmail());
            ps.setInt(4, p.getId());
            ps.executeUpdate();
            if(p instanceof PessoaFisica){
                sql = "UPDATE pessoa_fisica SET cpf = ? WHERE pessoa_id = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, ((PessoaFisica) p).getCpf());
                ps.setInt(2, p.getId());
            }else{
                sql = "UPDATE pessoa_juridica SET cnpj = ?, nome_fantasia = ? "
                        + "WHERE pessoa_id = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, ((PessoaJuridica) p).getCnpj());
                ps.setString(2, ((PessoaJuridica) p).getNomeFantasia());
                ps.setInt(3, p.getId());
            }
            ps.executeUpdate();
            resposta = true;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, 
                    "Erro ao atualizar: " + ex.getMessage());
            resposta = false;
        }        
        return resposta;
    }
    
    //Função para excluir uma pessoa
    public boolean excluir(Pessoa p){
        String sql = "DELETE FROM pessoa WHERE id = ?";
        boolean resposta = false;
        try{
            Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, p.getId());
            ps.executeUpdate();
            resposta = true;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, 
                    "Erro ao deletar: " + ex.getMessage());
            resposta = false;
        }
        return resposta;
    }
    
    // Função para listar todas as pessoas do 
    // banco de dados
    public List<Pessoa> listar(){
        String sql = "SELECT " +
                     " p.*, pf.cpf, pj.cnpj, pj.nome_fantasia " +
                     "FROM pessoa p " +
                     " LEFT JOIN pessoa_fisica pf " +
                     "	ON p.id = pf.pessoa_id " +
                     " LEFT JOIN pessoa_juridica pj " +
                     "    ON p.id = pj.pessoa_id " +
                     "ORDER BY p.id;";
        List<Pessoa> listaPessoa = new ArrayList<>();
        try{
            Connection con = Conexao.getConexao(); //Conecto no BD
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Pessoa pessoa;
                //verificar se a linha é PF ou PJ
                if(rs.getString("cpf") != null){
                    //PF
                    pessoa = new PessoaFisica(
                            rs.getString("nome"),
                            rs.getString("endereco"),
                            rs.getString("email"),
                            rs.getString("cpf")
                    );
                }else{
                    //PJ
                    pessoa = new PessoaJuridica(
                            rs.getString("nome"),
                            rs.getString("endereco"),
                            rs.getString("email"),
                            rs.getString("cnpj"),
                            rs.getString("nome_fantasia")
                    );
                }
                pessoa.setId(rs.getInt("id")); //chave primária
                listaPessoa.add(pessoa); //adicionei a pessoa na lista
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, 
                    "Erro ao buscar Lista de Pessoas.\n" + ex.getMessage());
        }        
        return listaPessoa;
    }
    
}
