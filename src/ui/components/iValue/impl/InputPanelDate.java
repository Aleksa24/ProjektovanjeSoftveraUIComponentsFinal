/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.components.iValue.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import ui.components.iValue.IValue;
import vrednosniValidator.VrednosniValidator;
import vrednosniValidator.impl.VrednosniValidatorDefault;

/**
 *
 * @author Aleksa
 */
public class InputPanelDate extends javax.swing.JPanel implements IValue {

    private vrednosniValidator.VrednosniValidator validator = new VrednosniValidatorDefault();

    /**
     * Creates new form InputPanelDate
     */
    public InputPanelDate() {
        initComponents();
        prepareForm();
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
        jComboBoxDay = new javax.swing.JComboBox<>();
        jComboBoxMonth = new javax.swing.JComboBox<>();
        jComboBoxYear = new javax.swing.JComboBox<>();
        jlabError = new javax.swing.JLabel();

        jlabText.setText("jLabel1");

        jComboBoxDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
                        .addComponent(jlabText, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxDay, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxYear, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabText)
                    .addComponent(jComboBoxDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlabError))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBoxDay;
    private javax.swing.JComboBox<String> jComboBoxMonth;
    private javax.swing.JComboBox<String> jComboBoxYear;
    private javax.swing.JLabel jlabError;
    private javax.swing.JLabel jlabText;
    // End of variables declaration//GEN-END:variables

    @Override
    public Object getValue() throws Exception {
        validator.validate();
        String day = (String) jComboBoxDay.getSelectedItem();
        String month = (String) jComboBoxMonth.getSelectedItem();
        String year = (String) jComboBoxYear.getSelectedItem();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        return sdf.parse(day + "-" + month + "-" + year);//greska se obradjuje u validatoru

    }

    @Override
    public void setValue(Object value) {//samo namesta u combo boxevima datum
        if (value instanceof Date) {
            Date danasnjiDatum = (Date) value;
            prepareForm();
            SimpleDateFormat sdf = new SimpleDateFormat("dd");
            jComboBoxDay.setSelectedItem(sdf.format(danasnjiDatum));
            sdf = new SimpleDateFormat("MM");
            jComboBoxMonth.setSelectedItem(sdf.format(danasnjiDatum));
            sdf = new SimpleDateFormat("yyyy");
            jComboBoxYear.setSelectedItem(sdf.format(danasnjiDatum));
        }
    }

    /**
     * ubaci godinu od koje se broji
     * @param initValue 
     */
    @Override
    public void inicialize(Object initValue) {
        if (!(initValue instanceof Date)) {
            prepareForm();
        }
        this.jComboBoxYear.removeAllItems();
        Integer godinaOdKojeSeBroji = (Integer) initValue;
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.YEAR, 20);
        Date date = cal.getTime();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        int godina = Integer.parseInt(sdf.format(date));
        for (int i = godina; i > godinaOdKojeSeBroji; i--) {
            jComboBoxYear.addItem(String.valueOf(i));
        }
    }

    public JLabel getJlabError() {
        return jlabError;
    }

    public JLabel getJlabText() {
        return jlabText;
    }

    private void prepareForm() {
        jComboBoxDay.removeAllItems();
        jComboBoxMonth.removeAllItems();
        jComboBoxYear.removeAllItems();

        for (int i = 1; i < 32; i++) {
            jComboBoxDay.addItem(String.valueOf(i));
        }
        for (int i = 1; i < 13; i++) {
            jComboBoxMonth.addItem(String.valueOf(i));
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.YEAR, 20);
        Date date = cal.getTime();
        int godina = Integer.parseInt(sdf.format(date));
        for (int i = godina; i > 1950; i--) {
            jComboBoxYear.addItem(String.valueOf(i));
        }
    }

    @Override
    public void setValidator(VrednosniValidator validator) {
        this.validator = validator;
    }

    public JComboBox<String> getjComboBoxDay() {
        return jComboBoxDay;
    }

    public JComboBox<String> getjComboBoxMonth() {
        return jComboBoxMonth;
    }

    public JComboBox<String> getjComboBoxYear() {
        return jComboBoxYear;
    }
    
    
}
