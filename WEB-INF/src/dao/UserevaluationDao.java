
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class UserevaluationDao {
	
	public List<Userevaluation> userevaluationsList;
	public Connection conn;
	public Statement st;
	public PreparedStatement ps;
	public ResultSet rs;
	public String sql;
	
	public UserevaluationDao() {
		conn = null;
		st = null;
		ps = null;
		rs = null;
	}
	
	public List<Userevaluation> getUserevaluation() throws Exception {
		sql = "select * from userevaluation";
		userevaluationsList = new ArrayList<>();
		conn = SQLUtil.getConnection();
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		while (rs.next()){
			Userevaluation userevaluation = new Userevaluation();
			userevaluation.setuId(rs.getInt(1));
			userevaluation.setuEvaluationText(rs.getString(2));
			userevaluation.setuPrcture(rs.getString(3));
			userevaluation.setuData(rs.getString(4));
			userevaluation.setuAttractionsId(rs.getInt(5));
			userevaluation.setuBUserTableId(rs.getInt(6));
			userevaluationsList.add(userevaluation);
		}
		SQLUtil.closeAll(conn, st, rs);
		return userevaluationsList;
	}
	
	public void addUserevaluation(Userevaluation userevaluation) throws Exception {
		sql = "insert into userevaluation (uevaluationtext, upictuer, udata, uattractions_id, ubusertable_id) values (?, ?, ?, ?, ?)";
		conn = SQLUtil.getConnection();
		ps  = conn.prepareStatement(sql);
		ps.setString(1, userevaluation.getuEvaluationText());
		ps.setString(2, userevaluation.getuPicture());
		ps.setString(3, userevaluation.getuData());
		ps.setInt(4, userevaluation.getuAttractionsId());
		ps.setInt(5, userevaluation.getuBUserTableId());
		ps.executeUpdate();
		SQLUtil.closeAll(conn, ps);
	}
	
	public void modUserevaluation(Userevaluation userevaluation) throws Exception {
		sql = "update userevaluation set uevaluationtext = ?, upictuer = ?, udata = ?, uattractions_id = ?, ubusertable_id = ? where uid = ?";
		conn = SQLUtil.getConnection();
		ps  = conn.prepareStatement(sql);
		ps.setString(1, userevaluation.getuEvaluationText());
		ps.setString(2, userevaluation.getuPicture());
		ps.setString(3, userevaluation.getuData());
		ps.setInt(4, userevaluation.getuAttractionsId());
		ps.setInt(5, userevaluation.getuBUserTableId());
		ps.setInt(6, userevaluation.getuId());
		ps.executeUpdate();
		SQLUtil.closeAll(conn, ps);
	}
	
	public void delUserevaluation(Userevaluation userevaluation) throws Exception {
		sql = "delete from userevaluation where uid = ?";
		conn = SQLUtil.getConnection();
		ps  = conn.prepareStatement(sql);
		ps.setInt(1, userevaluation.getuId());
		ps.executeUpdate();
		SQLUtil.closeAll(conn, ps);
	}
	
}