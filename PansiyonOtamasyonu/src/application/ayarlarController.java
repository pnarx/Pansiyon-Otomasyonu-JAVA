package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.MouseEvent;

import java.sql.*;
import com.IsteMySQL.Util.VeritabanıUtil;

public class ayarlarController {

	public ayarlarController() {
		baglantı=VeritabanıUtil.Baglan();
	}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_geri;

    @FXML
    private Button btn_güncelle;

    @FXML
    private Button btn_sil;

    @FXML
    private Button btn_yenile;

    @FXML
    private TableColumn<admin_login, String> col_ad;

    @FXML
    private TableColumn<admin_login, Integer> col_id;

    @FXML
    private TableColumn<admin_login, String> col_mail;

    @FXML
    private TableColumn<admin_login, String> col_sifre;

    @FXML
    private TableColumn<admin_login, String> col_soy;

    @FXML
    private Label lbl_id;

    @FXML
    private Label lbl_sonuc;

    @FXML
    private TableView<admin_login> tableview_yöneticiler;

    @FXML
    private TextField txt_ad;

    @FXML
    private TextField txt_mail;

    @FXML
    private PasswordField txt_sifre;

    @FXML
    private TextField txt_soy;

    Connection baglantı = null ;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;
    
    @FXML
    void btn_geri_Click(ActionEvent event) {
    	/*try {
        	 AnchorPane panel =(AnchorPane) FXMLLoader.load(getClass().getResource("kayitekrani.fxml"));
        	anchor_sağ.getChildren().setAll(panel);
        	Scene scene = new Scene(panel,814,465);
        	
        	}
        	catch(Exception e) {
        		e.printStackTrace();
        	}
        }
        */
    }

    @FXML
    void btn_güncelle_Click(ActionEvent event) {
        String sql = "UPDATE ayarlar SET ad=?, soy=?, mail=?, sifre=? WHERE id=?";
        try {
            PreparedStatement sorguIfadesi = baglantı.prepareStatement(sql);
            sorguIfadesi.setString(1, txt_ad.getText().trim());
            sorguIfadesi.setString(2, txt_soy.getText().trim());
            sorguIfadesi.setString(3, txt_mail.getText().trim());
            sorguIfadesi.setString(4, VeritabanıUtil.MD5Sifrele(txt_sifre.getText().trim()));
            sorguIfadesi.setInt(5, Integer.parseInt(lbl_id.getText().trim()));

            int etkilenenSatirSayisi = sorguIfadesi.executeUpdate();
            if (etkilenenSatirSayisi > 0) {
                showAlert("Dikkat", "Kullanıcı güncelleştirme gerçekleşti.");
            } else {
                showAlert("Dikkat", "Kullanıcı güncelleştirme başarısız oldu.");
            }
        } catch (SQLException e) {
            lbl_sonuc.setText(e.getMessage());
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText("Bilgilendirme Mesajı");
        alert.setContentText(message);
        alert.showAndWait();
    }

     
    

    @FXML
    void btn_sil_Click(ActionEvent event) {
    	 sql = "DELETE FROM ayarlar WHERE id=?";
         try {
             sorguIfadesi = baglantı.prepareStatement(sql);
             sorguIfadesi.setString(1, lbl_id.getText().trim());

             sorguIfadesi.executeUpdate();
             Alert alert = new Alert(AlertType.WARNING);
         	alert.setTitle("Dikkat!");
         	alert.setHeaderText("bilgilendirme mesajı");
         	alert.setContentText("Kullanıcı kaydı silindi .");
         	alert.showAndWait();        } catch (Exception e) {
             lbl_sonuc.setText(e.getMessage().toString());
         }
    }

    @FXML
    void btn_yenile(ActionEvent event) {
   	   DegerleriGetir(tableview_yöneticiler);


    }
    public void DegerleriGetir(TableView tablo) {
    	sql = "select*from ayarlar";
    	ObservableList <admin_login> kayitlarliste = FXCollections.observableArrayList();
    		 	try {
    		    	sorguIfadesi =baglantı.prepareStatement(sql);
ResultSet getirilen=sorguIfadesi.executeQuery();
while (getirilen.next()) {
	kayitlarliste.add(new admin_login(getirilen.getInt("id"),getirilen.getString("ad"),getirilen.getString("soy"),getirilen.getString("mail"),getirilen.getString("sifre")));
	
}

col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
col_ad.setCellValueFactory(new PropertyValueFactory<>("ad"));
col_soy.setCellValueFactory(new PropertyValueFactory<>("soy"));
col_mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
col_sifre.setCellValueFactory(new PropertyValueFactory<>("sifre"));


tableview_yöneticiler.setItems(kayitlarliste);
	
    		 	}catch (Exception e ) {
    		 		System.out.println(e.getMessage().toString());
    		 		
    		 	}
    	
    }
    
    @FXML
    void tableview_yöneticiler_MouseClick(MouseEvent event) {
    	  admin_login kayit = new admin_login();
          kayit=(admin_login) tableview_yöneticiler.getItems().get(tableview_yöneticiler.getSelectionModel().getSelectedIndex());
          
          txt_ad.setText(kayit.getAd());
          txt_soy.setText(kayit.getSoy());
          txt_mail.setText(String.valueOf(kayit.getMail()));
          txt_sifre.setText(String.valueOf(kayit.getSifre()));
    

          lbl_id.setText(String.valueOf(kayit.getId()));
          
    }
    @FXML
    void initialize() {
  	   DegerleriGetir(tableview_yöneticiler);


    }

}
