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
public class VrednosniValidatorEmail implements vrednosniValidator.VrednosniValidator{
    
    private InputPanelTextField panel;

    public VrednosniValidatorEmail(InputPanelTextField panel) {
        this.panel = panel;
    }

    public void validate() throws Exception {
        panel.getJlabError().setText("");
        if (panel.getJtxtInput().getText().equals("") || panel.getJtxtInput().getText().isEmpty()) {
            return;
        }
        if (!panel.getJtxtInput().getText().matches("^(.+)@(.+)$")) {
            panel.getJlabError().setText("email mora da sadrzi @");
            throw new Exception("email mora da sadrzi @");
        }
    }
}
