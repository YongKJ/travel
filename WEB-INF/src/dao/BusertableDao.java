
import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class BusertableDao {
	
	public List<Busertable> busertablesList;
	public Connection conn;
	public Statement st;
	public PreparedStatement ps;
	public ResultSet rs;
	public String sql;
	
	public BusertableDao() {
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
	
	public List<Busertable> getBusertable() throws Exception {
		sql = "select * from busertable";
		busertablesList = new ArrayList<>();
		conn = SQLUtil.getConnection();
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		while (rs.next()){
			Busertable busertable = new Busertable();
			busertable.setbId(rs.getInt(1));
			busertable.setbNumber(rs.getString(2));
			busertable.setbPWD(rs.getString(3));
			busertable.setbName(rs.getString(4));
			busertable.setbEmail(rs.getString(5));
			busertable.setrName(rs.getString(6));
			busertable.setbSex(rs.getString(7));
			busertable.setBirthday(rs.getString(8));
			busertable.setbPhone(rs.getString(9));
			busertablesList.add(busertable);
		}
		SQLUtil.closeAll(conn, st, rs);
		return busertablesList;
	}
	
	public void addBusertable(Busertable busertable) throws Exception {
		sql = "insert into busertable (bnumber, bpwd, bname, bemail, rname, bsex, birthday, bphone) values (?, ?, ?, ?, ?, ?, ?, ?)";
		conn = SQLUtil.getConnection();
		ps  = conn.prepareStatement(sql);
//         writeToLog("11111");
		ps.setString(1, busertable.getbNumber());
		ps.setString(2, busertable.getbPWD());
		ps.setString(3, busertable.getbName());
		ps.setString(4, busertable.getbEmail());
		ps.setString(5, busertable.getrName());
		ps.setString(6, busertable.getbSex());
		ps.setString(7, busertable.getBirthday());
		ps.setString(8, busertable.getbPhone());
//         writeToLog("22222");
		ps.executeUpdate();
//         writeToLog("33333");
		SQLUtil.closeAll(conn, ps);
	}
	
	public void modBusertable(Busertable busertable) throws Exception {
		sql = "update busertable set bnumber = ?, bpwd = ?, bname = ?, bemail = ?, rname = ?, bsex = ?, birthday = ?, bphone = ? where bId = ?";
		conn = SQLUtil.getConnection();
		ps  = conn.prepareStatement(sql);
		ps.setString(1, busertable.getbNumber());
		ps.setString(2, busertable.getbPWD());
		ps.setString(3, busertable.getbName());
		ps.setString(4, busertable.getbEmail());
		ps.setString(5, busertable.getrName());
		ps.setString(6, busertable.getbSex());
		ps.setString(7, busertable.getBirthday());
		ps.setString(8, busertable.getbPhone());
		ps.setInt(9, busertable.getbId());
		ps.executeUpdate();
		SQLUtil.closeAll(conn, ps);
	}
	
	public void delBusertable(Busertable busertable) throws Exception {
		sql = "delete from busertable where bId = ?";
		conn = SQLUtil.getConnection();
		ps  = conn.prepareStatement(sql);
//         writeToLog("11111");
		ps.setInt(1, busertable.getbId());
//         writeToLog("22222");
		ps.executeUpdate();
//         writeToLog("33333");
		SQLUtil.closeAll(conn, ps);
	}
	
}