
public class Membership {

	private int mId;
	private String mName;			//团费类型名称
	private double mPrice;		   //不同类型价格
	private int mAttractionsId;	  //景区编号
	
	public int getmId() {
		return mId;
	}
	
	public void setmId(int mId) {
		this.mId = mId;
	}
	
	public String getmName() {
		return mName;
	}
	
	public void setmName(String mName) {
		this.mName = mName;
	}
	
	public double getmPrice() {
		return mPrice;
	}
	
	public void setmPrice(double mPrice) {
		this.mPrice = mPrice;
	}
	
	public int getmAttractionsId() {
		return mAttractionsId;
	}
	
	public void setmAttractionsId(int mAttractionsId) {
		this.mAttractionsId = mAttractionsId;
	}

}