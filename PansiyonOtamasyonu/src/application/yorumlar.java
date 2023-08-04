package application;

public class yorumlar {	
	
	    private int id;
	    private String ad;
	    private String yorum;
		private String mail;
		
        public String getMail() {
			return mail;
		}
		public void setMail(String mail) {
			this.mail = mail;
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
	public String getYorum() {
		return yorum;
	}
	public void setYorum(String yorum) {
		this.yorum = yorum;
	}
	
	
	
	yorumlar(){
		
	}
	
	yorumlar(int id , String ad, String yorum, String mail){
		this.id=id;
		this.ad=ad;
		this.yorum=yorum;
		this.mail=mail;
		
	}
}
