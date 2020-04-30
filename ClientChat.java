
package com.mycompany.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class ClientChat extends javax.swing.JFrame {
static Socket sk;
    static DataInputStream diss;
    static DataOutputStream doss;
    public ClientChat() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_send2 = new javax.swing.JTextField();
        msg_send2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        msg_area2 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txt_send2.setFont(new java.awt.Font("Lato", 0, 11)); // NOI18N

        msg_send2.setBackground(new java.awt.Color(255, 255, 255));
        msg_send2.setText("Send");
        msg_send2.setActionCommand("");
        msg_send2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msg_send2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lato", 1, 11)); // NOI18N
        jLabel1.setText("Client");

        msg_area2.setEditable(false);
        msg_area2.setColumns(20);
        msg_area2.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        msg_area2.setRows(5);
        jScrollPane1.setViewportView(msg_area2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_send2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(msg_send2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(msg_send2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_send2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void msg_send2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msg_send2ActionPerformed

        try {

            String msgout="";
            msgout=txt_send2.getText().trim();
            doss.writeUTF(msgout);
            doss.flush();
            msg_area2.setText(msg_area2.getText().trim()+"\n Client:"+msgout);

        } catch (IOException ex) {
           
        }
    }//GEN-LAST:event_msg_send2ActionPerformed

 
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientChat().setVisible(true);
            }
        });
        try{
           
            sk=new Socket("192.168.43.245",9966);
            
            diss=new DataInputStream(sk.getInputStream());
            doss=new DataOutputStream(sk.getOutputStream());
            String msgin="";
            while(!msgin.equals("bye")){
                msgin=diss.readUTF();
                msg_area2.setText(msg_area2.getText().trim()+"\n Server:"+msgin);
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextArea msg_area2;
    private javax.swing.JButton msg_send2;
    private javax.swing.JTextField txt_send2;
    // End of variables declaration//GEN-END:variables
}
