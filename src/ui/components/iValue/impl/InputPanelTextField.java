/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.components.iValue.impl;

import ui.components.iValue.IValue;
import vrednosniValidator.VrednosniValidator;
import vrednosniValidator.impl.VrednosniValidatorDefault;

/**
 *
 * @author Aleksa
 */
public class InputPanelTextField extends javax.swing.JPanel implements IValue{

    private vrednosniValidator.VrednosniValidator validator;
    
    /**
     * Creates new form InputPanelTextField
     */
    public InputPanelTextField() {
        initComponents();
        validator = new VrednosniValidatorDefault();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlabText = new javax.swing.JLabel();
        jtxtInput = new javax.swing.JTextField();
        jlabError = new javax.swing.JLabel();

        setForeground(new java.awt.Color(255, 0, 0));

        jlabText.setText("jLabel1");

        jlabError.setForeground(new java.awt.Color(255, 0, 0));
        jlabError.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jlabError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlabText, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxtInput, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabText)
                    .addComponent(jtxtInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlabError))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlabError;
    private javax.swing.JLabel jlabText;
    private javax.swing.JTextField jtxtInput;
    // End of variables declaration//GEN-END:variables

    @Override
    public Object getValue() throws Exception {
        validator.validate();
        return jtxtInput.getText().trim();
    }

    @Override
    public void setValue(Object value) {
        jtxtInput.setText(String.valueOf(value));
    }

    @Override
    public void inicialize(Object initValue) {
        jtxtInput.setText((String)initValue);
    }

    public javax.swing.JLabel getJlabError() {
        return jlabError;
    }

    public javax.swing.JLabel getJlabText() {
        return jlabText;
    }

    public javax.swing.JTextField getJtxtInput() {
        return jtxtInput;
    }

      @Override
    public void setValidator(VrednosniValidator validator) {
        this.validator = validator;
    }

    public VrednosniValidator getValidator() {
        return validator;
    }
    
    
}
