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

/**
 *
 * @author AR
 */
public class AccountHolderDataModel {
    private final Connection conn;

    public AccountHolderDataModel(String driver) throws SQLException {
        this.conn = DBHelper.getConnection(driver);
    }
    public void addAccountHolder(IndividualHolder holder) throws SQLException{
        String insertHolder = "INSERT INTO account_holder (holder_id, name, address, email)"
                + " VALUES (?,?,?,?)";
        String insertIndividual = "INSERT INTO individual_holder (holder_id, jenjang)"
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
    public void addAccountHolder(CorporateHolder holder) throws SQLException{
        String insertHolder = "INSERT INTO account_holder (holder_id, name, address, email)"
                + " VALUES (?,?,?,?)";
        String insertCorporate = "INSERT INTO corporate_holder (holder_id, pangkat)"
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
    
}
