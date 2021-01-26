/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.UAS.oop;

import id.UAS.oop.db.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author AR
 */
public class AccountHolderDataModel {

    public Connection conn;

    public AccountHolderDataModel(String driver) throws SQLException {
        this.conn = DBHelper.getConnection(driver);
    }

    public void addAccountHolder(IndividualHolder holder) throws SQLException {
        String insertHolder = "INSERT INTO accountholder (holder_id, name, address, email)"
                + " VALUES (?,?,?,?)";
        String insertIndividual = "INSERT INTO individualholder (holder_id, jenjang)"
                + " VALUES (?,?)";
        
        PreparedStatement stmtHolder = conn.prepareStatement(insertHolder);
        stmtHolder.setInt(1, holder.getHolderID());
        stmtHolder.setString(2, holder.getName());
        stmtHolder.setString(3, holder.getAddress());
        stmtHolder.setString(4, holder.getEmail());
        stmtHolder.execute();

        PreparedStatement stmtIndividual = conn.prepareStatement(insertIndividual);
        stmtIndividual.setInt(1, holder.getHolderID());
        stmtIndividual.setString(2, holder.getJenjang());
        stmtIndividual.execute();


    }

    public void addAccountHolder(CorporateHolder holder) throws SQLException {
        String insertHolder = "INSERT INTO accountholder (holder_id, name, address, email)"
                + " VALUES (?,?,?,?)";
        String insertCorporate = "INSERT INTO corporateholder (holder_id, pangkat)"
                + " VALUES (?,?)";

        PreparedStatement stmtHolder = conn.prepareStatement(insertHolder);
        stmtHolder.setInt(1, holder.getHolderID());
        stmtHolder.setString(2, holder.getName());
        stmtHolder.setString(3, holder.getAddress());
        stmtHolder.setString(4, holder.getEmail());
        stmtHolder.execute();

        PreparedStatement stmtIndividual = conn.prepareStatement(insertCorporate);
        stmtIndividual.setInt(1, holder.getHolderID());
        stmtIndividual.setString(2, holder.getPangkat());
        stmtIndividual.execute();

    }

    public ObservableList<IndividualHolder> getIndividualHolder() throws SQLException {
        ObservableList<IndividualHolder> data = FXCollections.observableArrayList();
        String sql = "SELECT `holder_id`, `name`, `address`, `email`, `jenjang`"
                + " FROM `accountholder` NATURAL JOIN `individualholder` "
                + "ORDER BY `holder_id`";
        
        ResultSet rs = conn.createStatement().executeQuery(sql);
        
        while(rs.next()){
            data.add(new IndividualHolder(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
        }
        return data;
    }
    
    public ObservableList<CorporateHolder> getCorporateHolder() throws SQLException {
        ObservableList<CorporateHolder> guru = FXCollections.observableArrayList();
        String sql = "SELECT `holder_id`, `name`, `address`, `email`, `pangkat`"
                + " FROM `accountholder` NATURAL JOIN `corporateholder` "
                + "ORDER BY `name`";

        ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
               
                guru.add(new CorporateHolder(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5)));
            }
       return guru;
    }
    
    public ObservableList<Class> getClassess(int holderID) {
        ObservableList<Class> data = FXCollections.observableArrayList();
        String sql = "SELECT `idclass`, `classname`, `tutor`, "
                + " FROM `class` "
                + "WHERE holder_id="+holderID;

        ResultSet rs;
        try {
            rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                String sqlClass = "SELECT idclass, classname, tutor FROM class "
                        + "WHERE holder_id=" + rs.getInt(1);
                ResultSet rsClass = conn.createStatement().executeQuery(sqlClass);
                ArrayList<Class> dataClass = new ArrayList<>();
                while (rsClass.next()) {
                    dataClass.add(new Class(rsClass.getInt(1), rsClass.getString(2), rsClass.getString(3)));
                }
                data.add(new Class(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountHolderDataModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    public int nextID() throws SQLException{
        String sql = "SELECT MAX(holder_id) from AccountHolder";
        ResultSet rs = conn.createStatement().executeQuery(sql);
        while (rs.next()){
            return rs.getInt(1)==0?20200001:rs.getInt(1)+1;
        }
        return 20200001;
    }
    
    public int nextID1() throws SQLException{
        String sql = "SELECT MAX(holder_id) from AccountHolder";
        ResultSet rs = conn.createStatement().executeQuery(sql);
        while (rs.next()){
            return rs.getInt(1)==0?11110001:rs.getInt(1)+1;
        }
        return 11110001;
    }
    
      
        
    public int nextclassID(int holderID) throws SQLException{
        String sql = "SELECT MAX(idclass) from AccountHolder"+holderID;
        ResultSet rs = conn.createStatement().executeQuery(sql);
        while (rs.next()){
            return rs.getInt(1)+1;
        }
        return 0;
    }
}
















