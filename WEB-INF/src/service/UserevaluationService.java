
import java.util.List;
import java.util.ArrayList;

public class UserevaluationService {
	
	public UserevaluationDao usDao;
	public List<Userevaluation> userevaluationsList;
    public judgeService judge;
	
	public UserevaluationService() {
		usDao = new UserevaluationDao();
		userevaluationsList = new ArrayList<>();
        judge = new judgeService();
	}
	
	public List<Userevaluation> getUserevaluation() throws Exception {
		userevaluationsList = usDao.getUserevaluation();
		return userevaluationsList;
	}
	
	public boolean addUserevaluation(Userevaluation userevaluation) throws Exception {
        int uAttractionsId = userevaluation.getuAttractionsId();
        int uBUserTableId = userevaluation.getuBUserTableId();
        boolean uAttractionsIdFlag = judge.judgeAttractions(uAttractionsId);
        boolean uBUserTableIdFlag = judge.judgeBusertable(uBUserTableId);
        
		if(uAttractionsIdFlag && uBUserTableIdFlag) {
			usDao.addUserevaluation(userevaluation);
            return true;
		}
        return false;
	}
	
	public boolean modUserevaluation(Userevaluation userevaluation) throws Exception {
        int userevaluationId = userevaluation.getuId();
        boolean userevaluationIdFlag = judge.judgeUserevaluation(userevaluationId);
        
		if(userevaluationIdFlag) {
			usDao.modUserevaluation(userevaluation);
            return true;
		}
        return false;
	}
	
	public boolean delUserevaluation(Userevaluation userevaluation) throws Exception {
        int userevaluationId = userevaluation.getuId();
        boolean userevaluationIdFlag = judge.judgeUserevaluation(userevaluationId);
        
		if(userevaluationIdFlag) {
			usDao.delUserevaluation(userevaluation);
            return true;
		}
        return false;
	}
	
}