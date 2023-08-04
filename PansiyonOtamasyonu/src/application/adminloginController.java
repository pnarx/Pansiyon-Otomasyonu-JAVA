package application;

import javafx.scene.control.PasswordField;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import com.IsteMySQL.Util.VeritabanıUtil;
import java.sql.*;
import com.IsteMySQL.Util.VeritabanıUtil;
import javafx.scene.control.Label;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class adminloginController {

	public adminloginController() {
	   baglantı=VeritabanıUtil.Baglan();
	}
    @FXML
    private ResourceBundle resources;
    
    @FXML
    private PasswordField txt_sifre;
    
    @FXML
    private URL location;

    @FXML
    private AnchorPane anhor_ilk;

    @FXML
    private Label lbl_sonuc;
    
    @FXML
    private Button btn_giris;

    @FXML
    private TextField txt_kul;

  
    
    Connection baglantı = null ;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;
    
    @FXML
    void btn_giris_Click(ActionEvent event) {
        sql = "SELECT * FROM ayarlar WHERE ad=? AND sifre=?";
        try {
            sorguIfadesi = baglantı.prepareStatement(sql);
            sorguIfadesi.setString(1, txt_kul.getText().trim());
            sorguIfadesi.setString(2, VeritabanıUtil.MD5Sifrele(txt_sifre.getText().trim()));

            ResultSet getirilen = sorguIfadesi.executeQuery();
            if (!getirilen.next()) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("UYARI!");
                alert.setHeaderText(" Bilgileriniz Kontrol Edin");
                alert.setContentText("Giriş Başarısız. ");
                alert.showAndWait();
            } else {
                System.out.println("id:" + getirilen.getString("id"));
                System.out.println("kullanıcı:" + getirilen.getString("ad"));
                System.out.println("şifre:" + getirilen.getString("sifre"));
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Başarılı");
                alert.setHeaderText("bilgilendirme mesajı");
                alert.setContentText("Giriş Başarılı");
                alert.showAndWait();

                AnchorPane panel = FXMLLoader.load(getClass().getResource("yönetici2.fxml"));
                anhor_ilk.getChildren().setAll(panel);
                Scene scene = new Scene(panel, 810, 465);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }



    @FXML
    void initialize() {
       btn_giris.setStyle("-fx-background-color:  #FFFFFF;");
       btn_giris.setStyle("-fx-background-radius: 50;");
    }

}
