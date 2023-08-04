package application;

public class müsterikayit {

	private int id;	
	private String ad_soy;
	private String tel;
	private String tc;
	private int oda_say;
	private int birey_say;
	private String oda_tercih;
    private String giris_tarih;
	private String cikis_tarih;
	private int fiyat;
	
	müsterikayit(){
		
	}
	müsterikayit(int id , String adsoy , String tel , String tc, int odasay, int bireysay , String odatercih ,String giristarih, String cikistarih, int fiyat){
		this.id=id;
		this.ad_soy=adsoy;
		this.tel=tel;
		this.tc=tc;
		this.oda_say=odasay;
		this.birey_say=bireysay;
		this.oda_tercih=odatercih;
		this.giris_tarih=giristarih;
		this.cikis_tarih=cikistarih;
		this.fiyat=fiyat;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAd_soy() {
		return ad_soy;
	}
	public void setAd_soy(String ad_soy) {
		this.ad_soy = ad_soy;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getTc() {
		return tc;
	}
	public void setTc(String tc) {
		this.tc = tc;
	}
	public int getOda_say() {
		return oda_say;
	}
	public void setOda_say(int oda_say) {
		this.oda_say = oda_say;
	}
	public int getBirey_say() {
		return birey_say;
	}
	public void setBirey_say(int birey_say) {
		this.birey_say = birey_say;
	}
	public String getOda_tercih() {
		return oda_tercih;
	}
	public void setOda_tercih(String oda_tercih) {
		this.oda_tercih = oda_tercih;
	}
	public String getGiris_tarih() {
		return giris_tarih;
	}
	public void setGiris_tarih(String giris_tarih) {
		this.giris_tarih = giris_tarih;
	}
	public String getCikis_tarih() {
		return cikis_tarih;
	}
	public void setCikis_tarih(String cikis_tarih) {
		this.cikis_tarih = cikis_tarih;
	}
	public int getFiyat() {
		return fiyat;
	}
	public void setFiyat(int fiyat) {
		this.fiyat = fiyat;
	}

	
}
