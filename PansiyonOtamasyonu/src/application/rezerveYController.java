package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.IsteMySQL.Util.VeritabanıUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.cell.PropertyValueFactory;

public class rezerveYController {

	public rezerveYController() {
		baglantı=VeritabanıUtil.Baglan();
	}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_gönder;

    @FXML
    private Button btn_kayıt;

    @FXML
    private TableColumn<Rezervasyon, String> col_ad;

    @FXML
    private TableColumn<Rezervasyon, String> col_csayı;

    @FXML
    private TableColumn<Rezervasyon, String> col_ctarih;

    @FXML
    private TableColumn<Rezervasyon, String> col_gsm;

    @FXML
    private TableColumn<Rezervasyon, String> col_gtarih;

    @FXML
    private TableColumn<Rezervasyon, Integer> col_id;

    @FXML
    private TableColumn<Rezervasyon, String> col_ksayı;

    @FXML
    private TableColumn<Rezervasyon, String> col_mail;

    @FXML
    private TableColumn<Rezervasyon, String> col_mesaj;

    @FXML
    private TableColumn<Rezervasyon, String> col_oda;

    @FXML
    private TableColumn<Rezervasyon, String> col_soy;

    @FXML
    private TableColumn<Rezervasyon, String> col_tel;

    @FXML
    private Label lbl_id;

    @FXML
    private Label lbl_sonuc;

    @FXML
    private Label lbl_sonuc1;

    @FXML
    private TableView<Rezervasyon> tableview_rezervasyon;

    @FXML
    private TextField txt_alıcı;

    @FXML
    private AnchorPane anchor_ilk;
    
    @FXML
    private TextField txt_gönderen;

    @FXML
    private TextArea txt_mesaj;
    
    Connection baglantı = null ;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;
    
    @FXML
    void btn_gönder_Click(ActionEvent event) {
    	 sql="insert into müsteriyegiden (alıcı,gönderen,mesaj)values(?,?,?)";
         
     	try {
     		sorguIfadesi=baglantı.prepareStatement(sql);
     		sorguIfadesi.setString(1,txt_alıcı.getText().trim());
     		sorguIfadesi.setString(2,txt_gönderen.getText().trim());
        		sorguIfadesi.setString(3,txt_mesaj.getText().trim());
    
            

             sorguIfadesi.executeUpdate();
             Alert alert = new Alert(AlertType.INFORMATION);
         	alert.setTitle("Başarılı");
         	alert.setHeaderText("bilgilendirme mesajı");
         	alert.setContentText("Mesaj Gönderildi");
         	alert.showAndWait();    	}
     	catch (Exception e){
             lbl_sonuc.setText(e.getMessage().toString());

     	} 
    }

    @FXML
    void btn_kayıt_Click(ActionEvent event) {
    	
    	try {
    	 AnchorPane panel =(AnchorPane) FXMLLoader.load(getClass().getResource("kayitekrani.fxml"));
     	anchor_ilk.getChildren().setAll(panel);
     	Scene scene = new Scene(panel,814,465);
     	
     	}
     	catch(Exception e) {
     		e.printStackTrace();
     	}
    }
    
    public void DegerleriGetir(TableView tablo) {
    	sql = "select*from rezervasyon";
    	ObservableList <Rezervasyon> liste = FXCollections.observableArrayList();
    		 	try {
    		    	sorguIfadesi =baglantı.prepareStatement(sql);
    ResultSet getirilen=sorguIfadesi.executeQuery();
    while (getirilen.next()) {
    liste.add(new Rezervasyon(getirilen.getInt("id"),getirilen.getString("ad"),getirilen.getString("soyad"),getirilen.getString("tel"),getirilen.getString("gsm"),getirilen.getString("mail"),getirilen.getString("odatip"),getirilen.getString("ksayi"),getirilen.getString("csayi"),getirilen.getString("giristarih"),getirilen.getString("cikistarih"),getirilen.getString("mesaj")));
    

    }

    col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
    col_ad.setCellValueFactory(new PropertyValueFactory<>("ad"));
    col_soy.setCellValueFactory(new PropertyValueFactory<>("soy"));
    col_tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
    col_gsm.setCellValueFactory(new PropertyValueFactory<>("gsm"));
    col_mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
    col_oda.setCellValueFactory(new PropertyValueFactory<>("odatip"));
    col_ksayı.setCellValueFactory(new PropertyValueFactory<>("ksayi"));
    col_csayı.setCellValueFactory(new PropertyValueFactory<>("csayi"));
    col_gtarih.setCellValueFactory(new PropertyValueFactory<>("girist"));
    col_ctarih.setCellValueFactory(new PropertyValueFactory<>("cikist"));
    col_mesaj.setCellValueFactory(new PropertyValueFactory<>("mesaj"));




    tableview_rezervasyon.setItems(liste);

    		 	}catch (Exception e ) {
    		 		System.out.println(e.getMessage().toString());
    		 		
    		 	}
    	
    }
    
    @FXML
    void initialize() {
      DegerleriGetir(tableview_rezervasyon);
    }

}
