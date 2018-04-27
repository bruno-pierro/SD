/*Criado por
  André Barbosa Oliveira RA:20166152
  Bruno Campos de Pierro RA:20899009
  Luiz Herculino RA:20149622
  Raphael Ferrarese RA:21010723

*/
package sistemanotas;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class cliente extends javax.swing.JFrame {

    public cliente() {
        initComponents();
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtRa = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtTel = new javax.swing.JTextField();
        btInserir = new javax.swing.JButton();
        btConsulta = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("RA");

        jLabel2.setText("NOME");

        jLabel3.setText("TELEFONE");

        txtTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelActionPerformed(evt);
            }
        });

        btInserir.setText("Inserir");
        btInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInserirActionPerformed(evt);
            }
        });

        btConsulta.setText("Consultar");
        btConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultaActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNome)
                            .addComponent(txtTel, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(txtRa, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(btInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btConsulta)))
                .addGap(62, 62, 62)
                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtRa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btInserir)
                    .addComponent(btConsulta)
                    .addComponent(btExcluir))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelActionPerformed
        
        
        
    }//GEN-LAST:event_txtTelActionPerformed

    private void btInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInserirActionPerformed
        Socket server;
        aluno a1;
        ObjectOutputStream out;
        ObjectInputStream in;
        
        String nome;
        String telefone;
        long ra;
        
        
        //PEGANDO OS DADOS DA INTERFACE
        nome = txtNome.getText();
        ra = Long.parseLong(txtRa.getText());
        telefone = txtTel.getText();
        int op = 1;
        aluno a = new aluno(ra, nome,telefone,op);
        
        try {
            server = new Socket("127.0.0.1",9600);
            
            out = new ObjectOutputStream(server.getOutputStream());
            out.writeObject(a);
            in = new ObjectInputStream(server.getInputStream()); 
            a1 = (aluno) in.readObject();
                
            
            
            server.close();
         
            txtNome.setText("");
            txtRa.setText("");
            txtTel.setText("");
            
            
            
        } catch (Exception e) {
            
            System.out.println("ErroCliente: "+e.getMessage());
        }
    }//GEN-LAST:event_btInserirActionPerformed

    private void btConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultaActionPerformed
        Socket server;
        aluno a1;
        ObjectOutputStream out;
        ObjectInputStream in;
        
        String nome;
        String telefone;
        long ra;
        
        
        //PEGANDO OS DADOS DA INTERFACE
        nome = txtNome.getText();
        ra = Long.parseLong(txtRa.getText());
        telefone = txtTel.getText();
        int op = 2;
        aluno a = new aluno(ra, nome,telefone,op);
        
        try {
            server = new Socket("127.0.0.1",9600);
            
            out = new ObjectOutputStream(server.getOutputStream());
            out.writeObject(a);
            in = new ObjectInputStream(server.getInputStream()); 
            a1 = (aluno) in.readObject();
                
            
            //System.out.println("Voltou "+a1.getNome());
            
            server.close();
         
            txtNome.setText("");
            txtRa.setText("");
            txtTel.setText("");
            
            
            
        } catch (Exception e) {
            
            System.out.println("ErroCliente: "+e.getMessage());
        }
    }//GEN-LAST:event_btConsultaActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
         Socket server;
        aluno a1;
        ObjectOutputStream out;
        ObjectInputStream in;
        
        String nome;
        String telefone;
        long ra;
        
        
        //PEGANDO OS DADOS DA INTERFACE
        nome = txtNome.getText();
        ra = Long.parseLong(txtRa.getText());
        telefone = txtTel.getText();
        int op = 3;
        aluno a = new aluno(ra, nome,telefone,op);
        
        try {
            server = new Socket("127.0.0.1",9600);
            
            out = new ObjectOutputStream(server.getOutputStream());
            out.writeObject(a);
            in = new ObjectInputStream(server.getInputStream()); 
            a1 = (aluno) in.readObject();
                
            
            //System.out.println("Voltou "+a1.getNome());
            txtNome.setText("");
            txtRa.setText("");
            txtTel.setText("");
            
            server.close();
         
            
            
            
            
        } catch (Exception e) {
            
            System.out.println("ErroCliente: "+e.getMessage());
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    public static void main(String args[]) {
       
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConsulta;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btInserir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtRa;
    private javax.swing.JTextField txtTel;
    // End of variables declaration//GEN-END:variables
}
