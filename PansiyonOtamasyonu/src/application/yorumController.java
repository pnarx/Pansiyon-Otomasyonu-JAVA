package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.IsteMySQL.Util.VeritabanıUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import java.sql.*;

public class yorumController {
	
	public yorumController() {
		   baglantı=VeritabanıUtil.Baglan();
		}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_yorum;

    @FXML
    private TableColumn<yorumlar, String> col_ad;

    @FXML
    private TableColumn<yorumlar, Integer> col_id;
    @FXML
    private TableColumn<yorumlar, String> col_mail;


    @FXML
    private TableColumn<yorumlar, String> col_yorum;
    
    @FXML
    private Label lbl_id;
    
    @FXML
    private Label lbl_sonuc;

    @FXML
    private TableView<yorumlar> tableview_yorum;

    @FXML
    private TextField txt_ad;

    @FXML
    private TextField txt_mail;

    @FXML
    private TextArea txtarea_yorum;
    
    Connection baglantı = null ;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;
    
    @FXML
    void btn_yorum_Click(ActionEvent event) {
    	sql="insert into yorum (ad,yorum,mail)values(?,?,?)";
    	try {
    		sorguIfadesi=baglantı.prepareStatement(sql);
    		sorguIfadesi.setString(2,txtarea_yorum.getText().trim());
    		sorguIfadesi.setString(1,txt_ad.getText().trim());
    		sorguIfadesi.setString(3,txt_mail.getText().trim());
            sorguIfadesi.executeUpdate();
            Alert alert = new Alert(AlertType.INFORMATION);
         	alert.setTitle("Bigi");
         	alert.setHeaderText("Bilgilendirme mesajı");
         	alert.setContentText("Yorum ekleme işlemi gerçekleşti....");
         	alert.showAndWait();      
          
      	   DegerleriGetir(tableview_yorum);

    	}
    	catch (Exception e){
            lbl_sonuc.setText(e.getMessage().toString());

    	} 
    }
    public void DegerleriGetir(TableView tablo) {
        sql = "select * from yorum";
        ObservableList<yorumlar> yorumliste = FXCollections.observableArrayList();
        try {
            sorguIfadesi = baglantı.prepareStatement(sql);
            ResultSet getirilen = sorguIfadesi.executeQuery();
            while (getirilen.next()) {
                yorumliste.add(new yorumlar(
                        getirilen.getInt("id"),
                        getirilen.getString("ad"),
                        getirilen.getString("yorum"),
                        getirilen.getString("mail")
                ));
            }

            col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
            col_ad.setCellValueFactory(new PropertyValueFactory<>("ad")); // Bu satırı ekledim
            col_yorum.setCellValueFactory(new PropertyValueFactory<>("yorum"));
            col_mail.setCellValueFactory(new PropertyValueFactory<>("mail"));

            tableview_yorum.setItems(yorumliste);
        } catch (Exception e) {
            System.out.println(e.getMessage().toString());
        }
    }


    @FXML
    void tableview_yorum_MouseClick(MouseEvent event) {
    	 yorumlar yorumm = new yorumlar();
         yorumm=(yorumlar) tableview_yorum.getItems().get(tableview_yorum.getSelectionModel().getSelectedIndex());
         txt_ad.setText(yorumm.getAd());
         txtarea_yorum.setText(yorumm.getYorum());
         txt_mail.setText(String.valueOf(yorumm.getMail()));
         lbl_id.setText(String.valueOf(yorumm.getId()));
    }

    @FXML
    void initialize() {
    	   DegerleriGetir(tableview_yorum);
    	   col_mail.setVisible(false);
    	   btn_yorum.setStyle("-fx-background-radius: 50;");
    }

}
