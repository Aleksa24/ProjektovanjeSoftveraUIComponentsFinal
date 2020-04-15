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
public class VrednosniValidatorPozitivanBroj implements vrednosniValidator.VrednosniValidator{

    private final InputPanelTextField panel;

    public VrednosniValidatorPozitivanBroj(InputPanelTextField panel) {
        this.panel = panel;
    }

    @Override
    public void validate() throws Exception {
        panel.getJlabError().setText("");
        Long broj = -1l;
        if (panel.getJtxtInput().getText().equals("") || panel.getJtxtInput().getText().isEmpty()) {
            return;
        }
        try{
            broj = Long.valueOf(panel.getJtxtInput().getText().trim());
            if (broj < 0) {
                throw new Exception("broj je negatibvan");
            }
        }catch(ClassCastException cce){
            panel.getJlabError().setText("niste uneli broj");
            throw cce;
        }catch(Exception e){
            panel.getJlabError().setText("broj je negatibvan");
            throw e;
        }
        
    }
    
}
