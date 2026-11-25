package cadastropessoa;

/**
 *
 * @author ronan
 */

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.SQLException;

public class TelaCadVenda extends javax.swing.JInternalFrame {
    private TelaPrincipal telaPrincipal;
    private PessoaDAO pessoaDAO = new PessoaDAO();
    private ProdutoDAO produtoDAO = new ProdutoDAO();
    private VendaDAO vendaDAO = new VendaDAO();

    private List<PessoaFisica> listaClientes = new ArrayList<>();
    private List<Produto> listaProdutos = new ArrayList<>();

    public TelaCadVenda(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
        initComponents();
        carregarClientes();
        carregarProdutos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCliente = new javax.swing.JLabel();
        lblProduto = new javax.swing.JLabel();
        cbCliente = new javax.swing.JComboBox<>();
        cbProduto = new javax.swing.JComboBox<>();
        lblQuantidade = new javax.swing.JLabel();
        txtQuantidaade = new javax.swing.JTextField();
        lblValorUnitario = new javax.swing.JLabel();
        txtValorUnitario = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaItens = new javax.swing.JTable();
        lblTotal = new javax.swing.JLabel();
        btnFinalizar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Vendas");

        lblCliente.setText("Cliente: ");

        lblProduto.setText("Produto: ");

        cbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbClienteActionPerformed(evt);
            }
        });

        cbProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProdutoActionPerformed(evt);
            }
        });

        lblQuantidade.setText("Quantidade: ");

        txtQuantidaade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantidaadeActionPerformed(evt);
            }
        });

        lblValorUnitario.setText("Valor Unitário: ");

        txtValorUnitario.setEditable(false);
        txtValorUnitario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorUnitarioActionPerformed(evt);
            }
        });

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        tabelaItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Quantidade", "Valor Unitário", "Subtotal"
            }
        ));
        jScrollPane1.setViewportView(tabelaItens);

        lblTotal.setText("Total: R$ 0,00");

        btnFinalizar.setText("Finalizar Venda");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbCliente, 0, 430, Short.MAX_VALUE)
                            .addComponent(cbProduto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblQuantidade)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(74, 74, 74)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnAdicionar)
                                            .addComponent(txtQuantidaade, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnRemover)
                                    .addComponent(txtValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnFinalizar)
                                    .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(135, 135, 135))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQuantidaade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionar)
                    .addComponent(btnRemover))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFinalizar)
                .addGap(240, 240, 240))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbClienteActionPerformed

    private void cbProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProdutoActionPerformed
        Produto produto = (Produto) cbProduto.getSelectedItem();

        if (produto != null) {
            txtValorUnitario.setText(String.format("%.2f", produto.getPreco()));
        } else {
            txtValorUnitario.setText("");
        }
    }//GEN-LAST:event_cbProdutoActionPerformed

    private void txtQuantidaadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantidaadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantidaadeActionPerformed

    private void txtValorUnitarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorUnitarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorUnitarioActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        Produto produto = (Produto) cbProduto.getSelectedItem();

        if (produto == null) {
            JOptionPane.showMessageDialog(this, "Selecione um produto.");
            return;
        }

        int quantidade;

        try {
            quantidade = Integer.parseInt(txtQuantidaade.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Informe uma quantidade válida.");
            return;
        }

        if (quantidade <= 0) {
            JOptionPane.showMessageDialog(this, "A quantidade deve ser maior que zero.");
            return;
        }

        int quantidadeNaTabela = 0;

        for (int i = 0; i < tabelaItens.getRowCount(); i++) {
            Produto item = (Produto) tabelaItens.getValueAt(i, 0);

            if (item.getId() == produto.getId()) {
                quantidadeNaTabela += (int) tabelaItens.getValueAt(i, 1);
            }
        }

        if (quantidade + quantidadeNaTabela > produto.getEstoque()) {
            JOptionPane.showMessageDialog(this, "Estoque insuficiente.");
            return;
        }

        double preco = produto.getPreco();
        double subtotal = quantidade * preco;

        ((javax.swing.table.DefaultTableModel) tabelaItens.getModel()).addRow(
            new Object[]{produto, quantidade, preco, subtotal}
        );

        atualizarTotal();
        txtQuantidaade.setText("");
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        int linha = tabelaItens.getSelectedRow();

        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um produto na tabela.");
            return;
        }

        ((javax.swing.table.DefaultTableModel) tabelaItens.getModel()).removeRow(linha);

        atualizarTotal();
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        PessoaFisica cliente = (PessoaFisica) cbCliente.getSelectedItem();

    if (cliente == null) {
        JOptionPane.showMessageDialog(this, "Selecione um cliente.");
        return;
    }

    if (tabelaItens.getRowCount() == 0) {
        JOptionPane.showMessageDialog(this, "Adicione pelo menos um produto.");
        return;
    }

    Venda venda = new Venda(cliente);

    for (int i = 0; i < tabelaItens.getRowCount(); i++) {
        Produto produto = (Produto) tabelaItens.getValueAt(i, 0);
        int quantidade = ((Number) tabelaItens.getValueAt(i, 1)).intValue();
        double valor = ((Number) tabelaItens.getValueAt(i, 2)).doubleValue();

        venda.getItens().add(new ItemVenda(produto, quantidade, valor));
    }

    try {
        vendaDAO.inserir(venda);

        JOptionPane.showMessageDialog(this, "Venda realizada com sucesso!");

        while (tabelaItens.getRowCount() > 0) {
            ((javax.swing.table.DefaultTableModel) tabelaItens.getModel()).removeRow(0);
        }

        atualizarTotal();
        carregarProdutos();
        txtQuantidaade.setText("");
        txtValorUnitario.setText("");

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this,
                "Erro ao finalizar venda:\n" + ex.getMessage());
    }
    }//GEN-LAST:event_btnFinalizarActionPerformed
    
    private void carregarClientes() {
    listaClientes.clear();
    cbCliente.removeAllItems();

    for (Pessoa pessoa : pessoaDAO.listar()) {
        if (pessoa instanceof PessoaFisica) {
            PessoaFisica cliente = (PessoaFisica) pessoa;
            listaClientes.add(cliente);
            cbCliente.addItem(cliente);
        }
    }
    }

    private void carregarProdutos() {
        listaProdutos.clear();
        cbProduto.removeAllItems();

        listaProdutos.addAll(produtoDAO.listar());

        for (Produto produto : listaProdutos) {
            cbProduto.addItem(produto);
        }
    }
    
    private void atualizarTotal() {
    double total = 0;

    for (int i = 0; i < tabelaItens.getRowCount(); i++) {
        total += (double) tabelaItens.getValueAt(i, 3);
    }

    lblTotal.setText(String.format("Total: R$ %.2f", total));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JComboBox<PessoaFisica> cbCliente;
    private javax.swing.JComboBox<Produto> cbProduto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblProduto;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblValorUnitario;
    private javax.swing.JTable tabelaItens;
    private javax.swing.JTextField txtQuantidaade;
    private javax.swing.JTextField txtValorUnitario;
    // End of variables declaration//GEN-END:variables
}
