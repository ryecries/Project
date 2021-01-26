/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.UAS.oop;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author AR
 */
public class IndividualHolder extends AccountHolder{
    public StringProperty jenjang;
    
    public IndividualHolder(Integer holderID, String name, String address, String email,
            String jenjang) {
        super(holderID, name, address, email);
        this.jenjang = new SimpleStringProperty(jenjang);
    }

    public String getJenjang() {
        return jenjang.get();
    }

    public void setJenjang(String jenjang) {
        this.jenjang.set(jenjang);
    }
}
