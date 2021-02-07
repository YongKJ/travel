
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class LabelDao {
	
	public List<Label> labelsList;
	public Connection conn;
	public Statement st;
	public PreparedStatement ps;
	public ResultSet rs;
	public String sql;
	
	public LabelDao() {
		conn = null;
		st = null;
		ps = null;
		rs = null;
	}
	
	public List<Label> getLabel() throws Exception {
		sql = "select * from label";
		labelsList = new ArrayList<>();
		conn = SQLUtil.getConnection();
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		while (rs.next()){
			Label label = new Label();
			label.setlId(rs.getInt(1));
			label.setlName(rs.getString(2));
			labelsList.add(label);
		}
		SQLUtil.closeAll(conn, st, rs);
		return labelsList;
	}
	
	public void addLabel(Label label) throws Exception {
		sql = "insert into label (lname) values (?)";
		conn = SQLUtil.getConnection();
		ps  = conn.prepareStatement(sql);
		ps.setString(1, label.getlName());
		ps.executeUpdate();
		SQLUtil.closeAll(conn, ps);
	}
	
	public void modLabel(Label label) throws Exception {
		sql = "update label set lname = ? where lid = ?";
		conn = SQLUtil.getConnection();
		ps  = conn.prepareStatement(sql);
		ps.setString(1, label.getlName());
		ps.setInt(2, label.getlId());
		ps.executeUpdate();
		SQLUtil.closeAll(conn, ps);
	}
	
	public void delLabel(Label label) throws Exception {
		sql = "delete from label where lid = ?";
		conn = SQLUtil.getConnection();
		ps  = conn.prepareStatement(sql);
		ps.setInt(1, label.getlId());
		ps.executeUpdate();
		SQLUtil.closeAll(conn, ps);
	}
	
}
	
