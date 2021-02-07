
import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class CityDao {
	
	public List<City> citysList;
	public Connection conn;
	public Statement st;
	public PreparedStatement ps;
	public ResultSet rs;
	public String sql;
	
	public CityDao() {
		conn = null;
		st = null;
		ps = null;
		rs = null;
	}
    
    public void writeToLog(int str) throws Exception {
        String fileName = "/usr/local/tomcat/apache-tomcat-9.0.19/webapps/travel/WEB-INF/src/Log.txt";
        FileWriter writeFile = new FileWriter(fileName, true);
        BufferedWriter writer = new BufferedWriter(writeFile);
		
		writer.write(str + "\n");
        
        writer.flush();
        writeFile.close();
    }
	
	public List<City> getCity() throws Exception {
		sql = "select * from city";
		citysList = new ArrayList<>();
		conn = SQLUtil.getConnection();
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		while (rs.next()){
			City city = new City();
			city.setCityId(rs.getInt(1));
			city.setCityName(rs.getString(2));
			city.setProId(rs.getInt(3));
			citysList.add(city);
		}
		SQLUtil.closeAll(conn, st, rs);
		return citysList;
	}
	
	public void addCity(City city) throws Exception {
		sql = "insert into city (cityName, proID) values (?, ?)";
		conn = SQLUtil.getConnection();
		ps  = conn.prepareStatement(sql);
		ps.setString(1, city.getCityName());
		ps.setInt(2, city.getProId());
		ps.executeUpdate();
		SQLUtil.closeAll(conn, ps);
	}
	
	public void modCity(City city) throws Exception {
		sql = "update city set cityName = ?, proID = ? where cityID = ?";
		conn = SQLUtil.getConnection();
		ps  = conn.prepareStatement(sql);
		ps.setString(1, city.getCityName());
		ps.setInt(2, city.getProId());
		ps.setInt(3, city.getCityId());
		ps.executeUpdate();
		SQLUtil.closeAll(conn, ps);
	}
	
	public void delCity(City city) throws Exception {
		sql = "delete from city where cityID = ?";
		conn = SQLUtil.getConnection();
		ps  = conn.prepareStatement(sql);
//         writeToLog(city.getCityId());
		ps.setInt(1, city.getCityId());
		ps.executeUpdate();
		SQLUtil.closeAll(conn, ps);
	}
	
}