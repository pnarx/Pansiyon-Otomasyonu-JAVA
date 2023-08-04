package application;

public class Rezervasyon {

	
	private int id;
	private String ad;
	private String soy;
	private String tel;
	private String gsm;
	private String mail;
	private String odatip;
	private String ksayi;
	private String csayi;
	private String girist;
	private String cikist;
	private String mesaj;
	
	Rezervasyon(){
		
	}
	Rezervasyon( int id, String ad, String soy, String tel , String gsm, String mail , String odatip, String ksayi, String csayi ,String girist,String cikist,String mesaj) {
		this.id=id;
		this.ad=ad;
		this.soy=soy;
		this.tel=tel;
		this.gsm=gsm;
		this.mail=mail;
		this.odatip=odatip;
		this.ksayi=ksayi;
		this.csayi=csayi;
		this.girist=girist;
		this.cikist=cikist;
		this.mesaj=mesaj;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getSoy() {
		return soy;
	}
	public void setSoy(String soy) {
		this.soy = soy;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getGsm() {
		return gsm;
	}
	public void setGsm(String gsm) {
		this.gsm = gsm;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getOdatip() {
		return odatip;
	}
	public void setOdatip(String odatip) {
		this.odatip = odatip;
	}
	public String getKsayi() {
		return ksayi;
	}
	public void setKsayi(String ksayi) {
		this.ksayi = ksayi;
	}
	public String getCsayi() {
		return csayi;
	}
	public void setCsayi(String csayi) {
		this.csayi = csayi;
	}
	public String getGirist() {
		return girist;
	}
	public void setGirist(String girist) {
		this.girist = girist;
	}
	public String getCikist() {
		return cikist;
	}
	public void setCikist(String cikist) {
		this.cikist = cikist;
	}
	public String getMesaj() {
		return mesaj;
	}
	public void setMesaj(String mesaj) {
		this.mesaj = mesaj;
	}
	

	
}
