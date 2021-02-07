
import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
	
	public List<Order> ordersList;
	public Connection conn;
	public Statement st;
	public PreparedStatement ps;
	public ResultSet rs;
	public String sql;
	
	public OrderDao() {
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
	
	public List<Order> getOrder() throws Exception {
//         writeToLog("-1");
		sql = "select * from `order`";
//         writeToLog("-2");
		ordersList = new ArrayList<>();
//         writeToLog("-3");
		conn = SQLUtil.getConnection();
//         writeToLog("-4");
		st = conn.createStatement();
//         writeToLog("-5");
		rs = st.executeQuery(sql);
//         writeToLog("------");
		while (rs.next()){
			Order order = new Order();
			order.setoId(rs.getInt(1));
			order.setoPrice(rs.getDouble(2));
			order.setoState(rs.getString(3));
			order.setoData(rs.getString(4));
			order.setoBUserTableId(rs.getInt(5));
			ordersList.add(order);
		}
//         writeToLog("+++++");
		SQLUtil.closeAll(conn, st, rs);
		return ordersList;
	}
	
	public void addOrder(Order order) throws Exception {
		sql = "insert into `order` (oprice, ostate, odata, obusertable_id) values (?, ?, ?, ?)";
		conn = SQLUtil.getConnection();
		ps  = conn.prepareStatement(sql);
		ps.setDouble(1, order.getoPrice());
		ps.setString(2, order.getoState());
		ps.setString(3, order.getoData());
		ps.setInt(4, order.getoBUserTableId());
		ps.executeUpdate();
		SQLUtil.closeAll(conn, ps);
	}
	
	public void modOrder(Order order) throws Exception {
		sql = "update `order` set oprice = ?, ostate = ?, odata = ?, obusertable_id = ? where oid = ?";
		conn = SQLUtil.getConnection();
		ps  = conn.prepareStatement(sql);
		ps.setDouble(1, order.getoPrice());
		ps.setString(2, order.getoState());
		ps.setString(3, order.getoData());
		ps.setInt(4, order.getoBUserTableId());
		ps.setInt(5, order.getoId());
		ps.executeUpdate();
		SQLUtil.closeAll(conn, ps);
	}
	
	public void delOrder(Order order) throws Exception {
		sql = "delete from `order` where oid = ?";
		conn = SQLUtil.getConnection();
		ps  = conn.prepareStatement(sql);
		ps.setInt(1, order.getoId());
		ps.executeUpdate();
		SQLUtil.closeAll(conn, ps);
	}
	
}