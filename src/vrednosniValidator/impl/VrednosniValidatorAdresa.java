/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vrednosniValidator.impl;

import ui.components.iValue.impl.InputPanelTextField;
import vrednosniValidator.VrednosniValidator;

/**
 *
 * @author Aleksa
 */
public class VrednosniValidatorAdresa implements VrednosniValidator {

    private InputPanelTextField panel;
    private boolean daLiMozeDaBudePrazan;

    public VrednosniValidatorAdresa(InputPanelTextField panel) {
        this.panel = panel;
        daLiMozeDaBudePrazan = false;
    }

    public VrednosniValidatorAdresa(InputPanelTextField inputPanelEmail, boolean b) {
        this.panel = panel;
        daLiMozeDaBudePrazan = b;// = true;
    }

    public void validate() throws Exception {
        panel.getJlabError().setText("");
        if (daLiMozeDaBudePrazan && (panel.getJtxtInput().getText().equals("") || panel.getJtxtInput().getText().isEmpty())) {
            return;
        }
        if (!panel.getJtxtInput().getText().matches("([A-Za-z] )+//d*")) {
            panel.getJlabError().setText("adresa mora da sadrzi rec sa razmakom na kraju, i moze broj na kraju po zelji");
            throw new Exception("adresa mora da sadrzi rec sa razmakom na kraju, i moze broj na kraju po zelji");
        }
    }
}
