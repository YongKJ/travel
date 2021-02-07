
import java.util.List;
import java.util.ArrayList;

public class CityService {
	
	public CityDao ciDao;
	public List<City> citysList;
    public judgeService judge;
	
	public CityService() {
		ciDao = new CityDao();
		citysList = new ArrayList<>();
        judge = new judgeService();
	}
	
	public List<City> getCity() throws Exception {
		citysList = ciDao.getCity();
		return citysList;
	}
	
	public boolean addCity(City city) throws Exception {
        int proId = city.getProId();
        boolean proIdFlag = judge.judgePromary(proId);
        
		if(proIdFlag) {
			ciDao.addCity(city);
            return true;
		}
        return false;
	}
	
	public boolean modCity(City city) throws Exception {
        int cityId = city.getCityId();
        boolean cityIdFlag = judge.judgeCity(cityId);
        
		if(cityIdFlag) {
			ciDao.modCity(city);
            return true;
		}
        return false;
	}
	
	public boolean delCity(City city) throws Exception {
        int cityId = city.getCityId();
        boolean cityIdFlag = judge.judgeCity(cityId);
        boolean attractionsFlag = judge.judgeAttractions_aCityId(cityId);
        
        if(cityIdFlag && !attractionsFlag) {
            ciDao.delCity(city);
            return true;
        }
		return false;
	}
	
}