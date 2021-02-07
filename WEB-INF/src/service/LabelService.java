
import java.util.List;
import java.util.ArrayList;

public class LabelService {
	
	public LabelDao laDao;
	public List<Label> labelsList;
    public judgeService judge;
	
	public LabelService() {
		laDao = new LabelDao();
		labelsList = new ArrayList<>();
        judge = new judgeService();
	}
	
	public List<Label> getLabel() throws Exception {
		labelsList = laDao.getLabel();
		return labelsList;
	}
	
	public boolean addLabel(Label label) throws Exception {
        laDao.addLabel(label);
        return true;
	}
	
	public boolean modLabel(Label label) throws Exception {
        int labelId = label.getlId();
        boolean labelIdFlag = judge.judgeLabel(labelId);
        
		if(labelIdFlag) {
			laDao.modLabel(label);
            return true;
		}
        return false;
	}
	
	public boolean delLabel(Label label) throws Exception {
        int labelId = label.getlId();
        boolean labelIdFlag = judge.judgeLabel(labelId);
        boolean attractionsFlag = judge.judgeAttractions_aLabelId(labelId);
        
		if(labelIdFlag && !attractionsFlag) {
			laDao.delLabel(label);
            return true;
		}
        return false;
	}
	
}