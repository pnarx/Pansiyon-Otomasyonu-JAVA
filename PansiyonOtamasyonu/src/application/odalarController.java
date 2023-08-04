package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TextArea;

public class odalarController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchr_ana;

    @FXML
    private AnchorPane anchr_sağ;

    @FXML
    private AnchorPane anchr_sol;

    @FXML
    private Button btn_blkoda;

    @FXML
    private Button btn_stdoda;

    @FXML
    private Button btn_trsoda;

    @FXML
    private ImageView imgview_img1;

    @FXML
    private ImageView imgview_img2;

    @FXML
    private ImageView imgview_img3;

    @FXML
    private ImageView imgview_img4;
    
    @FXML
    private TextArea txt_stdoda;
    
    @FXML
    private ImageView imgview_img5;

    @FXML
    private ImageView imgview_img6;

    @FXML
    void btn_blkoda_Click(ActionEvent event) {
    	try {
         	 AnchorPane panel =(AnchorPane) FXMLLoader.load(getClass().getResource("balkonluoda.fxml"));
         	anchr_sağ.getChildren().setAll(panel);
         	Scene scene = new Scene(panel,300,300);
         	
         	}
         	catch(Exception e) {
         		e.printStackTrace();
         	}
         }
   
    

    @FXML
    void btn_stdoda_Click(ActionEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("odalar.fxml"));
    		AnchorPane anasayfa= loader.load();

          	AnchorPane anasayfaPanel = (AnchorPane) anchr_sağ.getParent(); // Mevcut panelin bulunduğu panele erişim
          	anasayfaPanel.getChildren().setAll(anasayfa);

          	}
          	catch(Exception e) {
          		e.printStackTrace();
          	}
    }

    @FXML
    void btn_trsoda_Click(ActionEvent event) {
    	try {
        	 AnchorPane panel =(AnchorPane) FXMLLoader.load(getClass().getResource("teraskat.fxml"));
        	anchr_sağ.getChildren().setAll(panel);
        	Scene scene = new Scene(panel,300,300);
        	
        	}
        	catch(Exception e) {
        		e.printStackTrace();
        	}
    }

    @FXML
    void imgview_img1_Click(MouseEvent event) {
    }

    @FXML
    void imgview_img1_MouseClick(MouseEvent event) {

    }

    @FXML
    void imgview_img2_Click(MouseEvent event) {
       
    }

    @FXML
    void imgview_img2_MouseClick(MouseEvent event) {
    }

    @FXML
    void imgview_img3_Click(MouseEvent event) {
        
    }

    @FXML
    void imgview_img3_MouseClick(MouseEvent event) {
    	
    }

    @FXML
    void imgview_img4_Click(MouseEvent event) {
        
    }

    @FXML
    void imgview_img4_MouseClick(MouseEvent event) {
    	
    }

    @FXML
    void imgview_img5_Click(MouseEvent event) {
        
    }

    @FXML
    void imgview_img5_MouseClick(MouseEvent event) {
    
    }

    @FXML
    void imgview_img6_Click(MouseEvent event) {
     
    }

    @FXML
    void imgview_img6_MouseClick(MouseEvent event) {
    	
    }

    @FXML
    void initialize() {
   String metin ="Standart odalarımız, modern bir tasarıma sahip olup sıcak bir atmosfer sunar. \n "
   		+ "İç mekanlar, şık ve rahat bir şekilde dekore edilmiştir. Rahat yataklar, temiz çarşaflar ve \n "
   		+ "konforlu mobilyalar, konaklamanız boyunca ihtiyaçlarınızı karşılamak için özenle seçilmiştir.\n"
   		+ " Standart odalarımızda sizin için her ayrıntıyı düşündük.\r\n"
   		+ "\r\n"
   		+ "Standart odalarımızın tümünde özel banyo, duş, tuvalet, klima, televizyon ve ücretsiz Wi-Fi erişimi gibi olanaklar bulunur. \n"
   		+ "Odalarımız günlük temizlik hizmetiyle düzenli olarak temizlenir ve hijyen standartlarına uygun olarak hazırlanır. \n"
   		+ "Size huzurlu ve konforlu bir konaklama sunmak bizim önceliğimizdir.";
   txt_stdoda.setText(metin);

    }

}

