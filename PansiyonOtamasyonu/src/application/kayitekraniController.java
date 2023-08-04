package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.sql.*;
import com.IsteMySQL.Util.VeritabanıUtil;

public class kayitekraniController {

	public kayitekraniController() {
		   baglantı=VeritabanıUtil.Baglan();
		}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_güncelle;

    @FXML
    private Button btn_kaydet;
    
    @FXML
    private Button btn_ara;
    
    @FXML
    private Button btn_sil;

    @FXML
    private Button btn_yenile;


    @FXML
    private AnchorPane anchor_orta; 
    
    @FXML
    private ComboBox<String> cmb_odater;

    @FXML
    private TableColumn<müsterikayit, String> col_adsoy;

    @FXML
    private TableColumn<müsterikayit, String> col_birey;

    @FXML
    private TableColumn<müsterikayit, String> col_cikist;

    @FXML
    private TableColumn<müsterikayit, Integer> col_fiyat;

    @FXML
    private TableColumn<müsterikayit, String> col_girist;

    @FXML
    private TableColumn<müsterikayit, Integer> col_id;

    @FXML
    private TableColumn<müsterikayit, Integer> col_odasay;

    @FXML
    private TableColumn<müsterikayit, String> col_odater;

    @FXML
    private TableColumn<müsterikayit, Integer> col_tc;

    @FXML
    private TableColumn<müsterikayit, String> col_tel;

    @FXML
    private DatePicker dtpck_cikis;
    
    @FXML
    private Label lbl_armasonuc;
    
    @FXML
    private DatePicker dtpck_girs;

    @FXML
    private TextField txt_fiyat;

    @FXML
    private Button btn_ileri; 
    
    @FXML
    private Label lbl_id;
    
    @FXML
    private TextField txt_ara;
    
    @FXML
    private TableView<müsterikayit> tableview_kayit;

    @FXML
    private TextField txt_adsoy;

    @FXML
    private TextField txt_birey;

    @FXML
    private TextField txt_odasay;

    @FXML
    private TextField txt_tc;


    @FXML
    private Label lbl_sonuc; 
    
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


    public void DegerleriGetir(TableView tablo) {
    	sql = "select*from kayit";
    	ObservableList <müsterikayit> müsteriliste = FXCollections.observableArrayList();
    		 	try {
    		    	sorguIfadesi =baglantı.prepareStatement(sql);
ResultSet getirilen=sorguIfadesi.executeQuery();
while (getirilen.next()) {
	müsteriliste.add(new müsterikayit(getirilen.getInt("id"),getirilen.getString("ad_soy"),getirilen.getString("tel"),getirilen.getString("tc"),getirilen.getInt("oda_say"),getirilen.getInt("birey_say"),getirilen.getString("oda_tercihi"),getirilen.getString("giris_tarih"),getirilen.getString("cikis_tarih"),getirilen.getInt("fiyat")));
	
}

col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
col_adsoy.setCellValueFactory(new PropertyValueFactory<>("ad_soy"));
col_tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
col_tc.setCellValueFactory(new PropertyValueFactory<>("tc"));
col_odasay.setCellValueFactory(new PropertyValueFactory<>("oda_say"));
col_birey.setCellValueFactory(new PropertyValueFactory<>("birey_say"));
col_odater.setCellValueFactory(new PropertyValueFactory<>("oda_tercih"));
col_girist.setCellValueFactory(new PropertyValueFactory<>("giris_tarih"));
col_cikist.setCellValueFactory(new PropertyValueFactory<>("cikis_tarih"));
col_fiyat.setCellValueFactory(new PropertyValueFactory<>("fiyat"));


tableview_kayit.setItems(müsteriliste);
	
    		 	}catch (Exception e ) {
    		 		System.out.println(e.getMessage().toString());
    		 		
    		 	}
    	
    }
    @FXML

    void btn_güncelle_Click(ActionEvent event) {
        sql = "UPDATE kayit SET ad_soy=?, tel=?, tc=?, oda_say=?, birey_say=?, oda_tercihi=?, giris_tarih=?, cikis_tarih=?, fiyat=? WHERE id=?";
        try {
            sorguIfadesi = baglantı.prepareStatement(sql);
            sorguIfadesi.setString(1, txt_adsoy.getText().trim());
            sorguIfadesi.setString(2, txt_tel.getText().trim());
            sorguIfadesi.setString(3, txt_tc.getText().trim());
            sorguIfadesi.setString(4, String.valueOf(txt_birey.getText().trim()));
            sorguIfadesi.setString(5, String.valueOf(txt_odasay.getText().trim()));
            sorguIfadesi.setString(6, cmb_odater.getValue().toString().trim());
            sorguIfadesi.setString(7, dtpck_girs.getValue().toString().trim());
            sorguIfadesi.setString(8, dtpck_cikis.getValue().toString().trim());
            sorguIfadesi.setString(9, String.valueOf(txt_fiyat.getText().trim()));
            sorguIfadesi.setString(10,String.valueOf( lbl_id.getText().trim()));

            sorguIfadesi.executeUpdate();
            Alert alert = new Alert(AlertType.CONFIRMATION);
        	alert.setTitle("Dikkat!");
        	alert.setHeaderText("bilgilendirme mesajı");
        	alert.setContentText("Kullanıcı güncelleştirme gerçekleşti...");
        	alert.showAndWait();
            
            if (cmb_odater.getValue() != null) {
                String odaTercihi = cmb_odater.getValue().toString().trim();
                // Güncelleme işlemini gerçekleştir
                // ...
            } else {
                // Seçili bir oda tercihi yok, hata işlemlerini yap
                // ...
            }

            
        } catch (Exception e) {
            lbl_sonuc.setText(e.getMessage().toString());
        }
    }
    
    @FXML
    void btn_ileri_Click(ActionEvent event) {
    	try {
        	 AnchorPane panel =(AnchorPane) FXMLLoader.load(getClass().getResource("odalarY.fxml"));
        	anchor_orta.getChildren().setAll(panel);
        	Scene scene = new Scene(panel,814,466);
        	
        	}
        	catch(Exception e) {
        		e.printStackTrace();
        	}
        }
    

    @FXML
    void btn_kaydet_Click(ActionEvent event) {
    	sql="insert into kayit (ad_soy,tel,tc,oda_say,birey_say,oda_tercihi,giris_tarih,cikis_tarih,fiyat)values(?,?,?,?,?,?,?,?,?)";
    	try {
    		sorguIfadesi=baglantı.prepareStatement(sql);
    		sorguIfadesi.setString(2,txt_tel.getText().trim());
    		sorguIfadesi.setString(1,txt_adsoy.getText().trim());
    		sorguIfadesi.setString(3,txt_tc.getText().trim());
    		sorguIfadesi.setString(4,txt_birey.getText().trim());
    		sorguIfadesi.setString(5,txt_odasay.getText().trim());
    		sorguIfadesi.setString(6,cmb_odater.getValue().toString().trim());
    		sorguIfadesi.setString(7,dtpck_girs.getValue().toString().trim());
    		sorguIfadesi.setString(8,dtpck_cikis.getValue().toString().trim());
    		sorguIfadesi.setString(9,txt_fiyat.getText().trim());


            sorguIfadesi.executeUpdate();
            Alert alert = new Alert(AlertType.CONFIRMATION);
        	alert.setTitle("Başarılı");
        	alert.setHeaderText("bilgilendirme mesajı");
        	alert.setContentText("Kullanıcı kayıt edildi.");
        	alert.showAndWait();    	}
    	catch (Exception e){
            lbl_sonuc.setText(e.getMessage().toString());

    	} 
    }
  

@FXML
    void btn_sil_Click(ActionEvent event) {
        sql = "DELETE FROM kayit WHERE id=?";
        try {
            sorguIfadesi = baglantı.prepareStatement(sql);
            sorguIfadesi.setString(1, lbl_id.getText().trim());

            sorguIfadesi.executeUpdate();
            Alert alert = new Alert(AlertType.CONFIRMATION);
        	alert.setTitle("Dikkat!");
        	alert.setHeaderText("bilgilendirme mesajı");
        	alert.setContentText("Kullanıcı kaydı silindi .");
        	alert.showAndWait();        } catch (Exception e) {
            lbl_sonuc.setText(e.getMessage().toString());
        }
    }


    @FXML
    void btn_yenile_Click(ActionEvent event) {
 	   DegerleriGetir(tableview_kayit);

    }
    @FXML
    void btn_ara_Click(ActionEvent event) {
    	
    	    String arananKelime = txt_ara.getText().trim();
    	    
    	    if (arananKelime.isEmpty()) {
    	        // Aranan kelime boşsa, tüm kayıtları göster
    	        DegerleriGetir(tableview_kayit);
    	    } else {
    	        // Aranan kelimeye göre kayıtları filtrele
    	        sql = "SELECT * FROM kayit WHERE ad_soy LIKE ? OR tel LIKE ? OR tc LIKE ?";
    	        try {
    	            sorguIfadesi = baglantı.prepareStatement(sql);
    	            sorguIfadesi.setString(1, "%" + arananKelime + "%"); // Ad veya soyada göre arama
    	            sorguIfadesi.setString(2, "%" + arananKelime + "%"); // Telefon numarasına göre arama
    	            sorguIfadesi.setString(3, "%" + arananKelime + "%"); // TC numarasına göre arama
    	            
    	            ResultSet getirilen = sorguIfadesi.executeQuery();
    	            ObservableList<müsterikayit> müsteriliste = FXCollections.observableArrayList();
    	            while (getirilen.next()) {
    	                müsteriliste.add(new müsterikayit(
    	                        getirilen.getInt("id"),
    	                        getirilen.getString("ad_soy"),
    	                        getirilen.getString("tel"),
    	                        getirilen.getString("tc"),
    	                        getirilen.getInt("oda_say"),
    	                        getirilen.getInt("birey_say"),
    	                        getirilen.getString("oda_tercihi"),
    	                        getirilen.getString("giris_tarih"),
    	                        getirilen.getString("cikis_tarih"),
    	                        getirilen.getInt("fiyat")
    	                ));
    	            }

    	            tableview_kayit.setItems(müsteriliste);
    	        } catch (Exception e) {
    	        	
    	            lbl_armasonuc.setText(e.getMessage().toString());
    	        }
    	    }
    	}
    
    @FXML
    void tableview_kayit_MouseClick(MouseEvent event) {
    	  müsterikayit kayit = new müsterikayit();
           kayit=(müsterikayit) tableview_kayit.getItems().get(tableview_kayit.getSelectionModel().getSelectedIndex());
           txt_adsoy.setText(kayit.getAd_soy());
           txt_tel.setText(String.valueOf(kayit.getTel()));
           txt_tc.setText(String.valueOf(kayit.getTc()));
           txt_birey.setText(String.valueOf(kayit.getBirey_say()));
           txt_odasay.setText(String.valueOf(kayit.getOda_say()));
           cmb_odater.setPromptText(String.valueOf(kayit.getOda_tercih()));
           dtpck_girs.setPromptText(String.valueOf(kayit.getGiris_tarih()));
           dtpck_cikis.setPromptText(String.valueOf(kayit.getCikis_tarih()));
           txt_fiyat.setText(String.valueOf(kayit.getFiyat()));

           lbl_id.setText(String.valueOf(kayit.getId()));
           
    }

    @FXML
    void initialize() {
    	   DegerleriGetir(tableview_kayit);
    	    cmb_odater.setItems(odatipi); 
    	    btn_kaydet.setStyle("-fx-background-color:  #FFFFFF;");
    	    btn_sil.setStyle("-fx-background-color:  #FFFFFF;");
    	    btn_yenile.setStyle("-fx-background-color:  #FFFFFF;");
    	    btn_güncelle.setStyle("-fx-background-color:  #FFFFFF;");
    	    btn_ara.setStyle("-fx-background-color:  #FFFFFF;");

    	    btn_ara.setStyle("-fx-background-radius: 50;");
    	    btn_kaydet.setStyle("-fx-background-radius: 50;");
    	    btn_sil.setStyle("-fx-background-radius: 50;");
    	    btn_yenile.setStyle("-fx-background-radius: 50;");
    	    btn_güncelle.setStyle("-fx-background-radius: 50;");

    }

}
