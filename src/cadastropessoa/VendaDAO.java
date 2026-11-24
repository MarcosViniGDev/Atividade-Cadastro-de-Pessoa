package cadastropessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {

    private static final String INSERIR_VENDA =
            "INSERT INTO venda (data_venda, cliente_id) VALUES (?, ?)";
    private static final String INSERIR_ITEM =
            "INSERT INTO item_venda (venda_id, produto_id, quantidade, valor_unitario) "
            + "VALUES (?, ?, ?, ?)";
    private static final String BAIXAR_ESTOQUE =
            "UPDATE produto SET estoque = estoque - ? WHERE id = ? AND estoque >= ?";

    /** Grava a venda e informa à tela, por SQLException, qualquer falha. */
    public void inserir(Venda venda) throws SQLException {
        validarVenda(venda);

        LocalDateTime dataVenda = venda.getDataVenda();
        if (dataVenda == null) {
            dataVenda = LocalDateTime.now();
        }
        dataVenda = dataVenda.withNano(0);

        List<Integer> idsItens = new ArrayList<>();
        try (Connection con = Conexao.getConexao()) {
            if (con == null) {
                throw new SQLException("Não foi possível conectar ao banco para gravar a venda.");
            }

            con.setAutoCommit(false);
            int idVenda;
            try {
                idVenda = gravarVenda(con, venda, dataVenda);

                try (PreparedStatement baixarEstoque = con.prepareStatement(BAIXAR_ESTOQUE);
                     PreparedStatement inserirItem = con.prepareStatement(
                             INSERIR_ITEM, Statement.RETURN_GENERATED_KEYS)) {
                    for (ItemVenda item : venda.getItens()) {
                        Produto produto = item.getProduto();
                        int quantidade = item.getQuantidade();

                        // A baixa só acontece se ainda houver saldo no momento da gravação.
                        baixarEstoque.setInt(1, quantidade);
                        baixarEstoque.setInt(2, produto.getId());
                        baixarEstoque.setInt(3, quantidade);
                        if (baixarEstoque.executeUpdate() == 0) {
                            throw new SQLException("Estoque insuficiente para o produto: "
                                    + produto.getNome() + ".");
                        }

                        inserirItem.setInt(1, idVenda);
                        inserirItem.setInt(2, produto.getId());
                        inserirItem.setInt(3, quantidade);
                        inserirItem.setDouble(4, item.getValorUnitario());
                        inserirItem.executeUpdate();
                        idsItens.add(obterIdGerado(inserirItem));
                    }
                }

                con.commit();
            } catch (SQLException | RuntimeException ex) {
                try {
                    con.rollback();
                } catch (SQLException erroRollback) {
                    ex.addSuppressed(erroRollback);
                }
                throw ex;
            }

            venda.setId(idVenda);
            venda.setDataVenda(dataVenda);
            for (int i = 0; i < idsItens.size(); i++) {
                venda.getItens().get(i).setId(idsItens.get(i));
            }
        }
    }

    private int gravarVenda(Connection con, Venda venda, LocalDateTime dataVenda)
            throws SQLException {
        try (PreparedStatement ps = con.prepareStatement(
                INSERIR_VENDA, Statement.RETURN_GENERATED_KEYS)) {
            ps.setTimestamp(1, Timestamp.valueOf(dataVenda));
            ps.setInt(2, venda.getCliente().getId());
            ps.executeUpdate();
            return obterIdGerado(ps);
        }
    }

    private int obterIdGerado(PreparedStatement ps) throws SQLException {
        try (ResultSet rs = ps.getGeneratedKeys()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        throw new SQLException("O banco não retornou o ID do registro inserido.");
    }

    private void validarVenda(Venda venda) throws SQLException {
        if (venda == null || venda.getCliente() == null
                || venda.getCliente().getId() == null || venda.getCliente().getId() <= 0) {
            throw new SQLException("Selecione um cliente cadastrado para a venda.");
        }
        if (venda.getId() != null && venda.getId() > 0) {
            throw new SQLException("Esta venda já foi gravada.");
        }
        if (venda.getItens() == null || venda.getItens().isEmpty()) {
            throw new SQLException("Adicione pelo menos um item à venda.");
        }
        for (ItemVenda item : venda.getItens()) {
            if (item == null || item.getProduto() == null || item.getProduto().getId() == null
                    || item.getProduto().getId() <= 0) {
                throw new SQLException("Selecione um produto cadastrado para cada item.");
            }
            if (item.getQuantidade() <= 0) {
                throw new SQLException("A quantidade do item deve ser maior que zero.");
            }
            if (!Double.isFinite(item.getValorUnitario()) || item.getValorUnitario() < 0) {
                throw new SQLException("Informe um valor unitário válido para cada item.");
            }
        }
    }
}
