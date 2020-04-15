/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.components.iValue;

import vrednosniValidator.VrednosniValidator;

/**
 *
 * @author Aleksa
 */
public interface IValue {

    Object getValue() throws Exception;
    void setValue(Object value);
    void inicialize(Object initValue);
    void setValidator(VrednosniValidator validator);
}
