
package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

import java.sql.*;
import com.IsteMySQL.Util.VeritabanıUtil;

public class RezervasyonController {

	public RezervasyonController() {
		baglantı=VeritabanıUtil.Baglan();
	}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_gönder;

    @FXML
    private ComboBox<String> cmb_oda;

    @FXML
    private DatePicker dtpck_cikis;

    @FXML
    private DatePicker dtpck_giris;

    @FXML
    private Label lbl_sonuc;

    @FXML
    private TextField txt_ad;

    @FXML
    private TextField txt_cocuksayi;

    @FXML
    private TextField txt_gsm;

    @FXML
    private TextField txt_kisisayı;
    
    @FXML
    private Button btn_renk;

    @FXML
    private TextField txt_mail;

    @FXML
    private TextArea txt_not;

    @FXML
    private TextField txt_soyad;

    @FXML
    private TextField txt_tel;

    Connection baglantı = null ;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;

    ObservableList<String> odatipi = FXCollections.observableArrayList(
            "Balkonlu",
            "Teras kat",
            "Orta kat",
            "Balkonsuz",
            "Aile Odası",
            "Tek Kişilk"
            
    );
    
    @FXML
    void btn_gönder(ActionEvent event) {
    	sql="insert into rezervasyon (ad,soyad,tel,gsm, mail,odatip, ksayı,csayı,giristarih,cikistarih,mesaj)values(?,?,?,?,?,?,?,?,?,?,?)";
    	try {
    		sorguIfadesi=baglantı.prepareStatement(sql);
    		sorguIfadesi.setString(1,txt_ad.getText().trim());
    		sorguIfadesi.setString(2,txt_soyad.getText().trim());
    		sorguIfadesi.setString(3,txt_tel.getText().trim());    		
    		sorguIfadesi.setString(4,txt_gsm.getText().trim());
    		sorguIfadesi.setString(5,txt_mail.getText().trim());
    		sorguIfadesi.setString(6,cmb_oda.getValue().toString().trim());
    		sorguIfadesi.setString(7,txt_kisisayı.getText().trim());
    		sorguIfadesi.setString(8,txt_cocuksayi.getText().trim());
    		sorguIfadesi.setString(9,dtpck_giris.getValue().toString().trim());
    		sorguIfadesi.setString(10,dtpck_cikis.getValue().toString().trim());
    		sorguIfadesi.setString(11,txt_not.getText().trim());


            sorguIfadesi.executeUpdate();
            Alert alert = new Alert(AlertType.INFORMATION);
         	alert.setTitle("Başarılı");
         	alert.setHeaderText("bilgilendirme mesajı");
         	alert.setContentText("Mesaj İletildi.");
         	alert.showAndWait(); 
    	}
    	catch (Exception e){
            lbl_sonuc.setText(e.getMessage().toString());

    	} 
    }

    @FXML
    void initialize() {
	    cmb_oda.setItems(odatipi); 
	    btn_renk.setStyle("-fx-background-color:#845454;");
	    btn_gönder.setStyle("-fx-background-radius: 50;");
    }

}
