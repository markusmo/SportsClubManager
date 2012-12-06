/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javamessagingclient;

import javamessagingclient.controller.DeleteMemberFromClubTeam;
import javamessaging.stubs.*;
import javamessaging.contract.*;
import java.util.*;
import java.util.logging.*;
import javax.jms.*;
import javax.swing.event.*;
import javax.swing.table.*;

/**
 @author Thomas
 */
public class MatchSubscriberForm
        extends javax.swing.JFrame
        implements MessageListener, ExceptionListener
{
    private IMatchMessage selectedMessage = null;
    private List<IMatchMessage> messages = new LinkedList<IMatchMessage>();
    private DeleteMemberFromClubTeam controller = new DeleteMemberFromClubTeam();
    private IMemberDto member;
    private MatchSubscriberJms subscriberJms;

    /**
     Creates new form MatchSubscriberForm
     */
    public MatchSubscriberForm(IMemberDto member)
    {
        initComponents();

        this.member = member;

        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                int selectedMessageId = jTable1.getSelectedRow();

                jButton1.setEnabled(selectedMessageId != -1);
                jButton2.setEnabled(selectedMessageId != -1);

                if (selectedMessageId == -1)
                {
                    return;
                }

                selectedMessage = messages.get(selectedMessageId);
            }
        });

        subscriberJms = new MatchSubscriberJms(member);
        subscriberJms.read(this, this);
    }

    /**
     This method is called from within the constructor to
     initialize the form.
     WARNING: Do NOT modify this code. The content of this method is
     always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Mannschaft", "Wettbewerb"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jButton1.setText("Ja");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Nein");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Update");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(307, 307, 307)
                .addComponent(jButton1)
                .addGap(39, 39, 39)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 254, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(308, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(53, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        writeToDatabase(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
    {//GEN-HEADEREND:event_jButton2ActionPerformed
        writeToDatabase(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton3ActionPerformed
    {//GEN-HEADEREND:event_jButton3ActionPerformed
        messages.clear();
        jTable1.removeAll();
        subscriberJms.read(this, this);
    }//GEN-LAST:event_jButton3ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onMessage(Message message)
    {
        try
        {
            ObjectMessage om = (ObjectMessage) message;
            Object o = om.getObject();
            IMatchMessage msg = (IMatchMessage) o;

            if (!member.getUsername().equals(msg.getMember().getUsername()))
            {
                return;
            }
            messages.add(msg);
            updateTable();
        }
        catch (JMSException ex)
        {
            Logger.getLogger(MatchSubscriberForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void onException(JMSException exception)
    {
        System.err.println("something bad happended: " + exception);
    }

    private void writeToDatabase(boolean b)
    {
        int selectedMessageId = jTable1.getSelectedRow();

        if (selectedMessageId == -1)
        {
            return;
        }

        selectedMessage = messages.remove(selectedMessageId);

        updateTable();

        System.out.println("Message handeld");

        if (b)
        {
            return;
        }
        controller.deleteMemberFromClubTeam(selectedMessage.getClubTeam(), member);
    }

    private void updateTable()
    {

        TableModel tm = jTable1.getModel();

        DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
        dm.setRowCount(0);
        dm.setRowCount(messages.size());

        jTable1.setModel(tm);

        TableModel tableModel = jTable1.getModel();

        for (int i = 0; i < messages.size(); i++)
        {
            tableModel.setValueAt(messages.get(i).getClubTeam().getName(), i, 0);
            tableModel.setValueAt(messages.get(i).getCompetition().getName(), i, 1);
        }

        jTable1.setModel(tableModel);
    }
}
