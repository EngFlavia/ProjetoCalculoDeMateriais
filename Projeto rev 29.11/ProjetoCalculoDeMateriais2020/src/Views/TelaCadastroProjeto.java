package Views;

import dao.mysql.AmbientesDAO;
import dao.mysql.ClientesDAO;
import dao.mysql.ProjetoDAO;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.Ambiente;
import models.Cliente;
import models.Projeto;
import models.TabelaBase;
import models.Usuario;

/**
 *
 * @author ngarcia
 */
public class TelaCadastroProjeto extends javax.swing.JDialog {
    private Usuario usuarioLogado = null ;
    private ClientesDAO clienteDao = null;
    private ProjetoDAO projetoDao = null;
    private AmbientesDAO ambienteDao = null;    
    private int idProjetoSelecionado;
    private int idAmbienteSelecionado;

    public TelaCadastroProjeto(java.awt.Frame parent, boolean modal, int idProjeto, Usuario usuarioLogado) {
        super(parent, modal);
        initComponents();
        
        this.usuarioLogado = usuarioLogado;
        this.clienteDao = new ClientesDAO();
        this.projetoDao = new ProjetoDAO();
        this.ambienteDao = new AmbientesDAO();
        this.setIdProjetoSelecionado(idProjeto);
        if (idProjeto != 0) {            
            btbNovoAmbiente.setEnabled(true);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        lblAmbiente1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblArt = new javax.swing.JLabel();
        txtArt = new javax.swing.JTextField();
        lblNomeProj = new javax.swing.JLabel();
        txtNomeProj = new javax.swing.JTextField();
        lblLogradouro = new javax.swing.JLabel();
        txtLogradouro = new javax.swing.JTextField();
        lblCidade = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        lblNomeCliente = new javax.swing.JLabel();
        lblAmbientes = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btbNovoAmbiente = new javax.swing.JButton();
        scrTabela = new javax.swing.JScrollPane();
        tblAmbiente = new javax.swing.JTable();
        comboCliente = new javax.swing.JComboBox<>();
        btnEditarAmbiente = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();

        jButton5.setText("Voltar");

        jButton6.setText("Novo Cadastro");

        jButton7.setText("Salvar ");

        jButton8.setText("Excluir");

        lblAmbiente1.setText("Cadastro de Ambiente");

        jLabel2.setText(" Nome");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblArt.setText("ART:");

        lblNomeProj.setText("Nome projeto:");

        lblLogradouro.setText("Endereço");

        lblCidade.setText("Cidade:");

        lblNomeCliente.setText("Nome Cliente:");

        lblAmbientes.setText("Ambientes:");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.setActionCommand("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btbNovoAmbiente.setText("Novo");
        btbNovoAmbiente.setEnabled(false);
        btbNovoAmbiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbNovoAmbienteActionPerformed(evt);
            }
        });

        tblAmbiente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblAmbiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAmbienteMouseClicked(evt);
            }
        });
        scrTabela.setViewportView(tblAmbiente);

        comboCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboClienteItemStateChanged(evt);
            }
        });
        comboCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboClienteActionPerformed(evt);
            }
        });

        btnEditarAmbiente.setText("Editar");
        btnEditarAmbiente.setEnabled(false);
        btnEditarAmbiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarAmbienteActionPerformed(evt);
            }
        });

        btnImprimir.setText("Imprimir");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCidade)
                    .addComponent(lblLogradouro)
                    .addComponent(lblArt)
                    .addComponent(lblNomeProj)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblNomeCliente)
                        .addComponent(lblAmbientes)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(scrTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnEditarAmbiente)
                                    .addGap(18, 18, 18)
                                    .addComponent(btbNovoAmbiente, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtLogradouro, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtArt, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(145, 145, 145))
                                .addComponent(txtNomeProj, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(comboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(97, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)
                        .addGap(95, 95, 95))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblArt)
                    .addComponent(txtArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeProj)
                    .addComponent(txtNomeProj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLogradouro)
                    .addComponent(txtLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCidade)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeCliente)
                    .addComponent(comboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btbNovoAmbiente)
                    .addComponent(btnEditarAmbiente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAmbientes)
                    .addComponent(scrTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalvar)
                    .addComponent(btnImprimir))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(714, 461));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void comboClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboClienteActionPerformed

    private void comboClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboClienteItemStateChanged
        Cliente cliente = (Cliente)comboCliente.getSelectedItem();
    }//GEN-LAST:event_comboClienteItemStateChanged

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       CarregarDadosProjeto();
    }//GEN-LAST:event_formWindowActivated

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        SalvarProjeto();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btbNovoAmbienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbNovoAmbienteActionPerformed
        AbrirTelaAmbienteNovo();
    }//GEN-LAST:event_btbNovoAmbienteActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        AtualizaTabelaAmbiente();
    }//GEN-LAST:event_formWindowOpened

    private void btnEditarAmbienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarAmbienteActionPerformed
        AbrirTelaAmbienteEditar();
    }//GEN-LAST:event_btnEditarAmbienteActionPerformed

    private void tblAmbienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAmbienteMouseClicked
        JTable tabela = (JTable) evt.getSource();
        int row = tabela.rowAtPoint(evt.getPoint());
        
        String codigo = tabela.getModel().getValueAt(row, 0) + "";        
        setIdAmbienteSelecionado(Integer.parseInt(codigo));
        
        btnEditarAmbiente.setEnabled(true);
    }//GEN-LAST:event_tblAmbienteMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroProjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroProjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroProjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroProjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaCadastroProjeto dialog = new TelaCadastroProjeto(new javax.swing.JFrame(), true, 0, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbNovoAmbiente;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditarAmbiente;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<Cliente> comboCliente;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblAmbiente1;
    private javax.swing.JLabel lblAmbientes;
    private javax.swing.JLabel lblArt;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblLogradouro;
    private javax.swing.JLabel lblNomeCliente;
    private javax.swing.JLabel lblNomeProj;
    private javax.swing.JScrollPane scrTabela;
    private javax.swing.JTable tblAmbiente;
    private javax.swing.JTextField txtArt;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtLogradouro;
    private javax.swing.JTextField txtNomeProj;
    // End of variables declaration//GEN-END:variables
   
    private int getIdProjetoSelecionado() {
        return this.idProjetoSelecionado;
    }
    
    private void setIdProjetoSelecionado(int idProjetoSelecionado) {
        this.idProjetoSelecionado = idProjetoSelecionado;
    }
    
    private int getIdAmbienteSelecionado() {
        return this.idAmbienteSelecionado;
    }
    
    private void setIdAmbienteSelecionado(int idAmbienteSelecionado) {
        this.idAmbienteSelecionado = idAmbienteSelecionado;
    }
    
    private void CarregarDadosProjeto(){
        if (getIdProjetoSelecionado()<= 0) {
            AtualizaCombobox();
            return;
        }
         
        Projeto projeto = projetoDao.SelecionarPorId(getIdProjetoSelecionado());
        txtArt.setText(projeto.getART());
        txtNomeProj.setText(projeto.getDescricao());
        txtLogradouro.setText(projeto.getEndereco());
        txtCidade.setText(projeto.getCidade());

        Cliente cliente = clienteDao.SelecionarPorId(projeto.getIdCliente());
        ArrayList<Cliente> listaCliente = new ArrayList<>();
        listaCliente.add(cliente);
        comboCliente.setModel(new DefaultComboBoxModel<Cliente>(listaCliente.toArray(new Cliente[listaCliente.size()])));
    }            
    
    private void SalvarProjeto()
    {        
        Cliente cliente = (Cliente) comboCliente.getSelectedItem();     
        int idCliente = cliente.getId();
        int idUsuarioLogado = usuarioLogado.getId();
        String descricao = txtNomeProj.getText();
        String art = txtArt.getText();
        String endereco = txtLogradouro.getText();
        String cidade = txtCidade.getText();
                
        Projeto projeto = new Projeto(getIdProjetoSelecionado(), idCliente,
           idUsuarioLogado, descricao, art, endereco, cidade);
          
        String ehValido = projetoDao.EhValido(projeto);
        if(!ehValido.equals(""))
        {
            JOptionPane.showMessageDialog(this, ehValido);
            return;
        }
        
        projetoDao.Salvar(projeto);        
        JOptionPane.showMessageDialog(this, "Salvo com sucesso!");
        
        dispose();
    }
    
    private void AtualizaCombobox() {
        ArrayList<Cliente> clientes = clienteDao.Selecionar();
        comboCliente.setModel(new DefaultComboBoxModel<Cliente>(clientes.toArray(new Cliente[clientes.size()])));
    }
    
    private void AtualizaTabelaAmbiente() {        
        if (getIdProjetoSelecionado() != 0) {
            ResultSet tbl = ambienteDao.SelecionarTabelaPorIdProjeto(getIdProjetoSelecionado());
            
            TabelaBase tabela = new TabelaBase(tbl);                           
            tblAmbiente.setModel(new DefaultTableModel(tabela.ObterDados(), tabela.ObterColuna()));                
            tblAmbiente.getColumnModel().getColumn(0).setHeaderValue("Código Ambiente");
            tblAmbiente.getColumnModel().getColumn(1).setHeaderValue("Nome Ambiente");
        }

    }

    private void AbrirTelaAmbienteEditar(){
        TelaAmbiente telaAmbiente = new TelaAmbiente(null, true, getIdAmbienteSelecionado(), getIdProjetoSelecionado());
        telaAmbiente.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        telaAmbiente.setVisible(true);
        
        AtualizaTabelaAmbiente();
        
        btnEditarAmbiente.setEnabled(false);
    }

    private void AbrirTelaAmbienteNovo() {
        TelaAmbiente telaAmbiente = new TelaAmbiente(null, true, 0, getIdProjetoSelecionado());
        telaAmbiente.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        telaAmbiente.setVisible(true);
        
        AtualizaTabelaAmbiente();
        
        btnEditarAmbiente.setEnabled(false);
    }
}
