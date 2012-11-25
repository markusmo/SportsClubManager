/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javamessagingclient;

import javamessagingclient.contract.IMatchMessage;
import javamessagingclient.stubs.IMemberDto;
import java.util.*;
import javamessagingclient.contract.*;
import javamessagingclient.stubs.*;
import javax.jms.*;
import javax.swing.event.*;
import javax.swing.table.TableModel;

/**

 @author Thomas
 */
public class MemberSubscriberForm
        extends javax.swing.JFrame
        implements MessageListener, ExceptionListener
{
    private IMemberDepartmentMessage selectedMessage = null;
    private List<IMemberDepartmentMessage> messages = new LinkedList<IMemberDepartmentMessage>();
    private AddMemberAddClubTeam controller = new AddMemberAddClubTeam();
    private IDepartmentHeadDto departmentHeadDto;
    private MemberSubscriberJms subscriberJms;

    /**
     Creates new form MatchSubscriberForm
     */
    public MemberSubscriberForm(IDepartmentHeadDto departmentHead)
    {
        initComponents();

        this.departmentHeadDto = departmentHead;

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

        subscriberJms = new MemberSubscriberJms(departmentHead);
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
                new Object[][]
                {
                    {
                        null, null
                    },
                    {
                        null, null
                    },
                    {
                        null, null
                    },
                    {
                        null, null
                    }
                },
                new String[]
                {
                    "Mannschaft", "Wettbewerb"
                }));
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
                .addContainerGap())));
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
                .addContainerGap(53, Short.MAX_VALUE))));

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
        IMemberDepartmentMessage msg = (IMemberDepartmentMessage) message;

        System.out.println("received: " + msg);

        if (!departmentHeadDto.getDepartmentList().contains(msg.getDepartment()))
        {
            return;
        }
        messages.add(msg);

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
        jTable1.remove(selectedMessageId);
        if (b)
        {
            return;
        }

        //controller.deleteMemberFromClubTeam(selectedMessage.getClubTeam(), departmentHeadDto);
    }
}