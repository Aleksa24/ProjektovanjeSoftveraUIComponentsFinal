/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vrednosniValidator.impl;

import ui.components.iValue.impl.InputPanelTextField;

/**
 *
 * @author Aleksa
 */
public class VrednosniValidatorTelefon implements vrednosniValidator.VrednosniValidator{
    
    private InputPanelTextField panel;
    
    public VrednosniValidatorTelefon(InputPanelTextField panel) {
        this.panel = panel;
    }

    public void validate() throws Exception {
        panel.getJlabError().setText("");
        Long id = -1l;
        if (panel.getJtxtInput().getText().equals("") || panel.getJtxtInput().getText().isEmpty()) {
            return;
        }
        if (!panel.getJtxtInput().getText().matches("^((060)|(061)|(062)|(063)|(064)|(065))[0-9]{4,8}")) {
            panel.getJlabError().setText("telefon mora da krece sa 060,061,062,063,064,065");
            throw new Exception("telefon mora da krece sa 060,061,062,063,064,065");
        }
    }
    
}
