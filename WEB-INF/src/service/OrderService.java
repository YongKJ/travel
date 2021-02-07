
import java.util.List;
import java.util.ArrayList;

public class OrderService {
	
	public OrderDao orDao;
	public List<Order> ordersList;
    public judgeService judge;
	
	public OrderService() {
		orDao = new OrderDao();
		ordersList = new ArrayList<>();
        judge = new judgeService();
	}
	
	public List<Order> getOrder() throws Exception {
		ordersList = orDao.getOrder();
		return ordersList;
	}
	
	public boolean addOrder(Order order) throws Exception {
        int oBUserTableId = order.getoBUserTableId();
        boolean oBUserTableIdFlag = judge.judgeBusertable(oBUserTableId);
        
		if(oBUserTableIdFlag) {
			orDao.addOrder(order);
            return true;
		}
        return false;
	}
	
	public boolean modOrder(Order order) throws Exception {
        int orderId = order.getoId();
        boolean orderIdFlag = judge.judgeOrder(orderId);
        
		if(orderIdFlag) {
			orDao.modOrder(order);
            return true;
		}
        return false;
	}
	
	public boolean delOrder(Order order) throws Exception {
        int orderId = order.getoId();
        boolean orderIdFlag = judge.judgeOrder(orderId);
        boolean orderdetailsFlag = judge.judgeOrderdetails_dOrderId(orderId);
        
		if(orderIdFlag && !orderdetailsFlag) {
			orDao.delOrder(order);
            return true;
		}
        return false;
	}
	
}