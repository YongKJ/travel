
public class Userevaluation {

	private int uId;
	private String uEvaluationText;	//评价的内容文本
	private String uPicture;		   //上传的图片
	private String uData;			  //发表日期
	private int uAttractionsId;		//景点编号
	private int uBUserTableId;		 //用户编号
	
	public int getuId() {
		return uId;
	}
	
	public void setuId(int uId) {
		this.uId = uId;
	}
	
	public String getuEvaluationText() {
		return uEvaluationText;
	}
	
	public void setuEvaluationText(String uEvaluationText) {
		this.uEvaluationText = uEvaluationText;
	}
	
	public String getuPicture() {
		return uPicture;
	}
	
	public void setuPrcture(String uPicture) {
		this.uPicture = uPicture;
	}
	
	public String getuData() {
		return uData;
	}
	
	public void setuData(String uData) {
		this.uData = uData;
	}
	
	public int getuAttractionsId() {
		return uAttractionsId;
	}
	
	public void setuAttractionsId(int uAttractionsId) {
		this.uAttractionsId = uAttractionsId;
	}
	
	public int getuBUserTableId() {
		return uBUserTableId;
	}
	
	public void setuBUserTableId(int uBUserTableId) {
		this.uBUserTableId = uBUserTableId;
	}

}