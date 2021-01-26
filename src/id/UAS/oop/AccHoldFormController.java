/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.UAS.oop;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author ACER
 */
public class AccHoldFormController implements Initializable {
    
    
    @FXML
    private TextField tfholderID;

    @FXML
    private TextField tfname;

    @FXML
    private TextField tfaddress;

    @FXML
    private TextField tfemail;
    
    @FXML
    private ComboBox<String> cbJenjang;
  
    @FXML
    private Button btnsave;
    
    @FXML
    private Label lblsavestatus;
    
    @FXML
    private TableView<IndividualHolder> tbview;
    
    @FXML
    private TableColumn<IndividualHolder, Integer> tbid;

    @FXML
    private TableColumn<IndividualHolder, String> tbnama;

    @FXML
    private TableColumn<IndividualHolder, String> tbalamat;

    @FXML
    private TableColumn<IndividualHolder, String> tbemail;
    
     @FXML
    private TableColumn<IndividualHolder, String> tbjenjang;

    @FXML
    private Button btnadd;
    
    //set 2
      @FXML
    private TextField tfholderID1;

    @FXML
    private TextField tfname1;

    @FXML
    private TextField tfaddress1;

    @FXML
    private TextField tfemail1;

    @FXML
    private ComboBox<String> cbJenjang1;

    @FXML
    private Button btnsave1;

    @FXML
    private Label lblsavestatus1;

    @FXML
    private TableView<CorporateHolder> tbview1;

    @FXML
    private TableColumn<CorporateHolder, Integer> tbid1;

    @FXML
    private TableColumn<CorporateHolder, String> tbnama1;

    @FXML
    private TableColumn<CorporateHolder, String> tbalamat1;

    @FXML
    private TableColumn<CorporateHolder, String> tbemail1;

    @FXML
    private TableColumn<CorporateHolder, String> tbjenjang1;

    @FXML
    private Button btnadd1;
    
    //

    @FXML
    private Label lblDBStatus;

    private AccountHolderDataModel ahdm;
    
    @FXML
    void handleADDButton(ActionEvent event) throws SQLException {
         ObservableList<IndividualHolder> data = ahdm.getIndividualHolder();
         tbid.setCellValueFactory(new PropertyValueFactory<>("holderID"));
         tbnama.setCellValueFactory(new PropertyValueFactory<>("name"));
         tbalamat.setCellValueFactory(new PropertyValueFactory<>("address"));
         tbemail.setCellValueFactory(new PropertyValueFactory<>("email"));
         tbjenjang.setCellValueFactory(new PropertyValueFactory<>("jenjang"));
         tbview.setItems(null);
         tbview.setItems(data);
    }
    
    @FXML
    void handleADDButton1(ActionEvent event) throws SQLException{
         ObservableList<CorporateHolder> guru = ahdm.getCorporateHolder();
         tbid1.setCellValueFactory(new PropertyValueFactory<>("holderID"));
         tbnama1.setCellValueFactory(new PropertyValueFactory<>("name"));
         tbalamat1.setCellValueFactory(new PropertyValueFactory<>("address"));
         tbemail1.setCellValueFactory(new PropertyValueFactory<>("email"));
         tbjenjang1.setCellValueFactory(new PropertyValueFactory<>("pangkat"));
         tbview1.setItems(null);
         tbview1.setItems(guru);

    }

    @FXML
    void handleSaveButton(ActionEvent event) throws SQLException {
        IndividualHolder siswa;
        //5 Input
        siswa = new IndividualHolder (Integer.parseInt(
                tfholderID.getText()),
                tfname.getText(),
                tfaddress.getText(),
                tfemail.getText(),
                cbJenjang.getSelectionModel().getSelectedItem());
        
    
        try {
            ahdm.addAccountHolder(siswa);
            tfholderID.setText(""+ahdm.nextID());
            btnadd.fire();
            lblsavestatus.setText("Data Berhasil Disimpan");
        } catch (SQLException ex) {
            lblsavestatus.setText("Data Gagal Disimpan");
            Logger.getLogger(AccHoldFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @FXML
    void handleSaveButton1(ActionEvent event) {
          CorporateHolder guru;
        //5 Input
        guru = new CorporateHolder (Integer.parseInt(
                tfholderID1.getText()),
                tfname1.getText(),
                tfaddress1.getText(),
                tfemail1.getText(),
                cbJenjang1.getSelectionModel().getSelectedItem());
        
    
        try {
            ahdm.addAccountHolder(guru);
//            tfholderID1.setText(""+ahdm.nextID1());
            lblsavestatus1.setText("Data Berhasil Disimpan");
            btnadd1.fire();
        } catch (SQLException ex) {
            lblsavestatus1.setText("Data Gagal Disimpan");
            Logger.getLogger(AccHoldFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> jenjang = FXCollections.observableArrayList("SMA 10","SMA 11","SMA 12");
        cbJenjang.setItems(jenjang);
        ObservableList<String> pangkat = FXCollections.observableArrayList("PNS","Honorer","Sukarela");
        cbJenjang1.setItems(pangkat);
        try {
            ahdm = new AccountHolderDataModel("MYSQL");
            lblDBStatus.setText(ahdm.conn==null?"Not Connected":"Connected") ;
            tfholderID.setText(""+ahdm.nextID());
//            tfholderID1.setText(""+ahdm.nextID1());
            
            btnadd.fire();
        } catch (SQLException ex) {
            Logger.getLogger(AccHoldFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }    
    
}





















