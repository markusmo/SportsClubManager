/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.forms.member;

import contract.dto.IAddressDto;
import contract.dto.classes.AddressDto;
import contract.useCaseController.IAddressController;

/**
 @author Thomas
 */
public class AddressPanel
        extends javax.swing.JPanel
{
    private IAddressDto address;
    private IAddressController controller;

    public void setController(IAddressController controller)
    {
        this.controller = controller;
    }

    public IAddressDto getAddress()
    {
        if (address == null)
        {
            address = new AddressDto();
        }

        address.setStreet(txtfieldAddress.getText());
        address.setStreetNumber(Integer.parseInt(txtfieldStreetNr.getText()));
        address.setPostalCode(Integer.parseInt(txtfieldPostCode.getText()));
        address.setVillage(txtfieldCity.getText());
        address.setCountry(controller.getCountryByName(txtfieldCountry.getText()).getId());

        return address;
    }

    public void setAddress(IAddressDto address)
    {
        this.address = address;

        txtfieldAddress.setText(address.getStreet());
        txtfieldStreetNr.setText(Integer.toString(address.getStreetNumber()));
        txtfieldPostCode.setText(address.getPostalCode() + "");
        txtfieldCity.setText(address.getVillage());
        txtfieldCountry.setText(controller.getCountryById(address.getCountry()) + "");
    }

    /**
     Creates new form AddressPanel
     */
    public AddressPanel()
    {
        initComponents();
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

        txtfieldPostCode = new javax.swing.JTextField();
        txtfieldCountry = new javax.swing.JTextField();
        lblCountry = new javax.swing.JLabel();
        lblPostCode = new javax.swing.JLabel();
        txtfieldCity = new javax.swing.JTextField();
        txtfieldAddress = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        lblCity = new javax.swing.JLabel();
        txtfieldStreetNr = new javax.swing.JTextField();

        setName(""); // NOI18N

        txtfieldPostCode.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txtfieldPostCodeActionPerformed(evt);
            }
        });

        lblCountry.setText("Country");

        lblPostCode.setText("Post Code");

        lblAddress.setText("Street + Nr.");

        lblCity.setText("City");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAddress)
                            .addComponent(lblCity))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtfieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtfieldStreetNr, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
                            .addComponent(txtfieldCity)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPostCode)
                            .addComponent(lblCountry))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtfieldCountry)
                            .addComponent(txtfieldPostCode))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblAddress)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCity))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtfieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtfieldStreetNr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtfieldCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPostCode))
                    .addComponent(txtfieldPostCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCountry)
                    .addComponent(txtfieldCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtfieldPostCodeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txtfieldPostCodeActionPerformed
    {//GEN-HEADEREND:event_txtfieldPostCodeActionPerformed
    }//GEN-LAST:event_txtfieldPostCodeActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblPostCode;
    private javax.swing.JTextField txtfieldAddress;
    private javax.swing.JTextField txtfieldCity;
    private javax.swing.JTextField txtfieldCountry;
    private javax.swing.JTextField txtfieldPostCode;
    private javax.swing.JTextField txtfieldStreetNr;
    // End of variables declaration//GEN-END:variables
}