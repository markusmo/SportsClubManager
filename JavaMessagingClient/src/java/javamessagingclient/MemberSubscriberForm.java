/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javamessagingclient;

import javamessagingclient.controller.AddPlayerToClubTeamController;
import java.util.*;
import java.util.logging.*;
import javamessaging.stubs.*;
import javamessaging.contract.*;
import javamessaging.stubs.IDepartmentHeadDto;
import javax.jms.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

/**

 @author Thomas
 */
public class MemberSubscriberForm
        extends javax.swing.JFrame
        implements MessageListener, ExceptionListener
{
    private List<IMemberDepartmentMessage> messages = new LinkedList<IMemberDepartmentMessage>();
    private List<IClubTeamDto> clubTeams = new LinkedList<IClubTeamDto>();
    private AddPlayerToClubTeamController controller = new AddPlayerToClubTeamController();
    private IDepartmentHeadDto departmentHeadDto;
    private MemberSubscriberJms subscriberJms;

    public MemberSubscriberForm(IDepartmentHeadDto departmentHead)
    {
        initComponents();

        this.departmentHeadDto = departmentHead;

        TableModel tableModel = jTable2.getModel();

        for (IDepartmentDto d : this.departmentHeadDto.getDepartmentList())
        {
            for (IClubTeamDto c : d.getClubTeamList())
            {
                clubTeams.add(c);
                jTable2.setValueAt(c, tableModel.getRowCount() + 1, 0);
            }
        }
        jTable2.setModel(tableModel);

        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                int selectedMessageId = jTable1.getSelectedRow();

                jButton1.setEnabled(selectedMessageId != -1);
                jButton2.setEnabled(selectedMessageId != -1);
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Vorname", "Nachname"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(1).setHeaderValue("Nachname");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Team"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(307, 307, 307)
                        .addComponent(jButton1)
                        .addGap(39, 39, 39)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 254, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onMessage(Message message)
    {
        try
        {
            ObjectMessage om = (ObjectMessage) message;
            Object o = om.getObject();

            IMemberDepartmentMessage msg = (IMemberDepartmentMessage) o;

            System.out.println("received: " + msg);

            if (!departmentHeadDto.getDepartmentList().contains(msg.getDepartment()))
            {
                return;
            }

            messages.add(msg);
        }
        catch (JMSException ex)
        {
            Logger.getLogger(MemberSubscriberForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void onException(JMSException exception)
    {
        System.err.println("something bad happended: " + exception);
    }

    private void writeToDatabase(boolean shouldWrite)
    {
        int selectedMessageId = jTable1.getSelectedRow();

        if (selectedMessageId == -1)
        {
            JOptionPane.showMessageDialog(this, "No message selected");
            return;
        }

        IMemberDepartmentMessage selectedMessage = messages.remove(selectedMessageId);
        jTable1.remove(selectedMessageId);

        if (shouldWrite)
        {
            return;
        }

        int[] clubTeamIds = jTable2.getSelectedRows();

        if (clubTeamIds.length == 0)
        {
            JOptionPane.showMessageDialog(this, "No clubTeam selected");
            return;
        }

        for (int clubTeamId : clubTeamIds)
        {
            IClubTeamDto clubTeam = clubTeams.get(clubTeamId);

            controller.addPlayerToClubTeam(clubTeam, getPlayer(selectedMessage.getMember()));
        }
    }

    private IPlayerDto getPlayer(IMemberDto member)
    {
        for (IRoleDto r : member.getRoleList())
        {
            if (r instanceof IPlayerDto)
            {
                return (IPlayerDto) r;
            }
        }

        return null;
    }
}
