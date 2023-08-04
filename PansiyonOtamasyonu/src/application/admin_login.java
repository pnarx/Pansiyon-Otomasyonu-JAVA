package application;

public class admin_login {

	private int id;	
	private String ad;
	private String soy;
	private String mail;
	private String sifre;

	admin_login(){
		
	}
	admin_login(int id,String ad, String soy, String mail, String sifre){
		
		this.id=id;
		this.ad=ad;		
		this.soy=soy;
		this.mail=mail;

		this.sifre=sifre;
		
	}
	
	public String getSifre() {
		return sifre;
	}
	public void setSifre(String sifre) {
		this.sifre = sifre;
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

	
}
