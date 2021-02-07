
public class Order {

	private int oId;
	private double oPrice;			//订单金额
	private String oState;			//订单状态
	private String oData;			 //下单时间
	private int oBUserTableId;		//外键：用户id
	
	public int getoId() {
		return oId;
	}
	
	public void setoId(int oId) {
		this.oId = oId;
	}
	
	public double getoPrice() {
		return oPrice;
	}
	
	public void setoPrice(double oPrice) {
		this.oPrice = oPrice;
	}
	
	public String getoState() {
		return oState;
	}
	
	public void setoState(String oState) {
		this.oState = oState;
	}
	
	public String getoData() {
		return oData;
	}
	
	public void setoData(String oData) {
		this.oData = oData;
	}
	
	public int getoBUserTableId() {
		return oBUserTableId;
	}
	
	public void setoBUserTableId(int oBUserTableId) {
		this.oBUserTableId = oBUserTableId;
	}

}