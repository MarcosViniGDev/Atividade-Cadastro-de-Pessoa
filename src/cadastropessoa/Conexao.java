/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastropessoa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Professor
 */
public class Conexao {
    private static final String URL  = "jdbc:mysql://localhost:3306/cadastro_pessoa";
    private static final String USER = "root"; //usuário
    private static final String PASS = ""; //senha
    
    public static Connection getConexao() {
        //Tratador de erro
        try{
            //tentar
            return DriverManager.getConnection(URL,USER, PASS);
        }catch(SQLException ex){
            //capturar o erro
            JOptionPane.showMessageDialog(null, 
                    "Não consegui conectar!");
            return null;
        }
    }

    //cria a base de dados a partir do banco_dados.sql, caso ela ainda não exista
    public static void criarBaseDados() {
        //conecta no servidor, sem escolher a base (ela pode não existir)
        //allowMultiQueries permite executar o arquivo .sql inteiro de uma vez
        String urlServidor = "jdbc:mysql://localhost:3306/?allowMultiQueries=true";
        try(Connection con = DriverManager.getConnection(urlServidor, USER, PASS);
            Statement st = con.createStatement()){
            ResultSet rs = st.executeQuery("SHOW DATABASES LIKE 'cadastro_pessoa'");
            if(rs.next()){
                return; //a base já existe, não faz nada
            }
            //o arquivo fica na pasta do projeto (pasta onde o NetBeans roda o sistema)
            String script = Files.readString(Paths.get("banco_dados.sql"));
            st.execute(script);
            JOptionPane.showMessageDialog(null,
                    "Base de dados criada com sucesso!");
        }catch(SQLException | IOException ex){
            JOptionPane.showMessageDialog(null,
                    "Erro ao criar a base de dados.\n" + ex.getMessage());
        }
    }

}

   