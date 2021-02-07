
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class AttentionService {
	
	public AttentionDao aeDao;
	public List<Attention> attentionsList;
    public judgeService judge;
	
	public AttentionService() {
		aeDao = new AttentionDao();
		attentionsList = new ArrayList<>();
        judge = new judgeService();
	}
    
    public void writeToLog(int str) throws Exception {
        String fileName = "/usr/local/tomcat/apache-tomcat-9.0.19/webapps/travel/WEB-INF/src/Log.txt";
        FileWriter writeFile = new FileWriter(fileName, true);
        BufferedWriter writer = new BufferedWriter(writeFile);
		
		writer.write(str + "\n");
        
        writer.flush();
        writeFile.close();
    }

	public List<Attention> getAttention() throws Exception {
		attentionsList = aeDao.getAttention();
		return attentionsList;
	}
	
	public boolean addAttention(Attention attention) throws Exception {
        int aAttractionsId = attention.getaAttractionsId();
        int aBUserTableId = attention.getaBUserTableId();
//         writeToLog(-1);
        boolean aAttractionsIdFlag = judge.judgeAttractions(aAttractionsId);
        boolean aBUserTableIdFlag = judge.judgeBusertable(aBUserTableId);
//         writeToLog(-2);
        
		if(aAttractionsIdFlag && aBUserTableIdFlag) {
			aeDao.addAttention(attention);
            return true;
		}
        return false;
	}
	
	public boolean modAttention(Attention attention) throws Exception {
        int attentionId = attention.getaId();
        boolean attentionIdFlag = judge.judgeAttention(attentionId);
        
        if(attentionIdFlag) {
            aeDao.modAttention(attention);
            return true;
        }
		return false;
	}
	
	public boolean delAttention(Attention attention) throws Exception {
        int attentionId = attention.getaId();
        boolean attentionIdFlag = judge.judgeAttention(attentionId);
        
        if(attentionIdFlag) {
            aeDao.delAttention(attention);
            return true;
        }
		return false;
	}
	
}