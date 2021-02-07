
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class AttractionsService {
	
	public AttractionsDao arDao;
	public List<Attractions> attractionsList;
    public judgeService judge;
	
	public AttractionsService() {
		arDao = new AttractionsDao();
		attractionsList = new ArrayList<>();
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
    
    public void writeToLog(boolean str) throws Exception {
        String fileName = "/usr/local/tomcat/apache-tomcat-9.0.19/webapps/travel/WEB-INF/src/Log.txt";
        FileWriter writeFile = new FileWriter(fileName, true);
        BufferedWriter writer = new BufferedWriter(writeFile);
		
		writer.write(str + "\n");
        
        writer.flush();
        writeFile.close();
    }
	
	public List<Attractions> getAttractions() throws Exception {
		attractionsList = arDao.getAttractions();
		return attractionsList;
	}
	
	public boolean addAttractions(Attractions attractions) throws Exception {
//         writeToLog("-1");
        int aLabelId = attractions.getaLabelId();
        int aCityId = attractions.getaCityId();
        boolean aLabelIdFlag = judge.judgeLabel(aLabelId);
        boolean aCityIdFlag = judge.judgeCity(aCityId);
//         writeToLog("-2");
        
		if(aLabelIdFlag && aCityIdFlag) {
//             writeToLog("-3");
			arDao.addAttractions(attractions);
//             writeToLog("-4");
            return true;
		}
        return false;
	}
	
	public boolean modAttractions(Attractions attractions) throws Exception {
        int attractionsId = attractions.getaId();
        boolean attractionsIdFlag = judge.judgeAttractions(attractionsId);
//         writeToLog("-1");
//         writeToLog(attractionsIdFlag);
        
        if(attractionsIdFlag) {
//             writeToLog("-2");
            arDao.modAttractions(attractions);
            return true;
        }
		return false;
	}
	
	public boolean delAttractions(Attractions attractions) throws Exception {
        int attractionsId = attractions.getaId();
        boolean userevaluationFlag = judge.judgeUserevaluation_uAttractionsId(attractionsId);
        boolean attentionFlag = judge.judgeAttention_aAttractionsId(attractionsId);
        boolean orderdetailsFlag = judge.judgeOrderdetails_dAttractionsId(attractionsId);
        boolean membershipFlag = judge.judgeMembership_mAttractionsId(attractionsId);
        boolean attractionsIdFlag = judge.judgeAttractions(attractionsId);
        
        if(attractionsIdFlag && !userevaluationFlag && !attentionFlag && !orderdetailsFlag && !membershipFlag) {
            arDao.delAttractions(attractions);
            return true;
        }
		return false;
	}
	
}