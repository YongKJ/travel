
import java.util.List;
import java.util.ArrayList;

public class PromaryService {
	
	public PromaryDao prDao;
	public List<Promary> promarysList;
    public judgeService judge;
	
	public PromaryService() {
		prDao = new PromaryDao();
		promarysList = new ArrayList<>();
        judge = new judgeService();
	}
	
	public List<Promary> getPromary() throws Exception {
		promarysList = prDao.getPromary();
		return promarysList;
	}
	
	public boolean addPromary(Promary promary) throws Exception {
        prDao.addPromary(promary);
        return true;
	}
	
	public boolean modPromary(Promary promary) throws Exception {
        int promaryId = promary.getProId();
        boolean promaryIdFlag = judge.judgePromary(promaryId);
        
		if(promaryIdFlag) {
			prDao.modPromary(promary);
            return true;
		}
        return false;
	}
	
	public boolean delPromary(Promary promary) throws Exception {
        int promaryId = promary.getProId();
        boolean promaryIdFlag = judge.judgePromary(promaryId);
        boolean cityFlag = judge.judgeCity_proId(promaryId);
        
		if(promaryIdFlag && !cityFlag) {
			prDao.delPromary(promary);
            return true;
		}
        return false;
	}
	
}