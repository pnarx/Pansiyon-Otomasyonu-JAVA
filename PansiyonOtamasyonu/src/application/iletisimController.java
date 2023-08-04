package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import java.sql.*;
import com.IsteMySQL.Util.VeritabanıUtil;

public class iletisimController {

	public iletisimController() {
		   baglantı=VeritabanıUtil.Baglan();

	}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_gönder;

    @FXML
    private TextField txt_ad;

    @FXML
    private TextField txt_mail;

    @FXML
    private Label lbl_sonuc;
    
    @FXML
    private TextArea txt_mesaj;

    @FXML
    private TextField txt_soyad;

    @FXML
    private TextField txt_tel;

    Connection baglantı = null ;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;
   
    
    @FXML
    void btn_gönder_Click(ActionEvent event) {
    	sql="insert into iletisim (ad,soy,tel,mail,mesaj)values(?,?,?,?,?)";
    	try {
    		sorguIfadesi=baglantı.prepareStatement(sql);
    		sorguIfadesi.setString(1,txt_ad.getText().trim());
    		sorguIfadesi.setString(2,txt_soyad.getText().trim());
    		sorguIfadesi.setString(3,txt_tel.getText().trim());
    		sorguIfadesi.setString(4,txt_mail.getText().trim());
    		sorguIfadesi.setString(5,txt_mesaj.getText().trim());


            sorguIfadesi.executeUpdate();
            Alert alert = new Alert(AlertType.INFORMATION);
        	alert.setTitle("Başarılı");
        	alert.setHeaderText("Bilgilendirme Mesajı");
        	alert.setContentText("Bilgiler Gönderildi.");
        	alert.showAndWait();
    	}
    	catch (Exception e){
            lbl_sonuc.setText(e.getMessage().toString());

    	} 
    }

    @FXML
    void initialize() {
    	btn_gönder.setStyle("-fx-background-radius: 50;");

    }

}
