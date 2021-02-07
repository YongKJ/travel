
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class judgeService {
	
	public AttentionDao aeDao;
	public AttractionsDao arDao;
	public BusertableDao buDao;
	public CityDao ciDao;
	public LabelDao laDao;
	public MembershipDao meDao;
	public OrderDao orDao;
	public OrderdetailsDao odDao;
	public PromaryDao prDao;
	public StrategyDao stDao;
	public UserevaluationDao usDao;
	public List<Attention> attentionsList;
	public List<Attractions> attractionsList;
	public List<Busertable> busertablesList;
	public List<City> citysList;
	public List<Label> labelsList;
	public List<Membership> membershipsList;
	public List<Order> ordersList;
	public List<Orderdetails> orderdetailsList;
	public List<Promary> promarysList;
	public List<Strategy> strategysList;
	public List<Userevaluation> userevaluationsList;
	
	public judgeService() {
		aeDao = new AttentionDao();
		arDao = new AttractionsDao();
		buDao = new BusertableDao();
		ciDao = new CityDao();
		laDao = new LabelDao();
		meDao = new MembershipDao();
		orDao = new OrderDao();
		odDao = new OrderdetailsDao();
		prDao = new PromaryDao();
		stDao = new StrategyDao();
		usDao = new UserevaluationDao();
		attentionsList = new ArrayList<>();
		attractionsList = new ArrayList<>();
		busertablesList = new ArrayList<>();
		citysList = new ArrayList<>();
		labelsList = new ArrayList<>();
		membershipsList = new ArrayList<>();
		ordersList = new ArrayList<>();
		orderdetailsList = new ArrayList<>();
		promarysList = new ArrayList<>();
		strategysList = new ArrayList<>();
		userevaluationsList = new ArrayList<>();
	}
    
    public void writeToLog(String str) throws Exception {
        String fileName = "/usr/local/tomcat/apache-tomcat-9.0.19/webapps/travel/WEB-INF/src/Log.txt";
        FileWriter writeFile = new FileWriter(fileName, true);
        BufferedWriter writer = new BufferedWriter(writeFile);
		
		writer.write(str + "\n");
        
        writer.flush();
        writeFile.close();
    }
	
	public boolean judgeAttention(int id) throws Exception {
		attentionsList = aeDao.getAttention();
		for(int i = 0; i < attentionsList.size(); i++) {
			if(id == attentionsList.get(i).getaId()) {
				return true;
			}
		}
		return false;
	}
    
    public boolean judgeAttention_aAttractionsId(int id) throws Exception {
		attentionsList = aeDao.getAttention();
		for(int i = 0; i < attentionsList.size(); i++) {
			if(id == attentionsList.get(i).getaAttractionsId()) {
				return true;
			}
		}
		return false;
	}
    
    public boolean judgeAttention_aBUserTableId(int id) throws Exception {
		attentionsList = aeDao.getAttention();
		for(int i = 0; i < attentionsList.size(); i++) {
			if(id == attentionsList.get(i).getaBUserTableId()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean judgeAttractions(int id) throws Exception {
		attractionsList = arDao.getAttractions();
		for(int i = 0; i < attractionsList.size(); i++) {
			if(id == attractionsList.get(i).getaId()) {
				return true;
			}
		}
		return false;
	}
    
    public boolean judgeAttractions_aLabelId(int id) throws Exception {
		attractionsList = arDao.getAttractions();
		for(int i = 0; i < attractionsList.size(); i++) {
			if(id == attractionsList.get(i).getaLabelId()) {
				return true;
			}
		}
		return false;
	}
    
    public boolean judgeAttractions_aCityId(int id) throws Exception {
		attractionsList = arDao.getAttractions();
		for(int i = 0; i < attractionsList.size(); i++) {
			if(id == attractionsList.get(i).getaCityId()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean judgeBusertable(int id) throws Exception {
		busertablesList = buDao.getBusertable();
		for(int i = 0; i < busertablesList.size(); i++) {
			if(id == busertablesList.get(i).getbId()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean judgeCity(int id) throws Exception {
		citysList = ciDao.getCity();
		for(int i = 0; i < citysList.size(); i++) {
			if(id == citysList.get(i).getCityId()) {
				return true;
			}
		}
		return false;
	}
    
    public boolean judgeCity_proId(int id) throws Exception {
		citysList = ciDao.getCity();
		for(int i = 0; i < citysList.size(); i++) {
			if(id == citysList.get(i).getProId()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean judgeLabel(int id) throws Exception {
		labelsList = laDao.getLabel();
		for(int i = 0; i < labelsList.size(); i++) {
			if(id == labelsList.get(i).getlId()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean judgeMembership(int id) throws Exception {
		membershipsList = meDao.getMembership();
		for(int i = 0; i < membershipsList.size(); i++) {
			if(id == membershipsList.get(i).getmId()) {
				return true;
			}
		}
		return false;
	}
    
    public boolean judgeMembership_mAttractionsId(int id) throws Exception {
		membershipsList = meDao.getMembership();
		for(int i = 0; i < membershipsList.size(); i++) {
			if(id == membershipsList.get(i).getmAttractionsId()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean judgeOrder(int id) throws Exception {
		ordersList = orDao.getOrder();
		for(int i = 0; i < ordersList.size(); i++) {
			if(id == ordersList.get(i).getoId()) {
				return true;
			}
		}
		return false;
	}
    
    public boolean judgeOrder_oBUserTableId(int id) throws Exception {
//         writeToLog("aaaaa");
		ordersList = orDao.getOrder();
//         writeToLog("bbbbb");
		for(int i = 0; i < ordersList.size(); i++) {
			if(id == ordersList.get(i).getoBUserTableId()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean judgeOrderdetails(int attractionsId, int orderId) throws Exception {
		orderdetailsList = odDao.getOrderdetails();
		for(int i = 0; i < orderdetailsList.size(); i++) {
			if(attractionsId == orderdetailsList.get(i).getdAttractionsId() && orderId == orderdetailsList.get(i).getdOrderId()) {
				return true;
			}
		}
		return false;
	}
    
    public boolean judgeOrderdetails_dAttractionsId(int id) throws Exception {
		orderdetailsList = odDao.getOrderdetails();
		for(int i = 0; i < orderdetailsList.size(); i++) {
			if(id == orderdetailsList.get(i).getdAttractionsId()) {
				return true;
			}
		}
		return false;
	}
    
    public boolean judgeOrderdetails_dOrderId(int id) throws Exception {
		orderdetailsList = odDao.getOrderdetails();
		for(int i = 0; i < orderdetailsList.size(); i++) {
			if(id == orderdetailsList.get(i).getdOrderId()) {
				return true;
			}
		}
		return false;
	}
    
    public boolean judgeOrderdetails_dAttractionsId_dOrderId(int dAttractionsId, int dOrderId) throws Exception {
		orderdetailsList = odDao.getOrderdetails();
		for(int i = 0; i < orderdetailsList.size(); i++) {
			if(dAttractionsId == orderdetailsList.get(i).getdAttractionsId() && dOrderId == orderdetailsList.get(i).getdOrderId()) {
				return true;
			}
		}
        return false;
	}
	
	public boolean judgePromary(int id) throws Exception {
		promarysList = prDao.getPromary();
		for(int i = 0; i < promarysList.size(); i++) {
			if(id == promarysList.get(i).getProId()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean judgeStrategy(int id) throws Exception {
		strategysList = stDao.getStrategy();
		for(int i = 0; i < strategysList.size(); i++) {
			if(id == strategysList.get(i).getsId()) {
				return true;
			}
		}
		return false;
	}
    
    public boolean judgeStrategy_sBUserTableId(int id) throws Exception {
		strategysList = stDao.getStrategy();
		for(int i = 0; i < strategysList.size(); i++) {
			if(id == strategysList.get(i).getsBUserTableId()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean judgeUserevaluation(int id) throws Exception {
		userevaluationsList = usDao.getUserevaluation();
		for(int i = 0; i < userevaluationsList.size(); i++) {
			if(id == userevaluationsList.get(i).getuId()) {
				return true;
			}
		}
		return false;
	}
    
    public boolean judgeUserevaluation_uAttractionsId(int id) throws Exception {
		userevaluationsList = usDao.getUserevaluation();
		for(int i = 0; i < userevaluationsList.size(); i++) {
			if(id == userevaluationsList.get(i).getuAttractionsId()) {
				return true;
			}
		}
		return false;
	}
    
    public boolean judgeUserevaluation_uBUserTableId(int id) throws Exception {
		userevaluationsList = usDao.getUserevaluation();
		for(int i = 0; i < userevaluationsList.size(); i++) {
			if(id == userevaluationsList.get(i).getuBUserTableId()) {
				return true;
			}
		}
		return false;
	}
	
}