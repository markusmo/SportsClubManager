/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.forms.competition;

import com.contract.IUseCaseControllerFactory;
import com.*;
import contract.dto.*;
import contract.useCaseController.IChangeCompetitionTeamController;
import java.util.*;
import javax.swing.*;
import presentation.basics.*;

/**
 *
 * @author Lucia
 */
public class ChangeCompetitionTeamForm
        extends AbstractMainForm {

    IMemberDto user;
    IUseCaseControllerFactory client;
    IChangeCompetitionTeamController controller;
    ICompetitionDto competition;
    List<IClubTeamDto> cTeams;  //for ComboBox
    IClubTeamDto formerTeam;
    List<IPlayerDto> allPlayers;
    List<IPlayerDto> newPlayerList;

    /**
     * Creates new form AddTeamMember
     */
    public ChangeCompetitionTeamForm(AbstractForm form, IUseCaseControllerFactory client, IMemberDto user)
            throws ServiceNotAvailableException {
        super(form);
        this.client = client;
        this.user = user;
        controller = this.client.getChangeCompetitionTeamController();
        initComponents();

        String[] neededRoles = {"Admin", "Trainer"};
        if (!hasRole(neededRoles)) {
            this.panelChangeTeam.removeAll();
            JOptionPane.showMessageDialog(null, "Sorry, you do not have the permission to enter this area!");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        panelChangeTeam = new javax.swing.JPanel();
        lblCompetitionSel = new javax.swing.JLabel();
        comboCompetition = new javax.swing.JComboBox();
        lblSelTeam = new javax.swing.JLabel();
        comboTeam = new javax.swing.JComboBox();
        scrollTeam = new javax.swing.JScrollPane();
        listTeam = new javax.swing.JList();
        lblMembers = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        scrollCompTeam = new javax.swing.JScrollPane();
        listCompTeam = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        btnRemove = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnShow = new javax.swing.JButton();
        btnGetTeams = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(845, 549));

        lblCompetitionSel.setText("Competition");

        comboCompetition.setModel(new javax.swing.DefaultComboBoxModel(controller.getCompetition().toArray()));

        lblSelTeam.setText("Team");

        comboTeam.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));

        listTeam.setModel(new javax.swing.AbstractListModel()
        {
            String[] strings = { "" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        scrollTeam.setViewportView(listTeam);

        lblMembers.setText("Team Members");

        btnAdd.setText("Add >");
        btnAdd.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAddActionPerformed(evt);
            }
        });

        listCompTeam.setModel(new javax.swing.AbstractListModel()
        {
            String[] strings = { "" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        scrollCompTeam.setViewportView(listCompTeam);

        jLabel1.setText("Current Competition Team");

        btnRemove.setText("< Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnRemoveActionPerformed(evt);
            }
        });

        btnSave.setText("Save Team");
        btnSave.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSaveActionPerformed(evt);
            }
        });

        btnShow.setText("Show");
        btnShow.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnShowActionPerformed(evt);
            }
        });

        btnGetTeams.setText("Find Teams");
        btnGetTeams.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnGetTeamsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelChangeTeamLayout = new javax.swing.GroupLayout(panelChangeTeam);
        panelChangeTeam.setLayout(panelChangeTeamLayout);
        panelChangeTeamLayout.setHorizontalGroup(
            panelChangeTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelChangeTeamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelChangeTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelChangeTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnSave)
                        .addGroup(panelChangeTeamLayout.createSequentialGroup()
                            .addGroup(panelChangeTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblMembers)
                                .addGroup(panelChangeTeamLayout.createSequentialGroup()
                                    .addComponent(scrollTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(panelChangeTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panelChangeTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(scrollCompTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelChangeTeamLayout.createSequentialGroup()
                        .addGroup(panelChangeTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCompetitionSel)
                            .addComponent(lblSelTeam))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelChangeTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboCompetition, 0, 200, Short.MAX_VALUE)
                            .addComponent(comboTeam, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelChangeTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnGetTeams, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnShow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(362, Short.MAX_VALUE))
        );
        panelChangeTeamLayout.setVerticalGroup(
            panelChangeTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelChangeTeamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelChangeTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCompetitionSel)
                    .addComponent(comboCompetition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGetTeams))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelChangeTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSelTeam)
                    .addComponent(btnShow))
                .addGap(45, 45, 45)
                .addGroup(panelChangeTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelChangeTeamLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollCompTeam))
                    .addGroup(panelChangeTeamLayout.createSequentialGroup()
                        .addComponent(lblMembers)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelChangeTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelChangeTeamLayout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(btnAdd)
                                .addGap(27, 27, 27)
                                .addComponent(btnRemove))
                            .addComponent(scrollTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSave)
                .addContainerGap(162, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelChangeTeam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelChangeTeam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        //List Models
        ListModel origModel = listTeam.getModel();

        //arrays to store teams, list to save new state of origin
        Object[] origSel = listTeam.getSelectedValues();
        List<Object> tmpOrig = new LinkedList<>();

        for (int i = 0; i < origModel.getSize(); i++) {
            tmpOrig.add(origModel.getElementAt(i));
        }

        ListModel cTeamModel = listCompTeam.getModel();
        Object[] cTeam = new Object[cTeamModel.getSize() + origSel.length];

        for (int i = 0; i < cTeamModel.getSize(); i++) {
            cTeam[i] = cTeamModel.getElementAt(i);
        }
        for (int i = cTeamModel.getSize(); i < cTeam.length; i++) {
            cTeam[i] = origSel[i - cTeamModel.getSize()];
            newPlayerList.add((IPlayerDto) origSel[i - cTeamModel.getSize()]);
            allPlayers.remove((IPlayerDto) origSel[i - cTeamModel.getSize()]);   //remove from available team member list

            tmpOrig.remove(origSel[i - cTeamModel.getSize()]);
        }
        Object[] newOrigSel = tmpOrig.toArray();

        listCompTeam.setListData(cTeam);
        listTeam.setListData(newOrigSel);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        //List Models
        ListModel compTModel = listCompTeam.getModel();
        ListModel teamModel = listTeam.getModel();

        //arrays to store teams, list to save new state of competition team                            
        Object[] cTeamSel = listCompTeam.getSelectedValues();                  //competitionteam
        Object[] origTeam = new Object[teamModel.getSize() + cTeamSel.length];  //team general
        List<Object> tmpTeam = new LinkedList<>();

        //Competition Team before removing
        for (int i = 0; i < compTModel.getSize(); i++) {
            tmpTeam.add(compTModel.getElementAt(i));
        }
        //add team data to teamlist
        for (int i = 0; i < teamModel.getSize(); i++) {
            origTeam[i] = teamModel.getElementAt(i);
        }
        //add selected from compTeam to Team
        for (int i = teamModel.getSize(); i < origTeam.length; i++) {
            origTeam[i] = cTeamSel[i - teamModel.getSize()];
            tmpTeam.remove(cTeamSel[i - teamModel.getSize()]);
        }

        for (int i = 0; i < cTeamSel.length; i++) {
            allPlayers.add((IPlayerDto) cTeamSel[i]);
            newPlayerList.remove((IPlayerDto) cTeamSel[i]);  //remove from new team list
        }

        Object[] nTeam = tmpTeam.toArray();

        listCompTeam.setListData(nTeam);
        listTeam.setListData(origTeam);
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        IClubTeamDto newCompetitioTeam = formerTeam; //keep trainers and competitions this way /*new ClubTeamDto();*/

        List<Integer> newTeamPlayerIDs = new LinkedList<>();
        for (IPlayerDto p : newPlayerList) {
            newTeamPlayerIDs.add(p.getId());
        }
        newCompetitioTeam.setPlayerList(newTeamPlayerIDs);

        try{
            controller.setCompetitonTeam(competition, formerTeam, newCompetitioTeam);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "An error occured while trying to save changes!");
        }
        JOptionPane.showMessageDialog(null, "Competition Team changed!");
        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
        IClubTeamDto completeTeam = (IClubTeamDto) comboTeam.getSelectedItem();
        List<IPlayerDto> playerList = controller.getPlayers(completeTeam.getPlayerList());

        formerTeam = controller.getCompetitionTeam(completeTeam);
        newPlayerList = controller.getPlayers(formerTeam.getPlayerList());
        setNeededPLayerList();

        List<IPlayerDto> notNeededPlayerList = new LinkedList<>();

        for (IPlayerDto player : playerList) {
            if (!newPlayerList.contains(player)) {
                notNeededPlayerList.add(player);
            }
        }

        setNotNeededPlayerList(notNeededPlayerList);

    }//GEN-LAST:event_btnShowActionPerformed

    private void btnGetTeamsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetTeamsActionPerformed
        comboTeam.setModel(new DefaultComboBoxModel(getTeamList()));
    }//GEN-LAST:event_btnGetTeamsActionPerformed

    private void setNotNeededPlayerList(final List<IPlayerDto> players) {
        listTeam.setModel(new AbstractListModel() {
            Object[] objects = players.toArray(); /*players;*/


            @Override
            public int getSize() {
                return objects.length;
            }

            @Override
            public Object getElementAt(int i) {
                return objects[i];
            }
        });
    }

    private void setNeededPLayerList() {
        listCompTeam.setModel(new AbstractListModel() {
            Object[] objects = newPlayerList.toArray();

            @Override
            public int getSize() {
                return objects.length;
            }

            @Override
            public Object getElementAt(int i) {
                return objects[i];
            }
        });
    }

    private Object[] getTeamList() {
        competition = (ICompetitionDto) comboCompetition.getSelectedItem();
        cTeams = controller.getClubTeams(competition.getTeamList());
        return cTeams.toArray();
    }

    private boolean hasRole(String[] roleNames) {
        List<IRoleDto> roleList = controller.getRoles(user.getId());

        for (IRoleDto r : roleList) {
            for (int i = 0; i < roleNames.length; i++) {
                if (r.getName().equals(roleNames[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    public JPanel getPanel() {
        return panelChangeTeam;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnGetTeams;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnShow;
    private javax.swing.JComboBox comboCompetition;
    private javax.swing.JComboBox comboTeam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCompetitionSel;
    private javax.swing.JLabel lblMembers;
    private javax.swing.JLabel lblSelTeam;
    private javax.swing.JList listCompTeam;
    private javax.swing.JList listTeam;
    private javax.swing.JPanel panelChangeTeam;
    private javax.swing.JScrollPane scrollCompTeam;
    private javax.swing.JScrollPane scrollTeam;
    // End of variables declaration//GEN-END:variables
}
