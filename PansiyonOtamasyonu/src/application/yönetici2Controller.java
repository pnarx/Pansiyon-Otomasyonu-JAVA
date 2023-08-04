package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import java.sql.*;
import com.IsteMySQL.Util.VeritabanıUtil;

public class yönetici2Controller {

	public yönetici2Controller() {
		baglantı = VeritabanıUtil.Baglan();
	}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchor_ilk;

    @FXML
    private AnchorPane anchor_sağ;

    @FXML
    private AnchorPane anchor_sol;

    @FXML
    private Label bl_id;

    @FXML
    private Button btn_ayarlar;

    @FXML
    private Button btn_ileri;

    @FXML
    private Button btn_kaydet;

    @FXML
    private Button btn_kayıt;

    @FXML
    private Button btn_mesaj;

    @FXML
    private Button btn_mkayit;

    @FXML
    private Button btn_odalar;

    @FXML
    private Button btn_rezerve;

    @FXML
    private Button btn_yorum;

    @FXML
    private Label lbl_sonuc;

    @FXML
    private TextField txt_ad;

    @FXML
    private TextField txt_mail;

    @FXML
    private TextField txt_sifre;

    @FXML
    private TextField txt_soy;

    Connection baglantı = null ;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql; 
    @FXML
    void btn_ayarlar_Click(ActionEvent event) {
    	try {
        	 AnchorPane panel =(AnchorPane) FXMLLoader.load(getClass().getResource("ayarlar.fxml"));
        	anchor_sağ.getChildren().setAll(panel);
        	Scene scene = new Scene(panel,814,465);
        	
        	}
        	catch(Exception e) {
        		e.printStackTrace();
        	}
        }
    

    @FXML
    void btn_ileri_Click(ActionEvent event) {
    	try {
          	 AnchorPane panel =(AnchorPane) FXMLLoader.load(getClass().getResource("kayitekrani.fxml"));
          	anchor_sağ.getChildren().setAll(panel);
          	Scene scene = new Scene(panel,814,465);
          	
          	}
          	catch(Exception e) {
          		e.printStackTrace();
          	}
          }
    

    @FXML
    void btn_kaydet_Click(ActionEvent event) {
    	sql="insert into ayarlar (ad,soy,mail,sifre)values(?,?,?,?)";
    	try {
    		sorguIfadesi=baglantı.prepareStatement(sql);
    		sorguIfadesi.setString(2,txt_ad.getText().trim());
    		sorguIfadesi.setString(1,txt_soy.getText().trim());
    		sorguIfadesi.setString(3,txt_mail.getText().trim());
            sorguIfadesi.setString(4, VeritabanıUtil.MD5Sifrele(txt_sifre.getText().trim()));
    
    


            sorguIfadesi.executeUpdate();
            Alert alert = new Alert(AlertType.CONFIRMATION);
        	alert.setTitle("Başarılı");
        	alert.setHeaderText("bilgilendirme mesajı");
        	alert.setContentText("Yeni Bir Yönetici Kayıt Edildi.");
        	alert.showAndWait();    	}
    	catch (Exception e){
            lbl_sonuc.setText(e.getMessage().toString());

    	} 
    }

    @FXML
    void btn_kayıt_Click(ActionEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("yönetici2.fxml"));
    		AnchorPane anasayfa= loader.load();

          	AnchorPane anasayfaPanel = (AnchorPane) anchor_sağ.getParent(); // Mevcut panelin bulunduğu panele erişim
          	anasayfaPanel.getChildren().setAll(anasayfa);

          	}
          	catch(Exception e) {
          		e.printStackTrace();
          	}
    }

    @FXML
    void btn_mesaj_Click(ActionEvent event) {
    	try {
        	 AnchorPane panel =(AnchorPane) FXMLLoader.load(getClass().getResource("mesajlarY.fxml"));
        	anchor_sağ.getChildren().setAll(panel);
        	Scene scene = new Scene(panel,814,465);
        	
        	}
        	catch(Exception e) {
        		e.printStackTrace();
        	}
        }
    

    @FXML
    void btn_mkayit_Click(ActionEvent event) {
    	try {
         	 AnchorPane panel =(AnchorPane) FXMLLoader.load(getClass().getResource("kayitekrani.fxml"));
         	anchor_sağ.getChildren().setAll(panel);
         	Scene scene = new Scene(panel,814,465);
         	
         	}
         	catch(Exception e) {
         		e.printStackTrace();
         	}
         }
    

    @FXML
    void btn_odalar_Click(ActionEvent event) {
    	try {
       	 AnchorPane panel =(AnchorPane) FXMLLoader.load(getClass().getResource("odalarY.fxml"));
       	anchor_sağ.getChildren().setAll(panel);
       	Scene scene = new Scene(panel,814,465);
       	
       	}
       	catch(Exception e) {
       		e.printStackTrace();
       	}
       }
    

    @FXML
    void btn_rezerve_Click(ActionEvent event) {
    	try {
        	 AnchorPane panel =(AnchorPane) FXMLLoader.load(getClass().getResource("rezerveY.fxml"));
        	anchor_sağ.getChildren().setAll(panel);
        	Scene scene = new Scene(panel,814,465);
        	
        	}
        	catch(Exception e) {
        		e.printStackTrace();
        	}
    }

    @FXML
    void btn_yorum_Click(ActionEvent event) {
    	try {
        	 AnchorPane panel =(AnchorPane) FXMLLoader.load(getClass().getResource("YorumlarY.fxml"));
        	anchor_sağ.getChildren().setAll(panel);
        	Scene scene = new Scene(panel,814,465);
        	
        	}
        	catch(Exception e) {
        		e.printStackTrace();
        	}
    }

    @FXML
    void initialize() {
      
    }

}

