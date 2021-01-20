/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.UAS.oop;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author AR
 */
public abstract class AccountHolder {
    private IntegerProperty holderID;
    private StringProperty name;
    private StringProperty address;
    private StringProperty email;

    public AccountHolder(Integer holderID, String name, String address, String email) {
        this.holderID = new SimpleIntegerProperty(holderID);
        this.name = new SimpleStringProperty(name);
        this.address = new SimpleStringProperty(address);
        this.email = new SimpleStringProperty(email);
    }

    public Integer getHolderID() {
        return holderID.get();
    }

    public void setHolderID(Integer holderID) {
        this.holderID.set(holderID);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }
    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public IntegerProperty holderIDProperty(){
        return holderID;
    }
    public StringProperty nameProperty(){
        return name;
    }
    public StringProperty addressProperty(){
        return address;
    }
}

