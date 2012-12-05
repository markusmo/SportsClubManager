package presentation.forms.member;

import com.ServiceNotAvailableException;
import com.contract.IUseCaseControllerFactory;
import contract.dto.*;
import contract.useCaseController.IAddMemberToTeamController;
import java.util.*;
import javax.swing.*;
import presentation.basics.*;

/**
 *
 * @author Lucia
 */
public class AddToATeamForm extends AbstractMainForm {

    IUseCaseControllerFactory client;
    IMemberDto user;
    IClubTeamDto clubTeam;
    IDepartmentHeadDto departmentHeadDto;
    List<IPlayerDto> availablePlayers;
    List<IPlayerDto> teamPlayers;
    IAddMemberToTeamController controller;
    boolean permission;

    /**
     * Creates new form AddMemberToTeam
     */
    public AddToATeamForm(AbstractForm form, IUseCaseControllerFactory client, IMemberDto user) throws ServiceNotAvailableException {
        super(form);
        this.client = client;
        this.user = user;
        controller = client.getAddMemberToTeamController();
        initComponents();
        
        //TODO: Test as soon as controller is running properly
        String[] neededRoles = {"DepartmentHead", "Admin"};
        if(!hasRole(neededRoles)){         
            this.thePanel.removeAll();
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
    private void initComponents() {

        thePanel = new javax.swing.JPanel();
        comboTeam = new javax.swing.JComboBox();
        lblAvailable = new javax.swing.JLabel();
        lblPlayer = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listAvailable = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        listPlayer = new javax.swing.JList();
        btnSave = new javax.swing.JButton();
        btnShow = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(848, 546));

        comboTeam.setModel(new javax.swing.DefaultComboBoxModel(getClubTeams()));

        lblAvailable.setText("Available Members");

        lblPlayer.setText("Team Player(s)");

        btnAdd.setText("Add >");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRemove.setText("< Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        listAvailable.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listAvailable);

        listPlayer.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listPlayer.setEnabled(false);
        jScrollPane2.setViewportView(listPlayer);

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnShow.setText("Show");
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout thePanelLayout = new javax.swing.GroupLayout(thePanel);
        thePanel.setLayout(thePanelLayout);
        thePanelLayout.setHorizontalGroup(
            thePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(thePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(thePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(thePanelLayout.createSequentialGroup()
                        .addComponent(comboTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnShow))
                    .addGroup(thePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnSave)
                        .addGroup(thePanelLayout.createSequentialGroup()
                            .addGroup(thePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblAvailable)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(42, 42, 42)
                            .addGroup(thePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(30, 30, 30)
                            .addGroup(thePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPlayer)))))
                .addContainerGap(363, Short.MAX_VALUE))
        );
        thePanelLayout.setVerticalGroup(
            thePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, thePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(thePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnShow))
                .addGroup(thePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(thePanelLayout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemove))
                    .addGroup(thePanelLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(thePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAvailable)
                            .addComponent(lblPlayer))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(thePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))))
                .addGap(26, 26, 26)
                .addComponent(btnSave)
                .addContainerGap(125, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(thePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(thePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
          //List Models
        ListModel teamPlayerModel = listPlayer.getModel();
        ListModel availableModel = listAvailable.getModel();

        //arrays to store players, list to save new state of team                           
        Object[] selFromTeam = listPlayer.getSelectedValues();                  //team
        Object[] available = new Object[availableModel.getSize() + selFromTeam.length];  //members
        List<Object> tmpTeam = new LinkedList<>();

        //team before removing
        for (int i = 0; i < teamPlayerModel.getSize(); i++) {
            tmpTeam.add(teamPlayerModel.getElementAt(i));
        }
        //add team data to teamlist
        for (int i = 0; i < availableModel.getSize(); i++) {
            available[i] = availableModel.getElementAt(i);
        }
        //add selected from team to available
        for (int i = availableModel.getSize(); i < available.length; i++) {
            available[i] = selFromTeam[i - availableModel.getSize()];
            tmpTeam.remove(selFromTeam[i - availableModel.getSize()]);
        }

        for (int i = 0; i < selFromTeam.length; i++) {
            availablePlayers.add((IPlayerDto) selFromTeam[i]);
            teamPlayers.remove((IPlayerDto) selFromTeam[i]);  //update teamplayer list
        }

        Object[] nTeam = tmpTeam.toArray();
        listPlayer.setListData(nTeam);
        listAvailable.setListData(available);
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        //List Models
        ListModel teamPlayerModel = listPlayer.getModel();
        ListModel availableModel = listAvailable.getModel();

        //arrays to store teams, list to save new state of origin
        Object[] selFromAvailable = listAvailable.getSelectedValues();
        Object[] tPlayer = new Object[teamPlayerModel.getSize() + selFromAvailable.length];
        List<Object> tmpAvailable = new LinkedList<>();

        for (int i = 0; i < availableModel.getSize(); i++) {
            tmpAvailable.add(availableModel.getElementAt(i));
        }
        for (int i = 0; i < teamPlayerModel.getSize(); i++) {
            tPlayer[i] = teamPlayerModel.getElementAt(i);
        }
        for (int i = teamPlayerModel.getSize(); i < tPlayer.length; i++) {
            tPlayer[i] = selFromAvailable[i - teamPlayerModel.getSize()];
            teamPlayers.add((IPlayerDto) selFromAvailable[i - teamPlayerModel.getSize()]);
            availablePlayers.remove((IPlayerDto) selFromAvailable[i - teamPlayerModel.getSize()]);   //remove from available team member list

            tmpAvailable.remove(selFromAvailable[i - teamPlayerModel.getSize()]);
        }
        Object[] newOrigSel = tmpAvailable.toArray();

        listPlayer.setListData(tPlayer);
        listAvailable.setListData(newOrigSel);

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        LinkedList<Integer> playerIDs = new LinkedList<>();
        for (IPlayerDto p : teamPlayers) {
            playerIDs.add(p.getId());
        }

        //TODO: add to the team or call controlller
        clubTeam.setPlayerList(playerIDs);
        TODO: controller.updateClubTeam(clubTeam);

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
        clubTeam = (IClubTeamDto) comboTeam.getSelectedItem();

        setListAvailable(controller.getPotentialPlayer(clubTeam));
        setListPlayer(controller.getTeamPlayer(clubTeam));
    }//GEN-LAST:event_btnShowActionPerformed

    private Object[] getClubTeams() {
        List<IClubTeamDto> clubTeamList = controller.getClubTeams(user);

        return clubTeamList.toArray();
    }

    private void setListAvailable(final List<IPlayerDto> available) {
        availablePlayers = available;
        listAvailable.setModel(new AbstractListModel() {
            Object[] objects = available.toArray();

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

    private void setListPlayer(final List<IPlayerDto> team) {
        teamPlayers = team;
        listPlayer.setModel(new AbstractListModel() {
            Object[] objects = team.toArray();

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
        return thePanel;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnShow;
    private javax.swing.JComboBox comboTeam;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAvailable;
    private javax.swing.JLabel lblPlayer;
    private javax.swing.JList listAvailable;
    private javax.swing.JList listPlayer;
    private javax.swing.JPanel thePanel;
    // End of variables declaration//GEN-END:variables
}
