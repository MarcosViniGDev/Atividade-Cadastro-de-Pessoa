/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package cadastropessoa;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Augusto
 * @email augustogbarbieri05@gmail.com
 */
public class TelaCadProduto extends javax.swing.JInternalFrame {

    private final TelaPrincipal telaPrincipal;
    private final ProdutoDAO produtoDAO = new ProdutoDAO();
    private List<Produto> listaProdutos = new ArrayList<>();
    private int posicao = -1;

    public TelaCadProduto(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
        this.posicao = -1;
        initComponents();
        carregarFornecedores();
        carregarListaProdutos();
    }

    @SuppressWarnings("unchecked")
                              
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtPreco = new javax.swing.JTextField();
        txtEstoque = new javax.swing.JTextField();
        cbFornecedor = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Cadastro de Produto");

        jLabel1.setText("Nome:");

        jLabel2.setText("Preço:");

        jLabel3.setText("Estoque:");

        jLabel4.setText("Fornecedor:");

        jButton1.setText("Gravar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Listar Produtos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("◀");
        jButton3.setToolTipText("Navegar para o produto à esquerda");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("▶");
        jButton4.setToolTipText("Navegar para o produto à direita");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Excluir produto");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
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
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jButton3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtNome)
                            .addComponent(txtPreco)
                            .addComponent(txtEstoque)
                            .addComponent(cbFornecedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton4))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        pack();
    }                     

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        if (!camposPreenchidos()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente!");
            return;
        }

        try {
            String nome = txtNome.getText().trim();
            double preco = Double.parseDouble(txtPreco.getText().trim().replace(",", "."));
            int estoque = Integer.parseInt(txtEstoque.getText().trim());
            PessoaJuridica fornecedor = (PessoaJuridica) cbFornecedor.getSelectedItem();

            Produto produto = new Produto(nome, preco, estoque, fornecedor);
            String mensagem;

            if (posicao == -1) {
                if (!produtoDAO.inserir(produto)) {
                    return;
                }
                mensagem = "Produto cadastrado com sucesso!";
            } else {
                Produto atual = listaProdutos.get(posicao);
                produto.setId(atual.getId());
                if (!produtoDAO.atualizar(produto)) {
                    JOptionPane.showMessageDialog(null, "Não foi possível atualizar o produto.");
                    return;
                }
                mensagem = "Produto atualizado com sucesso!";
            }

            carregarListaProdutos();
            limparTela();
            posicao = -1;
            JOptionPane.showMessageDialog(null, mensagem);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Preço ou estoque inválido!");
        }
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        listarProdutos();
    }                                        

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        carregarListaProdutos();
        posicao++;
        if (posicao < listaProdutos.size()) {
            exibirProduto(listaProdutos.get(posicao));
        } else {
            JOptionPane.showMessageDialog(null, "Não existem mais produtos no cadastro");
            posicao = -1;
            limparTela();
        }
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        carregarListaProdutos();
        posicao--;
        if (posicao > -1 && posicao < listaProdutos.size()) {
            exibirProduto(listaProdutos.get(posicao));
        } else {
            JOptionPane.showMessageDialog(null, "Não existem mais produtos no cadastro");
            posicao = -1;
            limparTela();
        }
    }                                        

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        if (posicao == -1 || posicao >= listaProdutos.size()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Nenhum produto está sendo exibido para excluir!"
            );
            return;
        }

        int resposta = JOptionPane.showConfirmDialog(
                null,
                "Deseja realmente excluir este produto?",
                "Confirmar exclusão",
                JOptionPane.YES_NO_OPTION
        );

        if (resposta == JOptionPane.YES_OPTION) {
            Produto produto = listaProdutos.get(posicao);
            if (produtoDAO.excluir(produto)) {
                carregarListaProdutos();
                limparTela();
                posicao = -1;
                JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!");
            }
        }
    }                                        

                         
    private javax.swing.JComboBox<PessoaJuridica> cbFornecedor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtEstoque;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPreco;
                       

    private void carregarListaProdutos() {
        listaProdutos = produtoDAO.listar();
    }

    private void carregarFornecedores() {
        cbFornecedor.removeAllItems();
        if (telaPrincipal != null && telaPrincipal.getListaPessoa() != null) {
            for (Pessoa p : telaPrincipal.getListaPessoa()) {
                if (p instanceof PessoaJuridica) {
                    cbFornecedor.addItem((PessoaJuridica) p);
                }
            }
        }
    }

    private void exibirProduto(Produto produto) {
        txtNome.setText(produto.getNome());
        txtPreco.setText(String.valueOf(produto.getPreco()));
        txtEstoque.setText(String.valueOf(produto.getEstoque()));

        if (produto.getFornecedor() != null) {
            for (int i = 0; i < cbFornecedor.getItemCount(); i++) {
                PessoaJuridica item = cbFornecedor.getItemAt(i);
                if (item.getId() == produto.getFornecedor().getId()) {
                    cbFornecedor.setSelectedIndex(i);
                    break;
                }
            }
        }
    }

    private void limparTela() {
        txtNome.setText("");
        txtPreco.setText("");
        txtEstoque.setText("");
        if (cbFornecedor.getItemCount() > 0) {
            cbFornecedor.setSelectedIndex(0);
        }
        txtNome.requestFocusInWindow();
    }

    private void listarProdutos() {
        carregarListaProdutos();
        StringBuilder sb = new StringBuilder();
        for (Produto p : listaProdutos) {
            sb.append(p.toString()).append("\n -------- \n");
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(null, sb.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado.");
        }
    }

    private boolean camposPreenchidos() {
        if (txtNome.getText().trim().isEmpty()) {
            return false;
        }
        if (txtPreco.getText().trim().isEmpty()) {
            return false;
        }
        if (txtEstoque.getText().trim().isEmpty()) {
            return false;
        }
        return cbFornecedor.getSelectedItem() != null;
    }
}