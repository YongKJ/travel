
public class Attractions {

	private int aId;
	private String aName;			 //景区名字
	private String aPicture;		 //景区图片
	private String aBstract;		 //景区简介
	private double aUnitPrice;	     //单价
	private String aCostContent;	 //费用包含
	private String aScore;		     //点评分数
	private int aLabelId;			 //外键：标签
	private int aCityId;			 //外键：所处地点
	
	public int getaId() {
		return aId;
	}
	
	public void setaId(int aId) {
		this.aId = aId;
	}
	
	public String getaName() {
		return aName;
	}
	
	public void setaName(String aName) {
		this.aName = aName;
	}
	
	public String getaPicture() {
		return aPicture;
	}
	
	public void setaPicture(String aPicture) {
		this.aPicture = aPicture;
	}
	
	public String getaBstract() {
		return aBstract;
	}
	
	public void setaBstract(String aBstract) {
		this.aBstract = aBstract;
	}
	
	public double getaUnitPrice() {
		return aUnitPrice;
	}
	
	public void setaUnitPrice(double aUnitPrice) {
		this.aUnitPrice = aUnitPrice;
	}
	
	public String getaCostContent() {
		return aCostContent;
	}
	
	public void setaCostContent(String aCostContent) {
		this.aCostContent = aCostContent;
	}
	
	public String getaScore() {
		return aScore;
	}
	
	public void setaScore(String aScore) {
		this.aScore = aScore;
	}
	
	public int getaLabelId() {
		return aLabelId;
	}
	
	public void setaLabelId(int aLabelId) {
		this.aLabelId = aLabelId;
	}
	
	public int getaCityId() {
		return aCityId;
	}
	
	public void setaCityId(int aCityId) {
		this.aCityId = aCityId;
	}

}