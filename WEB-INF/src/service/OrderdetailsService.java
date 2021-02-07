
import java.util.List;
import java.util.ArrayList;

public class OrderdetailsService {
	
	public OrderdetailsDao odDao;
	public List<Orderdetails> orderdetailsList;
    public judgeService judge;
	
	public OrderdetailsService() {
		odDao = new OrderdetailsDao();
		orderdetailsList = new ArrayList<>();
        judge = new judgeService();
	}
	
	public List<Orderdetails> getOrderdetails() throws Exception {
		orderdetailsList = odDao.getOrderdetails();
		return orderdetailsList;
	}
	
	public boolean addOrderdetails(Orderdetails orderdetails) throws Exception {
        int dAttractionsId = orderdetails.getdAttractionsId();
        int dOrderId = orderdetails.getdOrderId();
        boolean dAttractionsIdFlag_dOrderIdFlag = judge.judgeOrderdetails_dAttractionsId_dOrderId(dAttractionsId, dOrderId);
        
		if(!dAttractionsIdFlag_dOrderIdFlag) {
			odDao.addOrderdetails(orderdetails);
            return true;
		}
        return false;
	}
	
	public boolean modOrderdetails(Orderdetails orderdetails) throws Exception {
        int dAttractionsId = orderdetails.getdAttractionsId();
        int dOrderId = orderdetails.getdOrderId();
        boolean dAttractionsIdFlag_dOrderIdFlag = judge.judgeOrderdetails_dAttractionsId_dOrderId(dAttractionsId, dOrderId);
        
		if(dAttractionsIdFlag_dOrderIdFlag) {
			odDao.modOrderdetails(orderdetails);
            return true;
		}
        return false;
	}
	
	public boolean delOrderdetails(Orderdetails orderdetails) throws Exception {
        int dAttractionsId = orderdetails.getdAttractionsId();
        int dOrderId = orderdetails.getdOrderId();
        boolean dAttractionsIdFlag_dOrderIdFlag = judge.judgeOrderdetails_dAttractionsId_dOrderId(dAttractionsId, dOrderId);
        
		if(dAttractionsIdFlag_dOrderIdFlag) {
			odDao.delOrderdetails(orderdetails);
            return true;
		}
        return false;
	}
	
}