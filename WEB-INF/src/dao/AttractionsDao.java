
import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class AttractionsDao {
	
	public List<Attractions> attractionsList;
	public Connection conn;
	public Statement st;
	public PreparedStatement ps;
	public ResultSet rs;
	public String sql;
	
	public AttractionsDao() {
		conn = null;
		st = null;
		ps = null;
		rs = null;
	}
    
    public void writeToLog(String str) throws Exception {
        String fileName = "/usr/local/tomcat/apache-tomcat-9.0.19/webapps/travel/WEB-INF/src/Log.txt";
        FileWriter writeFile = new FileWriter(fileName, true);
        BufferedWriter writer = new BufferedWriter(writeFile);
		
		writer.write(str + "\n");
        
        writer.flush();
        writeFile.close();
    }
    
    public void writeToLog(int str) throws Exception {
        String fileName = "/usr/local/tomcat/apache-tomcat-9.0.19/webapps/travel/WEB-INF/src/Log.txt";
        FileWriter writeFile = new FileWriter(fileName, true);
        BufferedWriter writer = new BufferedWriter(writeFile);
		
		writer.write(str + "\n");
        
        writer.flush();
        writeFile.close();
    }
	
	public List<Attractions> getAttractions() throws Exception {
		sql = "select * from attractions";
		attractionsList = new ArrayList<>();
		conn = SQLUtil.getConnection();
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		while (rs.next()){
			Attractions attractions = new Attractions();
			attractions.setaId(rs.getInt(1));
			attractions.setaName(rs.getString(2));
			attractions.setaPicture(rs.getString(3));
			attractions.setaBstract(rs.getString(4));
			attractions.setaUnitPrice(rs.getDouble(5));
			attractions.setaCostContent(rs.getString(6));
			attractions.setaScore(rs.getString(7));
			attractions.setaLabelId(rs.getInt(8));
			attractions.setaCityId(rs.getInt(9));
			attractionsList.add(attractions);
		}
		SQLUtil.closeAll(conn, st, rs);
		return attractionsList;
	}
	
	public void addAttractions(Attractions attractions) throws Exception {
		sql = "insert into attractions (aname, apicture, abstract, aunitprice, acostcontent, ascore, alabel_id, acity_id) values (?, ?, ?, ?, ?, ?, ?, ?)";
		conn = SQLUtil.getConnection();
		ps  = conn.prepareStatement(sql);
//         writeToLog("a");
		ps.setString(1, attractions.getaName());
		ps.setString(2, attractions.getaPicture());
		ps.setString(3, attractions.getaBstract());
		ps.setDouble(4, attractions.getaUnitPrice());
		ps.setString(5, attractions.getaCostContent());
		ps.setString(6, attractions.getaScore());
		ps.setInt(7, attractions.getaLabelId());
		ps.setInt(8, attractions.getaCityId());
//         ps.setString(1, "丹霞山");
// 		ps.setString(2, "1.jpg");
// 		ps.setString(3, "美丽的丹霞山！");
// 		ps.setString(4, "100");
// 		ps.setString(5, "景点游览、景区公交");
// 		ps.setString(6, "8.8");
// 		ps.setInt(7, 181);
// 		ps.setInt(8, 30);
//         writeToLog("b");
		ps.executeUpdate();
//         writeToLog("c");
		SQLUtil.closeAll(conn, ps);
	}
	
	public void modAttractions(Attractions attractions) throws Exception {
		sql = "update attractions set aname = ?, apicture = ?, abstract = ?, aunitprice = ?, acostcontent = ?, ascore = ?, alabel_id = ?, acity_id = ? where aid = ?";
		conn = SQLUtil.getConnection();
		ps  = conn.prepareStatement(sql);
		ps.setString(1, attractions.getaName());
		ps.setString(2, attractions.getaPicture());
		ps.setString(3, attractions.getaBstract());
		ps.setDouble(4, attractions.getaUnitPrice());
		ps.setString(5, attractions.getaCostContent());
		ps.setString(6, attractions.getaScore());
		ps.setInt(7, attractions.getaLabelId());
		ps.setInt(8, attractions.getaCityId());
		ps.setInt(9, attractions.getaId());
//         writeToLog("c");
//         writeToLog(attractions.getaLabelId());
//         writeToLog(attractions.getaCityId());
//         writeToLog(attractions.getaId());
		ps.executeUpdate();
//         writeToLog("d");
		SQLUtil.closeAll(conn, ps);
	}
	
	public void delAttractions(Attractions attractions) throws Exception {
		sql = "delete from attractions where aid = ?";
		conn = SQLUtil.getConnection();
		ps  = conn.prepareStatement(sql);
		ps.setInt(1, attractions.getaId());
		ps.executeUpdate();
		SQLUtil.closeAll(conn, ps);
	}
	
}