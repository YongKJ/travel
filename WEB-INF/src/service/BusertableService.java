
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class BusertableService {
	
	public BusertableDao buDao;
	public List<Busertable> busertablesList;
    public judgeService judge;
	
	public BusertableService() {
		buDao = new BusertableDao();
		busertablesList = new ArrayList<>();
        judge = new judgeService();
	}
    
    public void writeToLog(String str) throws Exception {
        String fileName = "/usr/local/tomcat/apache-tomcat-9.0.19/webapps/travel/WEB-INF/src/Log.txt";
        FileWriter writeFile = new FileWriter(fileName, true);
        BufferedWriter writer = new BufferedWriter(writeFile);
		
		writer.write(str + "\n");
        
        writer.flush();
        writeFile.close();
    }
	
	public List<Busertable> getBusertable() throws Exception {
		busertablesList = buDao.getBusertable();
		return busertablesList;
	}
	
	public boolean addBusertable(Busertable busertable) throws Exception {
        buDao.addBusertable(busertable);
        return true;
	}
	
	public boolean modBusertable(Busertable busertable) throws Exception {
        int busertableId = busertable.getbId();
        boolean busertableIdFlag = judge.judgeBusertable(busertableId);
        
		if(busertableIdFlag) {
			buDao.modBusertable(busertable);
            return true;
		}
        return false;
	}
	
	public boolean delBusertable(Busertable busertable) throws Exception {
        int busertableId = busertable.getbId();
//         writeToLog("11111");
        boolean busertableIdFlag = judge.judgeBusertable(busertableId);
//         writeToLog("22222");
        boolean attentionFlag = judge.judgeAttention_aBUserTableId(busertableId);
//         writeToLog("33333");
        boolean orderFlag = judge.judgeOrder_oBUserTableId(busertableId);
//         writeToLog("44444");
        boolean strategyFlag = judge.judgeStrategy_sBUserTableId(busertableId);
//         writeToLog("55555");
        boolean userevaluationFlag = judge.judgeUserevaluation_uBUserTableId(busertableId);
//         writeToLog("66666");
        
        if(busertableIdFlag && !attentionFlag && !orderFlag && !strategyFlag && !userevaluationFlag) {
            buDao.delBusertable(busertable);
            return true;
        }
		return false;
	}
	
}