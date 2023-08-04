package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class pansiyonhakkındaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txt_hakkimzda;

   

 

    @FXML
    void initialize() {
        String metin = "İSTE Pansiyon\r\n"
        		+ "\r\n"
        		+ "İSTE Pansiyon, huzurlu ve keyifli bir konaklama deneyimi sunmak için misafirlerine kapılarını açıyor. /n Kendinizi evinizde hissedeceğiniz samimi bir ortam sunan pansiyonumuz, unutulmaz anılar biriktirmeniz için mükemmel bir seçenektir.\r\n"
        		+ "\r\n"
        		+ "Konum\r\n"
        		+ "\r\n"
        		+ "Pansiyonumuz, şehir merkezine sadece birkaç dakikalık yürüme mesafesinde bulunmaktadır.\n Konumu sayesinde hem şehrin hareketli atmosferine kolaylıkla erişebilir, hem de sessizlik arayanların huzur bulabileceği bir noktada konaklayabilirsiniz. \n Ayrıca, çevredeki turistik bölgelere ve doğal güzelliklere kolayca ulaşabileceğiniz bir konumdadır.\r\n"
        		+ "\r\n"
        		+ "Odalar\r\n"
        		+ "\r\n"
        		+ "Misafirlerimizin konforu ve rahatı bizim için önemlidir. \nPansiyonumuzda ihtiyaçlarınıza uygun farklı tiplerde odalar bulunmaktadır. \n Temiz, ferah ve modern tasarımlı odalarımızda konforlu yataklar, özel banyo, ücretsiz Wi-Fi erişimi ve düzenli temizlik hizmeti bulunmaktadır.\\n Size evinizde hissettirecek konforlu bir konaklama sunmayı hedefliyoruz.\r\n"
        		+ "\r\n"
        		+ "Hizmetler\r\n"
        		+ "\r\n"
        		+ "Pansiyonumuzda konaklarken ihtiyaçlarınızı karşılamak için çeşitli hizmetler sunuyoruz.\n Güler yüzlü personelimiz her konuda size yardımcı olmaktan mutluluk duyacaktır. \n Konaklamanız boyunca huzur ve rahatlıkla zaman geçirebileceğiniz ortak kullanım alanları, sıcak bir kahvaltı servisi, otopark imkanı gibi olanaklar sunmaktayız.\r\n"
        		+ "\r\n"
        		+ "Çevre ve Aktiviteler\r\n"
        		+ "\r\n"
        		+ "Pansiyonumuzun bulunduğu bölge, keşfedilmeyi bekleyen birçok güzellik sunmaktadır. \nDoğa yürüyüşleri, tarihi ve kültürel geziler, su sporları gibi etkinliklere katılabilir ve bölgenin benzersiz güzelliklerini keşfedebilirsiniz. \nSize bu konuda rehberlik etmekten mutluluk duyacak olan ekibimiz, unutulmaz deneyimler yaşamanız için gerekli bilgileri sağlayacaktır.\r\n"
        		+ "\r\n"
        		+ "Rezervasyon\r\n"
        		+ "\r\n"
        		+ "Pansiyonumuzda konaklamak için rezervasyon yapmak için bize telefon veya e-posta yoluyla ulaşabilirsiniz.\n Size uygun bir tarih belirleyerek konaklamanızı planlayabiliriz.\r\n"
        		+ "\r\n"
        		+ "İSTE PANSİYON...";
        txt_hakkimzda.setText(metin);
    }

}
