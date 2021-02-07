
import java.util.List;
import java.util.ArrayList;

public class StrategyService {
	
	public StrategyDao stDao;
	public List<Strategy> strategysList;
    public judgeService judge;
	
	public StrategyService() {
		stDao = new StrategyDao();
		strategysList = new ArrayList<>();
        judge = new judgeService();
	}
	
	public List<Strategy> getStrategy() throws Exception {
		strategysList = stDao.getStrategy();
		return strategysList;
	}
	
	public boolean addStrategy(Strategy strategy) throws Exception {
        int sBUserTableId = strategy.getsBUserTableId();
        boolean sBUserTableIdFlag = judge.judgeBusertable(sBUserTableId);
        
		if(sBUserTableIdFlag) {
			stDao.addStrategy(strategy);
            return true;
		}
        return false;
	}
	
	public boolean modStrategy(Strategy strategy) throws Exception {
        int strategyId = strategy.getsId();
        boolean strategyIdFlag = judge.judgeStrategy(strategyId);
        
		if(strategyIdFlag) {
			stDao.modStrategy(strategy);
            return true;
		}
        return false;
	}
	
	public boolean delStrategy(Strategy strategy) throws Exception {
        int strategyId = strategy.getsId();
        boolean strategyIdFlag = judge.judgeStrategy(strategyId);
        
		if(strategyIdFlag) {
			stDao.delStrategy(strategy);
            return true;
		}
        return false;
	}
	
}