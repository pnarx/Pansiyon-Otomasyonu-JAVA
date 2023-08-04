package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class balkonluodaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txt_blkoda;

    @FXML
    void initialize() {
String metin ="Pansiyonumuzda konaklamak için balkonlu odalarımızı tercih ettiğinizde, konforlu ve ferah bir deneyim yaşayacaksınız. \r\n"
		+ " Balkonlu odalarımız size açık havada dinlenme ve keyifli vakit geçirme imkanı sunar. \n"
		+ "2 , 3 ve 4 kişilik odaları mevcuttur. \n"
		+ "Balkonlardan eşsiz manzarayı izleyebilir, serin bir esinti eşliğinde gün batımının keyfini çıkarabilirsiniz.\r\n"
		+ "\r\n"
		+ "Balkonlu odalarımız geniş ve modern bir tasarıma sahiptir. \n İç mekanları ferah ve zevkli bir şekilde dekore edilmiştir. \r\n "
		+ "Rahat bir yatak, çalışma masası, oturma alanı ve özel banyo gibi olanaklar sunar. \r\n"
		+ "Balkonlu odalarda bulunan sandalye ve masa sayesinde açık havada kahvenizi yudumlarken \n"
		+ "ya da kitabınızı okurken keyifli bir zaman geçirebilirsiniz.";
		txt_blkoda.setText(metin);
    }

}
