package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.IsteMySQL.Util.VeritabanıUtil;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import com.IsteMySQL.Util.VeritabanıUtil;
import java.sql.*;
public class mesajlarYController {

	public mesajlarYController() {
		baglantı=VeritabanıUtil.Baglan();
	}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txt_alıcı;


    @FXML
    private Label lbl_sonuc; 
    
    @FXML
    private Button btn_gönder; 
    
    @FXML
    private TextField txt_gönderen;

    @FXML
    private TextArea txt_mesaj;
    
    @FXML
    private TableColumn<iletisim, String> col_ad;

    @FXML
    private TableColumn<iletisim, Integer> col_id;

    @FXML
    private TableColumn<iletisim, String> col_mail;

    @FXML
    private TableColumn<iletisim, String> col_mesaj;

    @FXML
    private TableColumn<iletisim, String> col_soyad;

    @FXML
    private TableColumn<iletisim, String> col_tel;

    @FXML
    private TableView<iletisim> tableview_iletisim;

    Connection baglantı = null ;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;
    
    public void DegerleriGetir(TableView tablo) {
    	sql = "select*from iletisim";
    	ObservableList <iletisim> mesajliste = FXCollections.observableArrayList();
    		 	try {
    		    	sorguIfadesi =baglantı.prepareStatement(sql);
    ResultSet getirilen=sorguIfadesi.executeQuery();
    while (getirilen.next()) {
    mesajliste.add(new iletisim(getirilen.getInt("id"),getirilen.getString("ad"),getirilen.getString("soy"),getirilen.getString("mail"),getirilen.getString("tel"),getirilen.getString("mesaj")));
    

    }

    col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
    col_ad.setCellValueFactory(new PropertyValueFactory<>("ad"));
    col_soyad.setCellValueFactory(new PropertyValueFactory<>("soy"));
    col_mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
    col_tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
    col_mesaj.setCellValueFactory(new PropertyValueFactory<>("mesaj"));
   


    tableview_iletisim.setItems(mesajliste);

    		 	}catch (Exception e ) {
    		 		System.out.println(e.getMessage().toString());
    		 		
    		 	}
    	
    }
        @FXML
    void btn_gönder_Click(ActionEvent event) {
        sql="insert into müsteriyegiden (alıcı,gönderen,mesaj)values(?,?,?)";
        
    	try {
    		sorguIfadesi=baglantı.prepareStatement(sql);
    		sorguIfadesi.setString(1,txt_alıcı.getText().trim());
    		sorguIfadesi.setString(2,txt_gönderen.getText().trim());
       		sorguIfadesi.setString(3,txt_mesaj.getText().trim());
   
           

            sorguIfadesi.executeUpdate();
            Alert alert = new Alert(AlertType.CONFIRMATION);
        	alert.setTitle("Başarılı");
        	alert.setHeaderText("bilgilendirme mesajı");
        	alert.setContentText("Mesaj Gönderildi");
        	alert.showAndWait();    	}
    	catch (Exception e){
            lbl_sonuc.setText(e.getMessage().toString());

    	} 
    }
    
    @FXML
    void initialize() {
  	   DegerleriGetir(tableview_iletisim);

    }

}

