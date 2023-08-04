
package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class teraskatController  {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txt_trsoda;

    @FXML
    void initialize() {
           String metin = "Teras kat odalarımızda size özel bir konfor ve rahatlık sunuyoruz. \n"
           		+ "Rahat yataklar, konforlu oturma alanları ve modern olanaklar, konaklamanız boyunca ihtiyaçlarınızı \n karşılamak için tasarlanmıştır.\n"
           		+ " Ayrıca, teras kat odalarımızın tümünde ücretsiz Wi-Fi erişimi bulunur, böylece bağlantınızı \n"
           		+ "koparmadan dünyayla bağlantınızı sürdürebilirsiniz.2, 3 ve 4 kişilk odaları mevcuttur.\r\n"
           		+ "Teras kat odalarımız sınırlı sayıdadır, bu yüzden erken rezervasyon yapmanızı öneririz. \n"
           		+ "Muhteşem manzara eşliğinde huzurlu bir konaklama deneyimi için teras kat odalarımızı tercih edebilirsiniz.";
           txt_trsoda.setText(metin);
    }

}
