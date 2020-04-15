/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vrednosniValidator.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import ui.components.iValue.impl.InputPanelDate;
import ui.components.iValue.impl.InputPanelTextField;

/**
 *
 * @author Aleksa
 */
public class VrednosniValidatorDate implements vrednosniValidator.VrednosniValidator{

    private final InputPanelTextField panel;

    public VrednosniValidatorDate(InputPanelTextField panel) {
        this.panel = panel;
    }

    public VrednosniValidatorDate(InputPanelDate vremePanel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * proverava da li je polje datum
     * patern dd-MM-yyyy
     * @throws Exception 
     */
    @Override
    public void validate() throws Exception {
        panel.getJlabError().setText("");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            sdf.parse(panel.getJtxtInput().getText().trim());
        } catch (Exception e) {
            panel.getJlabError().setText("dd-MM-yyyy");
            throw e;
        }
        
    }
    
}
