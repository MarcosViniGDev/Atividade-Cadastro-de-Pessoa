/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastropessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brunim
 */
public class ProdutoDAO {
    public boolean inserir(Produto p){
    String sql = "INSERT INTO produto (nome, preco, estoque, fornecedor_id) "
               + "VALUES (?, ?, ?, ?)";
    try (Connection con = Conexao.getConexao()) {
        if (con == null) {
            return false;
        }
        try (PreparedStatement ps = con.prepareStatement(
                sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, p.getNome());
            ps.setDouble(2, p.getPreco());
            ps.setInt(3, p.getEstoque());
            ps.setInt(4, p.getFornecedor().getId());
            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        p.setId(rs.getInt(1));
                    }
                }
                return true;
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(
                null,
                "Erro ao inserir produto: " + ex.getMessage()
        );
    }
    return false;
}
    
    public List<Produto> listar(){
    String sql = "SELECT "
            + "pr.id AS produto_id, "
            + "pr.nome AS produto_nome, "
            + "pr.preco, "
            + "pr.estoque, "
            + "pr.fornecedor_id, "
            + "p.nome AS fornecedor_nome, "
            + "p.endereco, "
            + "p.email, "
            + "pj.cnpj, "
            + "pj.nome_fantasia "
            + "FROM produto pr "
            + "INNER JOIN pessoa_juridica pj "
            + "ON pr.fornecedor_id = pj.pessoa_id "
            + "INNER JOIN pessoa p "
            + "ON pj.pessoa_id = p.id "
            + "ORDER BY pr.id";

    List<Produto> listaProdutos = new ArrayList<>();

    try (Connection con = Conexao.getConexao()) {

        if (con == null) {
            return listaProdutos;
        }

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                // Reconstruindo o objeto PessoaJuridica
                PessoaJuridica fornecedor = new PessoaJuridica(
                        rs.getString("fornecedor_nome"),
                        rs.getString("endereco"),
                        rs.getString("email"),
                        rs.getString("cnpj"),
                        rs.getString("nome_fantasia")
                );

                fornecedor.setId(rs.getInt("fornecedor_id"));
                // Criando o objeto Produto
                Produto produto = new Produto(
                        rs.getString("produto_nome"),
                        rs.getDouble("preco"),
                        rs.getInt("estoque"),
                        fornecedor
                );
                produto.setId(rs.getInt("produto_id"));
                listaProdutos.add(produto);
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(
                null,
                "Erro ao buscar lista de produtos: " + ex.getMessage()
        );
    }
    return listaProdutos;
}   
    
    public boolean atualizar(Produto p) {
    String sql = "UPDATE produto SET "
            + "nome = ?, "
            + "preco = ?, "
            + "estoque = ?, "
            + "fornecedor_id = ? "
            + "WHERE id = ?";
    try (Connection con = Conexao.getConexao()) {
        if (con == null) {
            return false;
        }
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getNome());
            ps.setDouble(2, p.getPreco());
            ps.setInt(3, p.getEstoque());
            ps.setInt(4, p.getFornecedor().getId());
            ps.setInt(5, p.getId());
            int linhasAfetadas = ps.executeUpdate();
            return linhasAfetadas > 0;
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(
                null,
                "Erro ao atualizar produto: " + ex.getMessage()
        );
    }
    return false;
}
    
    public boolean excluir(Produto p) {
    String sql = "DELETE FROM produto WHERE id = ?";
    try (Connection con = Conexao.getConexao()) {
        if (con == null) {
            return false;
        }
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, p.getId());
            int linhasAfetadas = ps.executeUpdate();
            return linhasAfetadas > 0;
        }
    } catch (SQLException ex) {
        if ("23000".equals(ex.getSQLState())) {
            JOptionPane.showMessageDialog(
                    null,
                    "Não foi possível excluir este produto, "
                    + "pois ele está associado a uma venda."
            );
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao excluir produto: " + ex.getMessage()
            );
        }
    }
    return false;
}
}
