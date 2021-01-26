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
public class CorporateHolder extends AccountHolder {
    StringProperty pangkat;
    
    public CorporateHolder(Integer holderID, String name, String address, String email, 
            String pangkat) {
        super(holderID, name, address, email);
        this.pangkat= new SimpleStringProperty(pangkat);
    }

    public String getPangkat() {
        return pangkat.get();
    }

    public void setPangkat(String pangkat) {
        this.pangkat.set(pangkat);
    }
}
