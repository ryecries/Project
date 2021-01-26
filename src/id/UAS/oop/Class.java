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
public class Class {
    private final IntegerProperty idclass;
    private final StringProperty classname;
    private final StringProperty tutor;

    public Class(Integer idclass, String classname, String tutor) {
        this.idclass = new SimpleIntegerProperty(idclass);
        this.classname = new SimpleStringProperty (classname);
        this.tutor = new SimpleStringProperty (tutor);
    }

    public Integer getIdclass() {
        return idclass.get();
    }

    public void setIdclass(Integer idclass) {
        this.idclass.set(idclass);
    }

    public String getClassname() {
        return classname.get();
    }

    public void setClassname(String classname) {
        this.classname.set(classname);
    }

    public String getTutor() {
        return tutor.get();
    }

    public void setTutor(String tutor) {
        this.tutor.set(tutor);
    }
    
    public Integer getIdclassProperty() {
        return idclass.get();
    }
    
    public String getClassnameProperty() {
        return classname.get();
    }

    public String getTutorProperty() {
        return tutor.get();
    }

    
    
}
