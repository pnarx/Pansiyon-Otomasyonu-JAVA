package application;

import java.awt.Image;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ANASAYFAController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchor_alt;

    @FXML
    private AnchorPane anchor_tüm;
    
    @FXML
    private Text txt_hak;

    @FXML
    private Text txt_hiz;

    @FXML
    private Text txt_ilet;
    
    @FXML
    public AnchorPane anchor_orta;
    @FXML
    private AnchorPane anchor_üst;

    @FXML
    private Button btn_anasayfa;

    @FXML
    private Button btn_rezerve;
    
    @FXML
    private Button btn_fiyat;

    @FXML
    private Button btn_giris;

    @FXML
    private Button btn_hakkimizda;

    @FXML
    private Button btn_iletisim;

    @FXML
    private Button btn_odalar;

    @FXML
    private Button btn_yorumlar;

    @FXML
    private Label lbl_hakimizda;

    @FXML
    private Label lbl_hizmetler;

    @FXML
    private Label lbl_ileitsim;

    @FXML
    void anchor_tüm_Click(ActionEvent event) {

    }
    @FXML
    void btn_Anasayfa_Click(ActionEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("ANASAYFA.fxml"));
    		AnchorPane anasayfa= loader.load();

          	AnchorPane anasayfaPanel = (AnchorPane) anchor_orta.getParent(); // Mevcut panelin bulunduğu panele erişim
          	anasayfaPanel.getChildren().setAll(anasayfa);

          	}
          	catch(Exception e) {
          		e.printStackTrace();
          	}

    }
    
    
    @FXML
    void btn_rezerve_Click(ActionEvent event) {
    	try {
          	 AnchorPane panel =(AnchorPane) FXMLLoader.load(getClass().getResource("rezervasyon.fxml"));
          	anchor_orta.getChildren().setAll(panel);
          	Scene scene = new Scene(panel,300,300);
          	
          	}
          	catch(Exception e) {
          		e.printStackTrace();
          	}
          }
    

    @FXML
    void btn_fiyat_Click(ActionEvent event) {
    	try {
          	 AnchorPane panel =(AnchorPane) FXMLLoader.load(getClass().getResource("fiyat.fxml"));
          	anchor_orta.getChildren().setAll(panel);
          	Scene scene = new Scene(panel,814,465);
          	
          	}
          	catch(Exception e) {
          		e.printStackTrace();
          	}
    }

    @FXML
    void btn_giris_Click(ActionEvent event) {
    	try {
       	 AnchorPane panel =(AnchorPane) FXMLLoader.load(getClass().getResource("adminlogin.fxml"));
       	anchor_orta.getChildren().setAll(panel);
       	Scene scene = new Scene(panel,300,300);
       	
       	}
       	catch(Exception e) {
       		e.printStackTrace();
       	}
       }


    @FXML
    void btn_hakkimizda_Click(ActionEvent event) {

    	try {
    	 AnchorPane panel =(AnchorPane) FXMLLoader.load(getClass().getResource("pansiyonhakkında.fxml"));
    	anchor_orta.getChildren().setAll(panel);
    	Scene scene = new Scene(panel,810,462);
    	
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void btn_iletisim_Click(ActionEvent event) {
    	try {
       	 AnchorPane panel =(AnchorPane) FXMLLoader.load(getClass().getResource("iletisim.fxml"));
       	anchor_orta.getChildren().setAll(panel);
       	Scene scene = new Scene(panel,814,466);
       	
       	}
       	catch(Exception e) {
       		e.printStackTrace();
       	}
       }
    

    @FXML
    void btn_odalar_Click(ActionEvent event) {
    	try {
         	 AnchorPane panel =(AnchorPane) FXMLLoader.load(getClass().getResource("odalar.fxml"));
         	anchor_orta.getChildren().setAll(panel);
         	Scene scene = new Scene(panel,814,466);
         	
         	}
         	catch(Exception e) {
         		e.printStackTrace();
         	}
         }
   

    

    @FXML
    void btn_yorumlar_Click(ActionEvent event) {
    	try {
       	 AnchorPane panel =(AnchorPane) FXMLLoader.load(getClass().getResource("yorum.fxml"));
       	anchor_orta.getChildren().setAll(panel);
       	Scene scene = new Scene(panel,814,465);
       	
       	}
       	catch(Exception e) {
       		e.printStackTrace();
       	}
       }

    @FXML
    void initialize() {
    	txt_hak.setText("Pansiyonumuz 2,3 ve 4 odalı.\n "
                + "Toplam 15 odamız mevcut \n"
                + "Rezervasyon alabilirsiniz\n"
                + "İletişime geçebilir \n"
                + "Pansiyonumuza gelerek ,veya \n"
                + "arayarak kayıt oluşturabilirsiniz");
    	txt_hiz.setText("24 saat kapıda güvenlik hizmeti\n "
                + "24 saat rezervasyon işlemi \n"
                + "Günlük temizlik ve hijyen\n"
                );
    	txt_ilet.setText("Tel. 0555 555 55 55 \n "
                + "GSM. 0326 222 22 22 \n"
                + "e-mail iste@gmail.com \n"
                + "FAX. 0326 555 55 55"
                );
    	txt_hak.setFill(Color.BEIGE);
    	txt_hiz.setFill(Color.BEIGE);
    	txt_ilet.setFill(Color.BEIGE);
   

btn_anasayfa.setStyle("-fx-background-color:  #FFFFFF;");
btn_fiyat.setStyle("-fx-background-color:  #FFFFFF;");
btn_iletisim.setStyle("-fx-background-color:  #FFFFFF;");
btn_rezerve.setStyle("-fx-background-color:  #FFFFFF;");
btn_yorumlar.setStyle("-fx-background-color:  #FFFFFF;");
btn_hakkimizda.setStyle("-fx-background-color:  #FFFFFF;");
btn_giris.setStyle("-fx-background-color:  #FFFFFF;");
btn_odalar.setStyle("-fx-background-color:  #FFFFFF;");



    }

}
