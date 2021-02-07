
import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class OrderdetailsDao {
	
	public List<Orderdetails> orderdetailsList;
	public Connection conn;
	public Statement st;
	public PreparedStatement ps;
	public ResultSet rs;
	public String sql;
	
	public OrderdetailsDao() {
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
	
	public List<Orderdetails> getOrderdetails() throws Exception {
		sql = "select * from orderdetails";
		orderdetailsList = new ArrayList<>();
		conn = SQLUtil.getConnection();
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		while (rs.next()){
			Orderdetails orderdetails = new Orderdetails();
			orderdetails.setNumber(rs.getInt(1));
			orderdetails.setdAttractionsId(rs.getInt(2));
			orderdetails.setdOrderId(rs.getInt(3));
			orderdetailsList.add(orderdetails);
		}
		SQLUtil.closeAll(conn, st, rs);
		return orderdetailsList;
	}
	
	public void addOrderdetails(Orderdetails orderdetails) throws Exception {
		sql = "insert into orderdetails (number, dattractions_id, dorder_id) values (?, ?, ?)";
		conn = SQLUtil.getConnection();
		ps  = conn.prepareStatement(sql);
		ps.setInt(1, orderdetails.getNumber());
		ps.setInt(2, orderdetails.getdAttractionsId());
		ps.setInt(3, orderdetails.getdOrderId());
//         writeToLog(-1);
//         writeToLog(orderdetails.getNumber());
//         writeToLog(orderdetails.getdAttractionsId());
//         writeToLog(orderdetails.getdOrderId());
		ps.executeUpdate();
//         writeToLog(-2);
		SQLUtil.closeAll(conn, ps);
	}
	
	public void modOrderdetails(Orderdetails orderdetails) throws Exception {
		sql = "update orderdetails set number = ? where dattractions_id = ? and dorder_id = ?";
		conn = SQLUtil.getConnection();
		ps  = conn.prepareStatement(sql);
		ps.setInt(1, orderdetails.getNumber());
		ps.setInt(2, orderdetails.getdAttractionsId());
		ps.setInt(3, orderdetails.getdOrderId());
		ps.executeUpdate();
		SQLUtil.closeAll(conn, ps);
	}
	
	public void delOrderdetails(Orderdetails orderdetails) throws Exception {
		sql = "delete from orderdetails where dattractions_id = ? and dorder_id = ?";
		conn = SQLUtil.getConnection();
		ps  = conn.prepareStatement(sql);
		ps.setInt(1, orderdetails.getdAttractionsId());
		ps.setInt(2, orderdetails.getdOrderId());
		ps.executeUpdate();
		SQLUtil.closeAll(conn, ps);
	}
	
}