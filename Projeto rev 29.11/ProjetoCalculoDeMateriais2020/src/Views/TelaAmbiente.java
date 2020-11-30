/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import dao.mysql.AmbienteDAO;
import dao.mysql.ObjetoDAO;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.AmbienteProjeto;

/**
 *
 * @author ngarcia
 */
public class TelaAmbiente extends javax.swing.JDialog {

    private AmbienteDAO ambDAO;
    private ObjetoDAO objDAO;
    private int codigoSelecionadoAmb;
    private int codigoSelecionadoObj;
    private int codigoSelecionadoProj;

    public TelaAmbiente(java.awt.Frame parent, boolean modal, int codigoSelecionadoAmb, int codigoSelecionadoProj) {
        super(parent, modal);
        initComponents();
        objDAO = new ObjetoDAO();
        ambDAO = new AmbienteDAO();
        this.codigoSelecionadoProj = codigoSelecionadoProj;
        this.codigoSelecionadoAmb = codigoSelecionadoAmb;
        if (codigoSelecionadoAmb != 0) {
            btnObjeto.setEnabled(true);

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnObjeto = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnExcluirObjeto = new javax.swing.JButton();
        lblAmbiente = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        scrTabela = new javax.swing.JScrollPane();
        tblObjeto = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btnObjeto.setText("Novo Cadastro");
        btnObjeto.setEnabled(false);
        btnObjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObjetoActionPerformed(evt);
            }
        });

        jButton3.setText("Salvar ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnExcluirObjeto.setText("Excluir");
        btnExcluirObjeto.setEnabled(false);
        btnExcluirObjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirObjetoActionPerformed(evt);
            }
        });

        lblAmbiente.setText("Cadastro de Ambiente");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        jLabel1.setText(" Nome");

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tblObjeto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblObjeto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblObjetoMouseClicked(evt);
            }
        });
        scrTabela.setViewportView(tblObjeto);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnExcluirObjeto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                        .addComponent(btnObjeto)
                        .addGap(88, 88, 88))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNome)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(30, 30, 30)
                        .addComponent(jButton3)
                        .addGap(19, 19, 19))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAmbiente))
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(19, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAmbiente)
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(171, 171, 171)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnObjeto)
                    .addComponent(btnExcluirObjeto))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(104, 104, 104)
                    .addComponent(scrTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(56, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(416, 357));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnObjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObjetoActionPerformed
        TelaObjeto t = new TelaObjeto(null, true, codigoSelecionadoAmb);
        t.setVisible(true);
        atualizaTabelaObjeto();
    }//GEN-LAST:event_btnObjetoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        AmbienteProjeto amb = new AmbienteProjeto();

        amb.setNome(txtNome.getText());
        amb.setId_projeto(codigoSelecionadoProj);
        if (codigoSelecionadoAmb == 0) {
            ambDAO.inserir(amb);
        } else {
            amb.setId(codigoSelecionadoAmb);
            ambDAO.editar(amb);
        }

        JOptionPane.showMessageDialog(this, "Salvo com sucesso!");

        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        if (codigoSelecionadoAmb > 0) {
            AmbienteProjeto amb = ambDAO.selecionarPorCodigo(codigoSelecionadoAmb);
            txtNome.setText(amb.getNome());

        }
    }//GEN-LAST:event_formWindowActivated

    private void tblObjetoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblObjetoMouseClicked
        JTable tabela = (JTable) evt.getSource();
        int row = tabela.rowAtPoint(evt.getPoint());
        //int column = source.columnAtPoint(evt.getPoint());

        String codigo = tabela.getModel().getValueAt(row, 0) + "";

        btnExcluirObjeto.setEnabled(true);
        codigoSelecionadoObj = Integer.parseInt(codigo);
//        btnEdit.setEnabled(true);
    }//GEN-LAST:event_tblObjetoMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        atualizaTabelaObjeto();
    }//GEN-LAST:event_formWindowOpened

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void btnExcluirObjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirObjetoActionPerformed
        if (codigoSelecionadoObj != 0) {
            if (JOptionPane.showConfirmDialog(this, "Deseja excluir esse Objeto?", "Atenção",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                objDAO.excluir(codigoSelecionadoObj);
                atualizaTabelaObjeto();
                codigoSelecionadoObj = 0;
                btnExcluirObjeto.setEnabled(false);
            }
        }
    }//GEN-LAST:event_btnExcluirObjetoActionPerformed
    public void atualizaTabelaObjeto() {
        if (codigoSelecionadoAmb != 0) {
            ResultSet tbl = objDAO.selecionarTabela(codigoSelecionadoAmb);
            try {
                ResultSetMetaData metaData = tbl.getMetaData();
// names of columns
                Vector<String> columnNamesTbl = new Vector<String>();
                int columnCount = metaData.getColumnCount();
                for (int column = 1; column <= columnCount; column++) {
                    columnNamesTbl.add(metaData.getColumnName(column));
                }
// data of the table
                Vector<Vector<Object>> dataTbl = new Vector<Vector<Object>>();
                while (tbl.next()) {
                    Vector<Object> vectorTbl = new Vector<Object>();
                    for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                        vectorTbl.add(tbl.getObject(columnIndex));
                    }
                    dataTbl.add(vectorTbl);
                }
                tblObjeto.setModel(new DefaultTableModel(dataTbl, columnNamesTbl));
                int vColIndex = 0;
                tblObjeto.getColumnModel().getColumn(vColIndex).setHeaderValue("Código Objeto");
                tblObjeto.getColumnModel().getColumn(1).setHeaderValue("Nome Objeto");
                tblObjeto.getColumnModel().getColumn(2).setHeaderValue("Altura");
                tblObjeto.getColumnModel().getColumn(3).setHeaderValue("Largura");
            } catch (SQLException ex) {
                Logger.getLogger(TelaSelecionarProjeto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

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
            java.util.logging.Logger.getLogger(TelaAmbiente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAmbiente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAmbiente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAmbiente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaAmbiente dialog = new TelaAmbiente(new javax.swing.JFrame(), true, 0, 0);
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
    private javax.swing.JButton btnExcluirObjeto;
    private javax.swing.JButton btnObjeto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAmbiente;
    private javax.swing.JScrollPane scrTabela;
    private javax.swing.JTable tblObjeto;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
