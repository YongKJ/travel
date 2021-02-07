
import java.io.*;

public class City {

	private int cityId;
	private String cityName;
	private int proId;
    
    public void writeToLog(int str) throws Exception {
        String fileName = "/usr/local/tomcat/apache-tomcat-9.0.19/webapps/travel/WEB-INF/src/Log.txt";
        FileWriter writeFile = new FileWriter(fileName, true);
        BufferedWriter writer = new BufferedWriter(writeFile);
		
		writer.write(str + "\n");
        
        writer.flush();
        writeFile.close();
    }
	
	public int getCityId() {
		return cityId;
	}
	
	public void setCityId(int cityId) throws Exception { //一开始是int ciytId
//         writeToLog(cityId);                              //需要改成int cityId
		this.cityId = cityId;
	}
    
	public String getCityName() {
		return cityName;
	}
	
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	public int getProId() {
		return proId;
	}
	
	public void setProId(int proId) {
		this.proId = proId;
	}

}