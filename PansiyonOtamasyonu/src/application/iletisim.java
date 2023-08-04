package application;

public class iletisim {

	private int id;
	private String ad;
	private String soy;
	private String tel;
	private String mail;
	private String mesaj;
	
	iletisim(){
		
	}
	iletisim(int id, String ad, String soy ,String tel , String mail, String mesaj){
		this.id=id;
		this.ad=ad;
		this.soy=soy;
		this.tel=tel;
		this.mail=mail;
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getMesaj() {
		return mesaj;
	}
	public void setMesaj(String mesaj) {
		this.mesaj = mesaj;
	}


	
}
