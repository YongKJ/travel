
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class PromaryDao {
	
	public List<Promary> promarysList;
	public Connection conn;
	public Statement st;
	public PreparedStatement ps;
	public ResultSet rs;
	public String sql;
	
	public PromaryDao() {
		conn = null;
		st = null;
		ps = null;
		rs = null;
	}
	
	public List<Promary> getPromary() throws Exception {
		sql = "select * from promary";
		promarysList = new ArrayList<>();
		conn = SQLUtil.getConnection();
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		while (rs.next()){
			Promary promary = new Promary();
			promary.setProId(rs.getInt(1));
			promary.setProName(rs.getString(2));
			promarysList.add(promary);
		}
		SQLUtil.closeAll(conn, st, rs);
		return promarysList;
	}
	
	public void addPromary(Promary promary) throws Exception {
		sql = "insert into promary (proName) values (?)";
		conn = SQLUtil.getConnection();
		ps  = conn.prepareStatement(sql);
		ps.setString(1, promary.getProName());
		ps.executeUpdate();
		SQLUtil.closeAll(conn, ps);
	}
	
	public void modPromary(Promary promary) throws Exception {
		sql = "update promary set proName = ? where proID = ?";
		conn = SQLUtil.getConnection();
		ps  = conn.prepareStatement(sql);
		ps.setString(1, promary.getProName());
		ps.setInt(2, promary.getProId());
		ps.executeUpdate();
		SQLUtil.closeAll(conn, ps);
	}
	
	public void delPromary(Promary promary) throws Exception {
		sql = "delete from promary where proID = ?";
		conn = SQLUtil.getConnection();
		ps  = conn.prepareStatement(sql);
		ps.setInt(1, promary.getProId());
		ps.executeUpdate();
		SQLUtil.closeAll(conn, ps);
	}
	
}