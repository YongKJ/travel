
public class Strategy {

	private int sId;
	private String sTitle;		//博客标题
	private String sText;		 //博客内容
	private String sDataTime;	 //博客发布时间
	private String sPlace;		//博客发布地点
	private String sReading;	  //博客阅读量
	private int sBUserTableId;	//外键：用户id
	
	public int getsId() {
		return sId;
	}
	
	public void setsId(int sId) {
		this.sId = sId;
	}
	
	public String getsTitle() {
		return sTitle;
	}
	
	public void setsTitle(String sTitle) {
		this.sTitle = sTitle;
	}
	
	public String getsText() {
		return sText;
	}
	
	public void setsText(String sText) {
		this.sText = sText;
	}
	
	public String getsDataTime() {
		return sDataTime;
	}
	
	public void setsDataTime(String sDataTime) {
		this.sDataTime = sDataTime;
	}
	
	public String getsPlace() {
		return sPlace;
	}
	
	public void setsPlace(String sPlace) {
		this.sPlace = sPlace;
	}
	
	public String getsReading() {
		return sReading;
	}
	
	public void setsReading(String sReading) {
		this.sReading = sReading;
	}
	
	public int getsBUserTableId() {
		return sBUserTableId;
	}
	
	public void setsBUserTableId(int sBUserTableId) {
		this.sBUserTableId = sBUserTableId;
	}

}