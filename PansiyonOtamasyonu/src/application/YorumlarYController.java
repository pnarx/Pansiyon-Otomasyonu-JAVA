package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.sql.*;
import com.IsteMySQL.Util.VeritabanıUtil;

public class YorumlarYController {

	public YorumlarYController() {
		baglantı=VeritabanıUtil.Baglan();
	}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<yorumlar, String> col_ad;

    @FXML
    private TableColumn<yorumlar, Integer> col_id;

    @FXML
    private TableColumn<yorumlar, String> col_mail;

    @FXML
    private TableColumn<yorumlar, String> col_yorum;

    @FXML
    private TableView<yorumlar> tableview_yorumlar;


    Connection baglantı = null ;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;
    
    public void DegerleriGetir(TableView tablo) {
    	sql = "select*from yorum";
    	ObservableList <yorumlar> liste = FXCollections.observableArrayList();
    		 	try {
    		    	sorguIfadesi =baglantı.prepareStatement(sql);
    ResultSet getirilen=sorguIfadesi.executeQuery();
    while (getirilen.next()) {
    liste.add(new yorumlar(getirilen.getInt("id"),getirilen.getString("ad"),getirilen.getString("yorum"),getirilen.getString("mail")));
    

    }

    col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
    col_ad.setCellValueFactory(new PropertyValueFactory<>("ad"));
    col_yorum.setCellValueFactory(new PropertyValueFactory<>("yorum"));
    col_mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
  


    tableview_yorumlar.setItems(liste);

    		 	}catch (Exception e ) {
    		 		System.out.println(e.getMessage().toString());
    		 		
    		 	}
    	
    }
    @FXML
    void initialize() {
        DegerleriGetir(tableview_yorumlar);
    }

}
